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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity implements
        SearchView.OnQueryTextListener {

    // TODO: Replace the tab names and icons with the real ones
    private static final String[] CONTENT = new String[] { "Calendar",
            "Camera", "Alarms", "Location" };

    private static final int[] ICONS = new int[] {
            R.drawable.perm_group_calendar, R.drawable.perm_group_camera,
            R.drawable.perm_group_device_alarms,
            R.drawable.perm_group_location, };

    // Some fake data for hospitals
    private final String[] hospitals = { "Swedish Physicians",
            "University of Washington Medical Center",
            "Swedish Medical Center", "Women's Health Care Center",
            "ZOOM Care Wallingford" };

    private SearchView searchView;
    private ListView listView;
    private ArrayAdapter<String> listAdapter;

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

        // inits page indicator
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setTabIconLocation(TabPageIndicator.ICON_ONLY);
        indicator.setViewPager(pager);

        // inits action bar
        ActionBar actionBar = getActionBar();
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);
        actionBar.setCustomView(v);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // inits search view
        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search for hospitals and clinics");

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
            if (position == 0) {
                return new GoogleMapFragment();
            }
            return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
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
}