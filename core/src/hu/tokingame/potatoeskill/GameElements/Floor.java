package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Floor extends WorldActorGroup {


    public Floor(World world, WorldBodyEditorLoader loader) {
        super(world, loader, "floor", BodyDef.BodyType.StaticBody, 10, 1, 1, false);
        addToWorld();
        setSize(10000, 10);
        setPosition(0, 0);
    }
}
