package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Cannon extends WorldActorGroup {

    public OneSpriteStaticActor actor;

    public Cannon(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "cannon", BodyDef.BodyType.StaticBody, 0, 0, 0, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CANNON));
        addActor(actor);
        addToWorld();
        setSize(10, 10);
        actor.setSize(10, 10);
        setPosition(x, y);
        actor.setPosition(x,y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
