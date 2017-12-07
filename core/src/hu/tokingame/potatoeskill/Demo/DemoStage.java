package hu.tokingame.potatoeskill.Demo;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;


/**
 * Created by davimatyi on 12/07/2017
 */

public class DemoStage extends MyStage {

    MyGdxGame game;


    public DemoStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;





        addActor(new MyTextButton("Back"){
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