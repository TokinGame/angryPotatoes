package hu.tokingame.potatoeskill.Demo;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.GroupLayout;

import hu.tokingame.potatoeskill.Game.GameScreen;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.Menu.MenuScreen;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyLabel;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.MyTextButton;
import hu.tokingame.potatoeskill.MyGdxGame;


/**
 * Created by davimatyi on 12/07/2017
 */

public class DemoStage extends MyStage {

    MyGdxGame game;
    private int step = 0;
    private float removeTime = 0;

    OneSpriteStaticActor b1, b2, b3, pf, m1, m2, m3, x, black;
    MyLabel t1, t2, t3;
    MyTextButton tovabb;


    public DemoStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;

        addActor(b1 = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_1)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0, 0);
                setVisible(false);
            }
        });
        addActor(b2 = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_2)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0, 0);
                setVisible(false);
            }
        });
        addActor(b3 = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_3)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0, 0);
                setVisible(false);
            }
        });
        addActor(pf = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO_FAMILY)){
            @Override
            public void init() {
                super.init();
                setSize(300, 300);
                setPosition(800, 100);
                setVisible(false);
            }
        });
        addActor(m1 = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY)){
            @Override
            public void init() {
                super.init();
                setSize(400, 400);
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 400);
                setVisible(false);
            }
        });
        addActor(m2 = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY)){
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2-m1.getWidth(), 500);
                setVisible(false);
            }
        });
        addActor(m3 = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY)){
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2+m1.getWidth(), 500);
                setVisible(false);
            }
        });
        addActor(x = new OneSpriteStaticActor(Assets.manager.get(Assets.NUKE)){
            @Override
            public void init() {
                super.init();
                setSize(500, 500);
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 100);
                setVisible(false);
            }
        });
        addActor(black = new OneSpriteStaticActor(new Texture(new Pixmap(1, 1, Pixmap.Format.RGB888){
            @Override
            public void setColor(int color) {
                super.setColor(Color.BLACK);
            }
        })){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0, 0);
            }
        });


        addActor(t1 = new MyLabel("A krumplik békében éltek,\nmindenki frissen sütötte őket.", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 50);
                setVisible(false);
                setAlignment(2);
            }
        });
        addActor(t2 = new MyLabel("Egyszer csak megjelentek a gonosz mikrók,\nés elkezdték újra melegíteni a kumplikat.", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 50);
                setVisible(false);
                setAlignment(2);
            }
        });
        addActor(t3 = new MyLabel("A krumplik azt tették, amit tudtak. Felrobbantak.\nSenki sem szereti az újramelegített sültkrumplit.", game.getLabelStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 50);
                setVisible(false);
                setAlignment(2);
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
        addActor(tovabb = new MyTextButton("Tovább"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.currentLevel = 1;
                        game.setScreen(new GameScreen(game), false);
                    }
                });
                setVisible(false);
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(step == 0){
            step++;
            b1.setVisible(true);
            pf.setVisible(true);
            t1.setVisible(true);
        }
        if(elapsedTime > 6 && step == 1){
            step++;
            b1.setVisible(false);
            pf.setVisible(false);
            b2.setVisible(true);
            m1.setVisible(true);
            m2.setVisible(true);
            m3.setVisible(true);
            t1.setVisible(false);
            t2.setVisible(true);
        }
        if(elapsedTime > 11 && step == 2){
            step++;
            b2.setVisible(false);
            m1.setVisible(false);
            m2.setVisible(false);
            m3.setVisible(false);
            b3.setVisible(true);
            x.setVisible(true);
            t2.setVisible(false);
            t3.setVisible(true);
        }if(step == 3){
            step++;
        }
        if(elapsedTime < 1 && step == 1){
            removeTime += delta;
            Color c = black.getColor();
            c.a = 1f - removeTime;
            black.setColor(c);
            if (removeTime > 0.99f){
                black.setVisible(false);
            }
        }
        if(step==1){
            pf.setX(pf.getX()-0.2f);
            pf.setSize(pf.getWidth()-0.2f, pf.getHeight()-0.2f);
        }
        if(step == 2 && elapsedTime > 6.4f){
            m1.setY(m1.getY()-0.3f);
            m2.setY(m2.getY()-0.3f);
            m3.setY(m3.getY()-0.3f);
        }
        if(step == 4 && elapsedTime < 16){
            x.setSize(x.getWidth()+0.5f, x.getHeight()+0.5f);
            x.setX(Globals.WORLD_WIDTH/2-x.getWidth()/2);
        }else if(step == 4 && elapsedTime > 16) {
            tovabb.setVisible(true);
        }



    }
}