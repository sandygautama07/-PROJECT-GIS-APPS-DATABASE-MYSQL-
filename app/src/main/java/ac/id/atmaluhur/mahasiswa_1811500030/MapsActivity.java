package ac.id.atmaluhur.mahasiswa_1811500030;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.ProgressDialog;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ac.id.atmaluhur.mahasiswa_1811500030.api.ApiClient;
import ac.id.atmaluhur.mahasiswa_1811500030.api.ApiService;
import ac.id.atmaluhur.mahasiswa_1811500030.model.ListLocationModel;
import ac.id.atmaluhur.mahasiswa_1811500030.model.LocationModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99 ;
    private GoogleMap mMap;
    private List<LocationModel> mListMarker = new ArrayList<>();
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    int PROXIMITY_RADIUS = 10000;
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void buildGoogleApiClient(){
        mGoogleApiClient = new
                GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mGoogleApiClient.connect();
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
        //zoomin zoom out
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        //diarahkan ke class getalldatalocationlating

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }

        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        Button btnHospital = (Button) findViewById(R.id.B_Hospital);
        btnHospital.setOnClickListener(new View.OnClickListener() {
            String Hospital = "hospital";

            @Override
            public void onClick(View v) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                gethospital();
            }
        });

        Button btnRestaurant = (Button) findViewById(R.id.B_restaurant);
        btnRestaurant.setOnClickListener(new View.OnClickListener() {
            String Restaurant = "restaurant";

            @Override
            public void onClick(View v) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                getrestaurant();
            }
        });

        Button btnSchool = (Button) findViewById(R.id.B_school);
        btnSchool.setOnClickListener(new View.OnClickListener() {
            String School = "school";

            @Override
            public void onClick(View v) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                getschool();
            }
        });

        /*Button btnCurrent = (Button) findViewById(R.id.current);
        btnCurrent.setOnClickListener(new View.OnClickListener() {
            String current = "current";

            @Override
            public void onClick(View v) {
                Log.d("onClick", "Button is Clicked");
                mMap.clear();
                onLocationChanged(mLastLocation);
            }
        });*/

    }

    public void gethospital(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModel> call = apiService.getLocationHospital();
        call.enqueue(new Callback<ListLocationModel>() {
            @Override
            public void onResponse(Call<ListLocationModel> call, Response<ListLocationModel> response) {
                dialog.dismiss();
                mListMarker = response.body().getmData();
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModel> call, Throwable t) {
                Toast.makeText(MapsActivity.this, t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void getrestaurant(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModel> call = apiService.getLocationRestaurant();
        call.enqueue(new Callback<ListLocationModel>() {
            @Override
            public void onResponse(Call<ListLocationModel> call, Response<ListLocationModel> response) {
                dialog.dismiss();
                mListMarker = response.body().getmData();
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModel> call, Throwable t) {
                Toast.makeText(MapsActivity.this, t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void getschool(){
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Menampilkan data marker ..");
        dialog.show();
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListLocationModel> call = apiService.getLocationSchool();
        call.enqueue(new Callback<ListLocationModel>() {
            @Override
            public void onResponse(Call<ListLocationModel> call, Response<ListLocationModel> response) {
                dialog.dismiss();
                mListMarker = response.body().getmData();
                initMarker(mListMarker);
            }

            @Override
            public void onFailure(Call<ListLocationModel> call, Throwable t) {
                Toast.makeText(MapsActivity.this, t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initMarker(List<LocationModel> ListData) {
        //literasi semua data dan tampilkan marker
        for(int i=0; i<mListMarker.size(); i++) {
            //set latlng
            LatLng location = new LatLng(Double.parseDouble(mListMarker.get(i).getLatitude()), Double.parseDouble(mListMarker.get(i).getLongitude()));
            mMap.addMarker(new MarkerOptions().position(location).title(mListMarker.get(i).getImageLocationName()));
            LatLng latLng = new LatLng(Double.parseDouble(mListMarker.get(i).getLatitude()), Double.parseDouble(mListMarker.get(i).getLongitude()));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latLng.latitude, latLng.longitude), 11.0f));
        }
    }
    public void onClick(View v) {
        if (v.getId() == R.id.B_search) findViewById(R.id.TF_location);
        EditText tf_location = (EditText) findViewById(R.id.TF_location);
        String location = tf_location.getText().toString();
        List<Address> addressList = null;
        MarkerOptions markerOptions = new MarkerOptions();

        if (!location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 5);

            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < addressList.size(); i++) {
                Address myAddress = addressList.get(i);
                LatLng latLng = new LatLng(myAddress.getLatitude(), myAddress.getLongitude());
                markerOptions.position(latLng);
                markerOptions.title("Hasil Pencarian Mu");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                mMap.addMarker(markerOptions);
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("onLocationChanged", "entered");
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.draggable(true);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        Toast.makeText(MapsActivity.this, "Your Current Location",Toast.LENGTH_LONG).show();
        if (mGoogleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            Log.d("onlocationChanged", "Removing Location Update");
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[]
            permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0
                    && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
        // Izin diberikan.
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    if (mGoogleApiClient == null) {
                        buildGoogleApiClient();
                    }

                    mMap.setMyLocationEnabled(true);

                }
            } else {
        // Izin ditolak.
                Toast.makeText(this, "permission denied",
                        Toast.LENGTH_LONG).show();
            }

        }
    }
}