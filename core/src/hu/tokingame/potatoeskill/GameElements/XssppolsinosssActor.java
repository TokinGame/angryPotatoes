package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 11. 21..
 */

public class XssppolsinosssActor extends WorldActorGroup {
    public XssppolsinosssActor(World world, float X, float Y) {
        super(world, ShapeType.Circle, BodyDef.BodyType.KinematicBody, 1, 1, 1, true);
    }
}
