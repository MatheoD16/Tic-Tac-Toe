package fr.unknowz.tictactoe.controller;


import fr.unknowz.tictactoe.model.ColorPlayer;
import fr.unknowz.tictactoe.model.MorpionGrid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author matheo
 *
 * Classe du controller du jeu
 *
 */
public class MorpionController {

    /**
     * Objet javaFx qui représente la grille de jeu
     */
    @FXML
    private GridPane gridGame;

    /**
     * Objet JavaFx qui représente
     */
    @FXML
    private Label player;

    @FXML
    private Label playerColor;

    @FXML
    private Button restartButton;

    private MorpionGrid grid = new MorpionGrid();

    private Button[][] buttonGrid;

    private ColorPlayer turn = ColorPlayer.BLUE;

    @FXML
    public void initialize() {
        buttonGrid = new Button[MorpionGrid.SIZE][MorpionGrid.SIZE];
        for (int i = 0; i < MorpionGrid.SIZE; i++ ) {
            for (int j = 0; j < MorpionGrid.SIZE; j++) {
                Button btn = new Button();
                btn.setPrefSize(106.5, 82);
                btn.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));

                buttonGrid[i][j] = btn;
                gridGame.add(btn, i, j);
            }
        }
        playerColor.setText("Bleu");
        playerColor.setTextFill(Color.CORNFLOWERBLUE);

        for (int i = 0; i < MorpionGrid.SIZE; i++ ) {
            for (int j = 0; j < MorpionGrid.SIZE; j++) {
                buttonGrid[i][j].setOnAction(this::play);
            }
        }

    }

    @FXML
    public void changeTurn() {
        if (turn == ColorPlayer.BLUE) {
            turn = ColorPlayer.RED;
            playerColor.setText("Rouge");
            playerColor.setTextFill(Color.CRIMSON);
        }
        else {
            turn = ColorPlayer.BLUE;
            playerColor.setText("Bleu");
            playerColor.setTextFill(Color.CORNFLOWERBLUE);
        }
    }


    @FXML
    public void play(ActionEvent event) {
        Button btn = (Button) event.getSource();
        int x = GridPane.getRowIndex(btn);
        int y = GridPane.getColumnIndex(btn);
        grid.touched(x, y, turn);

        if (turn == ColorPlayer.BLUE) {
            buttonGrid[y][x].setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
        }
        else {
            buttonGrid[y][x].setBackground(new Background(new BackgroundFill(Color.CRIMSON, null, null)));
        }
        buttonGrid[y][x].setDisable(true);
        endGame();


    }

    @FXML
    public boolean egalite() {
        boolean res = true;

        for (int i = 0; i < MorpionGrid.SIZE; i++ ) {
            for (int j = 0; j < MorpionGrid.SIZE; j++) {
                if(! buttonGrid[i][j].isDisable()) {
                    res = false;
                }
            }

        }
        return res;
    }

    @FXML
    public void endGame() {
        if (grid.validation(turn)) {
            for (int i = 0; i < MorpionGrid.SIZE; i++ ) {
                for (int j = 0; j < MorpionGrid.SIZE; j++) {
                    buttonGrid[i][j].setDisable(true);
                }
            }
            if (turn == ColorPlayer.BLUE) {
                player.setText("Victoire du joueur Bleu !");
                player.setTextFill(Color.CORNFLOWERBLUE);
                playerColor.setText("");
            }
            else {
                player.setText("Victoire du joueur Rouge !");
                player.setTextFill(Color.CRIMSON);
                playerColor.setText("");
            }

        }
        else if(egalite()) {
            player.setText("Il n'y a pas de gagnant !");
            playerColor.setText("");
        }
        else {
            changeTurn();
        }
    }

    @FXML
    void restart(ActionEvent event) {
        grid = new MorpionGrid();
        turn = ColorPlayer.BLUE;
        player.setText("C'est au tour du joueur :");
        player.setTextFill(Color.BLACK);
        playerColor.setText("Bleu");
        playerColor.setTextFill(Color.CORNFLOWERBLUE);

        for (int i = 0; i < MorpionGrid.SIZE; i++ ) {
            for (int j = 0; j < MorpionGrid.SIZE; j++) {

                buttonGrid[i][j].setDisable(false);
                buttonGrid[i][j].setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));


            }
        }


    }

}