package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Cannon extends WorldActorGroup {

    public OneSpriteStaticActor actor;

    public Cannon(World world, float x, float y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody, 0, 0, 0, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CANNON));
        addActor(actor);
        addToWorld();
        setPosition(x, y);
        actor.setPosition(x,y);
        setSize(10, 10);
        actor.setSize(10, 10);
        setOrigin(0,0);
        actor.setOrigin(0, 0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
