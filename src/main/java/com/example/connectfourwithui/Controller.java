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

    @FXML
    private GridPane grid;

    @FXML
    protected void onButtonOne() {
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setGlyphName("APPLE");
        icon.setSize("2em");
        /*grid.getChildren().removeIf(node -> (!(GridPane.getRowIndex(node) == null) && GridPane.getRowIndex(node) == 4) && (GridPane.getColumnIndex(node) == null || GridPane.getColumnIndex(node) == 0));
        grid.add(icon, 0, 4);*/
        for (int row = 4; row >= 0; row--){
            if(isIconRemoved(row, null, grid, icon)){
                grid.add(icon, 0, row);
                break;
            }
        }
        }


    public boolean isIconRemoved(Integer row, Integer column, GridPane grid, FontAwesomeIcon icon) {
        ObservableList<Node> childrens = grid.getChildren();

        if(row == 0){
            grid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) == null || GridPane.getRowIndex(node) == 0) && (GridPane.getColumnIndex(node) == null || GridPane.getColumnIndex(node) == 0));
            return true;
        }
        for (Node child : childrens) {
            if(GridPane.getRowIndex(child) == row && GridPane.getColumnIndex(child) == column) {
                grid.getChildren().removeIf(node -> (!(GridPane.getRowIndex(node) == null) && GridPane.getRowIndex(node) == row) && (GridPane.getColumnIndex(node) == null || GridPane.getColumnIndex(node) == 0));
                return true;
            }
        }
        return false;
    }
}