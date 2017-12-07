package hu.tokingame.potatoeskill.GameElements;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.potatoeskill.Global.Assets;
import hu.tokingame.potatoeskill.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 12/7/2017.
 */

public class WindDirectionActor extends OneSpriteStaticActor {
    private float windIntensity;

    private static final float WIND_INTENSITY_MULTIPLIER = 5f;

    public WindDirectionActor() {
        super(Assets.manager.get(Assets.WIND_ARROW));
        this.setSize(40,18);
        this.setPosition(500,500);
    }

    @Override
    public void init() {
        super.init();
    }

    public void setWindIntensity(float intensity){
        this.windIntensity = intensity;
        System.out.println("wind intensity>>>>>>>>>"+Math.signum(intensity));
        switch ((int)Math.signum(intensity)){
            case -1: this.setRotation(180); break;
            case 1: this.setRotation(0); break;
        }
    }

}
