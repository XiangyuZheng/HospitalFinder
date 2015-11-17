package hachthon.hospitalfinder;

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

	private List<HospitalListInfo> hospitalList;
    private ListView listView;

    public HospitalListFragment (List<HospitalListInfo> hospitalList) {
    	this.hospitalList = hospitalList;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);
        
        final Button priceSort = (Button) view.findViewById(R.id.priceSort);
        final Button distanceSort = (Button) view.findViewById(R.id.distanceSort);
        final Button ratingSort = (Button) view.findViewById(R.id.ratingSort);

        priceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#000000"));
            	distanceSort.setTextColor(Color.parseColor("#979797"));
            	ratingSort.setTextColor(Color.parseColor("#979797"));
            }
        });

        distanceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#979797"));
            	distanceSort.setTextColor(Color.parseColor("#000000"));
            	ratingSort.setTextColor(Color.parseColor("#979797"));
            }
        });

        ratingSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	priceSort.setTextColor(Color.parseColor("#979797"));
            	distanceSort.setTextColor(Color.parseColor("#979797"));
            	ratingSort.setTextColor(Color.parseColor("#000000"));
            }
        });

        listView = (ListView) view.findViewById(R.id.listView);
//        listView.setAdapter(new CustomAdapter(getActivity(), list));
        return view;

    }

}