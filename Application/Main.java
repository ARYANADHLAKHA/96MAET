/////////////////////////// FILE HEADER//////////////////////////////////////////
// PROJECT : a2 Team Project GUI
// DESCRIPTION: Making a GUI for the social network using javaFX
/////////////////////////////////////////////////////////////////////////////////

package Application;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
// imported for the collections
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
// imported for button
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
// imported for the ComboBox
import javafx.scene.control.ComboBox;
// imported for label
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
// imported for image
import javafx.scene.image.Image;
// imported for image view
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;



public class Main extends Application {

  // store any command-line arguments that were entered.

  // NOTE: this.getParameters().getRaw() will get these also

  private List<String> args;

  // the height and width of the scene

  private static final int WINDOW_WIDTH = 700;

  private static final int WINDOW_HEIGHT = 700;

  private static final String APP_TITLE = "THE SOCIAL NETWORK";



  @Override

  public void start(Stage primaryStage) throws Exception {

    // save args example

    args = this.getParameters().getRaw();


    // creates a BorderPane as root

    BorderPane root = new BorderPane();

    // creates a new scene with the stage root and specified height, width
    root.setBackground(
        new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

    Scene Scene1 = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

    /*
     * 
     * jgcj.hv
     * 
     */
    args = this.getParameters().getRaw();



    TextField textF1 = new TextField("type username here");

    TextField textF2 = new TextField("type username here");

    TextField textF3 = new TextField("type first username here");

    TextField textF4 = new TextField("type second username here");

    TextField textF5 = new TextField("type username here");

    TextField textF6 = new TextField("type username here");

    TextField textF7 = new TextField("enter file name ");

    BorderPane borderPane4 = new BorderPane();
    Button friend1 = new Button(textF1.getText());
    borderPane4.setCenter(friend1);
    Scene finalScene = new Scene(borderPane4, WINDOW_WIDTH, WINDOW_HEIGHT);



    textF1.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF2.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF3.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF4.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF5.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF6.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF7.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");

    Label addUserName = new Label("Add username");

    Label removeUser = new Label("Remove user");

    Label findMutualFriends = new Label("Find mutual friends");

    Label searchUser = new Label("Search for user");

    Label displayConnections = new Label("Display connections");

    Label exportFriendsList = new Label("Export friends list");

    addUserName.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    removeUser.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    findMutualFriends.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    searchUser.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    displayConnections.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    exportFriendsList.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");


    Button add = new Button("add");

    Button remove = new Button("remove");

    Button lookUp = new Button("lookup");

    Button search = new Button("search");

    Button display = new Button("display");

    Button export = new Button("export");

    Button displayNetwork = new Button("DISPLAY NETWORK");

    Button removeAll = new Button("REMOVE ALL USERS");

    add.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    remove.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    lookUp.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    search.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    display.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    export.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    displayNetwork.setStyle("-fx-text-fill: black; -fx-font: 20 arial;");
    removeAll.setStyle("-fx-text-fill: black; -fx-font: 20 arial;");

    add.setOnAction(e -> {
      friend1.setText(textF1.getText());
      primaryStage.setScene(finalScene);

    });


    // Main layout is Border Pane example (top,left,center,right,bottom)

    BorderPane borderPane3 = new BorderPane();

    borderPane3.setBackground(
        new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
    Label scene3display = new Label("THE SOCIAL NETWORK");
    scene3display.setStyle("-fx-text-fill: yellow; -fx-font: 35 arial;");
    scene3display.setMaxWidth(Double.MAX_VALUE);
    scene3display.setAlignment(Pos.CENTER);
    borderPane3.setTop(scene3display);

    HBox firstRow = new HBox(addUserName, textF1, add);

    HBox secondRow = new HBox(removeUser, textF2, remove);

    HBox thirdRow = new HBox(findMutualFriends, textF3, textF4, lookUp);

    HBox fourthRow = new HBox(searchUser, textF5, search);

    HBox fifthRow = new HBox(displayConnections, textF6, display);

    HBox sixthRow = new HBox(exportFriendsList, textF7, export);


    HBox buttons = new HBox(removeAll, displayNetwork);


    buttons.setSpacing(5.0);

    buttons.setAlignment(Pos.CENTER);


    VBox VerticalBox = new VBox(firstRow, secondRow, thirdRow,

        fourthRow, fifthRow, sixthRow, buttons);

    VerticalBox.setSpacing(20.0);

    VerticalBox.setAlignment(Pos.CENTER);


    firstRow.setSpacing(5.0);

    firstRow.setAlignment(Pos.CENTER);


    secondRow.setSpacing(5.0);

    secondRow.setAlignment(Pos.CENTER);


    thirdRow.setSpacing(5.0);

    thirdRow.setAlignment(Pos.CENTER);


    fourthRow.setSpacing(5.0);

    fourthRow.setAlignment(Pos.CENTER);


    fifthRow.setSpacing(5.0);

    fifthRow.setAlignment(Pos.CENTER);


    sixthRow.setSpacing(5.0);

    sixthRow.setAlignment(Pos.CENTER);

    BorderPane lowerPane3 = new BorderPane();
    Button exitButton3 = new Button("Exit");

    exitButton3.setStyle("-fx-base: #ee2211; " + "-fx-background-radius: 40em; " +

        "-fx-min-width: 100px; " +

        "-fx-min-height: 100px; " +

        "-fx-max-width: 100px; " +

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 17 arial;");

    exitButton3.setAlignment(Pos.CENTER);

    exitButton3.setOnAction(e -> {
      Platform.exit();
      System.exit(0);
    });

    lowerPane3.setRight(exitButton3);

    borderPane3.setCenter(VerticalBox);
    borderPane3.setBottom(lowerPane3);


    removeAll.setAlignment(Pos.BASELINE_CENTER);



    // Add the stuff and set the primary stage



    /*
     * 
     * 
     * 
     * 
     */


    Scene mainScene = new Scene(borderPane3, WINDOW_WIDTH, WINDOW_HEIGHT);



    // sets the label at the top "The Social Network"

    Label headerTop = new Label("Welcome to ");
    headerTop.setStyle("-fx-text-fill: yellow; -fx-font: 35 arial;");


    Label headerBottom = new Label("THE SOCIAL NETWORK");
    headerBottom.setStyle("-fx-text-fill: yellow; -fx-font: 35 arial;");



    headerTop.setAlignment(Pos.CENTER);

    headerBottom.setAlignment(Pos.CENTER);

    headerTop.setMaxWidth(Double.MAX_VALUE);

    headerBottom.setMaxWidth(Double.MAX_VALUE);


    VBox newVBox = new VBox(headerTop, headerBottom);

    newVBox.setSpacing(20);

    newVBox.setAlignment(Pos.CENTER);

    root.setTop(newVBox);



    // a "Run text file(s)" button - linked to Scene2

    Button textFileButton = new Button("Run text file(s)");

    textFileButton.setStyle("-fx-base: #DCDCDC; " +

        "-fx-min-width: 200px; " +

        "-fx-min-height: 50px; " +

        "-fx-max-width: 200px; " +

        "-fx-max-height: 50px; -fx-text-fill: black; -fx-font: 17 arial;");
    /*
     *
     */

    BorderPane window = new BorderPane(); // Adding a label in the top panel


    Label scene2display = new Label("THE SOCIAL NETWORK");
    scene2display.setStyle("-fx-text-fill: yellow; -fx-font: 35 arial;");
    scene2display.setMaxWidth(Double.MAX_VALUE);
    scene2display.setAlignment(Pos.CENTER);
    window.setTop(scene2display);
    window.setBackground(
        new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

    VBox centerStuff = new VBox();
    Button fileButton = new Button("Add text file(s)");
    fileButton.setStyle("-fx-font: 24 arial;");



    FileChooser fileExplorer = new FileChooser();
    fileButton.setOnAction(e -> {
      File chosenFile = fileExplorer.showOpenDialog(primaryStage);
      Label filesToLoad = new Label(chosenFile.getName());
      filesToLoad.setStyle("-fx-text-fill: red; -fx-font: 15 arial;");
      centerStuff.getChildren().addAll(filesToLoad);
    });



    Button loadButton = new Button("LOAD");
    loadButton.setStyle("-fx-font: 28 arial;");

    loadButton.setOnAction(e -> {

      primaryStage.setScene(mainScene);

    });

    centerStuff.getChildren().addAll(fileButton, loadButton);

    centerStuff.setSpacing(20.0);
    centerStuff.setAlignment(Pos.CENTER);
    window.setCenter(centerStuff);


    BorderPane lowerPane2 = new BorderPane();
    Button exitButton2 = new Button("Exit");

    exitButton2.setStyle("-fx-base: #ee2211; " + "-fx-background-radius: 40em; " +

        "-fx-min-width: 100px; " +

        "-fx-min-height: 100px; " +

        "-fx-max-width: 100px; " +

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 17 arial;");

    exitButton2.setAlignment(Pos.CENTER);

    exitButton2.setOnAction(e -> {
      Platform.exit();
      System.exit(0);
    });

    lowerPane2.setRight(exitButton2);
    window.setBottom(lowerPane2);



    Scene scene2 = new Scene(window, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);



    textFileButton.setOnAction(e -> {

      primaryStage.setScene(scene2);

    });



    // a "Use Social Network" button - linked to borderPane3

    Button socNetButton = new Button("Use Social Network");

    socNetButton.setStyle("-fx-base: #DCDCDC; " +

        "-fx-min-width: 200px; " +

        "-fx-min-height: 50px; " +

        "-fx-max-width: 200px; " +

        "-fx-max-height: 50px; -fx-text-fill: black; -fx-font: 17 arial;");

    socNetButton.setOnAction(e -> {

      primaryStage.setScene(mainScene);

    });


    /*
     */
    // creating a vertical box

    VBox newBox = new VBox(textFileButton, socNetButton);

    newBox.setSpacing(50);

    newBox.setAlignment(Pos.CENTER);

    root.setCenter(newBox);



    // creating the exit button

    BorderPane lowerPane = new BorderPane();

    Button exitButton = new Button("Exit");

    exitButton.setStyle("-fx-base: #ee2211; " + "-fx-background-radius: 40em; " +

        "-fx-min-width: 100px; " +

        "-fx-min-height: 100px; " +

        "-fx-max-width: 100px; " +

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 17 arial;");

    exitButton.setAlignment(Pos.CENTER);

    exitButton.setOnAction(e -> {
      Platform.exit();
      System.exit(0);
    });

    lowerPane.setRight(exitButton);



    root.setBottom(lowerPane);



    // sets the scene in the stage

    primaryStage.setScene(Scene1);

    // shows the stage
    primaryStage.setTitle(APP_TITLE);

    primaryStage.show();



  }


  /**
   * 
   * @param args
   * 
   */

  public static void main(String[] args) {

    launch(args);

  }

}
