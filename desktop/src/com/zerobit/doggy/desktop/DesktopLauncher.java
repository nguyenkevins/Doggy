package com.zerobit.doggy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.zerobit.doggy.Control;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Title";
		cfg.height = 1280;
		cfg.width = 1440;
		new LwjglApplication(new Control(), cfg);
	}
}
