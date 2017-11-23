package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Potato extends WorldActorGroup {

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

    private float calcStandardX(float x){
        // TODO: 11/21/2017
        while((int)x > 10){
            x /= 10.0;
        }
        return x * SPEED_MULTIPLIER;
    }

    private float calcStandardY(float y){
        // TODO: 11/21/2017
        while((int)y > 10){
            y /= 10.0;
        }
        return y * SPEED_MULTIPLIER;
    }

}
