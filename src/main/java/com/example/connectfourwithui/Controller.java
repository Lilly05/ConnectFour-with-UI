package com.example.connectfourwithui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.spreadsheet.Grid;
import org.controlsfx.glyphfont.FontAwesome;

public class Controller {

    private boolean player = true;

    @FXML
    private GridPane grid;

    @FXML
    protected void onButtonOne() {
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setGlyphName(playerIconName(player));
        icon.setSize("2em");
        for (int row = 4; row >= 0; row--){
            if(row == 0) {
                grid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) == null || GridPane.getRowIndex(node) == 0) && (GridPane.getColumnIndex(node) == null || GridPane.getColumnIndex(node) == 0));
                grid.add(icon, 0, 0);
                break;
            }else if (isIconRemoved(row, null, grid)){
                grid.add(icon, 0, row);
                switchPlayer();
                break;
            }
        }
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
    protected void onButtonSix(){
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
                if(row != 0) {
                    switchPlayer();
                }
                break;
            }
        }
    }


    public boolean isIconRemoved(Integer row, Integer column, GridPane grid) {
        ObservableList<Node> childrens = grid.getChildren();
        FontAwesomeIcon parsedIcon;

        for (Node child : childrens) {
            if(row == 0) {
                grid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) == null || GridPane.getRowIndex(node) == row) && (GridPane.getColumnIndex(node) == column));
                return true;
            }
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
}