
package hachthon.hospitalfinder;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Switch;
import hachthon.hospitalfinder.custom.SeekbarWithIntervals;

public class FilterFragment extends Fragment {

    private SeekbarWithIntervals seekbarFee;
    private SeekbarWithIntervals seekbarDistance;
    private SeekbarWithIntervals seekbarRating;
    private GridView gridView;
    private ButtonAdapter buttonAdapter;

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

        gridView = (GridView) view.findViewById(R.id.gridview);
        buttonAdapter = new ButtonAdapter(getActivity());
        gridView.setAdapter(buttonAdapter);
        
        Switch switchFeature = (Switch) view.findViewById(R.id.switch_Feature);
        switchFeature.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonAdapter.setAllButtonsPressed(isChecked);
                buttonAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    public class ButtonAdapter extends BaseAdapter {
        private Integer[] mStringIds = {
                R.string.obama_care, R.string.low_income,
                R.string.charity_program, R.string.AAA_program,
                R.string.BBB_program, R.string.CCC_program,
                R.string.DDD_program, R.string.EEE_program,
                R.string.FFF_program
        };
        
        public boolean[] mSelected = {
                false, false, false, false, false, false, false, false, false
        };
        
        private Context mContext;

        public ButtonAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mStringIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public void setAllButtonsPressed (boolean pressed) {
            for (int i = 0; i < mSelected.length; i++) {
                mSelected[i] = pressed;
            }
        }
        
        // create a new ImageView for each item referenced by the Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            Button buttonItem;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                buttonItem = new Button(mContext);
                buttonItem.setLayoutParams(new GridView.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT));
                buttonItem.setTextSize(12f);
                buttonItem.setClickable(false);
            } else {
                buttonItem = (Button) convertView;
            }
            buttonItem.setText(getResources().getString(mStringIds[position]));
            buttonItem.setAlpha(mSelected[position] ? 1.0f : 0.5f);
            buttonItem.setOnTouchListener(new OnTouchListener() {
                
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        mSelected[position] = !mSelected[position];
                        notifyDataSetChanged();
                    }
                    return true;
                }
            });
            return buttonItem;
        }

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
