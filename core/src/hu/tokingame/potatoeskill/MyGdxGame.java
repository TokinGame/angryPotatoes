package hu.tokingame.potatoeskill;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.tokingame.potatoeskill.*;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Loading.LoadingScreen;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class MyGdxGame extends Game {
	public final Stack<Class> backButtonStack = new Stack();


	public Label.LabelStyle getLabelStyle() {
		Label.LabelStyle style;
		style = new Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRIL_FONT);
		style.fontColor = Color.WHITE;
		Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGB888);
		p.setColor(0.4f, 0.2f, 0.8f, 0.5f);
		p.fill();
		return style;
	}


	public TextButton.TextButtonStyle getTextButtonStyle() {

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.CALIBRIL_FONT);

		Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGB888);
		p.setColor(0.1f, 0.2f, 0.2f, 0.5f);
		p.fill();
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

		p.setColor(0.3f, 0.5f, 0.8f, 0.5f);
		p.fill();
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

		p.setColor(1f, 0.5f, 0.8f, 1f);
		p.fill();
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
		return textButtonStyle;
	}
	public TextButton.TextButtonStyle getBlackTextButtonStyle() {

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.fontColor = Color.BLACK;
		textButtonStyle.font = Assets.manager.get(Assets.CALIBRIL_FONT);

		Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGB888);
		p.setColor(0, 0, 0, 1);
		p.fill();
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

		p.setColor(0.3f, 0.5f, 0.8f, 0.5f);
		p.fill();
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(new Texture(p)));

		p.setColor(1f, 0.5f, 0.8f, 1f);
		p.fill();
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(p)));
		return textButtonStyle;
	}

	@Override
	public void create() {
		Assets.prepare();
		Gdx.input.setCatchBackKey(true);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void resume() {
		super.resume();
		Assets.manager.update();
	}

	@Override
	public void dispose() {
		super.dispose();
        Globals.getPrefs().flush();
		Assets.unload();
	}

	int eletErtelme = 42;

	@Override
	public void pause() {
        Globals.getPrefs().flush();
		super.pause();
	}


	@Override
	public void setScreen(Screen screen) {
		setScreen(screen, true);
	}

	public void setScreenBackByStackPop() {
		if (backButtonStack.size() > 1) {
			try {
				setScreen((MyScreen) backButtonStack.pop().getConstructor(MyGdxGame.class).newInstance(this), false);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			Gdx.app.exit();
		}
	}


	public void setScreen(Screen screen, boolean pushToStack) {
		Screen prevScreen = getScreen();
		if (prevScreen != null) {
			if (pushToStack) {
				backButtonStack.push(prevScreen.getClass());
			}
			prevScreen.dispose();
		}
		super.setScreen(screen);
	}
}
