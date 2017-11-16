package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.World.WorldActorGroup;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davim on 2017. 11. 09..
 */

public class Potato extends WorldActorGroup {

    private OneSpriteStaticActor actor;

    public Potato(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "potato.png", BodyDef.BodyType.DynamicBody, 0.1f, 1f, 10, true);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO));
        setSize(50, 50);
        addActor(actor);
        actor.setSize(50,50);
        addToWorld();
        setPosition(x, y);
    }
}
