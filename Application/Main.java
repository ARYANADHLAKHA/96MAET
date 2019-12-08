package Application;



import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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


    // dummy border pane

    BorderPane root2 = new BorderPane();

    // dummy scene

    Scene Scene2 = new Scene(root2);

    // dummy border pane

    BorderPane root3 = new BorderPane();

    // dummy scene

    Scene Scene3 = new Scene(root3);


    JMenuBar menuBar;  
    JMenu x; 
    JMenuItem m1, m2, m3,m4,m5,m6,m7; 
    JFrame f; 
  
    f = new JFrame("Menu demo"); 
    menuBar = new JMenuBar(); 
    x = new JMenu("Menu"); 
    m1 = new JMenuItem("Add a new friend"); 
    m2 = new JMenuItem("Remove a friend"); 
    m3 = new JMenuItem("Remove a user"); 
    m4 = new JMenuItem("Display all my friends");
    m5 = new JMenuItem("Get mutual friends");
    m6 = new JMenuItem("Get shortest path betwen two users");
    m7 = new JMenuItem("Get all the friend groups");
    
    x.add(m1); 
    x.add(m2); 
    x.add(m3);
    x.add(m4); 
    x.add(m5); 
    x.add(m6); 
    x.add(m7); 
    menuBar.add(x);
    f.setJMenuBar(menuBar); 
    f.setSize(500, 500); 
    f.setVisible(true); 


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

        "-fx-max-height: 50px; -fx-text-fill: black; -fx-font: 15 arial;");
    /*
     * AFKJANFABSJKF AF JASF ASF AF AF AS FA
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

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 15 arial;");

    exitButton2.setAlignment(Pos.CENTER);
    
    exitButton2.setOnAction(e-> {
      Platform.exit();
      System.exit(0);
    });
    
    lowerPane2.setRight(exitButton2);
    window.setBottom(lowerPane2);



    Scene scene2 = new Scene(window, WINDOW_WIDTH, WINDOW_HEIGHT, Color.AQUAMARINE);



    /*
     * AFKJANFABSJKF AF JASF ASF AF AF AS FA
     */
    textFileButton.setOnAction(e -> {

      primaryStage.setScene(scene2);

    });



    // a "Use Social Network" button - linked to Scene3

    Button socNetButton = new Button("Use Social Network");

    socNetButton.setStyle("-fx-base: #DCDCDC; " +

        "-fx-min-width: 200px; " +

        "-fx-min-height: 50px; " +

        "-fx-max-width: 200px; " +

        "-fx-max-height: 50px; -fx-text-fill: black; -fx-font: 15 arial;");

    socNetButton.setOnAction(e -> {

      primaryStage.setScene(Scene3);

    });



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

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 15 arial;");

    exitButton.setAlignment(Pos.CENTER);
    
    exitButton.setOnAction(e-> {
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
