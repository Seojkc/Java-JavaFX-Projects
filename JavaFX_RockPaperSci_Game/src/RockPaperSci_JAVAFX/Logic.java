package RockPaperSci_JAVAFX;

public class Logic {

    //rock=1,paper=2,scissorcs=3
    private int randomOpponentValue;
    private int value;

    private int result;// 1-user wins , 2-opponent wins , 3-draw

    public void setrandomOpponentValue() {

        randomOpponentValue = (int)(1+Math.random()*3);
    }

    public int getrandomOpponentValue() {
        return randomOpponentValue;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value=value;
        setrandomOpponentValue();
        logic(value);
    }


    public void logic(int value) {


/**
 * Checking if the opponent's and player's move is the same
 */
        if (value==randomOpponentValue) {
            setResult(3);
        }
        /**
         * Checking if the opponent has won or lost over rock
         */

        else if (getValue()==1) {
            if (randomOpponentValue==3) {
                setResult(1);
            } else if (randomOpponentValue==2) {
                setResult(2);
            }
/**
 * Checking if the opponent has won or lost over paper
 */
        } else if (getValue()==2) {
            if (randomOpponentValue==3) {
                setResult(2);
            } else if (randomOpponentValue==1) {
                setResult(1);
            }
/**
 * Checking if the opponent has won or lost over scissors
 */
        } else if (getValue()==3) {
            if (randomOpponentValue ==1) {
                setResult(2);
            } else if (randomOpponentValue==2) {
                setResult(1);
            }

        }


    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

