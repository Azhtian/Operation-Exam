package model;

public class TimeCounter {
    private int gameTimeHour = 7;
    private int gameTimeMinutes = 0;
    private float timeCount = 0;

    //Singleton coding pattern
    private static TimeCounter instance = null;
    public static TimeCounter getInstance() {
        if (instance == null) {
            instance = new TimeCounter();
        }
        return instance;
    }

    public void updateTime(float dt){
        timeCount += dt;
        if(timeCount >= 3){
            gameTimeMinutes+=1;
            if (gameTimeMinutes == 60){
                gameTimeHour+=1;
                gameTimeMinutes = 0;
            }
            timeCount = 0;
        }
    }

    public String getTime(){
        String hours;
        String minutes;
        minutes = gameTimeMinutes < 10 ? "0" + gameTimeMinutes : Integer.toString(gameTimeMinutes);
        hours = gameTimeHour < 10 ? "0" + gameTimeHour : Integer.toString(gameTimeHour);
        return hours + ":" + minutes;
    }
}
