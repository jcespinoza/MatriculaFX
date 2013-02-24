/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.CalendarPicker;

/**
 * @author Juan Carlos Espinoza
 *
 */
public class MainWindow extends AnchorPane implements Initializable{
    //controller variables
    private CalendarPicker cal;
    private String msg = "";
    private Calendar cali;
    
    //FXML vars
    public GridPane mainPane;
    public Label result;
    
    public MainWindow(){
        FXMLLoader fx = new FXMLLoader(getClass().getResource("/fxml/MainWindow.fxml"));
        fx.setRoot(this);
        fx.setController(this);
        try{
            fx.load();
        }catch(Exception ex){}
        putPicker();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public static void show(){
        AnchorPane mw = new MainWindow();
        Scene scene = new Scene(mw);
        Stage st = new Stage();
        st.setTitle("MatriculaFX");
        st.setScene(scene);
        st.sizeToScene();
        st.setResizable(false);
        st.show();
    }
    
    @FXML
    private void handleCalculate(){
        result.setText(getShowableString());
                
    }
    
    private String getShowableString(){
        cali = Calendar.getInstance();
        cali.setTime(new Date(cal.getCalendar().getTimeInMillis()));
        cali.add(Calendar.HOUR_OF_DAY, 36);
        msg = "Debe pagar antes de:\n";
        msg += cali.get(Calendar.HOUR) + ":";
        msg += cali.get(Calendar.MINUTE);
        msg += " " + cali.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault());
        msg += " - " + cali.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        msg += " " + cali.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        msg += " " + cali.get(Calendar.DAY_OF_MONTH);
        msg += ", " + cali.get(Calendar.YEAR);
        return msg;
    }
    
    private void putPicker() {
        cal = new CalendarPicker();
        cal.setCalendar(Calendar.getInstance());
        cal.setShowTime(Boolean.TRUE);
        GridPane.setConstraints(cal, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.NEVER, Priority.NEVER, new Insets(20, 30, 10, 30));
        mainPane.add(cal, 0, 1);
    }

}