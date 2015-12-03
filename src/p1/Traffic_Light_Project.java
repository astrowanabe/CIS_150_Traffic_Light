package p1;


import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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

        //create and run thread to handle lights
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true) {       //loop forever
                        if(cycleCnt[0] == 1) {              //if time for green light, set green on and rest off
                            gCircle.setFill(Color.GREEN);
                            yCircle.setFill(Color.WHITE);
                            rCircle.setFill(Color.WHITE);
                            Thread.sleep(15000);            //sleep thread for 15 seconds while green light is lit
                        } else if (cycleCnt[0] == 2) {      //if time for green light, set green on and rest off
                            gCircle.setFill(Color.WHITE);
                            yCircle.setFill(Color.YELLOW);
                            rCircle.setFill(Color.WHITE);
                            Thread.sleep(2000);             //sleep thread for 15 seconds while green light is lit
                        } else if (cycleCnt[0] == 3) {      //if time for green light, set green on and rest off
                            gCircle.setFill(Color.WHITE);
                            yCircle.setFill(Color.WHITE);
                            rCircle.setFill(Color.RED);
                            Thread.sleep(10000);            //sleep thread for 15 seconds while green light is lit
                        }
                        cycleCnt[0]++;                      //increment cycle counter
                        if (cycleCnt[0] == 4) {             //reset cycle counter after 3 light cycles
                            cycleCnt[0] = 1;
                        }
                    }
                }
                catch (InterruptedException ex){

                }
            }
        }).start();     //start thread


    }
}
