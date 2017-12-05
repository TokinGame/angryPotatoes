package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.LevelSelectScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by davim on 2017. 11. 30..
 */

public class LevelEndStage extends MyStage {

    MyGdxGame game;

    public LevelEndStage(Viewport viewport, Batch batch, MyGdxGame game, int finalScore) {
        super(viewport, batch, game);
        this.game = game;
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EARTH_BG)){
            @Override
            public void init() {
                super.init();
                this.setPosition(0,0);
                this.setSize(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT);
            }
        });
        addActor(new MyTextButton( finalScore + " pontot értél el."){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, Globals.WORLD_HEIGHT/2-this.getHeight()/2);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        //LevelEndStage.this.game.setScreen(new GameScreen(LevelEndStage.this.game));
                    }
                });
            }
        });
        addActor(new MyTextButton("Következő"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 250);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        LevelEndStage.this.game.setScreen(new GameScreen(LevelEndStage.this.game),false);
                    }
                });
            }
        });
        addActor(new MyTextButton("Kilépés"){
            @Override
            protected void init() {
                super.init();
                setPosition(0, 0);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        LevelEndStage.this.game.setScreen(new LevelSelectScreen(LevelEndStage.this.game),false);
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
