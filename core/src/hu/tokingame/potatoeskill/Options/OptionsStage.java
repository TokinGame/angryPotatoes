package hu.tokingame.potatoeskill.Options;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Exit.ExitScreen;
import hu.tokingame.potatoeskill.Game.GameScreen;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;
import jdk.nashorn.internal.objects.Global;


/**
 * Created by zoltan on 11/9/2017.
 */

public class OptionsStage extends MyStage {

    private OneSpriteStaticActor baglogic;
    MyGdxGame game;

    private static final String SOUDNFX_LABEL = "Hangeffektek: ", HARDNESS_LABEL = "Nehézség: ", MUSIC_LABEL = "Zene: ";

    public OptionsStage(Viewport viewport, Batch batch, MyGdxGame gam) {
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


        addActor(new MyTextButton(SOUDNFX_LABEL){
            @Override
            protected void init() {
                super.init();
                this.setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 500);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.soundFX = !Globals.soundFX;
                        Globals.getPrefs().putBoolean("soundFX", Globals.soundFX);
                        Globals.getPrefs().flush();
                        setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                    }
                });
            }
        });
        addActor(new MyTextButton(MUSIC_LABEL){
            @Override
            protected void init() {
                super.init();
                this.setText(MUSIC_LABEL + (Globals.music ? "Be" : "Ki"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.music = !Globals.music;
                        if(Globals.music)Assets.manager.get(Assets.MAIN_MUSIC).play();
                        else Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        Globals.getPrefs().putBoolean("soundFX", Globals.music);
                        Globals.getPrefs().flush();
                        setText(MUSIC_LABEL + (Globals.music ? "Be" : "Ki"));
                    }
                });
            }
        });
        addActor(new MyTextButton(HARDNESS_LABEL){
            @Override
            protected void init() {
                super.init();
                this.setText(HARDNESS_LABEL + (Globals.hard ? "Nehéz" : "Könnyű"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 250);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.hard = !Globals.hard;
                        Globals.getPrefs().putBoolean("hard", Globals.hard);
                        Globals.getPrefs().flush();
                        setText(HARDNESS_LABEL + (Globals.hard ? "Nehéz" : "Könnyű"));
                    }
                });
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
                        game.setScreen(new MenuScreen(game));
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