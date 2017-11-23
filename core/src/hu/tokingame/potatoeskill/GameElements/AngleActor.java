package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.UI.OneSpriteStaticActor;

/**
 * Created by M on 11/16/2017.
 */

public abstract class AngleActor extends OneSpriteStaticActor {

    private float angle, radAngle;

    public AngleActor() {
        super(Assets.manager.get(Assets.ZOLISCREENSHOT));
        this.setSize(30,30);
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
                System.out.println("AngleActor: " + x + " ------ " + y);
                onDrag(x,y);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                onTouchUp(x, y);
            }
        });
    }

    private void onDrag(float x, float y){
        if(x < 0.0f) x = 0.0f;
        if(y < 0.0f) y = 0.0f;
        radAngle = (float) Math.atan(y/x);
        angle = Math.abs((float) Math.toDegrees(radAngle));
        onAngleUpdate(angle);
    }

    public float getAngle() {
        return angle;
    }

    public float getRadAngle() {
        return radAngle;
    }

    public abstract void onAngleUpdate(float angle);

    public abstract void onTouchUp(float x, float y);

}