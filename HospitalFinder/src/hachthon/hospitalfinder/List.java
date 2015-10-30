package hachthon.hospitalfinder;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class List extends Activity {

	ListView lv;
	Context context;

	public static Integer[] image = { R.drawable.seattlechil, R.drawable.harborview, R.drawable.kindred,
			R.drawable.northwest, R.drawable.uwmedical };
	public static String[] hospitalList = { "Seattle Children's Hospital", "Harborview Medical Center",
			"Kindred Hospital Seattle - Northgate", "Northwest Hospital Midwives Clinic",
			"UW Medical Center at Roosevelt" };
	public static Integer[] review = { 65, 21, 36, 12, 42 };
	public static Double[] distance = { 1.6, 2.7, 3.5, 3.6, 6.2 };
	public static String[] address = { "4800 Sand Pt way NE, Seattle, WA 98105", "325 9th Ave, Seattle, WA 98104",
			"10631 8th Ave NE, Seattle, WA 98125", "10330 Meridian Ave NS 190, Seattle, WA 98133",
			"4245 Roosevelt Way NE, Seattle, WA 98105" };
	public static Integer[] price = { 40, 60, 35, 80, 100 };
	public static Integer[] time = { 20, 30, 30, 40, 45 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		context = this;
		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(new CustomAdapter(this, hospitalList, image, review, distance, address, price, time));
		ImageView imageLocation = (ImageView) findViewById(R.id.imageLocation);
		ImageView imageFilter = (ImageView) findViewById(R.id.imageFilter);
		ImageView imageList = (ImageView) findViewById(R.id.imageList);
		ImageView imageWhat = (ImageView) findViewById(R.id.imageWhat);
		imageLocation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(List.this, MainActivity.class);
				finish();
				startActivity(intent);
			}
		});
		imageFilter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(List.this, Filter.class);
				finish();
//				startActivity(intent);
			}
		});
		imageList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(List.this, List.class);
				finish();
				startActivity(intent);
			}
		});
		imageWhat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(List.this, HospitalDetail.class);
				finish();
				startActivity(intent);
			}
		});

	}

}
