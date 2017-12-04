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

public class Crate extends ExploadableActor {

    OneSpriteStaticActor actor;

    private float hp = 3;

    public Crate(World world, float X, float Y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 1000, 0.01f, 8, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE));
        addActor(actor);
        setSize(5, 5);
        actor.setSize(5, 5);
        setOrigin(0, 0);
        addToWorld();
        setPosition(X, Y);
        setScoreValue(1000);
    }

    @Override
    public void hitByExplosion(XssppolsinosssActor actor) {
        //super.hitByExplosion();
        hp -= actor.getHitStrength();
        System.out.println("Strength: >>> " + actor.getHitStrength());
        if(hp <= 0){
            this.removeFromWorld();
        }
    }
}
