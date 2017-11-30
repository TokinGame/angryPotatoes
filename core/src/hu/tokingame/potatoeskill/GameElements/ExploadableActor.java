package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by M on 11/23/2017.
 */

public class ExploadableActor extends WorldActorGroup{

    private XssppolsinosssActor xplosion;

    private boolean exp = false, exploading = false;

    private float explWidht = 15f, explHeight = 15f, projVelocity;



    public ExploadableActor(World world, ShapeType shapeType, BodyDef.BodyType bodyType, FixtureDef fixtureDef) {
        super(world, shapeType, bodyType, fixtureDef);
    }

    public ExploadableActor(World world, WorldBodyEditorLoader loader, String bodyID, BodyDef.BodyType bodyType, FixtureDef fixtureDef) {
        super(world, loader, bodyID, bodyType, fixtureDef);
    }

    public ExploadableActor(World world, ShapeType shapeType, BodyDef.BodyType bodyType, float friction, float restitution, float density, boolean isSensor) {
        super(world, shapeType, bodyType, friction, restitution, density, isSensor);
    }

    public ExploadableActor(World world, WorldBodyEditorLoader loader, String bodyID, BodyDef.BodyType bodyType, float friction, float restitution, float density, boolean isSensor) {
        super(world, loader, bodyID, bodyType, friction, restitution, density, isSensor);
    }


    public void setupXplosion(float velocity){
        exp = true;
        this.projVelocity = velocity;
    }

    public void setupXplosion(float explWidht, float explHeight){
        setExplSize(explWidht, explHeight);
        exp = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(xplosion != null){
            xplosion.setPosition(this.getX(), this.getY());
        }
        if (exp && !exploading){
            exp = false;
            xplosion = new XssppolsinosssActor(world, getX(), getY(), explWidht, explHeight, false);
            getStage().addActor(xplosion);
            exploading  = true;
        }
    }


    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if(another instanceof XssppolsinosssActor && !((XssppolsinosssActor)another).isDecorative()){
            hitByExplosion();
        }
    }

    public void hitByExplosion(){
        this.removeFromWorld();
    }


    public float getExplWidht() {
        return explWidht;
    }

    public float getExplHeight() {
        return explHeight;
    }


    public void setExplSize(float explWidht, float explHeight) {
        this.explWidht = explWidht;
        this.explHeight = explHeight;
        if(xplosion != null){
            xplosion.setSize(explWidht, explHeight);
            xplosion.actor.setSize(explWidht, explHeight);
        }
    }


    public boolean isExploading() {
        return exploading;
    }

}
