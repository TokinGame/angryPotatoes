package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.GameElements.Cannon;
import hu.tokingame.potatoeskill.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 11/9/2017.
 */

public class GameStage extends MyStage {

    World world;
    WorldBodyEditorLoader loader;
    Box2DDebugRenderer box2DDebugRenderer;


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);

        world = new World(new Vector2(0,0), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("Resources/physics.json"));


        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);


        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });


        addActor(new Cannon(world, 100, 100));

    }

    @Override
    public void init() {

    }


    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE){
            game.setScreenBackByStackPop();
        }
        return false;
    }
    @Override
    public void act(float delta) {
        world.step(delta, 10, 10);
        super.act(delta);

    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
    }
}
