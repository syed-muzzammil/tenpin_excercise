package dojo;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int totalScore;
    private int bonusRollsRemaining = 0;
    private static final int PINS_IN_STRIKE = 10;
    private int previousPins = 0;
    private int rollInFrame = 1;
    private List<Frame> frames;
    private Frame currentFrame;

    public Game() {
        frames = new ArrayList<Frame>();
        currentFrame = new Frame();
    }

    public void roll(int pins) {

        currentFrame.addRoll(pins);
        if(currentFrame.shouldClose()){
            currentFrame = new Frame();
        }

        updateTotalScore(pins);

        setBonusRollsRemaining(pins);
        setRollsInFrame(pins);

        if (isStrike(previousPins) && isStrike(pins)) {
            totalScore+=5;
        }
        previousPins = pins;
        frames.add(currentFrame);
    }

    private void setRollsInFrame(int pins) {
        if (isStrike(pins)) {
            rollInFrame = 1;
        } else if (isSpare(pins)) {
            rollInFrame = 1;
        } else {
            rollInFrame = 2;
        }
    }

    private void setBonusRollsRemaining(int pins) {
        if (isStrike(pins)) {
            bonusRollsRemaining = 2;
        } else if (currentFrame.isSpare()) {
            bonusRollsRemaining = 1;
        }
    }

    private void updateTotalScore(int pins) {
        if (bonusRollsRemaining > 0) {
            --bonusRollsRemaining;
            totalScore += pins;
        }
            totalScore += pins;
    }

    private boolean isStrike(int pins) {
        return rollInFrame == 1 && pins == PINS_IN_STRIKE;
    }

    private boolean isSpare(int pins) {
        return (rollInFrame == 2) && (pins + previousPins == PINS_IN_STRIKE);
    }

    public int score() {
        return totalScore;
    }
}