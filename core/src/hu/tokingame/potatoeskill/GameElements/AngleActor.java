package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;

/**
 * Created by M on 11/16/2017.
 */

public abstract class AngleActor extends OneSpriteStaticActor {
    public AngleActor() {
        super(Assets.manager.get(Assets.ZOLISCREENSHOT));
        this.setSize(300,300);
        this.setPosition(0,0);
        this.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                onDrag(x,y);
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                System.out.println(x + "djlkjfalkdsjf" + y);
                onDrag(x,y);
            }
        });
    }

    private void onDrag(float x, float y){
        if(x < 0.0f) x = 0.0f;
        if(y < 0.0f) y = 0.0f;
        float angle = (float) Math.toDegrees(Math.atan(y/x));
        onAngelUpdate(angle);
    }

    public abstract void onAngelUpdate(float angle);
}
