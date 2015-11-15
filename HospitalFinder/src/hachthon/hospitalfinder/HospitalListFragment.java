package hachthon.hospitalfinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
public class HospitalListFragment extends Fragment {

	HospitalListInfo a1 = new HospitalListInfo("Seattle Children's Hospital", "http://www.kinzer.com/wp-content/uploads/2014/12/Seattle_childrens-logo.png", 65, 1.6, "4800 Sand Pt way NE, Seattle, WA 98105", 40, 20, 5);
	HospitalListInfo a2 = new HospitalListInfo("Harborview Medical Center", "https://upload.wikimedia.org/wikipedia/en/8/88/HarborviewMC_Logo.png", 21, 1.5, "325 9th Ave, Seattle, WA 98104", 60, 30, 5);
	HospitalListInfo a3 = new HospitalListInfo("Kindred Hospital Seattle - Northgate", "http://www.kindredhospitalseattle.com/uploadedImages/_Global_Content/Facilities_-_Hospital/Patients_and_Families/Articles/KH_ClearLake_FrontExt2_300.jpg", 36, 3.5, "10631 8th Ave NE, Seattle, WA 98125", 35, 30, 5);
	HospitalListInfo a4 = new HospitalListInfo("Northwest Hospital Midwives Clinic", "http://www.nwmidwivesclinic.com/midwives/images/hp_photo_1.jpg", 12, 3.6, "10330 Meridian Ave NS 190, Seattle, WA 98133", 80, 40, 4);
	HospitalListInfo a5 = new HospitalListInfo("UW Medical Center at Roosevelt", "http://www.uwmedicine.org/locations/pediatric-care-center-uwmc-roosevelt/PublishingImages/splash3.jpg", 42, 6.2, "4245 Roosevelt Way NE, Seattle, WA 98105", 100, 45, 3);
	List<HospitalListInfo> listHospital;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list, container, false);
    	listHospital = new ArrayList<HospitalListInfo>();
    	listHospital.add(a1);
    	listHospital.add(a2);
    	listHospital.add(a3);
    	listHospital.add(a4);
    	listHospital.add(a5);
    	
        listView = (ListView) view.findViewById(R.id.listView);    	
        
        final Button priceSort = (Button) view.findViewById(R.id.priceSort);
        final Button distanceSort = (Button) view.findViewById(R.id.distanceSort);
        final Button ratingSort = (Button) view.findViewById(R.id.ratingSort);

        priceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#000000"));
            	distanceSort.setTextColor(Color.parseColor("#979797"));
            	ratingSort.setTextColor(Color.parseColor("#979797"));
            	Collections.sort(listHospital, new Comparator<HospitalListInfo>() {
            		@Override
            		public int compare(HospitalListInfo info1, HospitalListInfo info2) {
            			return Integer.valueOf(info1.getPrice()).compareTo(info2.getPrice());
            		}
            	});
                listView.setAdapter(new CustomAdapter(getActivity(), listHospital.toArray(new HospitalListInfo[listHospital.size()])));            	
            }
        });

        distanceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#979797"));
            	distanceSort.setTextColor(Color.parseColor("#000000"));
            	ratingSort.setTextColor(Color.parseColor("#979797"));
            	Collections.sort(listHospital, new Comparator<HospitalListInfo>() {
            		@Override
            		public int compare(HospitalListInfo info1, HospitalListInfo info2) {
            			return Double.valueOf(info1.getDistance()).compareTo(info2.getDistance());
            		}
            	});
                listView.setAdapter(new CustomAdapter(getActivity(), listHospital.toArray(new HospitalListInfo[listHospital.size()])));
            }
        });

        ratingSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#979797"));
            	distanceSort.setTextColor(Color.parseColor("#979797"));
            	ratingSort.setTextColor(Color.parseColor("#000000"));
            	Collections.sort(listHospital, new Comparator<HospitalListInfo>() {
            		@Override
            		public int compare(HospitalListInfo info1, HospitalListInfo info2) {
            			return -Integer.valueOf(info1.getRatingStar()).compareTo(info2.getRatingStar());
            		}
            	});
                listView.setAdapter(new CustomAdapter(getActivity(), listHospital.toArray(new HospitalListInfo[listHospital.size()])));
            }
        });
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(getActivity(), listHospital.toArray(new HospitalListInfo[listHospital.size()])));

        return view;

    }

}