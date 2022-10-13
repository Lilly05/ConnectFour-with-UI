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
    private FontAwesomeIcon iconOne;

    @FXML
    protected void onButton(){
        iconOne.setGlyphName("APPLE");
    }

    @FXML
    private FontAwesomeIcon iconTwo;

    @FXML
    protected void onSecondButton(){
        iconTwo.setGlyphName("LINUX");
    }

    // :)

    @FXML
    private GridPane grid;

    @FXML
    protected void onButtonOne() {
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setGlyphName("APPLE");
        icon.setSize("2em");
        grid.getChildren().removeIf(node -> (!(GridPane.getRowIndex(node) == null) && GridPane.getRowIndex(node) == 4) && (GridPane.getColumnIndex(node) == null || GridPane.getColumnIndex(node) == 0));
        grid.add(icon, 0, 4);
        }


    public Node getNodeByRowColumnIndex (int row, int column, GridPane grid) {
        Node result = null;
        ObservableList<Node> childrens = grid.getChildren();

        for (Node node : childrens) {
            if(grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}