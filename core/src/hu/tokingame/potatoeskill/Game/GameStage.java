package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import hu.tokingame.potatoeskill.GameElements.AngleActor;
import hu.tokingame.potatoeskill.GameElements.Cannon;
import hu.tokingame.potatoeskill.GameElements.Crate;
import hu.tokingame.potatoeskill.GameElements.Enemy;
import hu.tokingame.potatoeskill.GameElements.Floor;
import hu.tokingame.potatoeskill.GameElements.Potato;
import hu.tokingame.potatoeskill.GameElements.XssppolsinosssActor;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by M on 11/9/2017.
 */

public class GameStage extends MyStage {

    World world;
    hu.tokingame.potatoeskill.World.WorldBodyEditorLoader loader;
    Box2DDebugRenderer box2DDebugRenderer;
    MapLoader maploader;
    Matrix4 debugMatrix;

    Cannon cannon;
    Potato potato;

    GameStage ez;
    ControlStage controlStage;

    AngleActor angleActor;


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        ez = this;
        controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), batch, game, this);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.EARTH_BG)){
            @Override
            public void init() {
                super.init();
                setPosition(0, 0);
                setSize(ez.getWidth(), ez.getHeight());
            }
        });

        world = new World(new Vector2(0,-20), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new hu.tokingame.potatoeskill.World.WorldBodyEditorLoader(Gdx.files.internal("Resources/physics.json"));

        setDebugAll(Globals.DEBUG_ALL);

        debugMatrix = new Matrix4(getCamera().combined);




        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);


        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                /*
                if(contact.getFixtureA().getBody().getUserData() instanceof Potato){
                    if(contact.getFixtureB().getBody().getUserData() instanceof Enemy){
                        System.out.println("enemy hit TODO robban vagy valami");
                        //GameStage.this.addActor(new XssppolsinosssActor(world, potato.getX(), potato.getY()));
                        shitHole = true;
                        newPotato();
                        ((Potato)contact.getFixtureA().getBody().getUserData()).removeFromWorld();
                    }
                }
                else{
                    if(contact.getFixtureB().getBody().getUserData() instanceof Potato){
                        if(contact.getFixtureA().getBody().getUserData() instanceof Enemy){
                            System.out.println("enemy hit TODO robbanás vagy valami");
                            //GameStage.this.addActor(new XssppolsinosssActor(world, potato.getX(), potato.getY())); //TODO ezeket megcsinálni mert crashel
                            shitHole = true;
                            newPotato();
                            ((Potato)contact.getFixtureB().getBody().getUserData()).removeFromWorld();
                        }
                    }
                }
                */
                ((WorldActorGroup)contact.getFixtureA().getBody().getUserData()).contact((WorldActorGroup)contact.getFixtureB().getBody().getUserData());
                ((WorldActorGroup)contact.getFixtureB().getBody().getUserData()).contact((WorldActorGroup)contact.getFixtureA().getBody().getUserData());
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


        addActor(cannon = new Cannon(world, loader, 0, 0));
        //addActor(potato = new Potato(world, loader, 2000, 1));
        addActor(new Floor(world));
        //addActor(new XssppolsinosssActor(world, 80, 50));


        addActor(angleActor = new AngleActor(){
            @Override
            public void onAngleUpdate(float angle) {
                setCannonAngle(angle);
                System.out.println(angle);
            }

            @Override
            public void onTouchUp(float x, float y) {
                // TODO: 11/21/2017 Krúplííí lenní kíná úrhájjyó mint kina vezztőj a ókÓr ban. vagyis ki kell löni e
                addActor(potato = new Potato(world, loader, 2000, 10));
                potato.setLaunchAngle(this.getRadAngle());
                try {
                    Vector2 vector2 = new Vector2(13,0);
                    Vector2 rotateVector2 = vector2.setAngleRad(this.getRadAngle());
                    potato.setPosition(rotateVector2.x, rotateVector2.y);
                    addActor(new XssppolsinosssActor(world, rotateVector2.x, rotateVector2.y,5,5, true));
                    potato.setSpeedMultiplier(10f * controlStage.getCurrenLaunchMultiplier());
                    System.out.println(controlStage.getCurrenLaunchMultiplier());
                    potato.shootMe();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        load(1);






        //getCamera().combined.translate(viewport.getScreenX()/10, viewport.getScreenY()/10, 0);   //CAMERA ZOOM IN nem működik
    }

    public void newPotato(){

    }


    public void setCannonAngle(float degrees){
        cannon.setRotation(degrees-45);
    }

    public boolean getPressedState(){
        if(angleActor != null)return angleActor.isPressed();
        else return false;
    }

    public void load(int level){        //TODO ezt esetleg valami effektívebbre
        String current = "Loader/";
        System.out.println("loading "+level);
        switch(level){
            case 1:
                current += "1.txt";
                break;
            default:
                System.out.println("wrong input for load");
                break;
        }
        try {
            FileInputStream fis = new FileInputStream(current);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while(br.ready()){
                String[] thisLine = br.readLine().split(" ");
                switch(thisLine[0].charAt(0)){
                    case '@':
                        addActor(new Crate(world, Float.parseFloat(thisLine[1]), Float.parseFloat(thisLine[2])));
                        System.out.println("placed crate at " + thisLine[1] + " " + thisLine[2]);
                        break;
                    case '#':
                        addActor(new Enemy(world, loader, Float.parseFloat(thisLine[1]), Float.parseFloat(thisLine[2])));
                        System.out.println("placed microwave at " + thisLine[1] + " " + thisLine[2]);
                        break;
                    default:
                        System.out.println("!!!!!!!!unknown input!!!!!!!!!!");
                        break;
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
        controlStage.act(delta);
        //System.out.println(Enemy.getCount());
    }

    @Override
    public void draw() {
        super.draw();
        controlStage.draw();
        box2DDebugRenderer.render(world, debugMatrix);
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
    }
}
