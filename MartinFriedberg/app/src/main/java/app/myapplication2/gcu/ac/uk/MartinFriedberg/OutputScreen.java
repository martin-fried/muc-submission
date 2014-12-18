package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 10/12/2014.
 */
public class OutputScreen extends ActionBarActivity implements View.OnClickListener {

    Button btnPickDate;
    Button btnSavedData;
    TextView tvStarSign;
    android.app.FragmentManager fmAboutDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_screen);


// Get car news from RSS Feed
        RSSDataItem userHoroscope = new RSSDataItem();
        String RSSFeedURL = "http://www.autocar.co.uk/rss";
        AsyncRSSParser rssAsyncParse = new AsyncRSSParser(this,RSSFeedURL);
        try {
            userHoroscope = rssAsyncParse.execute("").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        btnPickDate= (Button) findViewById(R.id.btnPickDate);
        btnSavedData= (Button) findViewById(R.id.btnSavedData);

        btnPickDate.setOnClickListener(this);
        btnSavedData.setOnClickListener(this);

        tvStarSign = (TextView) findViewById(R.id.tvCarDesc);

        TextView mfOutput = (TextView) findViewById(R.id.tvOutputMsg);

        Intent iMainAct = getIntent();
        mfOutput.setText(iMainAct.getStringExtra("tvOutputMsg"));


        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "message");
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
            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:
                // About Dialogue
                DialogFragment AboutDlg = new AboutDialogue();
                AboutDlg.show(fmAboutDialogue, "about_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }






    //Starts the activity to load the date picker when the pick date button is clicked.
    private void btnPickDateClick(){

        Intent activity_main = new Intent(getApplicationContext(), MainActivity.class);

         startActivity(activity_main);

    }

    //Starts the activity saved data when the view saved data button is clicked.
    private void btnSavedDataClick(){

        Intent display_Prefs = new Intent(getApplicationContext(), SavingDataOutput.class);

        startActivity(display_Prefs);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnPickDate:
                btnPickDateClick();
                break;
            case R.id.btnSavedData:
                btnSavedDataClick();
                break;


        }
    }
  }





