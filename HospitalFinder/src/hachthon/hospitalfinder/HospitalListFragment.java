package hachthon.hospitalfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import hachthon.hospitalfinder.HospitalListInfo;
public class HospitalListFragment extends Fragment {

	HospitalListInfo a1 = new HospitalListInfo("Seattle Children's Hospital", "http://www.kinzer.com/wp-content/uploads/2014/12/Seattle_childrens-logo.png", 65, 1.6, "4800 Sand Pt way NE, Seattle, WA 98105", 40, 20);
	HospitalListInfo a2 = new HospitalListInfo("Harborview Medical Center", "https://upload.wikimedia.org/wikipedia/en/8/88/HarborviewMC_Logo.png", 21, 2.7, "325 9th Ave, Seattle, WA 98104", 60, 30);
	HospitalListInfo a3 = new HospitalListInfo("Kindred Hospital Seattle - Northgate", "http://www.kindredhospitalseattle.com/uploadedImages/_Global_Content/Facilities_-_Hospital/Patients_and_Families/Articles/KH_ClearLake_FrontExt2_300.jpg", 36, 3.5, "10631 8th Ave NE, Seattle, WA 98125", 35, 30);
	HospitalListInfo a4 = new HospitalListInfo("Northwest Hospital Midwives Clinic", "http://www.nwmidwivesclinic.com/midwives/images/hp_photo_1.jpg", 12, 3.6, "10330 Meridian Ave NS 190, Seattle, WA 98133", 80, 40);
	HospitalListInfo a5 = new HospitalListInfo("UW Medical Center at Roosevelt", "http://www.uwmedicine.org/locations/pediatric-care-center-uwmc-roosevelt/PublishingImages/splash3.jpg", 42, 6.2, "4245 Roosevelt Way NE, Seattle, WA 98105", 100, 45);
	HospitalListInfo[] list = {a1, a2, a3, a4, a5};

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);
        Button priceSort = (Button) view.findViewById(R.id.priceSort);
        priceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Algorithms here
            }
        });

        Button distanceSort = (Button) view.findViewById(R.id.distanceSort);
        distanceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Algorithms here
            }
        });

        Button ratingSort = (Button) view.findViewById(R.id.ratingSort);
        ratingSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Algorithms here
            }
        });

        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(getActivity(), list));
        return view;

    }

}
