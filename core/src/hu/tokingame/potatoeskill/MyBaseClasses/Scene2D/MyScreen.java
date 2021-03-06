package hu.tokingame.potatoeskill.MyBaseClasses.Scene2D;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import hu.tokingame.potatoeskill.MyBaseClasses.Game.InitableInterface;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
abstract public class MyScreen implements Screen, InitableInterface {

    //Todo: valószínűleg jó
    // -- Ha esetleg gond lenne, akkor ez ne legyen static
    protected SpriteBatch spriteBatch = new SpriteBatch();

    public float r=0,g=0,b=0;

    public final MyGdxGame game;



    public MyScreen(MyGdxGame game) {
        this.game = game;
        init();
    }

    @Override
    public void dispose() {
        //Todo: egyelőre vissza van kapcsolva
        // --kiszedve...
        spriteBatch.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        //setCameraReset(viewport, width, height);
    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    public Game getGame() {
        return game;
    }

    public void setBackGroundColor(float r, float g, float b)
    {
        this.r=r;
        this.g = g;
        this.b = b;
    }


}
