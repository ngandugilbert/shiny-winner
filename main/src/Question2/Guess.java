/*
 * Guess The Number Game 
 * @author  Gilbert Ng'andu
 * @SIN     20153347
 * @Lecturer Mr. Chibuluma
 * Date: 18-05-2023
 */
package Question2;

import java.security.SecureRandom;
import java.awt.Color;

public class Guess {

    private int guessNumber;
    private Color statusColor;
    private String statusMsg;
    private boolean isPlay = true;
    private final String START_MESSAGE = "Enter your first guess.";
    private final String HOT_MESSAGE = "Too High, try again.";
    private final String COLD_MESSAGE = "Too Low, try again.";
    private final String CORRECT_MESSAGE = "Hooray! That was correct!";
    private final Color HOT = Color.RED;
    private final Color COLD = Color.BLUE;
    private final Color CORRECT = Color.GREEN;

    public Guess() {
        this.setGuessNumber();
        this.statusMsg = this.START_MESSAGE;
    }

    // status
    public String getStatus() {
        return this.statusMsg;
    }

    // get the current color
    public Color getColor() {
        return this.statusColor;
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

    // Validate user input to be between 1 and 1000
    private boolean isValid(int userInput) {
        if (userInput > 0 && userInput <= 1000) {
            return true;
        }
        return false;
    }

    // update status
    private void update(int statusFlag) {
        switch (statusFlag) {
            case 1:
                // update too high
                setState(HOT, HOT_MESSAGE);
                break;
            case 2:
                // update too low
                setState(COLD, COLD_MESSAGE);
                break;
            case 3:
                // update correct
                setState(CORRECT,CORRECT_MESSAGE);
                this.isPlay = false;
                break;
            default:
                break;
        }
    }

    // Set the state
    private void setState(Color statusColor, String statusMsg) {
        this.statusColor = statusColor;
        this.statusMsg = statusMsg;
    }

}
