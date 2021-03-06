/*
 * This file is part of SpoutcraftAPI.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
 * SpoutcraftAPI is licensed under the GNU Lesser General Public License.
 *
 * SpoutcraftAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpoutcraftAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spoutcraft.spoutcraftapi.gui;

import java.util.Set;
import java.util.UUID;

import org.spoutcraft.spoutcraftapi.UnsafeClass;
import org.spoutcraft.spoutcraftapi.addon.Addon;

@UnsafeClass
public interface Screen extends Widget {
	/**
	 * Get's an array of all the attached widgets to this screen. Modifying this array will not affect the screen.
	 *
	 * @return array of all widgets
	 */
	public Widget[] getAttachedWidgets();

	/**
	 * Get's an array of all the attached widgets to this screen, and if recursive, any widgets of screens attached to this screen.
	 *
	 * @param recursive whether to get widgets attached to screens attached to this screen.
	 * @return array of all widgets
	 */
	public Widget[] getAttachedWidgets(boolean recursive);

	/**
	 * Get's a set of all the attached widgets to this screen. Modifying this array will not affect the screen.
	 *
	 * @return set of all widgets
	 */
	public Set<Widget> getAttachedWidgetsAsSet();

	/**
	 * Get's a set of all the attached widgets to this screen, and if recursive, any widgets of screens attached to this screen.
	 *
	 * @param recursive whether to get widgets attached to screens attached to this screen.
	 * @return set of all widgets
	 */
	public Set<Widget> getAttachedWidgetsAsSet(boolean recursive);

	/**
	 * Attaches a widget to this screen
	 *
	 * @param widget to attach
	 * @return screen
	 */
	@Deprecated
	public Screen attachWidget(Widget widget);

	/**
	 * Attaches a widget to this screen
	 *
	 * @param widget to attach
	 * @param Addon that created this widget
	 * @return screen
	 */
	public Screen attachWidget(Addon addon, Widget widget);

	/**
	 * Attaches an array of widgets to this screen
	 *
	 * @param addon that created this widget
	 * @param widgets to attach
	 * @return screen
	 */
	public Screen attachWidgets(Addon addon, Widget ...widgets);

	/**
	 * Removes a widget from this screen
	 *
	 * @param widget to remove
	 * @return screen
	 */
	public Screen removeWidget(Widget widget);

	/**
	 * Is true if the screen has the given widget attached to it. Uses a linear search, takes O(n) time to complete.
	 *
	 * @param widget to search for
	 * @return true if the widget was found
	 */
	public boolean containsWidget(Widget widget);

	/**
	 * Is true if the screen has a widget with the given id attached to it. Uses a linear search, takes O(n) time to complete.
	 *
	 * @param id to search for
	 * @return true if the widget was found
	 */
	public boolean containsWidget(UUID id);

	/**
	 * Get's the widget that is associated with the given id, or null if none was found
	 *
	 * @param id to search for
	 * @return widget, or null if none found.
	 */
	public Widget getWidget(UUID id);

	/**
	 * Replaces any attached widget with the given widget's id with the new widget
	 *
	 * @param widget to replace with
	 * @return true if a widget was replaced
	 */
	public boolean updateWidget(Widget widget);

	/**
	 * Is true if this grey background is visible and rendering on the screen
	 *
	 * @return visible
	 */
	public boolean isBgVisible();

	/**
	 * Sets the visibility of the grey background. If true, it will render normally. If false, it will not appear on the screen.
	 *
	 * @param enable the visibility
	 * @return the screen
	 */
	public Screen setBgVisible(boolean enable);

	/**
	 * Gets the height of the screen
	 * @return height
	 */
	public double getHeight();

	/**
	 * Gets the width of the screen
	 * @return width
	 */
	public double getWidth();

	/**
	 * Gets the screen type of this screen
	 * @return the screen type
	 */
	public ScreenType getScreenType();

	/**
	 * Internal use only
	 * @param mouseX
	 * @return this screen
	 */
	public Screen setMouseX(int mouseX);

	/**
	 * Internal use only
	 * @param mouseY
	 * @return this screen
	 */
	public Screen setMouseY(int mouseY);

	/**
	 * Gets the x coordinate of the mouse on this screen
	 * @return x coordinate of the mouse
	 */
	public int getMouseX();

	/**
	 * Gets the y coordinate of the mouse on this screen
	 * @return y coordinate of the mouse
	 */
	public int getMouseY();
}
