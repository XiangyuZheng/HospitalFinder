
package hachthon.hospitalfinder;

import java.util.ArrayList;
import java.util.List;

import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends FragmentActivity implements
        SearchView.OnQueryTextListener, OnPageChangeListener {

    private static final String TAG = "MainActivity";

    // TODO: Replace the tab names and icons with the real ones
    private static final String[] CONTENT = new String[] {
            "Map", "Filter",
            "List", "Emergency"
    };

    private static final int[] ICONS = new int[] {
            R.drawable.btn_map,
            R.drawable.btn_filter, R.drawable.btn_bookmark,
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
    
    private static List<HospitalListInfo> hospitalList;
    
    
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
        
        // initializes ArrayList of hospital details
        hospitalList = new ArrayList<HospitalListInfo>();
        hospitalList.add(new HospitalListInfo("Seattle Children's Hospital", 
        		"http://www.kinzer.com/wp-content/uploads/2014/12/Seattle_childrens-logo.png", 65, 1.6, 
        		"4800 Sand Pt way NE, Seattle, WA 98105", 40, 20, "(206)000-000", "Mon-Fri8:00am-4:30pm", "Operation Smile", 
        		"Free surgery for all children born with a cleft lip or cleft palate", "Eye Care", "Neurosciences", 
        		"Told me to go to the VA for help with a small issue. I just needed some antibiotics and I was paying cash? Thanks a lot for making me"
        		+ "4 hours just to tell me that I must go to the VA", 
        		"Love these docs who care to make me better. My pain doctor who is an anesthesiologist figured out what my issue was and is aggresively"
        		+ " fixing it"));
        hospitalList.add(new HospitalListInfo("Harborview Medical Center", "https://upload.wikimedia.org/wikipedia/en/8/88/HarborviewMC_Logo.png", 
        		21, 2.7, "325 9th Ave, Seattle, WA 98104", 60, 30, "(206)000-000", "Mon-Fri8:00am-4:30pm", "Operation Smile", 
        		"Free surgery for all children born with a cleft lip or cleft palate", "Eye Care", "Neurosciences", 
        		"Told me to go to the VA for help with a small issue. I just needed some antibiotics and I was paying cash? Thanks a lot for making me"
        		+ "4 hours just to tell me that I must go to the VA", 
        		"Love these docs who care to make me better. My pain doctor who is an anesthesiologist figured out what my issue was and is aggresively"
        		+ " fixing it"));
        hospitalList.add(new HospitalListInfo("Kindred Hospital Seattle - Northgate", "http://www.kindredhospitalseattle.com/uploadedImages/_Global_Content"
        		+ "/Facilities_-_Hospital/Patients_and_Families/Articles/KH_ClearLake_FrontExt2_300.jpg",
        		36, 3.5, "10631 8th Ave NE, Seattle, WA 98125", 35, 30, "(206)000-000", "Mon-Fri8:00am-4:30pm", "Operation Smile", 
        		"Free surgery for all children born with a cleft lip or cleft palate", "Eye Care", "Neurosciences", 
        		"Told me to go to the VA for help with a small issue. I just needed some antibiotics and I was paying cash? Thanks a lot for making me"
        		+ "4 hours just to tell me that I must go to the VA", 
        		"Love these docs who care to make me better. My pain doctor who is an anesthesiologist figured out what my issue was and is aggresively"
        		+ " fixing it"));
        hospitalList.add(new HospitalListInfo("Northwest Hospital Midwives Clinic", "http://www.nwmidwivesclinic.com/midwives/images/hp_photo_1.jpg", 12, 3.6, 
        		"10330 Meridian Ave NS 190, Seattle, WA 98133", 80, 40, "(206)000-000", "Mon-Fri8:00am-4:30pm", "Operation Smile", 
        		"Free surgery for all children born with a cleft lip or cleft palate", "Eye Care", "Neurosciences", 
        		"Told me to go to the VA for help with a small issue. I just needed some antibiotics and I was paying cash? Thanks a lot for making me"
        		+ "4 hours just to tell me that I must go to the VA", 
        		"Love these docs who care to make me better. My pain doctor who is an anesthesiologist figured out what my issue was and is aggresively"
        		+ " fixing it"));
        hospitalList.add(new HospitalListInfo("UW Medical Center at Roosevelt", "http://www.uwmedicine.org/locations/pediatric-care-center-uwmc-roosevelt/PublishingImages/splash3.jpg", 
        		42, 6.2, "4245 Roosevelt Way NE, Seattle, WA 98105", 100, 45, "(206)000-000", "Mon-Fri8:00am-4:30pm", "Operation Smile", 
        		"Free surgery for all children born with a cleft lip or cleft palate", "Eye Care", "Neurosciences", 
        		"Told me to go to the VA for help with a small issue. I just needed some antibiotics and I was paying cash? Thanks a lot for making me"
        		+ "4 hours just to tell me that I must go to the VA", 
        		"Love these docs who care to make me better. My pain doctor who is an anesthesiologist figured out what my issue was and is aggresively"
        		+ " fixing it"));
        

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
                    return new GoogleMapFragment(hospitalList);
                case 1:
                    return new FilterFragment();
                case 2:
                    return new HospitalListFragment(hospitalList);
                case 3:
                    return new HospitalListFragment(hospitalList);
                default:
                    return new GoogleMapFragment(hospitalList);
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
    
    public static List<HospitalListInfo> getHospitalList() {
    	return hospitalList;
    }
}