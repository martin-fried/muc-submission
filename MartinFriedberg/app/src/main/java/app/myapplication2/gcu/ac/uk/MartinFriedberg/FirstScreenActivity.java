package app.myapplication2.gcu.ac.uk.MartinFriedberg;

/**
 * Created by Martin on 15/12/2014.
 */

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
       import android.app.Activity;

        import android.os.Bundle;

        import android.view.View;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;


public class FirstScreenActivity extends Activity implements View.OnClickListener {

    Button btnStart;
    android.app.FragmentManager fmAboutDialogue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

//sets the onClick listener
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);


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
                AboutDlg.show(fmAboutDialogue,"about_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }






// Sets the Start button to activate the MainActivity class when clicked.
    public void onClick(View view) {

        Intent activity_main = new Intent(getApplicationContext(), MainActivity.class);


        startActivity(activity_main);


        setResult(Activity.RESULT_OK);
        finish();
    }


    }









