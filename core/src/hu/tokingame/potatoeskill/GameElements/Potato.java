package hu.tokingame.potatoeskill.GameElements;

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

    private static final float SPEED_MULTIPLIER = 25f, x = 1f;

    private float y = -666;

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


    public void shootThisShit() throws Exception{
        if(y == -666){
            throw new Exception("A kilövés elött be kell álítani a szöget");
        }
        if(canSu){
            this.getBody().setLinearVelocity(this.getBody().getLinearVelocity().x + x * SPEED_MULTIPLIER, this.getBody().getLinearVelocity().y + y * SPEED_MULTIPLIER);
            canSu = false;
        }

    }

    public void setLaunchAngle(float radAngle){
        y = (float) Math.tan(radAngle) / x;

    }

    @Override


    public void act(float delta) {
        super.act(delta);
        if (getBody()!= null && getBody().getLinearVelocity().len()<0.01f){
            removeFromWorld();
        }
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        //Krumpli csinál valamit
        if (another instanceof Enemy){
            System.out.println("Krumpli");
            setupXplosion();
        }
    }
}
