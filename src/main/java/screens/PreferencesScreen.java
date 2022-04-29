package screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import helper.ScreenManager;

public class PreferencesScreen extends AbstractScreen {

	public PreferencesScreen(ScreenManager game) {
		super(game);
	}

	@Override
	public void show() {
        super.show();

        // Creating music volume slider
        final Slider musicVolumeSlider = new Slider( 0f, 1f, 0.1f, false, skin );
        musicVolumeSlider.setValue(game.getPreferences().getMusicVolume());
        musicVolumeSlider.addListener(event -> {
        	game.getPreferences().setMusicVolume(musicVolumeSlider.getValue());
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
		Label musicOnOffLabel = new Label("Music On/Off", skin);
		Label soundOnOffLabel = new Label("Volume On/Off", skin);
        	
        table.add(titleLabel).colspan(2);
        table.row().pad(10,0,0,10);
        table.add(musicVolumeLabel);
        table.add(musicVolumeSlider);
        table.row().pad(10,0,0,10);
        table.add(musicOnOffLabel).left(); 
        table.add(musicCheckbox);
        table.row().pad(10,0,0,10);
        table.add(soundOnOffLabel).left();
        table.add(soundCheckbox);
        table.row().pad(10,0,0,10);
        table.add(backButton);
	}

}
