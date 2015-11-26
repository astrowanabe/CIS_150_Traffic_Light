package p1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Traffic_Light_Exercise.java
 *
 * Phillip Dingus
 * CIS150-401 Intro to Object-Oriented Programming
 * Delaware Technical Community College
 * Mr. Mailman
 *
 * This program will create a window with a simulated traffic light, comprised of a
 * rectangle outer edge and three circles for the green, yellow, and red lights.
 * The lights will be controlled by 3 toggle switches, with only one light being
 * lit at a time, and all lights off at the start of the program.
 */
public class Traffic_Light_Exercise extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create a pane
        Pane pane = new Pane();

        //create rectangular outline of traffic light
        Rectangle rectangle = new Rectangle();
        rectangle.setX(10);
        rectangle.setY(10);
        rectangle.heightProperty().set(400);
        rectangle.widthProperty().set(150);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        //create circle for green light, set to off on start
        Circle gCircle = new Circle();
        gCircle.setCenterX(85);
        gCircle.setCenterY(335);
        gCircle.setRadius(50);
        gCircle.setStroke(Color.BLACK);
        gCircle.setFill(Color.WHITE);

        //create circle for yellow light, set to off on start
        Circle yCircle = new Circle();
        yCircle.setCenterX(85);
        yCircle.setCenterY(210);
        yCircle.setRadius(50);
        yCircle.setStroke(Color.BLACK);
        yCircle.setFill(Color.WHITE);

        //create circle for red light, set to off on start
        Circle rCircle = new Circle();
        rCircle.setCenterX(85);
        rCircle.setCenterY(85);
        rCircle.setRadius(50);
        rCircle.setStroke(Color.BLACK);
        rCircle.setFill(Color.WHITE);

        //add the shapes to a pane
        pane.getChildren().add(rectangle);
        pane.getChildren().add(gCircle);
        pane.getChildren().add(yCircle);
        pane.getChildren().add(rCircle);

        //create 3 radio buttons
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbRed = new RadioButton("Red");

        //add radio buttons to a toggle group
        ToggleGroup tgColors = new ToggleGroup();
        rbGreen.setToggleGroup(tgColors);
        rbYellow.setToggleGroup(tgColors);
        rbRed.setToggleGroup(tgColors);

        //add radio buttons to a HBox
        HBox hBox = new HBox(10, rbGreen, rbYellow, rbRed);

        //put pane and HBox in a VBox
        VBox vBox = new VBox(10, pane, hBox);

        //add the VBox to the scene
        Scene scene = new Scene(vBox, 200, 450);

        //set up the stage and show it
        primaryStage.setTitle("Traffic Light Project");
        primaryStage.setScene(scene);
        primaryStage.show();

        //create an event handler to handle the three radio buttons
        EventHandler<ActionEvent> handler = e -> {
            if(rbGreen.isSelected())        //if radio button for green is selected
            {
                gCircle.setFill(Color.GREEN);   //set green light on
                yCircle.setFill(Color.WHITE);   //set yellow light off
                rCircle.setFill(Color.WHITE);   //set red light off
            }
            else if(rbYellow.isSelected())  //if radio button for yellow is selected
            {
                gCircle.setFill(Color.WHITE);   //set green light off
                yCircle.setFill(Color.YELLOW);  //set yellow light on
                rCircle.setFill(Color.WHITE);   //set red light off
            }
            else if(rbRed.isSelected())     //if radio button for red is selected
            {
                gCircle.setFill(Color.WHITE);   //set green light off
                yCircle.setFill(Color.WHITE);   //set yellow light off
                rCircle.setFill(Color.RED);     //set red light on
            }
        };

        //attach the three radio buttons to the event handler
        rbGreen.setOnAction(handler);
        rbYellow.setOnAction(handler);
        rbRed.setOnAction(handler);
    }
}
