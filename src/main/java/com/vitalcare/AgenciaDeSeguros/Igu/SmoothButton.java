package com.vitalcare.AgenciaDeSeguros.Igu;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class SmoothButton extends Button {

    public SmoothButton(String text) {
        super(text);
        getStyleClass().add("my-button");

        // Create a ScaleTransition for smooth color transition
        ScaleTransition scaleInTransition = new ScaleTransition(Duration.seconds(0.3), this);
        scaleInTransition.setToX(1.02);
        scaleInTransition.setToY(1.02);
        scaleInTransition.setAutoReverse(true);

        ScaleTransition scaleOutTransition = new ScaleTransition(Duration.seconds(0.3), this);
        scaleOutTransition.setToX(1.0);
        scaleOutTransition.setToY(1.0);

        setOnMouseEntered(event -> scaleInTransition.playFromStart());
        setOnMouseExited(event -> scaleOutTransition.playFromStart());
    }
}

