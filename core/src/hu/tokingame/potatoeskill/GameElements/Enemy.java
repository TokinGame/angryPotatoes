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

public class Enemy extends ExploadableActor {

    OneSpriteStaticActor actor;

    public static int getCount() {
        return count;
    }

    private static int count = 0;



    public Enemy(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "floor", BodyDef.BodyType.DynamicBody, 500, 0.01f, 4, false); //TODO change to nem padló
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY));

        addActor(actor);
        addToWorld();
        setPosition(x, y);
        setSize(5, 5);
        actor.setSize(5, 5);


    }

    @Override
    protected void afterAddToWorld() {
        super.afterAddToWorld();
        count++;
    }

    @Override
    protected void afterRemoveFromWorld() {
        super.afterRemoveFromWorld();
        count--;
    }

    public void die(){
        System.out.println("ded");
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if (another instanceof Potato){
            System.out.println("Mikró");
        }
    }
}
