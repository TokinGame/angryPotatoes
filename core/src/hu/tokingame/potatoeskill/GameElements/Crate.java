package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 11. 15..
 */

public class Crate extends WorldActorGroup {

    OneSpriteStaticActor actor;

    public Crate(World world, float X, float Y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 1000, 0.01f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE));
        addActor(actor);
        addToWorld();
        setPosition(X, Y);
        setSize(50, 50);
        actor.setSize(50, 50);
    }
}
