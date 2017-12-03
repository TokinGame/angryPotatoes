package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.ShapeType;

/**
 * Created by davimatyi on 2017. 11. 15..
 */

public class LongCrate extends Crate{
    public LongCrate(World world, float X, float Y) {
        super(world, X, Y);
        setWidth(15);
        actor.setWidth(15);
    }
}
