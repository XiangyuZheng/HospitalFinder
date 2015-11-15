
package hachthon.hospitalfinder;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import hachthon.hospitalfinder.custom.SeekbarWithIntervals;

public class FilterFragment extends Fragment {

    private SeekbarWithIntervals seekbarFee;
    private SeekbarWithIntervals seekbarDistance;
    private SeekbarWithIntervals seekbarRating;

    protected int fee;
    protected int distance;
    protected int rating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter, container, false);

        // for seek bars
        seekbarFee = (SeekbarWithIntervals) view.findViewById(R.id.seekbarFee);
        seekbarFee.setIntervals(getFeeIntervals());
        seekbarDistance = (SeekbarWithIntervals) view.findViewById(R.id.seekbarDistance);
        seekbarDistance.setIntervals(getDistanceIntervals());
        seekbarRating = (SeekbarWithIntervals) view.findViewById(R.id.seekbarRating);
        seekbarRating.setIntervals(getRatingIntervals());

        Switch switchBtnOpen = (Switch) view.findViewById(R.id.switch_OpenNow);
        switchBtnOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // IF OPEN NOW BUTTON IS ON...
                } else { // IF OPEN NOW BUTTON IS OFF...

                }
            }
        });

        // Feature program buttons
        Button obamaCare = (Button) view.findViewById(R.id.obamaCare);
        Button lowIncome = (Button) view.findViewById(R.id.lowIncome);
        Button charityProgram = (Button) view.findViewById(R.id.charityProgram);
        Button AAAProgram = (Button) view.findViewById(R.id.AAAProgram);
        Button BBBProgram = (Button) view.findViewById(R.id.BBBProgram);
        Button CCCProgram = (Button) view.findViewById(R.id.CCCProgram);
        Button DDDProgram = (Button) view.findViewById(R.id.DDDProgram);
        Button EEEProgram = (Button) view.findViewById(R.id.EEEProgram);
        Button FFFProgram = (Button) view.findViewById(R.id.FFFProgram);

        obamaCare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        lowIncome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        charityProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        AAAProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        BBBProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        CCCProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        DDDProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        EEEProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        FFFProgram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // DO SOMETHING
            }
        });
        return view;
    }

    private ArrayList<String> getFeeIntervals() {
        return new ArrayList<String>() {
            private static final long serialVersionUID = 1L;
            {
                add("0");
                add("50");
                add("100");
                add("150");
                add("200");
                add("250");
                add("No Limit");
            }
        };
    }
    
    private ArrayList<String> getDistanceIntervals() {
        return new ArrayList<String>() {
            private static final long serialVersionUID = 1L;
            {
                add("0");
                add("5");
                add("10");
                add("15");
                add("20");
                add("25");
                add("No Limit");
            }
        };
    }

    private ArrayList<String> getRatingIntervals() {
        return new ArrayList<String>() {
            private static final long serialVersionUID = 1L;
            {
                add("0");
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
            }
        };
    }
}
