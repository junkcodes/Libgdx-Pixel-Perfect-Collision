package com.gameproject.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gameproject.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyGdxGame.width;
		config.height = MyGdxGame.height;
		config.title = MyGdxGame.title;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
