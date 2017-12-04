package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyLabel;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextField;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by davim on 2017. 11. 23..
 */

public class ControlStage extends MyStage {

    private OneSpriteStaticActor speedIndicator, prevSpeedIndicator;
    GameStage gameStage;
    private MyLabel score;

    private MyLabel potatoCounter;

    float forceTimer = 0;

    private static final String SCORE_LABLE_TEXT = "Pont: ";
    private float prev_power = 0;


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
        prevSpeedIndicator = new OneSpriteStaticActor(Assets.manager.get(Assets.PREV_POWERBAR));
        speedIndicator = new OneSpriteStaticActor(Assets.manager.get(Assets.POWERBAR));
        speedIndicator.setSize(50, 50);
        prevSpeedIndicator.setSize(50, 50);
        addActor(prevSpeedIndicator);
        addActor(speedIndicator);
        speedIndicator.setPosition(100, 650);
        prevSpeedIndicator.setPosition(100, 650);
        addActor(score = new MyLabel(SCORE_LABLE_TEXT + "0", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setSize(400,100);
                setPosition(Globals.WORLD_WIDTH-getWidth(), Globals.WORLD_HEIGHT-getHeight());
            }
        });
        addActor(potatoCounter = new MyLabel("0", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(Globals.WORLD_WIDTH-getWidth()-score.getWidth(), Globals.WORLD_HEIGHT-getHeight());
            }
        });

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
            prev_power = currenLaunchMultiplier;
        }
        else{
            currenLaunchMultiplier = 0.5f;
            prevSpeedIndicator.setWidth(prev_power * 2 * 50);
            speedIndicator.setWidth(50);
            forceTimer = 0;
        }

    }

    public float getCurrenLaunchMultiplier() {
        return currenLaunchMultiplier;
    }


    public void updateScore(int newScore){
        score.setText(SCORE_LABLE_TEXT + newScore);
    }

    public void setCounter(int potatoes){
        potatoCounter.setText(potatoes+"");
    }

}
