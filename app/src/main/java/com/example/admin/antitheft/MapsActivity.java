package com.example.admin.antitheft;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.DecimalFormat;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public String name;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseDatabase database1;
    DatabaseReference myRef1;
    private LocationManager locationManager;
    private LocationListener listener;

    private GoogleMap mMap;
    DecimalFormat formater = new DecimalFormat("#.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent i = getIntent();
         name = i.getStringExtra("namedis");
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("users").child(name);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


              String  lati = dataSnapshot.child("Latitude").getValue().toString();
               Double latitude = Double.parseDouble(lati);
               String loni = dataSnapshot.child("Longitude").getValue().toString();
               Double longitude = Double.parseDouble(loni);
                 String date = dataSnapshot.child("time").getValue().toString();
               // userinfo user  = dataSnapshot.getValue(userinfo.class);
                //Double latitude = user.latitude;
                //Double longitude = user.longitude;
                //String date = user.currentDateTimeString;
                LatLng location = new LatLng(latitude,longitude);

                mMap.addMarker(new MarkerOptions().position(location).title("location").snippet(date+ " Latitude:" + formater.format(latitude)+ ",Longitude:" +formater.format(longitude)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       /* Double latitude =  22.0;
        Double longitude = 72.0;
        LatLng position = new LatLng(latitude, longitude);

        // Instantiating MarkerOptions class
        MarkerOptions options = new MarkerOptions();

        // Setting position for the MarkerOptions
        options.position(position);

        // Setting title for the MarkerOptions
        options.title("Position");

        // Setting snippet for the MarkerOptions
        options.snippet("Latitude:"+latitude+",Longitude:"+longitude);

        // Getting Reference to SupportMapFragment of activity_map.xml
       // SupportMapFragment fm = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        // Getting reference to google map
        GoogleMap googleMap = null;    // = fm.getMap();
mMap = googleMap;
        // Adding Marker on the Google Map
        mMap.addMarker(options);

        // Creating CameraUpdate object for position
        CameraUpdate updatePosition = CameraUpdateFactory.newLatLng(position);

        // Creating CameraUpdate object for zoom
        CameraUpdate updateZoom = CameraUpdateFactory.zoomBy(4);

        // Updating the camera position to the user input latitude and longitude
        mMap.moveCamera(updatePosition);

        // Applying zoom to the marker position
        mMap.animateCamera(updateZoom);*/
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        database1 = FirebaseDatabase.getInstance();
        myRef1 = database1.getReference().child("users").child(name);


      myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String  lati = dataSnapshot.child("Latitude").getValue().toString();
                Double latitude = Double.parseDouble(lati);
                String loni = dataSnapshot.child("Longitude").getValue().toString();
                Double longitude = Double.parseDouble(loni);
                String date = dataSnapshot.child("time").getValue().toString();
                // userinfo user  = dataSnapshot.getValue(userinfo.class);
                //Double latitude = user.latitude;
                //Double longitude = user.longitude;
                //String date = user.currentDateTimeString;
                LatLng location = new LatLng(latitude,longitude);

                mMap.addMarker(new MarkerOptions().position(location).title("location").snippet(date+ " Latitude:" + latitude+ ",Longitude:" +longitude));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));






            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






















/*        myRef.add(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                    String ll = dsp.getValue().toString();
                    String [] location = ll.split("=.");
                    Double latitude = Double.parseDouble(location[1]);





                userinfo user  = dsp.getValue(userinfo.class);
                  //  LatLng location = new LatLng(user.latitude,user.longitude);
                    //mMap.addMarker(new MarkerOptions().position(location).title("location"));
                    //mMap.moveCamera(CameraUpdateFactory.newLatLng(location));


                }



            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

      //  LatLng sydney = new LatLng(latitude,longitude);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


}
