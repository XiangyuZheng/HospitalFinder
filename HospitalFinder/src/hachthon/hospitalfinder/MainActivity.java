
package hachthon.hospitalfinder;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity implements
        SearchView.OnQueryTextListener, OnPageChangeListener {

    private static final String TAG = "MainActivity";

    // TODO: Replace the tab names and icons with the real ones
    private static final String[] CONTENT = new String[] {
            "Map", "Filter",
            "List", "History"
    };

    private static final int[] ICONS = new int[] {
            R.drawable.tab_icon_map,
            R.drawable.tab_icon_filter, R.drawable.tab_icon_list,
            R.drawable.tab_icon_emergency
    };

    // Some fake data for hospitals
    private final String[] hospitals = {
            "Swedish Physicians",
            "University of Washington Medical Center",
            "Swedish Medical Center", "Women's Health Care Center",
            "ZOOM Care Wallingford"
    };

    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private EditText editSearch;
    private ActionBar actionBar;

    @SuppressLint("InflateParams")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // inits view pager
        FragmentPagerAdapter adapter = new TabAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        // inits page indicator
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setTabIconLocation(TabPageIndicator.ICON_ONLY);
        indicator.setViewPager(pager);
        indicator.setOnPageChangeListener(this);

        // inits action bar
        actionBar = getActionBar();
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);
        actionBar.setCustomView(v);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // inits search view
        editSearch = (EditText) findViewById(R.id.search_bar);
        editSearch.addTextChangedListener(new TextWatcher() {
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    listAdapter.getFilter().filter("aaaaaaa");
                } else {
                    listAdapter.getFilter().filter(s.toString());
                }
            }
        });

        // inits list view
        listView = (ListView) findViewById(R.id.list_view);
        listAdapter = new ArrayAdapter<String>(this, R.layout.filter_item,
                hospitals);
        listView.setAdapter(listAdapter);
        listView.setTextFilterEnabled(true);
        listAdapter.getFilter().filter("aaaaaaa");
    }

    class TabAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new GoogleMapFragment();
                case 1:
                    return new FilterFragment();
                case 2:
                    return new HospitalListFragment();
                case 3:
                    return new HospitalListFragment();
                default:
                    return new GoogleMapFragment();
            }
        }

        @Override
        public int getIconResId(int index) {
            return ICONS[index];
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }

    @Override
    public boolean onQueryTextChange(String text) {
        if (TextUtils.isEmpty(text)) {
            listAdapter.getFilter().filter("aaaaaaa");
        } else {
            listAdapter.getFilter().filter(text);
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String arg0) {
        return false;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
//        if (position == 0) {
//            searchView.setVisibility(View.VISIBLE);
//        } else {
//            searchView.setVisibility(View.INVISIBLE);
//        }
    }

}
