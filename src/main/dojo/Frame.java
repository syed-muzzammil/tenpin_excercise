package dojo;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    public static final int TOTAL_PINS = 10;
    public List<Integer> rolls = new ArrayList<Integer>();

    public void addRoll(int pins) {
        if( rolls.isEmpty()) {
            rolls.add(0, pins);
        } else {
            rolls.add(1, pins);
        }
    }

    public boolean shouldClose() {
        if(isStrike()){
            return true;
        } else if(rolls.isEmpty()){
            return false;
        }

        return true;
    }

    public boolean isStrike() {
        return rolls.get(0) == TOTAL_PINS;
    }

    public boolean isSpare(){
        return rolls.size() == 2 && rolls.get(0) + rolls.get(1) == TOTAL_PINS;
    }
}
