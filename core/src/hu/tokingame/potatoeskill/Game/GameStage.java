package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
import hu.tokingame.potatoeskill.GameElements.LongCrate;
import hu.tokingame.potatoeskill.GameElements.Potato;
import hu.tokingame.potatoeskill.GameElements.XssppolsinosssActor;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

import static hu.tokingame.potatoeskill.Global.Globals.currentLevel;

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
    private LostStage lostStage;

    AngleActor angleActor;

    boolean finishedLoading = false;

    private int enemyCount = 0;
    private boolean enemiesAlive = true;
    private int score = 0;
    private int potatoesLeft = 0, potatoesStillAlive = 0;



    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        ez = this;
        // TODO: 12/5/2017 Megvan hogy mért crashelt! 2 stage használta ugyan azt a sprite batch-et !!!!!
        controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game, this);
        lostStage = new LostStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT), new SpriteBatch(), game, this);

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
                if(potatoesLeft > 0) {
                    addActor(potato = new Potato(world, loader, 2000, 10));
                    potato.setLaunchAngle(this.getRadAngle());
                    try {
                        Vector2 vector2 = new Vector2(13, 0);
                        Vector2 rotateVector2 = vector2.setAngleRad(this.getRadAngle());
                        potato.setPosition(rotateVector2.x, rotateVector2.y);
                        addActor(new XssppolsinosssActor(world, rotateVector2.x, rotateVector2.y, 5, 5, true, 0f));
                        potato.setSpeedMultiplier(10f * controlStage.getCurrenLaunchMultiplier());
                        System.out.println(controlStage.getCurrenLaunchMultiplier());
                        potato.shootMe();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        potatoesLeft--;
                        controlStage.setCounter(potatoesLeft);
                    }
                }
            }
        });

        load(Globals.currentLevel);

        //getCamera().combined.translate(viewport.getScreenX()/10, viewport.getScreenY()/10, 0);   //CAMERA ZOOM IN nem működik
    }

    public void newPotato(){

    }




    public void setCannonAngle(float degrees){
        if(potatoesLeft != 0){
            cannon.setRotation(degrees-45);
        }
    }

    public boolean getPressedState(){
        if(angleActor != null)return angleActor.isPressed();
        else return false;
    }

    public void load(int level){
        String current = "Loader/";
        System.out.println("loading "+level);
        switch(level){
            case 0:
                current += "test.txt";
                break;

            default:
                current += level+".txt";
                break;
        }
        try {
            InputStreamReader isr = new InputStreamReader(Gdx.files.internal(current).read());
            BufferedReader br = new BufferedReader(isr);
            potatoesLeft = Integer.parseInt(br.readLine());
            potatoesStillAlive = potatoesLeft;
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
                        enemyCount++;
                        break;
                    case '&':
                        addActor(new LongCrate(world, Float.parseFloat(thisLine[1]), Float.parseFloat(thisLine[2])));
                        System.out.println("placed triple crate at " + thisLine[1] + " " + thisLine[2]);
                        break;
                    default:
                        System.out.println("!!!!!!!!unknown input!!!!!!!!!!");
                        break;
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            finishedLoading = true;
            controlStage.setCounter(potatoesLeft);
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
        super.act(delta);
        if(potatoesLeft != 0){
            controlStage.act(delta);
        }else{
            lostStage.act(delta);
        }

        if (world != null) {
            world.step(delta, 10, 10);
        }

        if(finishedLoading){
            if(enemyCount == 0 && enemiesAlive){
                enemiesAlive = false;
                //TODO a staget átállítani
                System.out.println("end game");
                if(currentLevel < 15){
                    Globals.unlocked[currentLevel] = true;
                    Globals.getPrefs().putBoolean("l"+currentLevel, true);
                    Globals.getPrefs().flush();
                    currentLevel++;
                }
                game.setScreen(new LevelEndScreen(game,score), false);
            }
            if(potatoesStillAlive == 0){
                lostStage.lostGame(enemyCount);
            }
        }

    }

    @Override
    public void draw() {
        super.draw();
        if(potatoesStillAlive != 0){
            controlStage.draw();
        }else{
            lostStage.draw();
        }
        if (world != null) {
            box2DDebugRenderer.render(world, debugMatrix);
        }
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
    }

    public void addToScore(int scoreToAdd){
        score += scoreToAdd;
        controlStage.updateScore(score);
    }

    public void enemyRemoved(){
        enemyCount--;
    }

    public void potatoRemoved(){
        potatoesStillAlive--;
    }


    @Override
    public void dispose() {
        super.dispose();
        if (world != null) {
            world.dispose();
            world = null;
        }
    }
}
