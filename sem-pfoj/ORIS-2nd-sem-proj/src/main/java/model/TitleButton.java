package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class TitleButton extends Button {
    private final String FONT_PATH = "src/main/java/model/resources/matias.ttf";

    private final String BUTTON_PRESSED_IMAGE_PATH = "src/main/java/model/resources/yellow_button_pressed.png";
    private final String BUTTON_FREE_IMAGE_PATH = "src/main/java/model/resources/yellow_button.png";

    private final String BUTTON_PRESSED_STYLE =
            "-fx-background-color: transparent; -fx-background-image: url('/model/resources/yellow_button_pressed.png');";
    private final String BUTTON_FREE_STYLE =
            "-fx-background-color: transparent; -fx-background-image: url('/model/resources/yellow_button.png');";
    public TitleButton(String text) {
        setStyle(BUTTON_FREE_STYLE);
        setBackground(getBackground());

        System.out.println(getBackground());

        setText(text);
        setButtonFont();
        setPrefWidth(150);
        setPrefHeight(49);
        initializeButtonListeners();
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 25));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 25));
            System.out.println("Font not found or could not be loaded. Using default \"Verdana\"");
        }
    }

    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButtonListeners() {

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });
    }
}
