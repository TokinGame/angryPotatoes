package hu.tokingame.potatoeskill.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 11/9/2017.
 */

public class MenuScreen extends MyScreen {
    private MenuStage menuStage;
    public MenuScreen(MyGdxGame game) {
        super(game);
        menuStage = new MenuStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        menuStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(menuStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }
}
