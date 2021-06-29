package com.twcrone.technetium.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.twcrone.technetium.Basic3DTest;
import com.twcrone.technetium.TechnetiumGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Technetium";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new Basic3DTest(), config);
	}
}
