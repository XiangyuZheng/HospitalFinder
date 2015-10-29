package hachthon.hospitalfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class HospitalDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setText("Hospital Detail Fragment");
        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        text.setPadding(20, 20, 20, 0);
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(text);
        return layout;
    }

}
