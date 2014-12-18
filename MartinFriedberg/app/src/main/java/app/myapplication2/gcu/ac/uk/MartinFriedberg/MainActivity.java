package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    DatePicker dpCday;
    Button submitBtn;
    SaveData SDPrefs;
    SharedPreferences mySharedPrefs;
    android.app.FragmentManager fmAboutDialogue;
    String sOutputMsg;
    Button btnStart;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an instance of the DatePicker Object
        dpCday = (DatePicker) findViewById(R.id.datePicker);
        dpCday.setCalendarViewShown(false);

// Setup, access and listen for the submit button
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);

        //Create Default preferences for the app
        mySharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SDPrefs = new SaveData(mySharedPrefs);
        SDPrefs.setDefaultPrefs();

        fmAboutDialogue = this.getFragmentManager();
        Log.e("n","message");
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mf_menu, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
       switch (item.getItemId()) {
           case R.id.mMap:
               Intent mfMap = new Intent(this, MapActivity.class);
               this.startActivity(mfMap);
               return true;
           case R.id.mBio:
               Intent BioDraw = new Intent(this, BioActivity.class);
               this.startActivity(BioDraw);
               return true;

            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:
                // About Dialogue
                DialogFragment AboutDlg = new AboutDialogue();
                AboutDlg.show(fmAboutDialogue,"about_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onClick(View view) {

        martinFriedberg YourDay = new martinFriedberg(dpCday.getDayOfMonth(),dpCday.getMonth(),dpCday.getYear());

        //Save Preferences
        SDPrefs.savePreferences("DOW", YourDay.getiDOW());
        SDPrefs.savePreferences("Month", YourDay.getiMonth());
        SDPrefs.savePreferences("DayBorn", YourDay.getsDOW());

        Intent Output_Screen = new Intent(getApplicationContext(), OutputScreen.class);

//Send data to the new Activity
        sOutputMsg = YourDay.getsOutputMsg();
        Output_Screen.putExtra("tvOutputMsg", sOutputMsg);


        Output_Screen.putExtra("tvOutputMsg", YourDay.getsOutputMsg());

        Log.e("n", YourDay.getsOutputMsg());

        startActivity(Output_Screen);



        sOutputMsg = YourDay.getsOutputMsg();
        Output_Screen.putExtra("OutputMsg", sOutputMsg);

    }



}
