
package hachthon.hospitalfinder;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import hachthon.hospitalfinder.network.OnRESTCallbackListener;
import hachthon.hospitalfinder.network.SimpleRESTGetter;

import java.util.ArrayList;
import java.util.List;

/**
 * GoogleMap fragment. It displays hospitals on Google Map. The code refers to Google Map's official
 * sample code.
 */
@SuppressLint("InflateParams")
public class GoogleMapFragment extends Fragment implements
        OnMarkerClickListener, OnInfoWindowClickListener, OnMapReadyCallback, ConnectionCallbacks,
        OnConnectionFailedListener, LocationListener, OnCameraChangeListener {

    // Some hospitals and their locations
    private static final LatLng SwedishPhysicians = new LatLng(47.681288,
            -122.317086);
    private static final LatLng UniversityOfWashingtonMedicalCenter = new LatLng(
            47.648548, -122.306304);
    private static final LatLng SwedishMedicalCenter = new LatLng(47.608864,
            -122.321786);
    private static final LatLng WomensHealthCareCenter = new LatLng(47.658892,
            -122.318159);
    private static final LatLng ZOOMCareWallingford = new LatLng(47.661811,
            -122.342234);

    private static boolean isFirstConnectedGoogleApiService = true;
    private GoogleApiClient mGoogleApiClient;
    private List<HospitalListInfo> hospitalList;
    private long preHospitalUpdateTime;
    private LatLng preHospitalUpdateLatLng;
    private int preHospitalUpdateRadius;

    public GoogleMapFragment(List<HospitalListInfo> hospitalList) {
        this.hospitalList = hospitalList;
    }

    class CustomInfoWindowAdapter implements InfoWindowAdapter {
        private final View mContent;

        CustomInfoWindowAdapter() {
            mContent = getActivity().getLayoutInflater().inflate(
                    R.layout.info_card, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            render(marker, mContent);
            return mContent;
        }

        private void render(Marker marker, View view) {

            String title = marker.getTitle();
            TextView titleUi = ((TextView) view.findViewById(R.id.title));
            if (title != null) {
                // Spannable string allows us to edit the formatting of the
                // text.
                SpannableString titleText = new SpannableString(title);
                titleText.setSpan(new ForegroundColorSpan(Color.RED), 0,
                        titleText.length(), 0);
                titleUi.setText(titleText);
            } else {
                titleUi.setText("");
            }

            String distance;
            if (marker.equals(SwedishPhysiciansMarker)) {
                distance = "1.0";
            } else if (marker.equals(WomensHealthCareCenterMarker)) {
                distance = "2.0";
            } else if (marker.equals(SwedishMedicalCenterMarker)) {
                distance = "3.0";
            } else if (marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
                distance = "4.0";
            } else if (marker.equals(ZOOMCareWallingfordMarker)) {
                distance = "5.0";
            } else {
                distance = "6.0";
            }
            ((TextView) view.findViewById(R.id.distance)).setText(distance);

            String isOpen;
            if (marker.equals(SwedishPhysiciansMarker)) {
                isOpen = "open";
            } else if (marker.equals(WomensHealthCareCenterMarker)) {
                isOpen = "closed";
            } else if (marker.equals(SwedishMedicalCenterMarker)) {
                isOpen = "open";
            } else if (marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
                isOpen = "open";
            } else if (marker.equals(ZOOMCareWallingfordMarker)) {
                isOpen = "closed";
            } else {
                isOpen = "open";
            }
            ((TextView) view.findViewById(R.id.openText)).setText(isOpen);

            String stars;
            if (marker.equals(SwedishPhysiciansMarker)) {
                stars = "4.9";
            } else if (marker.equals(WomensHealthCareCenterMarker)) {
                stars = "9.6";
            } else if (marker.equals(SwedishMedicalCenterMarker)) {
                stars = "8.2";
            } else if (marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
                stars = "9.7";
            } else if (marker.equals(ZOOMCareWallingfordMarker)) {
                stars = "6.8";
            } else {
                stars = "5.5";
            }
            ((TextView) view.findViewById(R.id.starText)).setText(stars);

            String cost;
            if (marker.equals(SwedishPhysiciansMarker)) {
                cost = "$300/hr";
            } else if (marker.equals(WomensHealthCareCenterMarker)) {
                cost = "$100/hr";
            } else if (marker.equals(SwedishMedicalCenterMarker)) {
                cost = "$200/hr";
            } else if (marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
                cost = "$10/hr";
            } else if (marker.equals(ZOOMCareWallingfordMarker)) {
                cost = "$150/hr";
            } else {
                cost = "$55/hr";
            }
            ((TextView) view.findViewById(R.id.dollarsText)).setText(cost);

            int starBadge = R.drawable.popup_star;
            ((ImageView) view.findViewById(R.id.star)).setImageResource(starBadge);

            int dollarsBadge = R.drawable.popup_dollar;
            ((ImageView) view.findViewById(R.id.dollars)).setImageResource(dollarsBadge);

            int openBadge = R.drawable.popup_open;
            ((ImageView) view.findViewById(R.id.open)).setImageResource(openBadge);
        }
    }

    private GoogleMap mMap;

    private Marker ZOOMCareWallingfordMarker;
    private Marker SwedishMedicalCenterMarker;
    private Marker SwedishPhysiciansMarker;
    private Marker WomensHealthCareCenterMarker;
    private Marker UniversityOfWashingtonMedicalCenterMarker;

    private final List<Marker> mMarkerRainbow = new ArrayList<Marker>();

    private static View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    public void onPause() {
        super.onPause();
        mGoogleApiClient.disconnect();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.google_map_fragment, container,
                    false);
        } catch (InflateException e) {
            return view;
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        mMap.setMyLocationEnabled(true);
        mMap.setOnCameraChangeListener(this);

        // Hide the zoom controls as the button panel will cover it.
        mMap.getUiSettings().setZoomControlsEnabled(false);

        // Setting an info window adapter allows us to change the both the
        // contents and look of the
        // info window.
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

        // Set listeners for marker events. See the bottom of this class for
        // their behavior.
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);

        // Override the default content description on the view, for
        // accessibility mode.
        // Ideally this string would be localised.
        map.setContentDescription("Map with lots of markers.");

        // Pan to see all markers in view.
        // Cannot zoom to bounds until the map has a size.
        final View mapView = getFragmentManager().findFragmentById(R.id.map)
                .getView();
        if (mapView.getViewTreeObserver().isAlive()) {
            mapView.getViewTreeObserver().addOnGlobalLayoutListener(
                    new OnGlobalLayoutListener() {
                        @SuppressWarnings("deprecation")
                        // We use the new method when supported
                        @SuppressLint("NewApi")
                        // We check which build version we are using.
                        @Override
                        public void onGlobalLayout() {
                            LatLngBounds bounds = new LatLngBounds.Builder()
                                    .include(ZOOMCareWallingford)
                                    .include(SwedishMedicalCenter)
                                    .include(WomensHealthCareCenter)
                                    .include(SwedishPhysicians)
                                    .include(
                                            UniversityOfWashingtonMedicalCenter)
                                    .build();
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                mapView.getViewTreeObserver()
                                        .removeGlobalOnLayoutListener(this);
                            } else {
                                mapView.getViewTreeObserver()
                                        .removeOnGlobalLayoutListener(this);
                            }
                            mMap.moveCamera(CameraUpdateFactory
                                    .newLatLngBounds(bounds, 50));
                        }
                    });
        }
    }

    //
    // Marker related listeners.
    //

    @Override
    public boolean onMarkerClick(final Marker marker) {
        // We return false to indicate that we have not consumed the event and
        // that we wish
        // for the default behavior to occur (which is for the camera to move
        // such that the
        // marker is centered and for the marker's info window to open, if it
        // has one).
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        int index = 0;
        if (marker.getTitle().equals("Swedish Physicians")) {
            index = 0;
        } else if (marker.getTitle().equals("Swedish Medical Center")) {
            index = 1;
        } else if (marker.getTitle().equals("University of Washington Medical Center")) {
            index = 2;
        } else if (marker.getTitle().equals("ZOOM Care Wallingford")) {
            index = 3;
        } else if (marker.getTitle().equals("Women's Health Care Center")) {
            index = 4;
        }
        bundle.putInt("ARRAY_INDEX", index);
        intent.putExtras(bundle);
        intent.setClass(getActivity(), HospitalDetailActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 12);
        mMap.animateCamera(cameraUpdate);
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        updateHospitalsWithinCircle(location.getLatitude(), location.getLongitude(), 10000);
    }

    Handler handle = new Handler();

    void updateHospitalsWithinCircle(double lat, double lng, int radius) {
        String url = "https://data.medicare.gov/resource/ppaw-hhm5.json?"
                + "$select=hospital_name,location,location_address&"
                + "$where=within_circle(location," + lat
                + "," + lng
                + "," + radius
                + ")&$group=hospital_name,location,location_address";

        SimpleRESTGetter.queryHospitalInfo(url, new OnRESTCallbackListener() {

            @Override
            public void onSuccess(final List<HospitalListInfo> hospitalList) {
                handle.post(new Runnable() {

                    @Override
                    public void run() {
                        for (HospitalListInfo h : hospitalList) {
                            addHospitalMarkerToMap(h);
                        }
                    }
                });
            }
        });
    }

    void addHospitalMarkerToMap(HospitalListInfo hospital) {
        if (mMap != null) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(hospital.getLatitude(), hospital.getLongitude()))
                    .title(hospital.getHospitalName())
                    .snippet("Details about it")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
        }
    }

    // These settings are the same as the settings for the map. They will in fact give you updates
    // at the maximal rates currently possible.
    private static final LocationRequest REQUEST = LocationRequest.create()
            .setInterval(60000) // 1 minute
            .setFastestInterval(16) // 16ms = 60fps
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

    @Override
    public void onConnected(Bundle arg0) {
        if (isFirstConnectedGoogleApiService) {
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient,
                    REQUEST,
                    this); // LocationListener
            isFirstConnectedGoogleApiService = false;
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult arg0) {
    }

    @Override
    public void onCameraChange(CameraPosition position) {
        float[] result = new float[1];
        if (preHospitalUpdateLatLng != null) {
            Location.distanceBetween(preHospitalUpdateLatLng.latitude,
                    preHospitalUpdateLatLng.longitude, position.target.latitude,
                    position.target.longitude, result);
        }
        if (preHospitalUpdateLatLng == null
                || (result[0] > preHospitalUpdateRadius && System.currentTimeMillis() - 5000 > preHospitalUpdateTime)) {
            double lat = position.target.latitude;
            double lng = position.target.longitude;
            float zoom = position.zoom;
            int radius = (int) (10000 * Math.pow(2, 12 - zoom));
            updateHospitalsWithinCircle(lat, lng, radius);
            preHospitalUpdateLatLng = position.target;
            preHospitalUpdateRadius = radius;
            preHospitalUpdateTime = System.currentTimeMillis();
        }
    }
}
