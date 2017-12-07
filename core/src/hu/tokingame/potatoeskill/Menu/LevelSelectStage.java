package hu.tokingame.potatoeskill.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Demo.DemoScreen;
import hu.tokingame.potatoeskill.Exit.ExitScreen;
import hu.tokingame.potatoeskill.Game.GameScreen;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;
import hu.tokingame.potatoeskill.Options.OptionsScreen;

import static hu.tokingame.potatoeskill.Global.Globals.currentLevel;
import static hu.tokingame.potatoeskill.Global.Globals.unlocked;

/**
 * Created by M on 11/9/2017.
 */

public class LevelSelectStage extends MyStage {

    MyGdxGame game;

    public LevelSelectStage(final Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;



        addActor(new hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_1)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
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


        final int firstX = 190, firstY = 510;
        int whichLevel = 1;
        for(int s = 0; s < 3; s ++){
            for(int o = 0; o < 5; o++){
                final int co = o, cs = s, cl = whichLevel;
                addActor(new MyTextButton(whichLevel+"", game.getBlackTextButtonStyle()){
                    @Override
                    protected void init() {
                        super.init();
                        setSize(100, 100);
                        setPosition(firstX+co*200, firstY-cs*200);
                        setTexture(Assets.manager.get(Assets.ICONS[cl-1]));

                        if(unlocked[cl-1]){

                            addListener(new ClickListener(){
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    super.clicked(event, x, y);
                                    currentLevel = cl;
                                    if(cl == 1) game.setScreen(new DemoScreen(game));
                                    else game.setScreen(new GameScreen(game),false);
                                }
                            });
                        }else{
                            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.REDX)){
                                @Override
                                public void init() {
                                    super.init();
                                    setSize(100, 100);
                                    setPosition(firstX+co*200, firstY-cs*200);
                                }
                            });
                        }
                    }
                });
                whichLevel++;
            }
        }

    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
