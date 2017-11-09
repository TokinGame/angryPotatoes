package hu.tokingame.potatoeskill.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.Global.Globals;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.MyStage;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokingame.potatoeskill.MyGdxGame;

/**
 * Created by M on 11/9/2017.
 */

public class MenuStage extends MyStage {

    private OneSpriteStaticActor baglogic;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        addActor(baglogic = new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2f - this.getWidth() / 2f, Globals.WORLD_HEIGHT/2f - this.getHeight()/2f);
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        baglogic.setRotation(baglogic.getRotation() + 1f);
    }
}
