package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        stage.setTitle("CHECKBOX - RADIOBUTTONS - SLIDDER");

        // ICON
        Image icon = new Image(getClass().getResourceAsStream("colors.png"));
        // Add icon in stage
        stage.getIcons().add(icon);

       
        // SCENE
        // INSTANCIATION

        //*** TEXTS TOP RIGHT ***
        //labelTextFieldInput
        Label labelTextFieldInput = new Label("Enter your text:");

        //textFieldInput
        TextField textFieldInput = new TextField("");

        //labelTextFieldInput
        Label labelTextFieldModif = new Label("");

        //Vbox3Texts
        VBox vbox3Texts = new VBox(labelTextFieldInput,textFieldInput,labelTextFieldModif);


        //*** TITLEPANE PARAMETERS ***
        //checkBoxPrameters
        CheckBox checkBoxP1 = new CheckBox("BackGround Color");
        CheckBox checkBoxP2 = new CheckBox("Character Color");
        CheckBox checkBoxP3 = new CheckBox("Lowercase/Uppercase");

        //VBoxtitledPaneParameters
        VBox vboxtitlePaneParameters = new VBox(checkBoxP1,checkBoxP2,checkBoxP3);

        //titledPaneParameters
        TitledPane titledPaneParameters = new TitledPane("Parameters", vboxtitlePaneParameters);


        //*** TITLEPANE BACKGROUND ***
        //radioButtonsBackGround
        RadioButton radioButtonBGRed = new RadioButton("Red");
        RadioButton radioButtonBGGreen = new RadioButton("Green");
        RadioButton radioButtonBGBlue = new RadioButton("Blue");

        //vboxradioButtonsBackGround
        VBox vboxradioButtonsBackGround = new VBox(radioButtonBGRed, radioButtonBGGreen, radioButtonBGBlue);

        //titledPaneBackGround
        TitledPane titledPaneBackGround = new TitledPane("BackGround", vboxradioButtonsBackGround);


        //*** TITLEPANE CHARACTER COLOR"
        //Sliders Character Color
        Slider sliderRed = new Slider(0,100,50);
        Slider sliderGreen = new Slider(0,100,50);
        Slider sliderBlue = new Slider(0,100,50);
        
        //Labels Sliders Character Color
        Label labelSliderRed = new Label("Red : " + sliderRed.getValue());
        Label labelSliderGreen = new Label("Green : " + sliderGreen.getValue());
        Label labelSliderBlue = new Label("Blue : " + sliderBlue.getValue());

        //Listeners to detect value changes
        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderRed.setText("Red : " + newValue);
        });

        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderGreen.setText("Green : " + newValue);
        });

        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelSliderBlue.setText("Blue : " + newValue);
        });

        //GridPaneSlidersCharacterColor
        GridPane gridPaneSlidersCharacterColor = new GridPane();
        gridPaneSlidersCharacterColor.setPadding(new Insets(10)); //Around
        gridPaneSlidersCharacterColor.setHgap(10);
        gridPaneSlidersCharacterColor.setVgap(10);

        gridPaneSlidersCharacterColor.add(labelSliderRed,0,0);
        gridPaneSlidersCharacterColor.add(labelSliderGreen,0,1);
        gridPaneSlidersCharacterColor.add(labelSliderBlue,0,2);
        gridPaneSlidersCharacterColor.add(sliderRed,1,0);
        gridPaneSlidersCharacterColor.add(sliderGreen,1,1);
        gridPaneSlidersCharacterColor.add(sliderBlue,1,2);

        //titledPaneCharacterColor
        TitledPane titledPaneCharacterColor = new TitledPane("Character Color", gridPaneSlidersCharacterColor);


        //*** HBOX TITLEPANE BACKGROUND + TITLEPANECHARACTERCOLOR ***
        HBox hboxBackGroundCharacterColor = new HBox(titledPaneBackGround,titledPaneCharacterColor);


        //*** TITLEPANE LOWERCASE/UPPERCASE ***
        //radioButtonsLowerUpperCase
        RadioButton radioButtonLowerCase = new RadioButton("LowerCase");
        RadioButton radioButtonUpperCase = new RadioButton("UpperCase");

        //vboxradioButtonsLowerUpperCase
        VBox vboxradioButtonsLowerUpperCase = new VBox(radioButtonLowerCase,radioButtonUpperCase);

        //titledPaneLowerUpperCase
        TitledPane titledPaneLowerUpperCase = new TitledPane("LowerCase / UpperCase", vboxradioButtonsLowerUpperCase);


        //*** GRIDPANE 4 SECTIONS ***
        GridPane gridPane4Sections = new GridPane();
        gridPane4Sections.setPadding(new Insets(10)); //Around
        gridPane4Sections.setHgap(10);
        gridPane4Sections.setVgap(10);

        gridPane4Sections.add(vbox3Texts,0,0);
        gridPane4Sections.add(titledPaneParameters, 1,0);
        gridPane4Sections.add(hboxBackGroundCharacterColor,0,1);
        gridPane4Sections.add(titledPaneLowerUpperCase,1,1);


        // ASSEMBLY
        Scene scene = new Scene(gridPane4Sections,400, 400);

        //ACTIONS
        stage.setScene(scene);
        stage.show();
    }

}