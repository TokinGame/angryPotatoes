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

        setSize(1000, 1000);
        addToWorld();
        setPosition(0, -1000);
    }
}
