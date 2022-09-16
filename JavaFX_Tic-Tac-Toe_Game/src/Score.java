/**
 * TicTacToe Game:
 *
 * Author @ SEO JAMES
 * */
public class Score {


    private int sc=0;

    public void setScore(int sc){
        this.sc+=5;
    }

    @Override
    public String toString() {
        return
                "score=" + sc ;

    }
}
