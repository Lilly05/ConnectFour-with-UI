package com.example.connectfourwithui;

import com.example.connectfourwithui.GamePlay.Spot;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import com.example.connectfourwithui.GamePlay.Grid;


public class Controller{

    private boolean player = true;

    Grid gridArray = new Grid();
    Spot player1 = new Spot(Spot.Symbol.O, gridArray);
    Spot player2 = new Spot(Spot.Symbol.X, gridArray);

    @FXML
    private GridPane grid;

    @FXML
    private Label WinningText;

    @FXML
    private FontAwesomeIcon WinningIcon;

    @FXML
    private Button RestartButton;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonSeven;

    @FXML
    protected void onButtonOne() {
        setIcon(0, playerIconName(player));
    }

    @FXML
    protected void onButtonTwo(){
        setIcon(1, playerIconName(player));
    }

    @FXML
    protected void onButtonThree(){
        setIcon(2, playerIconName(player));
    }

    @FXML
    protected void onButtonFour(){
        setIcon(3, playerIconName(player));
    }

    @FXML
    protected void onButtonFive(){
        setIcon(4, playerIconName(player));
    }

    @FXML
    protected void onButtonSix() {
        setIcon(5, playerIconName(player));
    }

    @FXML
    protected void onButtonSeven(){
        setIcon(6, playerIconName(player));
    }

    public void setIcon(Integer column, String iconName){
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setGlyphName(iconName);
        icon.setSize("2em");
        for (int row = 4; row >= 0; row--){
            if(isIconRemoved(row, column, grid)){
                grid.add(icon, column, row);
                if (player){
                    player1.setSymbol(column);
                }else{
                    player2.setSymbol(column);
                }
                switchPlayer();
                if(gridArray.winGame()){
                    WinningIcon.setGlyphName(playerIconName(!player));
                    WinningText.setOpacity(1);
                    RestartButton.setOpacity(1);
                    disableEnableButtons();
                }
                break;
            }
        }
    }

    public boolean isIconRemoved(Integer row, Integer column, GridPane grid) {
        ObservableList<Node> children = grid.getChildren();
        FontAwesomeIcon parsedIcon;

        for (Node child : children) {
            if(GridPane.getRowIndex(child) == row && GridPane.getColumnIndex(child) == column) {
                parsedIcon = (FontAwesomeIcon) child;
                if(parsedIcon.getGlyphName().equals("CIRCLE_THIN")) {
                    grid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column));
                    return true;
                }
            }
        }
        return false;
    }

    public void switchPlayer(){
        this.player = !this.player;
    }

    public String playerIconName(boolean player){
        if(player){
            return "APPLE";
        }else{
            return "LINUX";
        }
    }

    public void disableEnableButtons(){
        buttonOne.setDisable(!buttonOne.isDisabled());
        buttonTwo.setDisable(!buttonTwo.isDisabled());
        buttonThree.setDisable(!buttonThree.isDisabled());
        buttonFour.setDisable(!buttonFour.isDisabled());
        buttonFive.setDisable(!buttonFive.isDisabled());
        buttonSix.setDisable(!buttonSix.isDisabled());
        buttonSeven.setDisable(!buttonSeven.isDisabled());
        RestartButton.setDisable(!RestartButton.isDisabled());
    }

    public void setEmptyGrid(int column, int row, String iconName){
        FontAwesomeIcon circle = new FontAwesomeIcon();
        circle.setGlyphName(iconName);
        circle.setSize("2em");
        grid.add(circle, column, row);
    }

    public void loopThroughGrid(){
        for (int column = 6; column >= 0; column--){
            for (int row = 4; row >= 0; row--){
                setEmptyGrid(column, row, "CIRCLE_THIN");
            }
        }
    }

    public void restartGame(){
        disableEnableButtons();
        this.gridArray = new Grid();
        this.player1 = new Spot(Spot.Symbol.O, gridArray);
        this.player2 = new Spot(Spot.Symbol.X, gridArray);
        WinningText.setOpacity(0);
        WinningIcon.setOpacity(0);
        RestartButton.setOpacity(0);
        this.grid.getChildren().clear();
        loopThroughGrid();
    }
}