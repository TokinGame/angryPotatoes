package hu.tokingame.potatoeskill.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Exit.ExitScreen;
import hu.tokingame.potatoeskill.Game.GameScreen;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;
import hu.tokingame.potatoeskill.Options.OptionsScreen;

/**
 * Created by M on 11/9/2017.
 */

public class MenuStage extends MyStage {

    private OneSpriteStaticActor baglogic; // táskalogika?
    OneSpriteStaticActor flyingPotato, macskura;
    boolean falling = false, big = false;
    MyGdxGame game;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;

        addActor(flyingPotato = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO)){
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(-200, 50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        triggerEasterEgg();
                    }
                });
            }

            @Override
            public void act(float delta) {
                super.act(delta);
                setRotation(getRotation()-1);
                setPosition(getX()+0.8f, getY()+0.2f);
            }
        });

        addActor(macskura = new OneSpriteStaticActor(Assets.manager.get(Assets.BANANA)) {

                    @Override
                    public void init() {
                        super.init();
                        setSize(400, 400);
                        setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 800);
                        addListener(new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                super.clicked(event, x, y);
                                setSize(1000, 1000);
                                setX(Globals.WORLD_WIDTH / 2 - getWidth() / 2);
                                if(big){
                                    Globals.currentLevel = 99;
                                    game.setScreen(new GameScreen(game));
                                }else big = true;
                            }
                        });
                    }

                    @Override
                    public void act(float delta) {
                        super.act(delta);
                        if (falling) setY(getY() - 15);
                        if ((getY() < -400 && !big) || (big && getY() < -1000)) {
                            setSize(400, 400);
                            setY(800);
                            setX(Globals.WORLD_WIDTH / 2 - getWidth() / 2);
                            falling = false;
                            big = false;
                        }

                    }
        });


        addActor(new MyTextButton("Jatek"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, Globals.WORLD_HEIGHT/2-this.getHeight()/2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new LevelSelectScreen(game));
                    }
                });
            }
        });
        addActor(new MyTextButton("Exit"){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });
        addActor(new MyTextButton("Options"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-170, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new OptionsScreen(game));
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


    void triggerEasterEgg(){
        falling = true;
    }
}
