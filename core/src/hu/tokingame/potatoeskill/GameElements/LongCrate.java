package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;
import hu.tokingame.potatoeskill.World.WorldBodyEditorLoader;

/**
 * Created by davimatyi on 2017. 11. 15..
 */

public class LongCrate extends Crate{
    public LongCrate(World world, WorldBodyEditorLoader loader, float X, float Y) {
        super(world, loader,"longcrate", X, Y);
        setSize(15, 5);
        actor.setWidth(15);
        setScoreValue(3000);
    }
}
