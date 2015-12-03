package p1;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Traffic_Light_Project.java
 *
 * Phillip Dingus
 * CIS150-401 Intro to Object-Oriented Programming
 * Delaware Technical Community College
 * Mr. Mailman
 *
 * This program will create a window with a simulated traffic light, comprised of a
 * rectangle outer edge and three circles for the green, yellow, and red lights.
 * The lights will cycle automatically with the following timing:
 * Green - 15 seconds
 * Yellow - 2 seconds
 * Red - 10 seconds
 */
public class Traffic_Light_Project extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final int[] cycleCnt = {1};    //holds current place in 3-color cycle

        //create a pane
        final Pane[] pane = {new Pane()};

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
        pane[0].getChildren().add(rectangle);
        pane[0].getChildren().add(gCircle);
        pane[0].getChildren().add(yCircle);
        pane[0].getChildren().add(rCircle);

        //add the pane to the scene
        Scene scene = new Scene(pane[0], 170, 420);

        //set up the stage and show it
        primaryStage.setTitle("Traffic Light Project");
        primaryStage.setScene(scene);
        primaryStage.show();

        /*//create an event handler to handle the event every second from the keyframe and run the lights
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
        };*/
/*
        //create an animation to control the flashing of the green light indefinitely
        Timeline gAnimation = new Timeline();  //create timeline
        gAnimation.setCycleCount(Timeline.INDEFINITE);   //make timeline repeat indefinitely
        KeyValue kvGon = new KeyValue(gCircle.fillProperty(), Color.GREEN); //keyvalue for Green light ON
        KeyFrame kfGon = new KeyFrame(Duration.seconds(15), kvGon);
        KeyValue kvGoff = new KeyValue(gCircle.fillProperty(), Color.WHITE);
        KeyFrame kfGoff = new KeyFrame(Duration.seconds(12), kvGoff);
        gAnimation.getKeyFrames().add(0, kfGon);
        gAnimation.getKeyFrames().add(1, kfGoff);

        //create an animation to control the flashing of the yellow light indefinitely
        Timeline yAnimation = new Timeline();  //create timeline
        yAnimation.setCycleCount(Timeline.INDEFINITE);   //make timeline repeat indefinitely
        KeyValue kvYoff1 = new KeyValue(yCircle.fillProperty(), Color.WHITE); //keyvalue for Yellow light OFF
        KeyFrame kfYoff1 = new KeyFrame(Duration.seconds(15), kvYoff1);       //keyframe for Yellow light OFF
        KeyValue kvYon = new KeyValue(yCircle.fillProperty(), Color.YELLOW);  //keyvalue for Yellow light ON
        KeyFrame kfYon = new KeyFrame(Duration.seconds(2), kvYon);            //keyframe for Yellow light ON
        KeyValue kvYoff2 = new KeyValue(yCircle.fillProperty(), Color.WHITE); //keyvalue for Yellow Light OFF
        KeyFrame kfYoff2 = new KeyFrame(Duration.seconds(10), kvYoff2);       //keyframe for Yellow Light OFF
        gAnimation.getKeyFrames().add(0, kfYoff1);
        gAnimation.getKeyFrames().add(1, kfYon);
        gAnimation.getKeyFrames().add(2, kfYoff2);

        //create an animation to control the flashing of the red light indefinitely
        Timeline rAnimation = new Timeline();  //create timeline
        rAnimation.setCycleCount(Timeline.INDEFINITE);   //make timeline repeat indefinitely
        KeyValue kvRoff = new KeyValue(rCircle.fillProperty(), Color.WHITE); //keyvalue for Red light OFF
        KeyFrame kfRoff = new KeyFrame(Duration.seconds(17), kvRoff);        //keyframe for Red light OFF
        KeyValue kvRon = new KeyValue(rCircle.fillProperty(), Color.RED);    //keyvalue for Red light ON
        KeyFrame kfRon = new KeyFrame(Duration.seconds(2), kvRon);           //keyframe for Red light ON
        gAnimation.getKeyFrames().add(0, kfRoff);
        gAnimation.getKeyFrames().add(1, kfRon);

        //start animations
        gAnimation.play();
        yAnimation.play();
        rAnimation.play();
*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true) {
                        if(cycleCnt[0] == 1) {
                            gCircle.fillProperty() = Color.GREEN;
                            yCircle.fillProperty() = Color.WHITE;
                            rCircle.fillProperty() = Color.WHITE;
                            Thread.sleep(15000);
                        } else if (cycleCnt[0] == 2) {
                            gCircle.fillProperty() = Color.WHITE;
                            yCircle.fillProperty() = Color.YELLOW;
                            rCircle.fillProperty() = Color.WHITE;
                            Thread.sleep(2000);
                        } else if (cycleCnt[0] == 3) {
                            gCircle.fillProperty() = Color.WHITE;
                            yCircle.fillProperty() = Color.WHITE;
                            rCircle.fillProperty() = Color.RED;
                            Thread.sleep(10000);
                        }
                        cycleCnt[0]++;
                        if (cycleCnt[0] == 4) {
                            cycleCnt[0] = 1;
                        }
                    }
                }
                catch (InterruptedException ex){

                }
            }
        }).start();


    }
}
