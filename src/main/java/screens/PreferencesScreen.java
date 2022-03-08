package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import core.ScreenManager;

public class PreferencesScreen implements Screen {
	private ScreenManager game;
	private Stage stage;
	private Label titleLabel; 
	private Label musicVolumeLabel;
	private Label soundVolumeLabel;
	private Label musicOnOffLabel;
	private Label soundOnOffLabel;
	
	public PreferencesScreen(ScreenManager game) {
		this.game = game;
		stage = new Stage(new StretchViewport(1200,480));
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1/30f));
		stage.draw();
	}

	@Override
	public void show() {
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		table.setFillParent(true);
		//table.setDebug(true);
		stage.addActor(table);
		
		Skin skin = new Skin(Gdx.files.internal("assets/glassy/skin/glassy-ui.json"));
		
		// Creating volume sliders
        final Slider musicVolumeSlider = new Slider( 0f, 1f, 0.1f, false, skin );
		musicVolumeSlider.setValue(game.getPreferences().getMusicVolume());
        musicVolumeSlider.addListener(new EventListener() {
  		@Override 
		public boolean handle(Event event) {
  			game.getPreferences().setMusicVolume(musicVolumeSlider.getValue());
                return false;
	    }
    });       
        final Slider soundVolumeSlider = new Slider( 0f, 1f, 0.1f, false, skin );
        soundVolumeSlider.setValue(game.getPreferences().getSoundVolume() );
        soundVolumeSlider.addListener(new EventListener() {
  		@Override
		public boolean handle(Event event) {
  			game.getPreferences().setSoundVolume(soundVolumeSlider.getValue() );
                return false;
	    }
    });
        
        // Creating on/off checkboxes
        final CheckBox musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked(game.getPreferences().isMusicOn());
        musicCheckbox.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean on = musicCheckbox.isChecked();
				game.getPreferences().setMusicChoice(on);
				return false;
			}
        });
        
        final CheckBox soundCheckbox = new CheckBox(null, skin);
        soundCheckbox.setChecked(game.getPreferences().isSoundOn());
        soundCheckbox.addListener(new EventListener() {
			@Override
			public boolean handle(Event event) {
				boolean on = soundCheckbox.isChecked();
				game.getPreferences().setSoundChoice(on);
				return false;
			}
        });
        
        // Adding a "Back to home menu" button		
        final TextButton backButton = new TextButton("Back", skin, "small");
        backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.changeScreen(ScreenManager.HOME);
				
			}
        });
        // Creating labels and adding the controls to table
        titleLabel = new Label( "Preferences", skin, "big");
        musicVolumeLabel = new Label("Music Volume", skin );
        soundVolumeLabel = new Label("Sound Volume", skin );
        musicOnOffLabel = new Label("On/Off", skin );
        soundOnOffLabel = new Label("On/Off", skin );
        	
        table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
        table.add(musicVolumeLabel);
        table.add(musicVolumeSlider);
        table.row().pad(10,0,0,10);
        table.add(musicOnOffLabel).left(); 
        table.add(musicCheckbox);
        table.row().pad(10,0,0,10);
        table.add(soundVolumeLabel);
        table.add(soundVolumeSlider);
        table.row().pad(10,0,0,10);
        table.add(soundOnOffLabel).left();
        table.add(soundCheckbox);
        table.row().pad(10,0,0,10);
        table.add(backButton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
	}

}
