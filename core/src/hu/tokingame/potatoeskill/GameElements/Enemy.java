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

    private boolean exp = false;

    private boolean xplosionFollow = false;

    public Enemy(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "floor", BodyDef.BodyType.DynamicBody, 500, 0.01f, 4, false); //TODO change to nem padló
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.ENEMY));

        addActor(actor);
        addToWorld();
        setPosition(x, y);
        setSize(5, 5);
        actor.setSize(5, 5);


    }

    public void setupXplosion(){
        exp = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(xplosionFollow){
            xplosion.setPosition(this.getX(), this.getY());
        }
        if (exp){
            exp = false;
            xplosion = new XssppolsinosssActor(world, getX(), getY());
            getStage().addActor(xplosion);
        }
    }

    public void die(){
        System.out.println("ded");
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        //Mikró csinál valamit
        if (another instanceof Potato){
            System.out.println("Mikró");
            setupXplosion();
        }

    }
}
