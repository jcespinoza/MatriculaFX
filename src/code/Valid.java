package code;

import java.util.Calendar;
import java.util.Date;

public class Valid {
    public static boolean isValid(int field, int value){
        switch(field){
            case Calendar.YEAR:
                return (value > 0);
            case Calendar.MONTH:
                return (value > 0 && value <= 12);
            case Calendar.HOUR_OF_DAY:
                return (value >= 0 && value <= 24);
            case Calendar.MINUTE: case Calendar.SECOND:
                return (value > 0 && value <= 60);
        }
        return false;
    }
    
    public static boolean isNAN(String val){
        try{
            Integer.parseInt(val);
            return false;
        }catch(Exception ex){
            return true;
        }
    }
    
    private static boolean isDayValid(int month, int value){
        if( value < 1)
            return false;
        
        switch(month){
            case Calendar.FEBRUARY:
                if( value <= 29)
                    return true;
                
            case Calendar.APRIL: case Calendar.JUNE:
            case Calendar.SEPTEMBER: case Calendar.NOVEMBER:
                if( value <= 30)
                    return true;
                
            case Calendar.JANUARY: case Calendar.MARCH:
            case Calendar.MAY: case Calendar.JULY:
            case Calendar.AUGUST: case Calendar.OCTOBER:
            case Calendar.DECEMBER:
                if (value <= 31)
                    return true;

            default:
                return false;
        }
    }
    
    public static Date parseDate(Object o){
        try{
            return (Date)(o);
        }catch(Exception ex){
            return null;
        }
    }
}