/**
 * TicTacToe Game:
 *
 * Author @ SEO JAMES
 * */
public class validatePlayer {

    /** Player1 String  */
    private String player1;

    /** Player2 String  */
    private String player2;
     /**
      * validatePlayer method is a boolean type - constructor. */
    public boolean validatePlayer(){
        if (getPlayer1().length()>0 && getPlayer2().length()>0){
            return true;
        }
        else{
            return false;
        }
    }

/**
 * getPlayer1 method is a string type , used to get player1
 * */
    public String getPlayer1() {
        return player1;
    }
    /**
     * setPlayer1 method is a Void type , used to set player1
     * passing arguments as string.
     * */
    public void setPlayer1(String player1){
        this.player1=player1;
    }
    /**
     * getPlayer2 method is a string type , used to get player2
     * */
    public String getPlayer2()
    {
        return player2;
    }
    /**
     * setPlayer2 method is a Void type , used to set player2
     * passing arguments(Player2) as string.
     * */
    public void setPlayer2(String player2)
    {
        this.player2=player2;
    }
}
