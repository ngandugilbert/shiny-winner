/*
 * Guess The Number Game 
 * @author  Gilbert Ng'andu
 * @SIN     20153347
 * @Lecturer Mr. Chibuluma
 * Date: 18-05-2023
 */

import java.security.SecureRandom;
import java.awt.Color;

public class Guess {

    private int guessNumber;
    private Color color;
    private String status;
    private boolean isPlay = true;

    public Guess() {
        this.setGuessNumber();
    }

    // status
    public String getStatus() {
        return this.status;
    }

    // get the current color
    public Color getColor() {
        return this.color;
    }

  

    // is player still playing
    public boolean getIsPlay() {
        return this.isPlay;
    }

    // Method sets the random value for the guess number
    private void setGuessNumber() {
        var random = new SecureRandom();
        int number = 1 + random.nextInt(1000);
        this.guessNumber = number;
    }

    // gets user input and tests it
    public boolean play(int userInput) {
        if (isValid(userInput)) {
            // Check if the value is either below or over the guess value
            if (userInput > this.guessNumber) {
                // too high
                update(1);
            } else if (userInput < this.guessNumber) {
                // Too low
                update(2);
            } else {
                // Then it is equal
                update(3);
            }
            return true;
        }
        return false;
    }

    // Validate user input
    private boolean isValid(int userInput) {
        if (userInput > 0 && userInput <= 1000) {
            return true;
        }
        return false;
    }

    // update status
    private void update(int flag) {
        switch (flag) {
            case 1:
                // update too high
                setState(Color.RED, "Too High");
                break;
            case 2:
                // update too low
                setState(Color.BLUE, "Too Low");
                break;
            case 3:
                // update correct
                setState(Color.GREEN, "Correct!");
                this.isPlay = false;
                break;
        }
    }

    // Set the state
    private void setState(Color color, String statusMsg) {
        this.color = color;
        this.status = statusMsg;
    }

}
