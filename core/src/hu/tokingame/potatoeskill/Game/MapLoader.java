package hu.tokingame.potatoeskill.Game;

import com.badlogic.gdx.physics.box2d.World;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import hu.tokingame.potatoeskill.GameElements.Crate;

/**
 * Created by davimatyi on 2017. 11. 15..
 */

public class MapLoader {
    GameStage gameStage;
    World world;
    int level;

    public MapLoader(GameStage gs, World w, int l){
        gameStage = gs;
        world = w;
        level = l;

    }



}
