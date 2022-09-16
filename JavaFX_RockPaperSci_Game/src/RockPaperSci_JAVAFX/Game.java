package RockPaperSci_JAVAFX;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {
        private int value;
        private int score;
        private Label scoreLabel;
        private Label opponentChoiceLabel;
        private int playerChances;
        private Label playerChancesLabel;



        // TODO: Instance Variables for View Components and Model
        // TODO: Private Event Handlers and Helper Methods

        public void check(int value){
            playerChances+=1;
            if (playerChances<10){
                playerChancesLabel.setText("Chances : "+playerChances+"/10");
                Logic logic=new Logic();
                logic.setValue(value);

                if (logic.getrandomOpponentValue()==1){
                    opponentChoiceLabel.setText("opponent choose ROCK");
                }
                else if (logic.getrandomOpponentValue()==2){
                    opponentChoiceLabel.setText("opponent choose PAPER");
                }
                else if (logic.getrandomOpponentValue()==3){
                    opponentChoiceLabel.setText("opponent choose SCISSORS");
                }
                if (logic.getResult()==1){
                    score =score+5;
                    scoreLabel.setText("Your Score is : "+score);
                }
                else if (logic.getResult()==2){
                }
                else if (logic.getResult()==3){
                }

            }
            else{
                playerChancesLabel.setText("Chances over !! .Please restart the game to play again");
                opponentChoiceLabel.setText("");
                scoreLabel.setText("Congratulations. Your Score is : "+score);

            }



        }

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
            root.setId("Pane");
            Scene scene = new Scene(root, 800, 600); // set the size here
            stage.setTitle("RockPaperScisscors"); // set the window title here
            stage.setScene(scene);
            scene.getStylesheets().addAll(this.getClass().getResource("design.css").toExternalForm());//calling css

            Button rock=new Button("rock");
            Button paper=new Button("paper");
            Button scissors=new Button("scissors");

            Button reset=new Button("Reset");

            scoreLabel=new Label("Your Score is : "+score);
            opponentChoiceLabel=new Label("");
            playerChancesLabel=new Label();

            rock.setId("tag");
            paper.setId("tag");
            scissors.setId("tag");
            reset.setId("reset");
            opponentChoiceLabel.setId("scoreLabel");
            scoreLabel.setId("scoreLabel");
            playerChancesLabel.setId("scoreLabel");

            rock.setPrefSize(200, 200);
            paper.setPrefSize(200, 200);
            scissors.setPrefSize(200, 200);
            reset.setPrefSize(100, 50);

            rock.setOnAction(this::checkrock);
            paper.setOnAction(this::checkpaper);
            scissors.setOnAction(this::checkscissors);
            reset.setOnAction(this::setReset);

            root.getChildren().addAll(rock,reset,paper,scissors,scoreLabel,opponentChoiceLabel,playerChancesLabel);

            playerChancesLabel.relocate(50, 200);
            opponentChoiceLabel.relocate(50, 150);
            scoreLabel.relocate(50, 100);
            rock.relocate(50, 300);
            paper.relocate(300, 300);
            scissors.relocate(550, 300);
            reset.relocate(600, 50);

            stage.show();
        }

        private void setReset(ActionEvent actionEvent) {
            playerChances=0;
            score=0;
            playerChancesLabel.setText("");
            scoreLabel.setText("Your Score is : "+score);
        }

        private void checkscissors(ActionEvent actionEvent) {
            value=3;
            check(value);
        }

        private void checkrock(ActionEvent actionEvent) {
            value=1;
            check(1);
        }

        private void checkpaper(ActionEvent actionEvent) {
            value=2;
            check(2);
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


