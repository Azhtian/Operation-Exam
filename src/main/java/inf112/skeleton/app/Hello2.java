package inf112.skeleton.app;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class Hello2 implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont font;

    private TiledMap tileMap;
    private TiledMapTileLayer board, player, hole, flag;
    
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    
    private Cell playerWonCell, playerDiedCell, playerCell; 
    private Texture texture;
    
    private TiledMapTile[] tile; 

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        // Displaying board 
        tileMap = new TmxMapLoader().load("RoboRally_Tiled.tmx");
        board = (TiledMapTileLayer) tileMap.getLayers().get("Board");
        player = (TiledMapTileLayer) tileMap.getLayers().get("Player");
        hole = (TiledMapTileLayer) tileMap.getLayers().get("Hole");
        flag = (TiledMapTileLayer) tileMap.getLayers().get("Flag");
        camera = new OrthographicCamera();
        camera.setToOrtho(false,5,5);
        camera.position.x = 2.5f;
        camera.update();             
        renderer = new OrthogonalTiledMapRenderer(tileMap); 
        // Displaying players
        texture = new Texture("player.png"); 
        TextureRegion[][] regions = TextureRegion.split(texture, 60, 60);
        playerWonCell = new Cell();
        playerDiedCell = new Cell();
        playerCell = new Cell();  
        tile = new TiledMapTile[3]; 
        tile[0] = new StaticTiledMapTile(regions[0][0]);
        playerWonCell.setTile(tile[0]);
        tile[1] = new StaticTiledMapTile(regions[0][1]);
        playerDiedCell.setTile(tile[1]);
        tile[2] = new StaticTiledMapTile(regions[1][0]);
        playerCell.setTile(tile[2]);                
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        //Display board
        player.setCell(0, 0, playerWonCell); 
        renderer.setView(camera); 
        renderer.render();
    }

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}