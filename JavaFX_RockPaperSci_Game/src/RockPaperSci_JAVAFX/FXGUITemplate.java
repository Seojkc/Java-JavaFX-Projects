package RockPaperSci_JAVAFX;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author SEOJAMES
 */
public class FXGUITemplate extends Application {

    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods

    private final Image imgPaper=new Image("RockPaperSci_JAVAFX/paper.png");
    private final Image imgRock=new Image("RockPaperSci_JAVAFX/rock.png");
    private final Image imgSci=new Image("RockPaperSci_JAVAFX/sci.png");
    private  String user;
    private ImageView imgview1,imgview2;
    private BackEnd backEnd;
    private Label result;
    private int score;
    private Label scLbl;
    private int chances;
    private Label chancesLbl;

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        root.setId("body");
        Scene scene = new Scene(root, 530, 700); // set the size here
        stage.setTitle("RockPaperSci"); // set the window title here
        stage.setScene(scene);
        scene.getStylesheets().addAll(this.getClass().getResource("CssFile.css").toExternalForm());//calling css




        imgview1=new ImageView(choice1(imgPaper));
        imgview2=new ImageView(choice2(imgPaper));
        Label vs=new Label("VS");
        result=new Label();
        chancesLbl=new Label("Your Chance is "+chances+"/10");
        scLbl=new Label("Score : "+score);
        Button rockBtn=new Button();
        Button paperBtn=new Button();
        Button sciBtn=new Button();
        Button reset=new Button("RESET");


        imgview1.relocate(20, 200);
        imgview2.relocate(330, 200);
        result.relocate(40, 400);
        reset.relocate(400, 40);
        scLbl.relocate(40, 50);
        chancesLbl.relocate(40, 80);
        vs.relocate(250, 275);
        rockBtn.relocate(20, 500);
        paperBtn.relocate(190, 500);
        sciBtn.relocate(360, 500);

        rockBtn.setPrefSize(150, 150);
        rockBtn.setId("rockBtn");
        paperBtn.setPrefSize(150, 150);
        paperBtn.setId("paperBtn");
        sciBtn.setPrefSize(150, 150);
        sciBtn.setId("sciBtn");
        vs.setId("vs");
        result.setId("vs");
        scLbl.setId("vs");
        reset.setId("reset");
        reset.setPrefSize(100, 50);
        chancesLbl.setId("vs");

        sciBtn.setOnAction(this::action);
        paperBtn.setOnAction(this::action);
        rockBtn.setOnAction(this::action);
        reset.setOnAction(this::setReset);




        root.getChildren().addAll(imgview1,imgview2,vs,rockBtn,paperBtn,sciBtn,result,scLbl,chancesLbl,reset);



        // TODO: Add your GUI-building code here
        stage.show();
    }

    private void setReset(ActionEvent actionEvent) {
        chances=0;
        chancesLbl.setText(" Your Chance is "+chances+"/10");
        score=0;
        scLbl.setText("Score : "+score);
        result.setText("");

    }

    private void action(ActionEvent actionEvent) {
        chances+=1;
        if (chances<=10){
        chancesLbl.setText(" Your Chance is "+chances+"/10");
        backEnd=new BackEnd();
        Character identity=actionEvent.getTarget().toString().charAt(10);
        if (identity=='p'){
            user="paper";
            imgview1.setImage(choice1(imgPaper));
            backEnd.setUserchoice(1);

        } else if (identity=='r') {
            user="rock";
            imgview1.setImage(choice1(imgRock));
            backEnd.setUserchoice(0);
        }
        else{
            user="sci";
            imgview1.setImage(choice1(imgSci));
            backEnd.setUserchoice(2);
        }
        if (backEnd.getSystemchoice()==0){
            imgview2.setImage(choice2(imgRock));
        }
        else if (backEnd.getSystemchoice()==1){
            imgview2.setImage(choice2(imgPaper));
        }
        else if (backEnd.getSystemchoice()==2){
            imgview2.setImage(choice2(imgSci));
        }
        if (backEnd.getAnswer()==0){
            result.setText("Wins!!");
            score+=10;
            scLbl.setText("Score : "+score);
        }
        else if (backEnd.getAnswer()==1){
            result.setText("Better Luck next time");
        }
        else{
            result.setText("DRAW");
        }}
        else{
            chancesLbl.setText("Chances is over.Please reset the Game");
            if (score>=40){
                result.setText("Congratulations !! You win the Game");
            }
            else{
                result.setText("Better luck next time");

            }
        }

    }

    public Image choice1(Image choice){
        return choice;
    }
    public Image choice2(Image choice){
        return choice;
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
