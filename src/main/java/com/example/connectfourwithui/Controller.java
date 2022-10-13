package com.example.connectfourwithui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
}