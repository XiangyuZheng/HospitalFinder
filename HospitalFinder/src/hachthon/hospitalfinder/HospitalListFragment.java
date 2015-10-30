package hachthon.hospitalfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class HospitalListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list, container, false);
		Button priceSort = (Button) getView().findViewById(R.id.priceSort);
		priceSort.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//Algorithms here
			}
		});
		
		Button distanceSort = (Button) getView().findViewById(R.id.distanceSort);
		distanceSort.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//Algorithms here
			}
		});
		
		Button ratingSort = (Button) getView().findViewById(R.id.ratingSort);
		ratingSort.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				//Algorithms here
			}
		});
				
		return view;

    }

}
