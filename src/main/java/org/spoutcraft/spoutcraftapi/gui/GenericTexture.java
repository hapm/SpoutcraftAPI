/*
 * This file is part of SpoutcraftAPI (http://wiki.getspout.org/).
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

import java.io.IOException;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.UnsafeClass;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;

@UnsafeClass
public class GenericTexture extends GenericWidget implements Texture {
	protected String url = null;
	protected boolean drawAlpha = false;
	protected int top;
	protected int left;
	protected Runnable finishDelegate = null;
	protected int originalWidth = -1, originalHeight = -1;

	public GenericTexture() {

	}

	public GenericTexture(String url) {
		setUrl(url);
	}

	public WidgetType getType() {
		return WidgetType.Texture;
	}

	@Override
	public int getVersion() {
		return super.getVersion() + 3;
	}

	@Override
	public void readData(SpoutInputStream input) throws IOException {
		super.readData(input);
		this.setUrl(input.readString());
		this.setDrawAlphaChannel(input.readBoolean());
		setTop(input.readShort());
		setLeft(input.readShort()); 
	}

	@Override
	public void writeData(SpoutOutputStream output) throws IOException {
		super.writeData(output);
		output.writeString(getUrl());
		output.writeBoolean(isDrawingAlphaChannel());
		output.writeShort((short) top);
		output.writeShort((short) left);
	}

	public void render() {
		Spoutcraft.getClient().getRenderDelegate().render(this);
	}

	public String getUrl() {
		return url;
	}

	public Texture setUrl(String url) {
		this.url = url;
		if (getUrl() != null) {
			Spoutcraft.getClient().getRenderDelegate().downloadTexture(getAddon().getDescription().getName(), getUrl());
		}
		return this;
	}

	@Override
	public Texture copy() {
		return ((Texture)super.copy())
				.setUrl(getUrl())
				.setTop(getTop())
				.setLeft(getLeft());
	}

	public boolean isDrawingAlphaChannel() {
		return drawAlpha;
	}

	public Texture setDrawAlphaChannel(boolean draw) {
		this.drawAlpha = draw;
		return this;
	}

	public Texture setTop(int top) {
		if (getTop() != top) {
			this.top = top;
		}
		return this;
	}

	public int getTop() {
		return top;
	}

	public Texture setLeft(int left) {
		if (getLeft() != left) {
			this.left = left;
		}
		return this;
	}

	public int getLeft() {
		return left;
	}
	
	public Runnable getFinishDelegate() {
		return finishDelegate;
	}
	
	public GenericTexture setFinishDelegate(Runnable finishDelegate) {
		this.finishDelegate = finishDelegate;
		return this;
	}

	public int getOriginalWidth() {
		return originalWidth;
	}

	public GenericTexture setOriginalWidth(int originalWidth) {
		this.originalWidth = originalWidth;
		return this;
	}

	public int getOriginalHeight() {
		return originalHeight;
	}

	public GenericTexture setOriginalHeight(int originalHeight) {
		this.originalHeight = originalHeight;
		return this;
	}
}
