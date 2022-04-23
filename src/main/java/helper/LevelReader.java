package helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * This class handles the number of game levels
 */

public class LevelReader {
    public static int getLevels(){
        int numberOfLevels = 0;

        int i = 1;
        while(Gdx.files.internal("assets/maps/map" + i + ".tmx") != null){
            try{
                new TmxMapLoader().load(String.valueOf(Gdx.files.internal("assets/maps/map" + i + ".tmx")));
                numberOfLevels++;
                i++;
            }
            catch (Exception e){
                break;
            }
        }

        return numberOfLevels;
    }
}
