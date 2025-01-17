/////////////////////////// FILE HEADER//////////////////////////////////////////
// PROJECT : a2 Team Project GUI
// DESCRIPTION: Making a GUI for the social network using javaFX
/////////////////////////////////////////////////////////////////////////////////

package application;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import javafx.scene.layout.StackPane;
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

  // yeah

  // store any command-line arguments that were entered.

  // NOTE: this.getParameters().getRaw() will get these also

  private List<String> args;

  // the height and width of the scene

  private static final int WINDOW_WIDTH = 700;

  private static final int WINDOW_HEIGHT = 600;

  private static final String APP_TITLE = "THE SOCIAL NETWORK";


  private void DispNetwork(String ce, Graph graphType, Stage stage) {
    Graph tempGraph = new Graph();
    tempGraph = graphType;
    StackPane root = new StackPane();
    Set<Person> connects = new HashSet<Person>();
    try {
      connects = graphType.getNeighbours(tempGraph.getNode(ce));
    } catch (Exception e1) {
    }
    System.out.println(ce + " total number of nodes " + tempGraph.getAllNodes().size());
    for (Person per : tempGraph.getAllNodes()) {
      System.out.println(per.getName());
    }
    Button[] buttons = new Button[connects.size()];
    HBox[] hBoxes = new HBox[buttons.length];
    // VBox [] vBoxes = new VBox [buttons.length];
    VBox vbox2 = new VBox(buttons.length);

    Iterator<Person> iter = connects.iterator();
    BorderPane borderPane4view = new BorderPane();
    for (int i = 0; i < connects.size(); i++) {
      Person per = iter.next();
      System.out.println("friend is " + per.getName());
      buttons[i] = new Button(per.getName());
      buttons[i].setStyle("-fx-text-fill: black; -fx-font: 10 arial;");
      buttons[i].setOnAction(e -> {
        DispNetwork(per.getName(), graphType, stage);
      });
      hBoxes[i] = new HBox(buttons[i]);

      hBoxes[i].setSpacing(5.0);

      hBoxes[i].setAlignment(Pos.CENTER);
      vbox2.getChildren().add(hBoxes[i]);
      // borderPane4view.setCenter(hBoxes[i]);
    }
    HBox displayName = new HBox(new Label("Showing all the friends of " + ce));
    displayName.setSpacing(5.0);

    displayName.setAlignment(Pos.CENTER);

    vbox2.getChildren().add(displayName);

    root.getChildren().addAll(vbox2);

    Scene sceneAdd = new Scene(root, 400, 150);
    stage.setScene(sceneAdd);
    stage.show();
  }



  private void dispGraph(TextField textDispGraph, Set<Graph> friends) {
    // TODO Auto-generated method stub

    String input = textDispGraph.getText();
    input = input.trim();
    char c = input.charAt(0);
    int val = Character.getNumericValue(c);
    Iterator<Graph> iter = friends.iterator();
    Graph temp = new Graph();

    for (int i = 0; i < val; i++) {
      if (iter.hasNext())
        temp = (Graph) iter.next();
    }
    Set<Person> persons = new HashSet<Person>();
    persons = temp.getAllNodes();
    Iterator<Person> iterator = persons.iterator();
    Stage stage = new Stage();
    int maxConnections = 0;
    Person toReturn = null;
    while (iterator.hasNext()) {
      Person ce = (Person) iterator.next();
      try {
        if (temp.getNeighbours(temp.getNode(ce.getName())).size() > maxConnections) {
          maxConnections = temp.getNeighbours(temp.getNode(ce.getName())).size();
          toReturn = ce;
        }
      } catch (Exception e) {
      }
      System.out.println("Returned value for tree: " + toReturn.getName());
    }
    DispNetwork(toReturn.getName(), temp, stage);
  }

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

    SocialNetwork friendNetwork = new SocialNetwork();


    TextField textF1 = new TextField("type username here");

    TextField textF2 = new TextField("type username here");

    TextField textF3 = new TextField("enter username 1 here");

    TextField textF4 = new TextField("enter username 2 here");

    TextField textF5 = new TextField("type username here");

    TextField textF6 = new TextField("type username here");

    TextField textF7 = new TextField("enter file name ");

    TextField textAF = new TextField("enter username");

    TextField textAF1 = new TextField("enter friend name ");

    TextField textRFL = new TextField("enter username 1 here ");

    TextField textRFL1 = new TextField("enter username 2 here ");

    TextField textDispGraph = new TextField("enter your option here ");



    BorderPane borderPane4 = new BorderPane();
    Button friend1 = new Button();
    Button friend2 = new Button();
    borderPane4.setCenter(friend1);
    Scene finalScene = new Scene(borderPane4, WINDOW_WIDTH, WINDOW_HEIGHT);
    Button goBackToScene2 = new Button("Go back to options");
    goBackToScene2.setOnAction(e -> {
      primaryStage.setScene(Scene1);
    });
    goBackToScene2.setAlignment(Pos.CENTER);
    BorderPane lowerPaneFinal = new BorderPane();
    lowerPaneFinal.setRight(goBackToScene2);


    textF1.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF2.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF3.setStyle("-fx-text-fill: black; -fx-font: 13 arial;");
    textF4.setStyle("-fx-text-fill: black; -fx-font: 13 arial;");
    textF5.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF6.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textF7.setStyle("-fx-text-fill: black; -fx-font: 15 arial;");
    textDispGraph.setStyle("-fx-text-fill: black; -fx-font: 12 arial;");
    textRFL.setStyle("-fx-text-fill: black; -fx-font: 13 arial;");
    textRFL1.setStyle("-fx-text-fill: black; -fx-font: 13 arial;");


    Label addUserName = new Label("Add username");

    Label removeUser = new Label("Remove user");

    Label findMutualFriends = new Label("Find mutual friends");

    Label searchUser = new Label("Search for user");

    Label displayConnections = new Label("Display connections");

    Label exportFriendsList = new Label("Export friends list");

    Label addFriendsLabel = new Label("Add friends");

    Label removeFriendshipLabel = new Label("Remove friendship");

    Label displayBox = new Label("Choose a graph\n to display");

    addUserName.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    removeUser.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    findMutualFriends.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    searchUser.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    displayConnections.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    exportFriendsList.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    addFriendsLabel.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    removeFriendshipLabel.setStyle("-fx-text-fill: white; -fx-font: 17 arial;");
    displayBox.setStyle("-fx-text-fill: black; -fx-font: 10 arial;");


    Button add = new Button("add");

    Button remove = new Button("remove");

    Button lookUp = new Button("lookup");

    Button search = new Button("search");

    Button display = new Button("display");

    Button export = new Button("export");

    Button addFriend = new Button("Add Friend");

    Button displayNetwork = new Button("DISPLAY NETWORK");

    Button removeAll = new Button("REMOVE ALL USERS");

    Button removeFriendship = new Button("Remove Friendship");

    Button displayGraph = new Button("display graph");



    add.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    remove.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    lookUp.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    search.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    display.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    addFriend.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    export.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    displayNetwork.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    removeAll.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    goBackToScene2.setStyle("-fx-text-fill: black; -fx-font: 20 arial;");
    removeFriendship.setStyle("-fx-text-fill: black; -fx-font: 17 arial;");
    displayGraph.setStyle("-fx-text-fill: black; -fx-font: 10 arial;");

    Stage secondaryStage = new Stage();

    Stage tertiaryStage = new Stage();



    // ADDED THE EXCEPTION HANDLING POPOUP BOX, WILL SHOW IF THE NAME FIELD IS EMPTY OR DUPLICATE NAME USER
    // ADDED
    add.setOnAction(e -> {
      friend1.setText(textF1.getText());
      boolean added = friendNetwork.addUser(textF1.getText());
      // if the friend was not added, exception thrown or whatever
      if (!added) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Error: Unable to add the user."));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Added " + textF1.getText() + " to the Social Network"));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }
    });



    export.setOnAction(e -> {

      friend1.setText(textF7.getText());
      File f1 = new File(textF7.getText() + ".txt");
      friendNetwork.txtFileName = textF7.getText();
      friendNetwork.savetoFile(f1);
      // pop-up window for the user
      BorderPane borderPane4add = new BorderPane();
      HBox firstRow = new HBox(new Label("Exported data to " + textF7.getText() + " text file"));

      VBox VerticalBox = new VBox(firstRow);

      VerticalBox.setSpacing(20.0);

      VerticalBox.setAlignment(Pos.CENTER);


      firstRow.setSpacing(5.0);

      firstRow.setAlignment(Pos.CENTER);

      borderPane4add.setCenter(VerticalBox);
      Scene sceneAdd = new Scene(borderPane4add, 300, 150);
      tertiaryStage.setScene(sceneAdd);
      tertiaryStage.show();
    });



    // ADDED THE ALERT BOX FOR REMOVING THE USER : WOULD HAPPEN IF NO NAME OR THE USER DOES NOT EXIST
    remove.setOnAction(e -> {
      friend1.setText(textF2.getText());
      boolean removed = friendNetwork.removeUser(textF2.getText());

      if (!removed) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Unable to remove the user."));
        VBox VerticalBox = new VBox(firstRow);
        VerticalBox.setSpacing(20.0);
        VerticalBox.setAlignment(Pos.CENTER);
        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);
        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
        // primaryStage.setScene(finalScene);
      } else {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow =
            new HBox(new Label("Removed " + textF2.getText() + " from the Social Network"));
        HBox secondRow = new HBox(new Label("Hope to see you again"));
        VBox VerticalBox = new VBox(firstRow, secondRow);
        VerticalBox.setSpacing(20.0);
        VerticalBox.setAlignment(Pos.CENTER);
        firstRow.setSpacing(5.0);
        firstRow.setAlignment(Pos.CENTER);
        secondRow.setSpacing(5.0);
        secondRow.setAlignment(Pos.CENTER);
        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
        // primaryStage.setScene(finalScene);
      }
    });



    // //ADDED THE ALERT BOX FOR MUTUAL FRIENDS NOT THERE IF NO NAMES OR INVALID USERS OR SAME USER
    lookUp.setOnAction(e -> {
      friend1.setText(textF3.getText());
      friend2.setText(textF4.getText());

      Set<Person> friendsSet = friendNetwork.getMutualFriends(textF3.getText(), textF4.getText());;
      if (friendsSet == null) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Unable to display the mutual friends"));
        VBox VerticalBox = new VBox(firstRow);
        VerticalBox.setSpacing(20.0);
        VerticalBox.setAlignment(Pos.CENTER);
        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);
        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {
        String labelText = "";
        if (friendsSet.size() != 0) {
          String[] temp = new String[friendsSet.size()];
          int i = 0;
          for (Person per : friendsSet) {
            temp[i] = per.getName();
            i++;
          }
          labelText = textF3.getText() + " and " + textF4.getText()
              + " have the following mutual friend(s):\n";
          for (i = 0; i < temp.length; i++) {
            labelText = labelText + temp[i] + "\n";
          }
        }
        if (friendsSet.size() == 0) {
          labelText = textF3.getText() + " and " + textF4.getText() + " have no mutual friends.";
        }
        BorderPane borderPane4display = new BorderPane();

        HBox firstRow = new HBox(new Label(labelText));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4display.setCenter(VerticalBox);

        Scene sceneSearch = new Scene(borderPane4display, WINDOW_WIDTH, WINDOW_HEIGHT);

        secondaryStage.setScene(sceneSearch);

        secondaryStage.show();

        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox row1 = new HBox(new Label(
            "Looked for mutual friends of " + textF3.getText() + " and " + textF4.getText()));

        VBox vertBox = new VBox(row1);

        vertBox.setSpacing(20.0);

        vertBox.setAlignment(Pos.CENTER);


        row1.setSpacing(5.0);

        row1.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(vertBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }
    });



    // ADDED THE ALERT BOX IF THE USER NAME IS NOT ENTERED OR THERE IS NO SUCH USER
    // Action set code for DISPLAY
    // Displays all the connections of a certain user
    display.setOnAction(e -> {
      friend1.setText(textF6.getText());
      Set<Person> neighboursSet = friendNetwork.getFriends(textF6.getText());

      if (neighboursSet == null) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Unable to display connections"));
        VBox VerticalBox = new VBox(firstRow);
        VerticalBox.setSpacing(20.0);
        VerticalBox.setAlignment(Pos.CENTER);
        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);
        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {
        String labelText = "";
        if (neighboursSet.size() != 0) {
          String[] temp = new String[neighboursSet.size()];
          int i = 0;
          for (Person per : neighboursSet) {
            temp[i] = per.getName();
            i++;
          }
          labelText = textF6.getText() + " has the following connections:\n";
          for (i = 0; i < temp.length; i++) {
            labelText = labelText + temp[i] + "\n";
          }
        }
        if (neighboursSet.size() == 0) {
          labelText = textF6.getText() + " has no connections.";
        }
        BorderPane borderPane4display = new BorderPane();

        HBox firstRow = new HBox(new Label(labelText));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4display.setCenter(VerticalBox);

        Scene sceneSearch = new Scene(borderPane4display, WINDOW_WIDTH, WINDOW_HEIGHT);

        secondaryStage.setScene(sceneSearch);

        secondaryStage.show();
      }
    });



    // ADDED THE ALERT BOX IF THE USER NAME IS NOT VALID OR THERE IS SELF EDGE
    addFriend.setOnAction(e -> {
      friend1.setText(textAF.getText());
      friend2.setText(textAF1.getText());
      boolean added = friendNetwork.addFriends(textAF.getText(), textAF1.getText());
      if (!added) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Unable to add the users as friends"));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(
            new Label("Added " + textAF.getText() + " and " + textAF1.getText() + " as friends."));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }

    });



    // ADDED THE ALERT BOX FOR NO GRAPH EXISTING
    removeAll.setOnAction(e -> {
      int size = friendNetwork.removeAllUsers();
      if (size == 0) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("The social network is empty."));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }
    });



    // ADDED THE ALERT BOX IF THE USER IS NPN EXISTENT
    // ACTION button for SEARCH BOX in Social Network Screen
    // i.e., screen 3
    // This sets the vertical box and the horizontal box. Then opens a new screen with
    // a new Border Pane
    search.setOnAction(e -> {
      friend1.setText(textF5.getText());
      Person temp = friendNetwork.getUser(textF5.getText());
      if (temp == null) {
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("No such user exists"));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {

        BorderPane borderPane4search = new BorderPane();

        HBox firstRow = new HBox(new Label("User details are:"), new Label(textF5.getText()));
        // after the work on Get Connections is done:
        // this should be in the bracket
        // ""+friendNetwork.getFriends(friend1.getText()).size()
        int numFriends = 0;
        if (!(friendNetwork.getFriends(textF5.getText()) == null)) {
          numFriends = friendNetwork.getFriends(temp.getName()).size();
        }
        HBox secondRow = new HBox(new Label("Number of connections of " + friend1.getText() + ":"),
            new Label("" + numFriends));
        VBox VerticalBox = new VBox(firstRow, secondRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);


        secondRow.setSpacing(5.0);

        secondRow.setAlignment(Pos.CENTER);


        Button loadButton = new Button("LOAD");
        loadButton.setStyle("-fx-font: 28 arial;");

        // loadButton.setOnAction(l -> {
        //
        // primaryStage.setScene(mainScene);
        //
        // });

        borderPane4search.setCenter(VerticalBox);

        Scene sceneSearch = new Scene(borderPane4search, WINDOW_WIDTH, WINDOW_HEIGHT);


        secondaryStage.setScene(sceneSearch);

        secondaryStage.show();

        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        firstRow =
            new HBox(new Label("Searched for " + textF5.getText() + " in the Social Network"));

        VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }

    });



    // ADDED THE ALERT BOX IF THERE ARE NO GRAPHS TO DISPLAY
    displayNetwork.setOnAction(e -> {
      Set<Graph> friends = friendNetwork.getConnectedComponents();
      Set<Graph> tempFriends = friends;
      ///////


      /////////////

      // there is no graph to display
      if (friends.size() == 0) {
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("No Graphs to display."));

        VBox VerticalBox = new VBox(firstRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }

      else {
        friend1.setText(textF6.getText());
        friendNetwork.getFriends(textF6.getText());
        BorderPane borderPane4connections = new BorderPane();
        borderPane4connections.setCenter(friend1);
        HBox firstOne =
            new HBox(new Label("Following are the connections in the graph. \n Pick one from the "
                + "following for individual trees"));
        // Set<Graph> friends= friendNetwork.getConnectedComponents();
        displayGraph.setOnAction(m -> {
          dispGraph(textDispGraph, tempFriends);
        });
        if (friends != null) {
          HBox[] horizontalBoxes = new HBox[friends.size()];
          String textPerLine = "";
          Iterator<Graph> iter = friends.iterator();

          Graph graph = new Graph();

          BorderPane borderPane4view = new BorderPane();

          for (int i = 0; i < friends.size(); i++) {
            textPerLine = textPerLine + (int) (i + 1) + ". ";
            graph = (Graph) iter.next();
            Set<Person> persons = graph.getAllNodes();
            Iterator<Person> iterator = persons.iterator();
            while (iterator.hasNext()) {
              Person per = iterator.next();
              textPerLine = textPerLine + per.getName() + " ";
            }
            horizontalBoxes[i] = new HBox(new Label(textPerLine));

            horizontalBoxes[i].setSpacing(5.0);

            horizontalBoxes[i].setAlignment(Pos.CENTER);

            borderPane4view.setCenter(horizontalBoxes[i]);

          }
          firstOne.setSpacing(5.0);

          HBox bottom = new HBox(displayBox, textDispGraph, displayGraph);
          bottom.setSpacing(5.0);

          bottom.setAlignment(Pos.CENTER);

          firstOne.setAlignment(Pos.CENTER);
          borderPane4view.setBottom(bottom);
          borderPane4view.setTop(firstOne);

          Scene sceneAdd = new Scene(borderPane4view, 400, 150);
          tertiaryStage.setScene(sceneAdd);
          tertiaryStage.show();

        }
      }

    });



    // ADDED THE ALERT BOX IF UNABLE TO REMOVE THE EDGE, NO NAME, SAME USER, NON EXISTENT USER
    removeFriendship.setOnAction(e -> {
      friend1.setText(textRFL.getText());
      friend2.setText(textRFL1.getText());
      boolean removed = friendNetwork.removeFriends(textRFL.getText(), textRFL1.getText());

      if (!removed) {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label("Unabel to remove friends."));
        VBox VerticalBox = new VBox(firstRow);
        VerticalBox.setSpacing(20.0);
        VerticalBox.setAlignment(Pos.CENTER);
        firstRow.setSpacing(5.0);
        firstRow.setAlignment(Pos.CENTER);
        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      } else {
        // pop-up window for the user
        BorderPane borderPane4add = new BorderPane();
        HBox firstRow = new HBox(new Label(
            "Removed " + textRFL.getText() + " and " + textRFL1.getText() + " as friends."));
        HBox secondRow = new HBox(new Label("Hope they two get back together"));

        VBox VerticalBox = new VBox(firstRow, secondRow);

        VerticalBox.setSpacing(20.0);

        VerticalBox.setAlignment(Pos.CENTER);


        firstRow.setSpacing(5.0);

        firstRow.setAlignment(Pos.CENTER);

        secondRow.setSpacing(5.0);

        secondRow.setAlignment(Pos.CENTER);

        borderPane4add.setCenter(VerticalBox);
        Scene sceneAdd = new Scene(borderPane4add, 300, 150);
        tertiaryStage.setScene(sceneAdd);
        tertiaryStage.show();
      }
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

    HBox firstRowL = new HBox(addUserName);
    HBox firstRowC= new HBox( textF1);
    HBox firstRowR= new HBox( add);

    HBox secondRowL = new HBox(removeUser);
    HBox secondRowC= new HBox(textF2);
    HBox secondRowR= new HBox(remove);
    
   // HBox secondRow = new HBox(removeUser, textF2, remove);
    HBox thirdRowL = new HBox(findMutualFriends);
    HBox thirdRowC= new HBox(textF3,textF4);
    HBox thirdRowR= new HBox(lookUp);
    
   // HBox thirdRow = new HBox(findMutualFriends, textF3, textF4, lookUp);
    HBox fourthRowL = new HBox(searchUser);
    HBox fourthRowC= new HBox(textF5);
    HBox fourthRowR= new HBox(search);
    
  //  HBox fourthRow = new HBox(searchUser, textF5, search);
    HBox fifthRowL = new HBox(displayConnections);
    HBox fifthRowC= new HBox(textF6);
    HBox fifthRowR= new HBox(display);
    
    //HBox fifthRow = new HBox(displayConnections, textF6, display);

    HBox sixthRowL = new HBox(exportFriendsList);
    HBox sixthRowC= new HBox(textF7);
    HBox sixthRowR= new HBox(export);
    
   // HBox sixthRow = new HBox(exportFriendsList, textF7, export);
    
    HBox seventhRowL = new HBox(addFriendsLabel);
    HBox seventhRowC= new HBox(textAF,textAF1);
    HBox seventhRowR= new HBox(addFriend);
    
  //  HBox seventhRow = new HBox (addFriendsLabel, textAF,textAF1, addFriend);
    
    HBox eightRowL = new HBox(removeFriendshipLabel);
    HBox eightRowC= new HBox(textRFL,textRFL1);
    HBox eightRowR= new HBox(removeFriendship);
    
   // HBox eightRow = new HBox (removeFriendshipLabel, textRFL, textRFL1, removeFriendship);

   // HBox buttons = new HBox(removeAll, displayNetwork);
    
    
   HBox center = new HBox (removeAll,displayNetwork);

//    buttons.setSpacing(5.0);
//
//    buttons.setAlignment(Pos.CENTER);
    HBox tempLabel=new HBox (new Label (""));
    
      VBox vBoxC = new VBox(firstRowC, secondRowC,
  
          fourthRowC, fifthRowC, sixthRowC, seventhRowC, thirdRowC,eightRowC);
      
      VBox vBoxL = new VBox( firstRowL, secondRowL,
          
          fourthRowL, fifthRowL, sixthRowL, seventhRowL, thirdRowL, eightRowL);
      
      VBox vBoxR = new VBox(firstRowR, secondRowR,
          
          fourthRowR, fifthRowR, sixthRowR, seventhRowR, thirdRowR, eightRowR);
    
    vBoxL.setSpacing(26.0);

    vBoxL.setAlignment(Pos.CENTER);
    vBoxC.setSpacing(20.0);
    
    vBoxC.setAlignment(Pos.CENTER);
    
    vBoxR.setSpacing(15.0);

    vBoxR.setAlignment(Pos.CENTER);


    firstRowL.setSpacing(7.0);

    firstRowL.setAlignment(Pos.CENTER);

    firstRowC.setSpacing(5.0);

    firstRowC.setAlignment(Pos.CENTER);
    
    firstRowR.setSpacing(5.0);

    firstRowR.setAlignment(Pos.CENTER);

    secondRowL.setSpacing(7.0);

    secondRowL.setAlignment(Pos.CENTER);
    
    secondRowC.setSpacing(5.0);

    secondRowC.setAlignment(Pos.CENTER);
    
    secondRowR.setSpacing(5.0);

    secondRowR.setAlignment(Pos.CENTER);


    thirdRowL.setSpacing(7.0);

    thirdRowL.setAlignment(Pos.CENTER);
    
    thirdRowC.setSpacing(5.0);

    thirdRowC.setAlignment(Pos.CENTER);
    
    thirdRowR.setSpacing(5.0);

    thirdRowR.setAlignment(Pos.CENTER);


    fourthRowL.setSpacing(7.0);

    fourthRowL.setAlignment(Pos.CENTER);

    fourthRowC.setSpacing(5.0);

    fourthRowC.setAlignment(Pos.CENTER);
    
    fourthRowR.setSpacing(5.0);

    fourthRowR.setAlignment(Pos.CENTER);

    
    fifthRowL.setSpacing(7.0);

    fifthRowL.setAlignment(Pos.CENTER);
    
    fifthRowC.setSpacing(5.0);

    fifthRowC.setAlignment(Pos.CENTER);
    
    fifthRowR.setSpacing(5.0);

    fifthRowR.setAlignment(Pos.CENTER);


    sixthRowL.setSpacing(7.0);

    sixthRowL.setAlignment(Pos.CENTER);
    
    sixthRowC.setSpacing(5.0);

    sixthRowC.setAlignment(Pos.CENTER);
    
    sixthRowR.setSpacing(5.0);

    sixthRowR.setAlignment(Pos.CENTER);
    
    seventhRowL.setSpacing(7.0);

    seventhRowL.setAlignment(Pos.CENTER);
    
    seventhRowC.setSpacing(5.0);

    seventhRowC.setAlignment(Pos.CENTER);
    
    seventhRowR.setSpacing(5.0);

    seventhRowR.setAlignment(Pos.CENTER);
    
    eightRowL.setSpacing(7.0);

    eightRowL.setAlignment(Pos.CENTER);

    eightRowC.setSpacing(5.0);

    eightRowC.setAlignment(Pos.CENTER);

    eightRowR.setSpacing(5.0);

    eightRowR.setAlignment(Pos.CENTER);
    
    tempLabel.setSpacing(2.0);

    tempLabel.setAlignment(Pos.CENTER);
    
    center.setSpacing(5.0);

    center.setAlignment(Pos.CENTER);
    
    BorderPane lowerPane3 = new BorderPane();
    Button exitButton3 = new Button("Exit");

    exitButton3.setStyle("-fx-base: #ee2211; " + "-fx-background-radius: 40em; " +

        "-fx-min-width: 100px; " +

        "-fx-min-height: 100px; " +

        "-fx-max-width: 100px; " +

        "-fx-max-height: 100px; -fx-text-fill: yellow; -fx-font: 17 arial;");
    
    exitButton3.setAlignment(Pos.CENTER);
    
    exitButton3.setOnAction(e -> {
      BorderPane shutDown = new BorderPane();
      String message;
      if(textF7.getText().equals("enter file name") || textF7.getText().equals("") || friendNetwork.txtFileName.equals(""))
      {
        message = "Hope you enjoyed using The Social Network.";
      }
      else {
        message = "Your commands were saved in the file: "+friendNetwork.txtFileName+"\nHope you enjoyed using The Social Network.";
      }
      HBox fRow = new HBox(new Label(message));
      HBox sRow = new HBox(new Label("See you again!"));
      
      VBox vBox = new VBox(fRow,sRow);
        
        vBox.setSpacing(20.0);

        vBox.setAlignment(Pos.CENTER);


        fRow.setSpacing(5.0);

        fRow.setAlignment(Pos.CENTER);
        
        sRow.setSpacing(5.0);

        sRow.setAlignment(Pos.CENTER);
        
     shutDown.setCenter(vBox);
     Scene sceneAdd = new Scene(shutDown,400, 200);
     primaryStage.setScene(sceneAdd);
     primaryStage.show();
      
    });
    lowerPane3.setRight(exitButton3);
    lowerPane3.setCenter(center);
    borderPane3.setCenter(vBoxC);
    borderPane3.setLeft(vBoxL);
    borderPane3.setRight(vBoxR);
   //borderPane3.setCenter(center);

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
      friendNetwork.LoadFromFile(chosenFile);
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