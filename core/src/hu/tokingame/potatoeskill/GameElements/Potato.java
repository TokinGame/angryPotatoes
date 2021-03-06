package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import hu.tokingame.potatoeskill.Game.GameStage;
import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

import static hu.tokingame.potatoeskill.Global.Globals.soundFX;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Potato extends ExploadableActor {

    private OneSpriteStaticActor actor;
    private boolean canSu = true;

    private boolean removeEffect = false;
    private float removeTime = 0;

    public static void setSpeedMultiplier(float speedMultiplier) {
        SPEED_MULTIPLIER = speedMultiplier;
    }

    private static float SPEED_MULTIPLIER = 5f;

    private float y = -666, x = 1f;


    private int rand(int a, int b){return (int)(Math.random()*(b-a+1)+a);}

    public Potato(World world, WorldBodyEditorLoader loader, float x, float y, boolean cat) {
        super(world, loader, "potato.png", BodyDef.BodyType.DynamicBody, 100, 0.1f, 25, false);
        actor = new OneSpriteStaticActor(cat ? Assets.manager.get(Assets.CAT) : Assets.manager.get(Assets.POTATO));
        if(cat) setSize(10, 10); else setSize(5, 5);
        addActor(actor);
        if(cat) actor.setSize(10, 10); else actor.setSize(5, 5);
        addToWorld();
        setPosition(x, y);
        setTouchable(Touchable.disabled);
    }

    public void launch(float xForce, float yForce){
        this.getBody().applyForceToCenter(new Vector2(xForce, yForce), true);
        //System.out.println("potato launched with "+xForce+" ; "+yForce+" forces");
    }


    public void shootMe() throws Exception{
        if(y == -666){
            throw new Exception("A kilövés elött be kell álítani a szöget");
        }
        if(canSu){
            this.getBody().setLinearVelocity(this.getBody().getLinearVelocity().x + x * SPEED_MULTIPLIER, this.getBody().getLinearVelocity().y + y * SPEED_MULTIPLIER);
            canSu = false;
        }
    }

    public void setLaunchAngle(float radAngle){
        y = underHundredify(Math.abs((float) Math.tan(radAngle) / x));
        //System.out.println("asdklfjkl;asdfj   "  + Math.toDegrees(radAngle));
        if(Math.toDegrees(radAngle) >= 90.0)  x = 0f;
        //System.out.println("Krumpli: " + x + " ------ " + y);
    }

    public float underHundredify(float n){
        // TODO: 11/23/2017 Ennek adni egy értelmes nevet
        while(n > 100){
            n /= 10;
        }
        return n;
    }

    @Override
    protected void beforeRemoveFromWorld() {
        super.beforeRemoveFromWorld();
        if(getStage() instanceof GameStage){
            ((GameStage) getStage()).potatoRemoved();
        }
    }

    public void setRemoveEffect(){
        removeEffect = true;
    }


    public void act(float delta) {
        super.act(delta);
        if(getX() > getStage().getViewport().getWorldWidth()){
            //System.out.println("szar>>>>>>>>>>>>>>>>>>>>>>>>> " + (getX() - getStage().getViewport().getWorldWidth()));
        }
        if (getBody()!= null && getBody().getLinearVelocity().len()<0.01f || getBody()!= null && getX() > getStage().getViewport().getWorldWidth()+35){
            setVisibilityControl(false);
            removeFromWorld();
            setRemoveEffect();
        }
        if (removeEffect){
            removeTime += delta;
            Color c = actor.getColor();
            c.a = 1f - removeTime;
            actor.setColor(c);
            if (removeTime > 1){
                removeFromStage();
            }
        }
        if(getBody()!= null && Globals.hard){
            this.getBody().applyForceToCenter(Globals.windDirection, 0, false);
            //System.out.println("applying "+Globals.windDirection+" wind");
        }
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if (another instanceof Enemy || another instanceof Crate || another instanceof LongCrate){
            //System.out.println("Krumpli");
            setupXplosion(this.getBody().getLinearVelocity().len());
            explosionSound();
        }
    }

    void explosionSound(){
        if(soundFX){
            switch(rand(0, 2)){
                case 0: Assets.manager.get(Assets.EXPLOSION_SOUND1).play(); break;
                case 1: Assets.manager.get(Assets.EXPLOSION_SOUND2).play(); break;
                case 2: Assets.manager.get(Assets.EXPLOSION_SOUND3).play(); break;
            }
        }
    }

}
