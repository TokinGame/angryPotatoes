package hu.tokingame.potatoeskill.HowTo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyLabel;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;
import jdk.nashorn.internal.objects.Global;


/**
 * Created by zoltan on 11/9/2017.
 */

public class HowToStage extends MyStage {

    MyGdxGame game;

    public HowToStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;


        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.WOOD_BG)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });


        addActor(new MyLabel("Hogyan Játssz", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 600);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TABLET)){
            @Override
            public void init() {
                super.init();
                setPosition(100, 150);
                setSize(500,400);
            }
        });

        addActor(new MyTextButton("Vissza"){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

