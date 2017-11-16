package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldActorGroup;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Floor extends WorldActorGroup {


    public Floor(World world) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody, 0.1f, 0.5f, 10, false);
        addToWorld();
        setPosition(0, 10);
        setSize(10000, 10);
    }
}
