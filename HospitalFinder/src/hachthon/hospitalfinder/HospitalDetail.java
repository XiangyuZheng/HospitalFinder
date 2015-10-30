package hachthon.hospitalfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HospitalDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospitaldetail);
		TextView website = (TextView) findViewById(R.id.website);
		website.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		ImageView imageLocation = (ImageView) findViewById(R.id.imageLocation);
		ImageView imageFilter = (ImageView) findViewById(R.id.imageFilter);
		ImageView imageList = (ImageView) findViewById(R.id.imageList);
		ImageView imageWhat = (ImageView) findViewById(R.id.imageWhat);
		imageLocation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HospitalDetail.this, MainActivity.class);
				finish();
				startActivity(intent);
			}
		});
		imageFilter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HospitalDetail.this, Filter.class);
				finish();
				startActivity(intent);
			}
		});
		imageList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HospitalDetail.this, List.class);
				finish();
				startActivity(intent);
			}
		});
		imageWhat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(HospitalDetail.this, HospitalDetail.class);
				finish();
				startActivity(intent);
			}
		});

	}
}
