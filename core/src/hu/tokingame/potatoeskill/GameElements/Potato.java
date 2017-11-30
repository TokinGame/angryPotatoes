package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

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

    public Potato(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "potato.png", BodyDef.BodyType.DynamicBody, 100, 0.1f, 25, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO));
        setSize(5, 5);
        addActor(actor);
        actor.setSize(5,5);
        addToWorld();
        setPosition(x, y);
        setTouchable(Touchable.disabled);
    }

    public void launch(float xForce, float yForce){
        this.getBody().applyForceToCenter(new Vector2(xForce, yForce), true);
        System.out.println("potato launched with "+xForce+" ; "+yForce+" forces");
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
        System.out.println("asdklfjkl;asdfj   "  + Math.toDegrees(radAngle));
        if(Math.toDegrees(radAngle) >= 90.0)  x = 0f;
        System.out.println("Krumpli: " + x + " ------ " + y);
    }

    public float underHundredify(float n){
        // TODO: 11/23/2017 Ennek adni egy értelmes nevet
        while(n > 100){
            n /= 10;
        }
        return n;
    }

    public void setRemoveEffect(){
        removeEffect = true;
    }


    public void act(float delta) {
        super.act(delta);
        if (getBody()!= null && getBody().getLinearVelocity().len()<0.01f){
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
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if (another instanceof Enemy || another instanceof Crate){
            System.out.println("Krumpli");
            setupXplosion(this.getBody().getLinearVelocity().len());
        }
    }

}
