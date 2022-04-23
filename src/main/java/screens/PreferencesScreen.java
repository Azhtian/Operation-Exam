package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import helper.ScreenManager;

public class PreferencesScreen extends AbstractScreen {

	public PreferencesScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
		// Creating volume sliders
        final Slider musicVolumeSlider = new Slider( 0f, 1f, 0.1f, false, skin );
		musicVolumeSlider.setValue(game.getPreferences().getMusicVolume());
        musicVolumeSlider.addListener(event -> {
			game.getPreferences().setMusicVolume(musicVolumeSlider.getValue());
return false;
});       
        final Slider soundVolumeSlider = new Slider( 0f, 1f, 0.1f, false, skin );
        soundVolumeSlider.setValue(game.getPreferences().getSoundVolume() );
        soundVolumeSlider.addListener(event -> {
			game.getPreferences().setSoundVolume(soundVolumeSlider.getValue() );
return false;
});
        
        // Creating on/off checkboxes
        final CheckBox musicCheckbox = new CheckBox(null, skin);
        musicCheckbox.setChecked(game.getPreferences().isMusicOn());
        musicCheckbox.addListener(event -> {
			boolean on = musicCheckbox.isChecked();
			game.getPreferences().setMusicChoice(on);
			return false;
		});
        
        final CheckBox soundCheckbox = new CheckBox(null, skin);
        soundCheckbox.setChecked(game.getPreferences().isSoundOn());
        soundCheckbox.addListener(event -> {
			boolean on = soundCheckbox.isChecked();
			game.getPreferences().setSoundChoice(on);
			return false;
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
		Label titleLabel = new Label("Preferences", skin, "big");
		Label musicVolumeLabel = new Label("Music Volume", skin);
		Label soundVolumeLabel = new Label("Sound Volume", skin);
		Label musicOnOffLabel = new Label("On/Off", skin);
		Label soundOnOffLabel = new Label("On/Off", skin);
        	
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

}
