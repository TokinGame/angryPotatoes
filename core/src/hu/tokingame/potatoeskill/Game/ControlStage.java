package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by davim on 2017. 11. 23..
 */

public class ControlStage extends MyStage {

    OneSpriteStaticActor speedIndicator;
    GameStage gameStage;
    float forceTimer = 0;


    float currenLaunchMultiplier = 0;

    public ControlStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gStage) {
        super(viewport, batch, game);
        gameStage = gStage;
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.POWERBAR_BG)){
            @Override
            protected void init() {
                super.init();
                setSize(450, 100);
                setPosition(75, 625);
            }
        });
        speedIndicator = new OneSpriteStaticActor(Assets.manager.get(Assets.POWERBAR));
        speedIndicator.setSize(50, 50);
        addActor(speedIndicator);
        speedIndicator.setPosition(100, 650);


    }

    @Override
    public void init() {

    }


    @Override
    public void act(float delta) {
        super.act(delta);

        if(gameStage.getPressedState()) {
            forceTimer += delta;
            speedIndicator.setSize(50*Math.abs((float)Math.sin(forceTimer)*8), 50);
            currenLaunchMultiplier = speedIndicator.getWidth()/2/50;
        }
        else{
            currenLaunchMultiplier = 0.5f;
            speedIndicator.setWidth(50);
            forceTimer = 0;
        }

    }
    public float getCurrenLaunchMultiplier() {
        return currenLaunchMultiplier;
    }

}
