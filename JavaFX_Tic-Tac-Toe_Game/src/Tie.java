/**
 * TicTacToe Game:
 *
 * Author @ SEO JAMES
 * */
public class Tie {
    int tie;
/**
 * isTie method is a boolean type , used to check the game is tie or not ,
 * if it id true , return true, otherwise false.
 * */

    public boolean isTie(int tie) {
        this.tie+=1;
        if (this.tie==9){
        return true;
    }
        else{
            return false;
        }}
}
