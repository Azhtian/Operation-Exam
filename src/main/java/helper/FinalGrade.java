package helper;

import model.Model;
import model.TimeCounter;

public class FinalGrade {
    static TimeCounter gameTime = TimeCounter.getInstance();

    /**
     * This function calculates the grade of the player. The grade is based on how many books the player collected and how much time they spent.
     *
     * How it's calculated:
     * First the percentage of books is found for example 0.845
     * Then this number is multiplied by 10 and casted to int -> 8
     * Then every hour the player arrives after 09:00 is deducted from the score, for example if the player arrives at 10, 1 point is deducted.
     * This gives a final score of 7 which gives the grade B
     *
     * @param numberOfBooksCollected
     * @return
     */
    public static String calculate(int numberOfBooksCollected){
        float totalNumberOfBooks = Model.books.size();

        float percentageOfBooksCollected = numberOfBooksCollected/totalNumberOfBooks;
        int pointsForGrade = ((int) (percentageOfBooksCollected * 10)) - (gameTime.getHour() - 9);

        //If the player arrives 5 hours after the exam started they fail
        if (gameTime.getHour() - 9 > 5){
            return "F";
        }
        else if (pointsForGrade >= 8){
            return "A";
        } else if (pointsForGrade >= 7){
            return "B";
        } else if (pointsForGrade >= 6){
            return "C";
        } else if (pointsForGrade >= 5){
            return "D";
        } else if (pointsForGrade >=4) {
            return "E";
        } else {
            return "F";
        }
    }
}
