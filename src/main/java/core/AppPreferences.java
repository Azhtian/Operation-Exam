package core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/*
 * This class stores the application preferences, and saves them when closing game 
 */

public class AppPreferences {
	private static final String PREF_MUSIC_ON = "music.on";
	private static final String PREF_MUSIC_VOL = "music.volume";
	private static final String PREF_SOUND_ON = "sound.on";
	private static final String PREFS_NAME = "OperationExam";
	
	protected Preferences getPrefs() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}
	
	public boolean isMusicOn() {
		return getPrefs().getBoolean(PREF_MUSIC_ON, true);
	}
	
	public void setMusicChoice(boolean musicOn) {
		getPrefs().putBoolean(PREF_MUSIC_ON, musicOn);
		getPrefs().flush();
	}
	
	public boolean isSoundOn() {
		return getPrefs().getBoolean(PREF_SOUND_ON, true);
	}
	
	public void setSoundChoice(boolean soundOn) {
		getPrefs().putBoolean(PREF_SOUND_ON, soundOn);
		getPrefs().flush();
	}
	
	public float getMusicVolume() {
		return getPrefs().getFloat(PREF_MUSIC_VOL, 0.5f);
	}
	
	public void setMusicVolume(float volume) {
		getPrefs().putFloat(PREF_MUSIC_VOL, volume);
		getPrefs().flush();
	}
	
}
