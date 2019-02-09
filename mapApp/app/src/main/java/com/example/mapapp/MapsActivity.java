package com.example.mapapp;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import static com.example.mapapp.SearchResults.result;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //extra thing
    private static final String TAG = "MainActivity";


    //widgets
    private ImageView mInfo;

    // my extra vars
    private Marker mMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //mInfo = (ImageView) findViewById(R.id.place_info);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        /////////////////////


        ////////////////


        mMap = googleMap;

        /////////////

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e("MapsActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e( "MapsActivity", "Can't find style. Error: ", e);
        }

        ////////////


        addMarkers();

        // Add a marker in Sydney and move the camera
        int pos = getIntent().getExtras().getInt("position");
        LatLng founders = new LatLng(result.get(pos).getLat(), result.get(pos).getLng());
        String snippet = "bananas are good: \n wow what a line break";

        MarkerOptions options = new MarkerOptions()
                .position(founders)
                .title("Founders Hall");
                //.snippet(snippet);
        mMarker = mMap.addMarker(options);


        //////////////
        /**LatLng stokes = new LatLng(40.009761, -75.308966);
        mMap.addMarker(new MarkerOptions().position(stokes).title("Stokes Hall"));**/

        mMap.setMaxZoomPreference(21);
        mMap.setMinZoomPreference(16);

        float zoomLevel = (float) 17.4;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(founders, zoomLevel));

        //createImageButton();
    }

    /**public void createImageButton(){
        mInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked place info");
                try {

                }
                catch (NullPointerException e){

                }
            }
        }

    }**/

    //gets all the information and adds the markers
    //using the dataObject
    public void addMarkers(){

        int[] DATAOBJECTSLIST = new int[10];

        //NEED TO GET THE LIST OF ALL TEH DATAOBJECTS
        float DATAOBJECTSLISTSIZE = 10;

        for(int i = 0; i < DATAOBJECTSLISTSIZE; i++){
            /**dataObject datObj = DATAOBJECTSLIST[i];

            //currently no getter method for this so if this crashes that's why
            String officName =  datObj.officialName;
            String name = datObj.getName().name.getString();
            String poi = datObj.getPlaceOfInterest().name.getString();
            String toi = datObj.getThingOfInterest().name.getString();

            //no getter method for this either
            String descript = datObj.description;

            //getFunction() returns an arrayList
            String function = datObj.getFunction().get(i);

            float lat = datObj.getLat();
            float lng = datObj.getLng();

            LatLng position = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions().position(position).title(officName));

            //float zoomLevel = (float) 17.4;
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, zoomLevel));**/
        }

    }

}
