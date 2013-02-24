/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controllers.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Jay C Espinoza
 */
public class MatriculaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainWindow.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
