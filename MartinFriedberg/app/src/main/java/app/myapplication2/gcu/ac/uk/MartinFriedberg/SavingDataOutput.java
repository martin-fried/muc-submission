package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 11/12/2014.
 */
public class SavingDataOutput extends Activity implements View.OnClickListener {

    SharedPreferences mfSharedPrefs;
    Button btnBack;
    TextView mfSDODOW;
    TextView mfSDOMonth;
    TextView mfSDODayBorn;
    TextView mfSDStarSign;
    Button btnSavedData;
    android.app.FragmentManager fmAboutDialogue;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_prefs);


        // setup, access and listen for the back button
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        //create text view for output
        mfSDODOW = (TextView) findViewById(R.id.tvDOW);
        mfSDOMonth = (TextView) findViewById(R.id.tvMonth);
        mfSDODayBorn = (TextView) findViewById(R.id.tvCarName);
        mfSDStarSign = (TextView) findViewById(R.id.tvCarDesc);
        //Load any saved preferences
        mfSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
        Log.e("n", "SDOutput msg");
    }

    private void loadSavedPreferences() {
        mfSDODOW.setText(mfSDODOW.getText() + String.valueOf(mfSharedPrefs.getInt("mf_DOW", 1)));
        mfSDOMonth.setText(mfSDOMonth.getText() + String.valueOf(mfSharedPrefs.getInt("mf_Month", 1)));
        mfSDODayBorn.setText(mfSDODayBorn.getText() + String.valueOf(mfSharedPrefs.getString("mf_DayBorn", "Sunday")));
        mfSDStarSign.setText(mfSDStarSign.getText() + mfSharedPrefs.getString("mf_StarSign", "January"));
    }

    public void onClick(View view) {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
