package RockPaperSci_JAVAFX;

public class BackEnd {
    //rock=0,paper=1,scissorcs=2
    private int userchoice;
    private int systemchoice;

    private int answer;// 0-user wins , 1-opponent wins , 2-draw

    public int getUserchoice() {
        return userchoice;
    }

    public int getSystemchoice() {
        return systemchoice;
    }

    public int getAnswer() {
        return answer;
    }

    public void setUserchoice(int userchoice) {
        this.userchoice = userchoice;
        setSystemchoice(0);
        setAnswer(userchoice);
    }

    public void setSystemchoice(int systemchoice) {
        this.systemchoice =(int)(Math.random()*3);
    }
    public void setAnswer(int userchoice) {
        if (userchoice==systemchoice) {
            answer=2;
        }
        else if (userchoice==0) {
            if (systemchoice==2) {
                answer=0;
            } else if (systemchoice==1) {
                answer=1;
            }
        } else if (userchoice==1) {
            if (systemchoice==2) {
                answer=1;
            } else if (systemchoice==0) {
                answer=0;
            }
   } else if (userchoice==2) {
            if (systemchoice ==0) {
                answer=1;
            } else if (systemchoice==1) {
                answer=0;
            }
        }

    }


}
