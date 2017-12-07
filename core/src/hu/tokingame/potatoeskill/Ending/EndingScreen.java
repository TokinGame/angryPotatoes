package hu.tokingame.potatoeskill.Ending;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyScreen;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyGdxGame;
/**
 * Created by zoltan on 2017.12.07..
 */

public class EndingScreen extends MyScreen{
    private EndingStage endingStage;
    public EndingScreen(MyGdxGame game) {
        super(game);
        endingStage = new EndingStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        endingStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(endingStage);

    }

    @Override
    public void init() {

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        endingStage.act(delta);
        endingStage.draw();
    }
}
