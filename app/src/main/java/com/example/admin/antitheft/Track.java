package com.example.admin.antitheft;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.TimeZone;
import java.text.DecimalFormat;

public class Track extends AppCompatActivity {

    private static final String TAG = null;
    private TextView name1;
    private TextView t;
    private Button b;
    private Button onmap;
    private TextView lal;
    private LocationManager locationManager;
    private LocationListener listener;
    private LocationListener listener1;
    public String Email;
    Double latitude;
    Double longitude;
    String currentDateTimeString;
    String OriginalName;
    public String name;
    TextView t2;
    int temp1=3;
    int temp2=4;
    int temp3=6;
    int temp4=7;
    String compo;
  //  int temp11 = 3;
    String tempo;
    String[] For_split_Textview;
   String ll = " ";
    String a = " ";
    String c = " ";
String namedis;
    Double latitude2 = 22.0;
    Double longitude2 = 72.0;
    private DatabaseReference myDriver;
    String Lat;
    String Lon;
    String Key;
    String Key1;
    Double latitude123;
    Double longitude123;
    String date;
    DatabaseReference myRef1;
    Context context;
    String lati;
    String loni;
    FirebaseDatabase database;
    DatabaseReference myRef;
    String currentDateTimeString1;




public ArrayList<String> Userlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        b = (Button) findViewById(R.id.track);
       // t = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView5);
        onmap = (Button) findViewById(R.id.map);

        name1 = (TextView) findViewById(R.id.set);
        Intent i = getIntent();
        Email = i.getStringExtra("Email");

        final String[] separated = Email.split("@");
        namedis = separated[0];

        String setname = separated[0].toUpperCase();
        String setname1 = "WELCOME" + "  " + setname + "!!!";
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


        //myDriver = FirebaseDatabase.getInstance().getReference().child("users").child(namedis);

       // userinfo userinfo12 = new userinfo(longitude,latitude,currentDateTimeString);

         //myRef1.setValue(userinfo12);
        /*myDriver = FirebaseDatabase.getInstance().getReference().child("users").child(namedis);
        Map<String, String> userData1 = new HashMap<String, String>();
        String lat = Double.toString(21.8714);
        String lon = Double.toString(72.347);

        userData1.put("currentDateTimeString",currentDateTimeString);
        userData1.put("latitude", lat);
        userData1.put("longitude", lon);
myDriver.setValue(userData1); */





        name1.setText(setname1);






    // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,listener);
//        Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //t2.append(loc.getLatitude() + "" + loc.getLongitude());

    //Location l = this.getLocation();
      //  t2.append(l.getLatitude() + "" + l.getLongitude());





        //  LocationManager lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        //boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

//        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,listener1);
      //  Location loc = lm.getLastKnownLocation(locationManager.GPS_PROVIDER);
        //name = name1.getText().toString();

        //String url = "http://stackoverflow.com/questions/thispost/";
        /*separated[0]; // = http:
        separated[1]; // = (nothing, i.e, empty string, `""`)
        separated[2]; // = stackoverflow.com
        separated[3]; // = questions
        separated[4]; // = thispost*/

        //Email = "WELCOME \n" + Email;

        //name1.setText(Email);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        listener = new LocationListener() {


            @Override
            public void onLocationChanged(Location location) {
                //   t.append("\n " + location.getLongitude() + " " + location.getLatitude());

                latitude = location.getLatitude();
                longitude = location.getLongitude();
         //       Toast.makeText(Track.this,"latitude" + latitude,Toast.LENGTH_SHORT ).show();



               // FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference myRef = database.getReference().child("users").child(separated[0]).child(currentDateTimeString);
                DatabaseReference childref;
                Map<String, String> userData = new HashMap<String, String>();
                String lat = Double.toString(latitude);
                String lon = Double.toString(longitude);
                database = FirebaseDatabase.getInstance();
                 myRef = database.getReference().child("users").child(namedis);
                currentDateTimeString1 = DateFormat.getDateTimeInstance().format(new Date());


                userData.put("Latitude", lat);
                  userData.put("Longitude", lon);
                  userData.put("time",currentDateTimeString1);
               myRef.setValue(userData);
     //childref = myRef.child("users").child(namedis);
       //           childref.setValue(namedis);
         //        childref.setValue(userData);


               //  userinfo userinfo1 = new userinfo(longitude,latitude,currentDateTimeString);

                //myRef.setValue(userinfo1);

               /* private static SimpleDateFormat df
                        = new SimpleDateFormat( "yyyy-MM-dd'T'hh:mm:ssz")
                df.setTimeZone(TimeZone.getTimeZone("GMT"));*/
                //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

// textView is the TextView view that should display it
                //name1.setText(currentDateTimeString);
                //myRef.setValue(currentDateTimeString);

//
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {


            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);

            }
        };
        configure_button();

       ActivityCompat.requestPermissions(Track.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 10);
        if (ActivityCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
            Log.e("fist","error");
        }

        LocationManager lm = (LocationManager)getSystemService(LOCATION_SERVICE);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000,10,listener);
            Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
           // Toast.makeText(Track.this,"latitude" + loc.getLatitude(),Toast.LENGTH_SHORT).show();

            Map<String, String> userData = new HashMap<String, String>();
            String lat123 = Double.toString(loc.getLatitude());
            String lon123 = Double.toString(loc.getLongitude());
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference().child("users").child(namedis);


            userData.put("Latitude", lat123);
            userData.put("Longitude", lon123);
            userData.put("time",currentDateTimeString);
            myRef.setValue(userData);







        }





    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.INTERNET}
                        , 10);
            }

            return;
        }
        // this code won't execute IF permissions are not allowed, because in the line above there is return statement.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 2000, 0, listener);




            }
        });
    }


    public void click_location(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference childref1;
        myRef1 = database.getReference("users").child(namedis);





        myRef1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

             lati = dataSnapshot.child("Latitude").getValue().toString();
        latitude123 = Double.parseDouble(lati);
        loni = dataSnapshot.child("Longitude").getValue().toString();
        longitude123 = Double.parseDouble(loni);
        date = dataSnapshot.child("time").getValue().toString();
/*            userinfo user = dataSnapshot.getValue(userinfo.class);
            latitude123 = user.latitude;
             longitude123 = user.longitude;
           date = user.currentDateTimeString;
            t2.append(user.currentDateTimeString +" "+"Latitude="+ user.latitude + " " +"Longitude="+ user.longitude+ " "); */
      t2.append(date +" " +"Latitude:" + latitude123 +" " + "Longitude:" + longitude123 + " ");

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});







/*myRef1.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
      for(DataSnapshot dsp:dataSnapshot.getChildren())
      {
          Key = dsp.getValue().toString();
          t2.append(Key);
      }
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}); */





  /* myRef1.addValueEventListener(new ValueEventListener() {
       @Override
       public void onDataChange(DataSnapshot dataSnapshot) {

     for(DataSnapshot dsp:dataSnapshot.getChildren())
     {
         Key = dsp.getKey().toString();
        // t2.append(Key);
     }
         //  t2.append(Key);

           //Key = dataSnapshot.getKey().toString();


       }

       @Override
       public void onCancelled(DatabaseError databaseError) {

       }
   });



       myDriver.child(Key).child("latitude").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

   Lat = dataSnapshot.getValue().toString();
                t2.append(Lat + "");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); */
        //DatabaseReference childref1;


        //final DatabaseReference myRef2 = myRef1.child(name1.getText().toString());


       // myRef3 = myRef2.child(currentDateTimeString);




    myRef1.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {

             //  Userlist = new ArrayList<String>();
               String[] rest = new String[100];
               int fact=0;


           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

    }


    public void show_map(View v)
    {

        Intent intent = new Intent(Track.this,MapsActivity.class);
        intent.putExtra("namedis",namedis);
        startActivity(intent);

    }

























}