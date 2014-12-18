package app.myapplication2.gcu.ac.uk.MartinFriedberg;

/**
 * Created by Martin on 11/12/2014.
 */

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;



import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 11/12/2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class AboutDialogue extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder mfAboutDialog = new AlertDialog.Builder(getActivity());
        mfAboutDialog.setMessage("This app will take a date and produce a car description")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        mfAboutDialog.setTitle("About");
        mfAboutDialog.setIcon(R.drawable.ic_menu_action_quit);
        // Create the AlertDialog object and return it
        return mfAboutDialog.create();
    }
}

