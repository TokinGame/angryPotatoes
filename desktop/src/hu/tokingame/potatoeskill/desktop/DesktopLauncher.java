package hu.tokingame.potatoeskill.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Globals.WORLD_WIDTH;
		config.height = Globals.WORLD_HEIGHT;
		//config.width = 1040;
		//config.height = 600;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
