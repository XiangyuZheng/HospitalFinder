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

public class HospitalListFragment extends Fragment {

    public static Integer[] image = { R.drawable.seattlechil,
            R.drawable.harborview, R.drawable.kindred, R.drawable.northwest,
            R.drawable.uwmedical };
    public static String[] hospitalList = { "Seattle Children's Hospital",
            "Harborview Medical Center",
            "Kindred Hospital Seattle - Northgate",
            "Northwest Hospital Midwives Clinic",
            "UW Medical Center at Roosevelt" };
    public static Integer[] review = { 65, 21, 36, 12, 42 };
    public static Double[] distance = { 1.6, 2.7, 3.5, 3.6, 6.2 };
    public static String[] address = {
            "4800 Sand Pt way NE, Seattle, WA 98105",
            "325 9th Ave, Seattle, WA 98104",
            "10631 8th Ave NE, Seattle, WA 98125",
            "10330 Meridian Ave NS 190, Seattle, WA 98133",
            "4245 Roosevelt Way NE, Seattle, WA 98105" };
    public static Integer[] price = { 40, 60, 35, 80, 100 };
    public static Integer[] time = { 20, 30, 30, 40, 45 };

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
        listView.setAdapter(new CustomAdapter(getActivity(), hospitalList, image,
                review, distance, address, price, time));
        return view;

    }

}
