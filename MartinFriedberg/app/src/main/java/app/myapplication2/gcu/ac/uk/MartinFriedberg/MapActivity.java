package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import app.myapplication2.gcu.ac.uk.martinfriedberg.R;

/**
 * Created by Martin on 16/12/2014.
 */
public class MapActivity extends Activity {


    static final LatLng AUDI = new LatLng(55.8684, -4.36682);
    static final LatLng MASERATI = new LatLng(55.7778, -4.05234);
    static final LatLng FERRARI = new LatLng(55.9311 ,-3.1058);
    static final LatLng ASTON = new LatLng(55.927368, -3.300648);
    static final LatLng FORD = new LatLng(55.843365, -4.467405);
    static final LatLng CHEVROLET = new LatLng(55.840956, -4.155625);
    static final LatLng VOLKSWAGEN = new LatLng(55.846707, -4.473736);

    private GoogleMap map;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.map_view);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mMap))
                .getMap();
        Marker audi = map.addMarker(new MarkerOptions().position(AUDI)
                .title("AUDI")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker maserati = map.addMarker(new MarkerOptions()
                .position(MASERATI)
                .title("MASERATI")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker ferrari = map.addMarker(new MarkerOptions().position(FERRARI)
                .title("FERRARI")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker aston = map.addMarker(new MarkerOptions().position(ASTON)
                .title("ASTON")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker ford = map.addMarker(new MarkerOptions().position(FORD)
                .title("FORD")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker chevrolet = map.addMarker(new MarkerOptions().position(CHEVROLET)
                .title("CHEVROLET")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        Marker volkswagen = map.addMarker(new MarkerOptions().position(VOLKSWAGEN)
                .title("VOLKSWAGEN")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(AUDI, 15));

        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

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

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
