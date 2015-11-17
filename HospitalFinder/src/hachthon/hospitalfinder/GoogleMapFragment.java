
package hachthon.hospitalfinder;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

/**
 * GoogleMap fragment. It displays hospitals on Google Map. The code refers to Google Map's official
 * sample code.
 */
@SuppressLint("InflateParams")
public class GoogleMapFragment extends Fragment implements
        OnMarkerClickListener, OnInfoWindowClickListener,
        OnSeekBarChangeListener, OnMapReadyCallback {

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
    
    List<HospitalListInfo> hospitalList;
    
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
//            int badge;
//            if (marker.equals(SwedishPhysiciansMarker)) {
//                badge = R.drawable.badge_qld;
//            } else if (marker.equals(WomensHealthCareCenterMarker)) {
//                badge = R.drawable.badge_sa;
//            } else if (marker.equals(SwedishMedicalCenterMarker)) {
//                badge = R.drawable.badge_nsw;
//            } else if (marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
//                badge = R.drawable.badge_victoria;
//            } else if (marker.equals(ZOOMCareWallingfordMarker)) {
//                badge = R.drawable.badge_wa;
//            } else {
//                // Passing 0 to setImageResource will clear the image view.
//                badge = 0;
//            }
//            ((ImageView) view.findViewById(R.id.badge)).setImageResource(badge);

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

//            String snippet = marker.getSnippet();
//            TextView snippetUi = ((TextView) view.findViewById(R.id.snippet));
//            if (snippet != null && snippet.length() > 12) {
//                SpannableString snippetText = new SpannableString(snippet);
//                snippetText.setSpan(new ForegroundColorSpan(Color.MAGENTA), 0,
//                        10, 0);
//                snippetText.setSpan(new ForegroundColorSpan(Color.BLUE), 12,
//                        snippet.length(), 0);
//                snippetUi.setText(snippetText);
//            } else {
//                snippetUi.setText("");
//            }
//            
            String distance;
            if(marker.equals(SwedishPhysiciansMarker)) {
            		distance = "1.0";
            } else if(marker.equals(WomensHealthCareCenterMarker)) {
            		distance = "2.0";
            } else if(marker.equals(SwedishMedicalCenterMarker)) {
            		distance = "3.0";
            } else if(marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
            		distance = "4.0";
            } else if(marker.equals(ZOOMCareWallingfordMarker)) {
            		distance = "5.0";
            } else {
            		distance = "";
            }
            ((TextView) view.findViewById(R.id.distance)).setText(distance);
        
        	String isOpen;
            if(marker.equals(SwedishPhysiciansMarker)) {
        		isOpen = "open";
            } else if(marker.equals(WomensHealthCareCenterMarker)) {
        		isOpen = "closed";
            } else if(marker.equals(SwedishMedicalCenterMarker)) {
        		isOpen = "open";
            } else if(marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
        		isOpen = "open";
            } else if(marker.equals(ZOOMCareWallingfordMarker)) {
        		isOpen = "closed";
            } else {
        		isOpen = "";
            }
            ((TextView) view.findViewById(R.id.openText)).setText(isOpen);
            
           	String stars;
            if(marker.equals(SwedishPhysiciansMarker)) {
        		stars = "4.9";
            } else if(marker.equals(WomensHealthCareCenterMarker)) {
        		stars = "9.6";
            } else if(marker.equals(SwedishMedicalCenterMarker)) {
        		stars = "8.2";
            } else if(marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
        		stars = "9.7";
            } else if(marker.equals(ZOOMCareWallingfordMarker)) {
        		stars = "6.8";
            } else {
        		stars = "";
            }
            ((TextView) view.findViewById(R.id.starText)).setText(stars);
            
           	String cost;
            if(marker.equals(SwedishPhysiciansMarker)) {
        		cost = "$300/hr";
            } else if(marker.equals(WomensHealthCareCenterMarker)) {
        		cost = "$100/hr";
            } else if(marker.equals(SwedishMedicalCenterMarker)) {
        		cost = "$200/hr";
            } else if(marker.equals(UniversityOfWashingtonMedicalCenterMarker)) {
        		cost = "$10/hr";
            } else if(marker.equals(ZOOMCareWallingfordMarker)) {
        		cost = "$150/hr";
            } else {
        		cost = "";
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

        // Hide the zoom controls as the button panel will cover it.
        mMap.getUiSettings().setZoomControlsEnabled(false);

        // Add lots of markers to the map.
        addMarkersToMap();

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

    private void addMarkersToMap() {
        SwedishPhysiciansMarker = mMap.addMarker(new MarkerOptions()
                .position(SwedishPhysicians)
                .title("Swedish Physicians")
                .snippet("Details about it")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
        SwedishMedicalCenterMarker = mMap.addMarker(new MarkerOptions()
                .position(SwedishMedicalCenter)
                .title("Swedish Medical Center")
                .snippet("Details about it")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
        UniversityOfWashingtonMedicalCenterMarker = mMap
                .addMarker(new MarkerOptions()
                        .position(UniversityOfWashingtonMedicalCenter)
                        .title("University of Washington Medical Center")
                        .snippet("Details about it")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
        ZOOMCareWallingfordMarker = mMap.addMarker(new MarkerOptions()
                .position(ZOOMCareWallingford)
                .title("ZOOM Care Wallingford")
                .snippet("Details about it")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
        WomensHealthCareCenterMarker = mMap.addMarker(new MarkerOptions()
                .position(WomensHealthCareCenter)
                .title("Women's Health Care Center")
                .snippet("Details about it")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalcross)));
    }

    private boolean checkReady() {
        return true;
    }

    /** Called when the Clear button is clicked. */
    public void onClearMap(View view) {
        if (!checkReady()) {
            return;
        }
        mMap.clear();
    }

    /** Called when the Reset button is clicked. */
    public void onResetMap(View view) {
        if (!checkReady()) {
            return;
        }
        // Clear the map because we don't want duplicates of the markers.
        mMap.clear();
        addMarkersToMap();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
        if (!checkReady()) {
            return;
        }
        float rotation = seekBar.getProgress();
        for (Marker marker : mMarkerRainbow) {
            marker.setRotation(rotation);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Do nothing.
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Do nothing.
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
        if(marker.getTitle().equals("Swedish Physicians")) {
        	index = 0;
        } else if(marker.getTitle().equals("Swedish Medical Center")) {
        	index = 1;
        } else if(marker.getTitle().equals("University of Washington Medical Center")) {
        	index = 2;
        } else if(marker.getTitle().equals("ZOOM Care Wallingford")) {
        	index = 3;
        } else if(marker.getTitle().equals("Women's Health Care Center")) {
        	index = 4;
        }
        bundle.putInt("ARRAY_INDEX", index);
        intent.putExtras(bundle);
        intent.setClass(getActivity(), HospitalDetailActivity.class);
        getActivity().startActivity(intent);
    }

}
