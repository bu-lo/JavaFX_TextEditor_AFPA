package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // TITLE IN STAGE
        stage.setTitle(" TEXT EDITOR");

        // ICON
        Image icon = new Image(getClass().getResourceAsStream("colors.png"));
        // Add icon in stage
        stage.getIcons().add(icon);

        // SCENE
        // INSTANCIATION

        // *** TEXTS TOP RIGHT ***
        // labelTextFieldInput
        Label labelTextFieldInput = new Label("Enter your text:");

        // textFieldInput
        TextField textFieldInput = new TextField("");

        // labelTextFieldInput
        Label labelTextFieldModif = new Label("");

        // Vbox3Texts
        VBox vbox3Texts = new VBox(labelTextFieldInput, textFieldInput, labelTextFieldModif);
        vbox3Texts.setSpacing(5);

        vbox3Texts.setMargin(labelTextFieldModif, new Insets(15, 0, 10, 8));

        // *** TITLEPANE PARAMETERS ***
        // checkBoxPrameters
        CheckBox checkBoxBackG = new CheckBox("Background Color");
        CheckBox checkBoxCharC = new CheckBox("Character Color");
        CheckBox checkBoxLUCase = new CheckBox("Lowercase/Uppercase");

        // VBoxtitledPaneParameters

        VBox vboxtitlePaneParameters = new VBox(5);
        vboxtitlePaneParameters.getChildren().addAll(checkBoxBackG, checkBoxCharC, checkBoxLUCase);

        // titledPaneParameters
        TitledPane titledPaneParameters = new TitledPane("Parameters", vboxtitlePaneParameters);

        // *** TITLEPANE BACKGROUND ***
        // radioButtonsBackGround
        RadioButton radioButtonBGRed = new RadioButton("Red");
        RadioButton radioButtonBGGreen = new RadioButton("Green");
        RadioButton radioButtonBGBlue = new RadioButton("Blue");

        //EXCLUSIVITY - TOGGLEGROUP Radio Button Background
        ToggleGroup toggleGroupRBBackG = new ToggleGroup();
        radioButtonBGRed.setToggleGroup(toggleGroupRBBackG);
        radioButtonBGGreen.setToggleGroup(toggleGroupRBBackG);
        radioButtonBGBlue.setToggleGroup(toggleGroupRBBackG);

        // vboxradioButtonsBackGround
        VBox vboxradioButtonsBackGround = new VBox(5);
        vboxradioButtonsBackGround.getChildren().addAll(radioButtonBGRed, radioButtonBGGreen, radioButtonBGBlue);

        // titledPaneBackGround
        TitledPane titledPaneBackGround = new TitledPane("Background Color", vboxradioButtonsBackGround);

        // *** TITLEPANE CHARACTER COLOR"
        // Sliders Character Color
        Slider sliderRed = new Slider(0, 255, 0);// BLACK (R:0,G:0,B:0)
        Slider sliderGreen = new Slider(0, 255, 0);
        Slider sliderBlue = new Slider(0, 255, 0);

        // Labels Sliders Character Color
        Label labelSliderRed = new Label("Red : " + sliderRed.getValue());
        Label labelSliderGreen = new Label("Green : " + sliderGreen.getValue());
        Label labelSliderBlue = new Label("Blue : " + sliderBlue.getValue());

    
        // Listeners to detect value changes
        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderRed.setText("Red : " + newValue.intValue());
            int red = newValue.intValue();
            int green = (int) sliderGreen.getValue();
            int blue = (int) sliderBlue.getValue();
            Color labelTextFieldModifColor = Color.rgb(red, green, blue);
            labelTextFieldModif.setTextFill(labelTextFieldModifColor);
        });

        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderGreen.setText("Green : " + newValue.intValue());
            int red = (int) sliderRed.getValue();
            int green = newValue.intValue();
            int blue = (int) sliderBlue.getValue();
            Color labelTextFieldModifColor = Color.rgb(red, green, blue);
            labelTextFieldModif.setTextFill(labelTextFieldModifColor);
        });

        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderBlue.setText("Blue : " + newValue.intValue());
            int red = (int) sliderRed.getValue();
            int green = (int) sliderGreen.getValue();
            int blue = newValue.intValue();
            Color labelTextFieldModifColor = Color.rgb(red, green, blue);
            labelTextFieldModif.setTextFill(labelTextFieldModifColor);
        });

        // GridPaneSlidersCharacterColor
        GridPane gridPaneSlidersCharacterColor = new GridPane();
        gridPaneSlidersCharacterColor.setPadding(new Insets(10)); // Around
        gridPaneSlidersCharacterColor.setHgap(5);
        gridPaneSlidersCharacterColor.setVgap(5);

        gridPaneSlidersCharacterColor.add(labelSliderRed, 0, 0);
        gridPaneSlidersCharacterColor.add(labelSliderGreen, 0, 1);
        gridPaneSlidersCharacterColor.add(labelSliderBlue, 0, 2);
        gridPaneSlidersCharacterColor.add(sliderRed, 1, 0);
        gridPaneSlidersCharacterColor.add(sliderGreen, 1, 1);
        gridPaneSlidersCharacterColor.add(sliderBlue, 1, 2);

        // titledPaneCharacterColor
        TitledPane titledPaneCharacterColor = new TitledPane("Character Color", gridPaneSlidersCharacterColor);

        // *** HBOX TITLEPANE BACKGROUND + TITLEPANECHARACTERCOLOR ***
        HBox hboxBackGroundCharacterColor = new HBox(titledPaneBackGround, titledPaneCharacterColor);
        hboxBackGroundCharacterColor.setSpacing(10);

        // *** TITLEPANE LOWERCASE/UPPERCASE ***
        // radioButtonsLowerUpperCase
        RadioButton radioButtonLowerCase = new RadioButton("LowerCase");
        RadioButton radioButtonUpperCase = new RadioButton("UpperCase");

        //EXCLUSIVITY - TOGGLEGROUP Lower/Upper Case
        ToggleGroup toggleGroupLUCase = new ToggleGroup();
        radioButtonLowerCase.setToggleGroup(toggleGroupLUCase);
        radioButtonUpperCase.setToggleGroup(toggleGroupLUCase);

        // vboxradioButtonsLowerUpperCase
        VBox vboxradioButtonsLowerUpperCase = new VBox(5);
        vboxradioButtonsLowerUpperCase.getChildren().addAll(radioButtonLowerCase, radioButtonUpperCase);

        // titledPaneLowerUpperCase
        TitledPane titledPaneLowerUpperCase = new TitledPane("LowerCase / UpperCase", vboxradioButtonsLowerUpperCase);


        // *** GRIDPANE 4 SECTIONS ***
        GridPane gridPane4Sections = new GridPane();
        gridPane4Sections.setPadding(new Insets(15)); // Around
        gridPane4Sections.setHgap(10);
        gridPane4Sections.setVgap(10);

        gridPane4Sections.add(vbox3Texts, 0, 0);
        gridPane4Sections.add(titledPaneParameters, 1, 0);
        gridPane4Sections.add(hboxBackGroundCharacterColor, 0, 1);
        gridPane4Sections.add(titledPaneLowerUpperCase, 1, 1);

        gridPane4Sections.setValignment(hboxBackGroundCharacterColor, VPos.TOP);
        gridPane4Sections.setValignment(titledPaneLowerUpperCase, VPos.TOP);


        // ASSEMBLY
        Scene scene = new Scene(gridPane4Sections, 570, 260);


        // ACTIONS


        //listener input -> label
        textFieldInput.textProperty().addListener((observable, oldValue, newValue) -> {
            labelTextFieldModif.setText(newValue);
        });

        //3 TITLEPANES NOT VISIBLE BEFORE SELECTED
        //titledPaneBackGround
        titledPaneBackGround.setVisible(false);

        checkBoxBackG.setOnAction(e -> {
            if(checkBoxBackG.isSelected()){
                titledPaneBackGround.setVisible(true);
            } else {
                titledPaneBackGround.setVisible(false);
                //RESET
                labelTextFieldModif.setStyle(STYLESHEET_CASPIAN);
                radioButtonBGRed.setSelected(false);
                radioButtonBGGreen.setSelected(false);
                radioButtonBGBlue.setSelected(false);
            }
        });

        //titledPaneCharacterColor
        titledPaneCharacterColor.setVisible(false);

        checkBoxCharC.setOnAction(e -> {
            if(checkBoxCharC.isSelected()){
                titledPaneCharacterColor.setVisible(true);
            } else {
                titledPaneCharacterColor.setVisible(false);
                //RESET
                sliderRed.setValue(0);// BLACK (R:0,G:0,B:0)
                sliderGreen.setValue(0);
                sliderBlue.setValue(0);
            }
        });

        //titledPaneLowerUpperCase
        titledPaneLowerUpperCase.setVisible(false);

        checkBoxLUCase.setOnAction(e -> {
            if(checkBoxLUCase.isSelected()){
                titledPaneLowerUpperCase.setVisible(true);
            } else {
                titledPaneLowerUpperCase.setVisible(false);
                //RESET
                labelTextFieldModif.setText(textFieldInput.getText());
                radioButtonLowerCase.setSelected(false);
                radioButtonUpperCase.setSelected(false);
                
            }
        });


        //TITLEPANEBACKGROUND

        radioButtonBGRed.setOnAction(e -> {
            if (radioButtonBGRed.isSelected()){
                labelTextFieldModif.setStyle("-fx-background-color: red; -fx-text-fill: black;");
            }
        });

        radioButtonBGGreen.setOnAction(e -> {
            if (radioButtonBGGreen.isSelected()){
                labelTextFieldModif.setStyle("-fx-background-color: lawngreen; -fx-text-fill: black;");
            }
        });

        radioButtonBGBlue.setOnAction(e -> {
            if (radioButtonBGBlue.isSelected()){
                labelTextFieldModif.setStyle("-fx-background-color: aqua; -fx-text-fill: black;");
            }
        });


        //TITLEPANECHARACTERCOLOR
        
    

        //TITLEPANELOWERUPPERCASE
        radioButtonLowerCase.setOnAction(e -> {
            if (radioButtonLowerCase.isSelected()){
                labelTextFieldModif.setText(labelTextFieldModif.getText().toLowerCase());
            }
        });

        radioButtonUpperCase.setOnAction(e -> {
            if (radioButtonUpperCase.isSelected()){
                labelTextFieldModif.setText(labelTextFieldModif.getText().toUpperCase());
            }
        });


        stage.setScene(scene);
        stage.show();
    }

}