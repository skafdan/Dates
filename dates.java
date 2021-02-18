/**
 * Etude 1 - Dates - Cosc326 
 * @author Dan Skaf 
 */
import java.util.*;

public class dates{
    //String array of month abbreviations 
    public static String[] monthAbrv = {
            "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug",
            "Sep","Oct","Nov","Dec","JAN","FEB","MAR","APR","MAY","JUN","JUL",
            "AUG","SEP","OCT","NOV","DEC","jan","feb","mar","apr","may","jun",
            "jul","aug","sep","oct","nov","dec"};

    public static void main(String[] args){
        int day;
        int month;
        int year;
        int code;
        boolean validFormat = false; 
        boolean leap = false;
        String inputedDate;
        //Perliminary regex formats
        String[] formats = {"[0-9]{1,2}\\/.*\\/[0-9]{2,4}",
            "[0-9]{1,2}-.*-[0-9]{2,4}","[0-9]{1,2} .* [0-9]{2,4}"};

        Scanner sc = new Scanner(System.in);
        Scanner sc2;

        System.out.println("Enter Date: ");
        while(sc.hasNext()){
            day = -1;
            month = -1;
            year = -1;
            inputedDate = sc.nextLine();
            validFormat = false;
            code = 5;
            sc2 = new Scanner(inputedDate).useDelimiter("-|/| ");
            //Checks inputed date matches one of the regex patterns
            for(String format: formats){
                if(inputedDate.matches(format)){
                    validFormat = true;
                }
            }
            //if it does parses the segments - day , month , year
            try{
            if(validFormat == true){
                while(sc2.hasNext()){
                    day = dayParse(sc2.next());
                    month = monthParse(sc2.next());
                    year = yearParse(sc2.next());
                    leap = isLeap(year);
                }
                code = validateDate(day,month,year,leap);
            }else {
                code = 6;
            }
            }
            catch(Exception e){
                code = 6;
            }
            /* Prints a message depending on the code
             * 0 - valid, 1 - 6 error;
             */
            switch(code) {
                case 0:
                    System.out.format("%02d %s %d\n",
                        day,monthAbrv[month-1],year);
                    break;
                case 1:
                    System.out.println(inputedDate + 
                        " INVALID: Day out of range.");
                    break;
                case 2:
                    System.out.println(inputedDate +
                        " INVALID: Month out of range.");
                    break;
                case 3:
                    System.out.println(inputedDate +
                        " INVALID: year out of range.");
                    break;
                case 4:
                    System.out.println(inputedDate +
                        " INVALID: 29 days in Feb non leap year.");
                    break;
                case 5:
                    System.out.println(inputedDate +
                        " INVALID: To many days in month");
                    break;
                case 6:
                    System.out.println(inputedDate +
                        " INVALID: wrong format <dd/mm/yyyy> <d-mm-yyyy>"+
                            " <dd mm yyyy>\n" +
                            "mm - maybe replaced with first three characters" +
                            " of month name,same case or 'Captilized'\n"+ 
                            "yyyyy - maybe replaced with yy");
            }
        }
    }

    /**
     * Ensures the parsed data are valid dates.
     * @param day - int day
     * @param month - int month 
     * @param year - int year
     * @param leap - boolean is the year a leap year
     * @return int - code depending on validation. 0 if no error
     */
    public static int validateDate(int day, int month,int year,boolean leap){
        if(day == -1){
            return 1;
        }else if(month == -1){
            return 2;
        }else if(year == -1){
            return 3;
        } else if(day > 28){
            if(day == 29 && month == 2){ //if they day is 29 in feb
                if(!leap){
                    return 5;
                }                
            }else if(day >= 29){ 
                if(month == 2){
                    return 4;
                }
                if(day > 30){ //30 days in april jul sept november
                    if(month == 4 || month == 6 
                        || month == 9 || month == 11){
                            return 5;
                    }
                }
            }
        } 
        return 0;
    }

    /**
     * Parse day string segment to int. 
     * @param dayString - String, day segment
     * @return int - parsed day. -1 if invalid
     */
    public static int dayParse(String dayString){
        int day = Integer.parseInt(dayString);
        if(day > 31 || day <= 0){
            return -1;
        }
        return day;
    }
    /**
     * Parse month string segment to int.
     * @param monthString - String, month segment.
     * @return int - parsed month. -1 if invalid
     */
    public static int monthParse(String monthString){
        int month = -1;
        if(monthString.matches("[a-zA-Z]{3}")){
            for(int i = 0; i < monthAbrv.length; i++){
                if(monthAbrv[i].equals(monthString)){
                   month = (i % 12) + 1;
                }
            }
        }else if(monthString.matches("[0-9]{1,2}")){
            month = Integer.parseInt(monthString);
        } 
        if(month <= 12 && month > 0){
            return month;
        }
        return -1;
    }

    /**
     * Parse year string segment to int.
     * @param yearString - yearString, year segment.
     * @return int - parsed year. -1 if invalid
     */
    public static int yearParse(String yearString){
        int year = -1;
        if(yearString.matches("[0-9]{2}")){
            year = Integer.parseInt(yearString);
            if (year < 50){
                year += 2000;
            } else {
                year += 1900;
            }
        }else if(yearString.matches("[^0][0-9]{3}")){
            year = Integer.parseInt(yearString);
        }
        if(year >= 1753 && year <= 3000){
           return year; 
        }
        return -1;
    }

    /**
     * Checks if year is leap year
     * @param year - int, year to check.
     * @return boolean - true of false;
     */
    public static boolean isLeap(int year){
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    return true;
                }
            }else {
                return true;
            }
        }
        return false;
    }
}