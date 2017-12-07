package hu.tokingame.potatoeskill.About;

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

public class AboutStage extends MyStage {

    private OneSpriteStaticActor baglogic;
    MyGdxGame game;

    public AboutStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;

        addActor(new hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor(Assets.manager.get(Assets.WOOD_BG)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });

        addActor(new MyLabel("Angry Potatoes\nKészítette a Tökin Game\nTagok:\nBálint Dániel\nDávid Mátyás\nKovács Zoltán\nSchuh Marcell", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 200);
                setAlignment(2);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TOKIN)){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 50);
                setSize(100, 100);
            }
        });



        addActor(new MyTextButton("Nem"){
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

