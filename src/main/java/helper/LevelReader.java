package helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

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
