import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * TicTacToe Game:
 *
 * Author @ SEO JAMES
 * */


public class TicTacToeMain extends Application {

    /** store Score into Score1  */
    private Score score1;
    /** store Score into Score2  */
    private Score score2;
    /** store GraphicsContext into gc  */
    private GraphicsContext gc;
    /** store Label into scLabel1  */
    private Label scLabel1;
    /** store Label into scLabel2  */
    private Label scLabel2;
    /** store Label into scLabel1  */
    private Pane root;
    private int index;
/** Font used to give font size, style */
    private Font font;
    /** buttons - Button array  */
    private Button[] buttons;
    /** ValueArray isa String Array type*/
    private String[] valueArray;
    /** value is a String type*/
    private String value;
    /** action is a Boolean type*/
    private boolean action=true;

    private TicTacToe ticTacToe;
/** store Canvas into canvas*/
    private Canvas canvas;
/** store the player1 name */
    private TextField player1;
    /** store the player2 name */
    private TextField player2;

    private Label player2Label,player1Label;
    /**  used to store the start button*/
    private Button start;
//store error message
    private Label errorMsg;
    private Label tieLabel;
    // store the score of first player
    private int scoreOne=0;
    // store the score of second player
    private int scoreTwo=0;

    private int tie;
    // object for Tie
    private Tie tieClass=new Tie();
/**Store player One Name in  playerOneName*/
    private String playerOneName;
    /**Store player two Name in  playertwoName*/
    private String playerTwoName;

    /**
     * start Method is a void type ,
     * here we are giving player's(1 and 2) name using getText method.
     * in else statement , its show error message  like we not type the name.
     * @param ev is a ActionEvent
     */
    public void start(ActionEvent ev){
        errorMsg.setText("");
        playerOneName=player1.getText();
        playerTwoName=player2.getText();
        validatePlayer validatePlayer=new validatePlayer();
        validatePlayer.setPlayer1(player1.getText());
        validatePlayer.setPlayer2(player2.getText());
        if (validatePlayer.validatePlayer()){
           root.getChildren().removeAll(player1,player2,player2Label,player1Label,start,errorMsg);
            root.getChildren().remove(canvas);
            scLabel1.setText(playerOneName+" : "+score1.toString());
            scLabel2.setText(playerTwoName+" : "+score2.toString());
    }

    else{
        errorMsg.setText("Player name should be entered");


        }
    }


    /**
     *  checkButton method is a void type , used for the check which button is pressed..
     *
     * @param ev is a ActionEvent
     */
    private void checkButton(ActionEvent ev){

        this.tie=this.tie+1;
        if(tieClass.isTie(this.tie)){
            tieLabel=new Label("its a tie");
            tieLabel.setId("tieId");
            tieLabel.relocate(400, 20);
            root.getChildren().add(tieLabel);

        }
        else{
            int Id= Integer.parseInt(String.valueOf(ev.getTarget().toString().charAt(16)));// this will identify which button is pressed..

            if (action==true){
                valueArray[Id]="X";
                action=false;

                buttons[Id].setTextFill(Color.RED);
                buttons[Id].setText("X");
                buttons[Id].setId("pressedButton");
                ticTacToe=new TicTacToe(valueArray);
                ticTacToe.setValue("X");


            }
            else{
                valueArray[Id]="O";
                action=true;
                ticTacToe.setValue("O");
                buttons[Id].setTextFill(Color.BLACK);
                buttons[Id].setText("O");
                buttons[Id].setId("pressedButton");
                ticTacToe=new TicTacToe(valueArray);
                ticTacToe.setValue("O");
            }
            for (int i=0;i<valueArray.length;i++){

            }
            buttons[Id].setDisable(true);

            if (ticTacToe.checkCondition())
            {
                if (valueArray[Id]=="X"){

                    scoreOne=scoreOne+5;
                    score1.setScore(scoreOne);
                    tieLabel=new Label("player 1 win");
                    tieLabel.setId("tieId");
                    tieLabel.relocate(400, 20);
                    root.getChildren().add(tieLabel);
                    scLabel1.setText(playerOneName+" : "+score1.toString());
                }
                if (valueArray[Id]=="O"){
                    scoreTwo=scoreTwo+5;
                    score2.setScore(scoreTwo);
                    scLabel2.setText(playerTwoName+" : "+score2.toString());
                    tieLabel=new Label("player 2 win");
                    tieLabel.setId("tieId");
                    tieLabel.relocate(400, 20);
                    root.getChildren().add(tieLabel);

                }
                else{
                    if(tie==9){
                        tieLabel=new Label("its a tie");
                        tieLabel.setId("tieId");
                        tieLabel.relocate(400, 20);
                        root.getChildren().add(tieLabel);

                    }
                }
                for (int i=0;i< buttons.length-1;i++){
                    buttons[i].setDisable(true);
                }

            }
        }

    }



        /**
         * This is where you create your components and the model and add event
         * handlers.
         *
         * @param stage The main stage
         * @throws Exception for exception
         */
        @Override
        public void start(Stage stage) throws Exception {
            root = new Pane();
            root.setId("pane");
            Scene scene = new Scene(root, 750, 800);
            scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            stage.setTitle("TicTacToe_byGeorge");

            stage.setScene(scene);
            canvas=new Canvas(800,800);
            gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0,800,800);












            Button reset=new Button("");
            reset.setId("reset");
            reset.relocate(600, 20);
            reset.setPrefSize(100,34);
            root.getChildren().add(reset);
            reset.setOnAction(this::setReset);


            valueArray=new String[9];




            player1=new TextField();
            player1Label=new Label("Player 1");
            player1Label.setId("playername");
            player1Label.relocate(190,180);
            player2=new TextField();

            player2Label=new Label("Player 2");
            player2Label.setId("playername");
            player2Label.relocate(190,320);


            score1=new Score();
            score2=new Score();

            scLabel1=new Label(playerOneName+score1.toString());
            scLabel2=new Label(playerTwoName+score2.toString());

            scLabel1.setId("score");
            scLabel2.setId("score");

            scLabel1.relocate(0, 0);
            scLabel2.relocate(0, 20);

            scLabel1.setText(playerOneName+score1.toString());
            scLabel2.setText(playerTwoName+score2.toString());
            root.getChildren().addAll(scLabel1,scLabel2);




            Font font = Font.font("Comic Sans MS",60);
            buttons=new Button[10];
            for (int i=0;i< buttons.length-1;i++){
                String s=String.valueOf(i);
                buttons[i]=new Button();
                buttons[i].setId("button"+s);
                font = Font.font("Comic Sans MS",60);
                buttons[i].setFont(font);
               // buttons[i].setBackground(Color.WHITE);
                buttons[i].setPrefSize(250, 250);
                root.getChildren().add(buttons[i]);
                buttons[i].setOnAction(this::checkButton);

            }



            buttons[0].relocate(0,80);
            buttons[1].relocate(250, 80);
            buttons[2].relocate(500, 80);
            buttons[3].relocate(0,330);
            buttons[4].relocate(250, 330);
            buttons[5].relocate(500, 330);
            buttons[6].relocate(0, 580);
            buttons[7].relocate(250, 580);
            buttons[8].relocate(500, 580);

            errorMsg = new Label("");
            errorMsg.setId("errorMsg");
            errorMsg.relocate(30, 90);

            root.getChildren().add(canvas);
            root.getChildren().add(errorMsg);



            player1.setPrefSize(400,80);
            player2.setPrefSize(400,80);
            player1.relocate(190,230);
            player2.relocate(190,400);

            start=new Button("");
            start.setId("start");
            start.relocate(270, 500);
            start.setPrefSize(200,200);

            root.getChildren().addAll(player1,player2,player1Label,player2Label);

            root.getChildren().add(start);

            start.setOnAction(this::start);



            // 6. Show the stage
            stage.show();
        }

    /**
     * setReset method is used to reset the game
     * @param actionEvent
     */
    private void setReset(ActionEvent actionEvent) {

        valueArray=new String[9];
        tieClass=new Tie();
        root.getChildren().remove(tieLabel);
        this.tie=0;
        for (int i=0;i< buttons.length-1;i++){
            root.getChildren().remove(buttons[i]);
        }

        for (int i=0;i< buttons.length-1;i++){
            String s=String.valueOf(i);
            buttons[i]=new Button();
            buttons[i].setId("button"+s);
            font = Font.font("Comic Sans MS",60);
            buttons[i].setFont(font);
            buttons[i].setPrefSize(250, 250);
            root.getChildren().add(buttons[i]);
            buttons[i].setOnAction(this::checkButton);

        }
        buttons[0].relocate(0,80);
        buttons[1].relocate(250, 80);
        buttons[2].relocate(500, 80);
        buttons[3].relocate(0,330);
        buttons[4].relocate(250, 330);
        buttons[5].relocate(500, 330);
        buttons[6].relocate(0, 580);
        buttons[7].relocate(250, 580);
        buttons[8].relocate(500, 580);

    }

    /**
         * Make no changes here.
         *
         * @param args unused
         */
        public static void main(String[] args) {
            launch(args);
        }
    }


