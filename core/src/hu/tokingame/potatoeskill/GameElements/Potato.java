package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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
        super(world, loader, "potato.png", BodyDef.BodyType.DynamicBody, 0.1f, 0.1f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO));
        setSize(5, 5);
        addActor(actor);
        actor.setSize(5,5);
        addToWorld();
        setPosition(x, y);
        actor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                launch(50, 50);
                System.out.println("röp");
            }
        });
    }

    public void launch(float xForce, float yForce){
        this.getBody().applyForceToCenter(new Vector2(xForce, yForce), true);
        System.out.println("potato launched with "+xForce+" ; "+yForce+" forces");
    }


}
