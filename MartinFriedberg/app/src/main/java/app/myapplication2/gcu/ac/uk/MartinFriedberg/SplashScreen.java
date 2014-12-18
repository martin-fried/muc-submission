package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 12/12/2014.
 */
public class SplashScreen  extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {


            //Showing splash screen with a timer.


            @Override
            public void run() {

                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, FirstScreenActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
