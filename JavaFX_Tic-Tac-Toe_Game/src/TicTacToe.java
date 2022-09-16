/**
 * TicTacToe Game:
 *
 * Author @ SEO JAMES
 * */
public class TicTacToe {
    /**valueArray is a String array type. */
    private String[] valueArray;
    /**value is a String  type. */
    private String value;

    /**
     * TicTacToe method is a Constructor.
     * @param valueArray String array type
     */
    public TicTacToe(String[] valueArray)
    {
        this.valueArray=valueArray;
    }

    /**
     * setValue method is void type.
     * @param value is a String type.
     */
    public void setValue(String value){
        this.value=value;
    }

    /**
     * checkCondition method is a boolean type
     * here we are giving the Tie condition like (0,2,3) are equal then its return true.
     * like that we given 8 condition using if statement , else
     * if the condition is not true , then return false.
     * @return
     */
    public boolean checkCondition(){
        if(valueArray[0]==value && valueArray[2]==value && valueArray[1]==value ){
            return true;
        }
        if(valueArray[3]==value && valueArray[4]==value && valueArray[5]==value ){
            return true;
        }
        if(valueArray[6]==value && valueArray[7]==value && valueArray[8]==value ){
            return true;
        }
        if(valueArray[0]==value && valueArray[3]==value && valueArray[6]==value ){
            return true;
        }
        if(valueArray[1]==value && valueArray[4]==value && valueArray[7]==value ){
            return true;
        }
        if(valueArray[2]==value && valueArray[5]==value && valueArray[8]==value ){
            return true;
        }
        if(valueArray[0]==value && valueArray[4]==value && valueArray[8]==value ){
            return true;
        }
        if(valueArray[2]==value && valueArray[4]==value && valueArray[6]==value ){
            return true;
        }
        return false;
    }

}
