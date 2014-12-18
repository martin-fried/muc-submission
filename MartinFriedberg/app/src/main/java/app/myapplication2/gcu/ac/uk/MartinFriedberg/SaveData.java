package app.myapplication2.gcu.ac.uk.MartinFriedberg;

/**
 * Created by Martin on //.
 */

import android.app.Activity;
 import android.content.SharedPreferences;
 import android.preference.PreferenceManager;
 import android.util.Log;

         public class SaveData extends Activity {
    
             // *********************************************
             // Declare variables etc.
             // *********************************************
            
             SharedPreferences mfSharedPrefs;
    
             private int mfSDDOW;
     private int mfSDMonth;
     private String mfSDDayBorn;
             private String mfSDStarSign;

    
             // *********************************************
             // Declare getters and setters etc.
             // *********************************************
            
             private void setmfSDDOW(int isDOW)
     {
         this.mfSDDOW = isDOW;
         }
    
             public int getmfSDDOW()
     {
         return mfSDDOW;
         }
    
             private void setmfSDMonth(int isMonth)
     {
         this.mfSDMonth = isMonth;

         }

             public void setmfSDStarSign(String mfSDStarSign)
             {
                 this.mfSDStarSign = mfSDStarSign;
                 setmfSDStarSign("January");

             }

             public String getmfSDStarSign()
             {
                 return mfSDStarSign;
             }
    
             public int getmfSDMonth()
     {
         return mfSDMonth;
         }
    
             private void setmfSDDayBorn(String isDayBorn)
     {
         this.mfSDDayBorn = isDayBorn;
         }
    
             public String getmfSDDayBorn()
     {
         return mfSDDayBorn;
         }
    
             // **************************************************
             // Declare constructor and date manipulation methods.
             // **************************************************
            
             public SaveData(SharedPreferences mfSDPrefs){
         setmfSDDOW(1);
         setmfSDMonth(1);
         setmfSDDayBorn("Sunday");
         try {
             this.mfSharedPrefs = mfSDPrefs;
             }
         catch (Exception e)
         {
             Log.e("n","Pref Manager is NULL" );
             }
         setDefaultPrefs();
         }
    
             public void savePreferences(String key, boolean value) {
         SharedPreferences.Editor editor = mfSharedPrefs.edit();

         editor.putBoolean(key, value);
         editor.commit();
         }
    
             public void savePreferences(String key, String value) {
         SharedPreferences.Editor editor = mfSharedPrefs.edit();
         editor.putString(key, value);
         editor.commit();
         }
    
             public void savePreferences(String key, int value) {
         SharedPreferences.Editor editor = mfSharedPrefs.edit();
         editor.putInt(key, value);
         editor.commit();
         }
    
             public void setDefaultPrefs(){
         savePreferences("mf_DOW", 1);
         savePreferences("mf_Month", 1);
         savePreferences("mf_DayBorn", "Empty");
         savePreferences("mf_StarSign", "Empty");
         }
     }
