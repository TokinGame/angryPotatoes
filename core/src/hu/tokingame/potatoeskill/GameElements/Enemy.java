package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davimatyi on 2017. 11. 16..
 */

public class Enemy extends WorldActorGroup {

    OneSpriteStaticActor actor;

    private XssppolsinosssActor xplosion;

    private boolean xplosionFollow = false;

    public Enemy(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "floor", BodyDef.BodyType.DynamicBody, 1000, 0.01f, 10, false); //TODO change to nem padló
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY));
        addActor(actor);
        addToWorld();
        setPosition(x, y);
        setSize(5, 5);
        actor.setSize(5, 5);


    }

    public void setupXplosion(XssppolsinosssActor actor){
        xplosion = actor;
        xplosionFollow = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(xplosionFollow){
            xplosion.setPosition(this.getX(), this.getY());
        }
    }

    public void die(){
        System.out.println("ded");
    }
}
