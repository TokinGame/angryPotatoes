package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.LevelSelectScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyLabel;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 12/5/2017.
 */

public class LostStage extends MyStage {

    private GameStage gameStage;

    public LostStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
    }

    @Override
    public void init() {

    }

    // TODO: 12/5/2017 Ez inkább másik stage legyen
    public void lostGame(int enemyCount){
        Gdx.input.setInputProcessor(this);
        addActor(new MyLabel("Veszítettél \n" + enemyCount + " ellenfél életben maradt!", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setSize(400,100);
                setPosition(Globals.WORLD_WIDTH/2f-getWidth()/2f, Globals.WORLD_HEIGHT/2f-getHeight()/2f);
            }
        });
        addActor(new MyTextButton("Újra"){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH - getWidth(), 0);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game), false);
                    }
                });
            }
        });
        addActor(new MyTextButton("Kilépés"){
            @Override
            protected void init() {
                super.init();
                this.setPosition(0,0);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new LevelSelectScreen(game), false);
                    }
                });
            }

        });
    }

}
