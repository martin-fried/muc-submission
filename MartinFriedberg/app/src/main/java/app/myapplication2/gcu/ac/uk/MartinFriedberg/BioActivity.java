package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import java.lang.annotation.Target;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 16/12/2014.
 */
public class BioActivity extends Activity {

    //An event handler called when the app is first created.
    //Usually contains lal initializations and setting up for the app.

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio_draw_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new BiorythmsSurfaceView(this));
    }
}
