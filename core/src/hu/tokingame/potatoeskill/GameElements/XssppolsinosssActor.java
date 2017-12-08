package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteAnimatedActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 11. 21..
 */

public class XssppolsinosssActor extends WorldActorGroup {

    OneSpriteAnimatedActor actor;
    float elapsedTime = 0;
    private boolean decorative = false;
    private float projVelocity = 0;

    public XssppolsinosssActor(World world, float X, float Y, float projVelocity) {
        super(world, ShapeType.Circle, BodyDef.BodyType.StaticBody, 1, 1, 1, true);
        actor = new OneSpriteAnimatedActor("GameTextures/explosion.txt");
        setSize(15, 15);
        actor.setSize(15,15);
        actor.setFps(24);
        addActor(actor);
        setPosition(X, Y);
        addToWorld();
        this.projVelocity = projVelocity;
    }

    public XssppolsinosssActor(World world, float X, float Y, float width, float height, boolean decorative, float projVelocity) {
        super(world, ShapeType.Circle, BodyDef.BodyType.StaticBody, 1, 1, 1, true);
        actor = new OneSpriteAnimatedActor(Assets.manager.get(Assets.EXPLOSION_TEXTUREATLAS));
        this.decorative = decorative;
        setSize(width, height);
        actor.setSize(width, height);
        actor.setFps(24);
        actor.setFrame(1);
        addActor(actor);
        setPosition(X, Y);
        addToWorld();
        this.projVelocity = projVelocity;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime += delta;
        if( actor.getCurrentFrame() == actor.getFrameCount()){
            removeFromStage();
            removeFromWorld();
        }
    }


    public float getHitStrength(){
        // TODO: 11/30/2017 kalibri
        if(projVelocity == 0) return 0;
        else if(isBetween(projVelocity, 1,15)) return 1;
        else if (isBetween(projVelocity, 16, 20)) return 2;
        else if (isBetween(projVelocity, 21, 25)) return 3;
        else if (isBetween(projVelocity, 26, 30)) return 4;
        else if (isBetween(projVelocity, 31, 35)) return 5;
        else if (isBetween(projVelocity, 36, 40)) return 6;
        else if (isBetween(projVelocity, 41, 45)) return 7;
        else if (isBetween(projVelocity, 46, 50)) return 8;
        else if (isBetween(projVelocity, 51, 55)) return 9;
        else if (isBetween(projVelocity, 56, 60)) return 10;
        else return 11;
    }

    private static boolean isBetween(float num, float min, float max){
        return num >= min && num <= max;
    }


    public boolean isDecorative() {
        return decorative;
    }
}
