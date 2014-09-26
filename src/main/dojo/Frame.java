package dojo;

public class Frame {
    public static final int TOTAL_PINS = 10;
    private Integer rollOne = null;
    private Integer rollTwo = null;

    public int getRollOne() {
        return rollOne;
    }

    public void setRollOne(int rollOne) {
        this.rollOne = rollOne;
    }

    public int getRollTwo() {
        return rollTwo;
    }

    public void setRollTwo(int rollTwo) {
        this.rollTwo = rollTwo;
    }

    public void addRoll(int pins) {
        if( rollOne == null) {
            rollOne = pins;
        } else {
            rollTwo = pins;
        }
    }

    public boolean shouldClose() {
        if(isStrike()){
            return true;
        } else if(rollOne == null || rollTwo == null){
            return false;
        }

        return true;
    }

    private boolean isStrike() {
        return rollOne == TOTAL_PINS;
    }
}
