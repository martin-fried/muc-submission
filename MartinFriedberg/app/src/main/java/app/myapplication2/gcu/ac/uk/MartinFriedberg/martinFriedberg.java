package app.myapplication2.gcu.ac.uk.MartinFriedberg;

/**
 * Created by Martin on //.
 */
import java.util.Calendar;
         import java.util.GregorianCalendar;
        

        
         public class martinFriedberg {


             // *********************************************
             // Declare variables etc.
             // *********************************************

             private int iDOW;
             private int iMonth;
             private int iYear;
             private int iDayOfWeek;

             private String sDOW;
             private String sLineFromcar;
             private String[] saLinesOfcar;
             private String[] saDOW;
             private String sOutputMsg;

             // *********************************************
             // Declare getters and setters etc.
             // *********************************************

             private void setiDOW(int isDOW) {
                 this.iDOW = isDOW;
             }

             public int getiDOW() {
                 return iDOW;
             }


             private void setiMonth(int isMonth) {
                 this.iMonth = isMonth;
             }

             public int getiMonth() {
                 return iMonth;
             }

             private void setiYear(int isYear) {
                 this.iYear = isYear;
             }

             public int getiYear() {
                 return iYear;
             }

             private void setiDayOfWeek(int siDayOfWeek) {
                 this.iDayOfWeek = siDayOfWeek;
             }

             public int getiDayOfWeek() {
                 return iDayOfWeek;
             }

             private void setsDOW(int iDay) {
                 this.sDOW = saDOW[iDay];
             }

             public String getsDOW() {
                 return sDOW;
             }

             private void setsLineFromcar(int icarLine) {
                 this.sLineFromcar = saLinesOfcar[icarLine];
             }

             public String getsLineFromcar()

             {
                 return sLineFromcar;
             }

             private void setSaLinesOfcar()
                 {

                     saLinesOfcar = new String[7];
                     saLinesOfcar[0] = "has a 2.0 litre diesel engine which produces 143 BHP and a 0-62 time of 8.6 seconds.";
                     saLinesOfcar[1] = "has a 5.0litre V12 producing 517 BHP and a 0-62 time of 4.5 seconds.";
                     saLinesOfcar[2] = "has a 1.6 litre turbocharges engine producing 182 BHP and a 0-62 time of 6.9 seconds";
                     saLinesOfcar[3] = "has a 4.2 litre V8 producing 395 BHP and a 0-62 tim eof 5.2 seconds.";
                     saLinesOfcar[4] = "has a 4.3 litre V8 engine producing 460 BHP and a 0-62 time of 4.0 seconds.";
                     saLinesOfcar[5] = "has a 6.2 litre V8 engine producing 437 BHP and has a 0-62 time of 4.3 seconds.";
                     saLinesOfcar[6] = "has a 2.0 litre turbocharged engine producing 210 BHP and has a 0-62 time of 6.9 seconds.";
                 }
                 public String[] getSaLinesOfcar ()
                 {
                     return saLinesOfcar;
                 }


                      private void setSaDOW()
              {
                  saDOW = new String[7];
                  saDOW[0] = "Audi A4";
                  saDOW[1] = "Aston Martin DBS";
                  saDOW[2] = "Ford Fiesta ST";
                  saDOW[3] = "Maserati Gran Turismo";
                  saDOW[4] = "Ferrari California";
                  saDOW[5] = "Chevrolet Corvette C6";
                  saDOW[6] = "Volkswagen Golf GTi";
             }

             public String[] getSaDOW() {
                 return saDOW;
             }

             private void setsOutputMsg(String sOutMsg) {
                 this.sOutputMsg = sOutMsg;
             }

             public String getsOutputMsg() {

                 return sOutputMsg;
             }

             // **************************************************
             // Declare constructor and date manipulation methods.
             // **************************************************
             public martinFriedberg() {
                 // Fill the arrays
                 setSaDOW();
                 setSaLinesOfcar();
                 // Use the Calendar to instantiate a calendar object for today's date
                 Calendar cCal = Calendar.getInstance();
                 // store the date, month, year
                 setiDOW(cCal.get(Calendar.DAY_OF_WEEK));
                 setiMonth(cCal.get(Calendar.MONTH));
                 setiYear(cCal.get(Calendar.YEAR));
             }

             public martinFriedberg(int mfDOW, int mfMonth, int mfYear) {
                 // Fill the arrays
                 setSaDOW();
                 setSaLinesOfcar();
                 // store the date, month, year
                 setiDOW(mfDOW);
                 setiMonth(mfMonth);
                 setiYear(mfYear);
                 // Use the GregorianCalendar to instantiate a calendar object
                 GregorianCalendar gcCday = new GregorianCalendar(mfYear, mfMonth, mfDOW);
                 // Set the day of the week integer using the date chosen
                 setiDayOfWeek(gcCday.get(Calendar.DAY_OF_WEEK)-1)
                 ;
                 // Set the string day of the week
                 setsDOW(getiDayOfWeek());
                 // Set the line from the car based on the integer day of the week
                 setsLineFromcar(getiDayOfWeek());
                 // Create temporary string for output message
                 String sTempStr = "This date uses a, " + getsDOW() + "\n" +
                         getsLineFromcar();
                 setsOutputMsg(sTempStr);
             }
         }
