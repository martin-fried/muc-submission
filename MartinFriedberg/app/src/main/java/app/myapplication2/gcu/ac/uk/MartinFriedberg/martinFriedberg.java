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
             private String sLineFromPoem;
             private String[] saLinesOfPoem;
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

             private void setsLineFromPoem(int iPoemLine) {
                 this.sLineFromPoem = saLinesOfPoem[iPoemLine];
             }

             public String getsLineFromPoem()

             {
                 return sLineFromPoem;
             }

             private void setSaLinesOfPoem()
                 {

                     saLinesOfPoem = new String[7];
                     saLinesOfPoem[0] = "has a 2.0 litre diesel engine which produces 143 BHP and a 0-62 time of 8.6 seconds.";
                     saLinesOfPoem[1] = "has a 5.0litre V12 producing 517 BHP and a 0-62 time of 4.5 seconds.";
                     saLinesOfPoem[2] = "has a 1.6 litre turbocharges engine producing 182 BHP and a 0-62 time of 6.9 seconds";
                     saLinesOfPoem[3] = "has a 4.2 litre V8 producing 395 BHP and a 0-62 tim eof 5.2 seconds.";
                     saLinesOfPoem[4] = "has a 4.3 litre V8 engine producing 460 BHP and a 0-62 time of 4.0 seconds.";
                     saLinesOfPoem[5] = "has a 6.2 litre V8 engine producing 437 BHP and has a 0-62 time of 4.3 seconds.";
                     saLinesOfPoem[6] = "has a 2.0 litre turbocharged engine producing 210 BHP and has a 0-62 time of 6.9 seconds.";
                 }
                 public String[] getSaLinesOfPoem ()
                 {
                     return saLinesOfPoem;
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
                 setSaLinesOfPoem();
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
                 setSaLinesOfPoem();
                 // store the date, month, year
                 setiDOW(mfDOW);
                 setiMonth(mfMonth);
                 setiYear(mfYear);
                 // Use the GregorianCalendar to instantiate a calendar object
                 GregorianCalendar gcBDay = new GregorianCalendar(mfYear, mfMonth, mfDOW);
                 // Set the day of the week integer using the date chosen
                 setiDayOfWeek(gcBDay.get(Calendar.DAY_OF_WEEK)-1)
                 ;
                 // Set the string day of the week
                 setsDOW(getiDayOfWeek());
                 // Set the line from the poem based on the integer day of the week
                 setsLineFromPoem(getiDayOfWeek());
                 // Create temporary string for output message
                 String sTempStr = "The car selected, " + getsDOW() + "\n" +
                         getsLineFromPoem();
                 setsOutputMsg(sTempStr);
             }
         }
