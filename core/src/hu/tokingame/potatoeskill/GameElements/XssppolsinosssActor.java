package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteAnimatedActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 11. 21..
 */

public class XssppolsinosssActor extends WorldActorGroup {

    OneSpriteAnimatedActor actor;
    float elapsedTime = 0;

    public XssppolsinosssActor(World world, float X, float Y) {
        super(world, ShapeType.Circle, BodyDef.BodyType.StaticBody, 1, 1, 1, true);
        actor = new OneSpriteAnimatedActor("GameTextures/explosion.txt");
        setSize(15, 15);
        actor.setSize(15,15);
        actor.setFps(10);
        addActor(actor);
        setPosition(X, Y);
        addToWorld();
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
}
