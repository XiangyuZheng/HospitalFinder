package hachthon.hospitalfinder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

public class Filter extends Activity {

	protected int fee;
	protected int distance;
	protected int rating;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filter);
		Switch switchBtnOpen = (Switch) findViewById(R.id.switch_OpenNow);
		switchBtnOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {		
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					// IF OPEN NOW BUTTON IS ON...
				} else { //IF OPEN NOW BUTTON IS OFF...
					
				}
			}
		});

		Switch switchBtnFeature = (Switch) findViewById(R.id.switch_Feature);
		switchBtnOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {		
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					// IF OPEN NOW BUTTON IS ON...
				} else { //IF OPEN NOW BUTTON IS OFF...
					
				}
			}
		});

		SeekBar seek1 = (SeekBar) findViewById(R.id.seekBar1);

		// text1 ~ text7 are number displayed on the screen for Consulting fee from 0 to 250 and No Limit.
		final TextView text1 = (TextView) findViewById(R.id.TextView2);
		final TextView text2 = (TextView) findViewById(R.id.TextView3);
		final TextView text3 = (TextView) findViewById(R.id.TextView4);
		final TextView text4 = (TextView) findViewById(R.id.TextView5);
		final TextView text5 = (TextView) findViewById(R.id.TextView6);
		final TextView text6 = (TextView) findViewById(R.id.TextView7);
		final TextView text7 = (TextView) findViewById(R.id.TextView8);
		seek1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				fee = progresValue;
				// Followings make the only specific textview bold 
				if (fee <= 25) {
					text1.setTypeface(null, Typeface.BOLD);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 0;
				} else if (fee > 25 && fee <= 75) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.BOLD);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 50;
				} else if (fee > 75 && fee <= 125) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.BOLD);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 100;
				} else if (fee > 125 && fee <= 175) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.BOLD);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 150;
				} else if (fee > 175 && fee <= 225) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.BOLD);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 200;
				} else if (fee > 225 && fee <= 275) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.BOLD);
					text7.setTypeface(null, Typeface.NORMAL);
					fee = 250;
				} else if (fee > 275 && fee <= 325) {
					text1.setTypeface(null, Typeface.NORMAL);
					text2.setTypeface(null, Typeface.NORMAL);
					text3.setTypeface(null, Typeface.NORMAL);
					text4.setTypeface(null, Typeface.NORMAL);
					text5.setTypeface(null, Typeface.NORMAL);
					text6.setTypeface(null, Typeface.NORMAL);
					text7.setTypeface(null, Typeface.BOLD);
					fee = 300;
				}
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Display the value in textview
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
		});

		// text11 ~ text77 are the numbers displayed on the screen for distance from 0 to 25 and No Limit.
		SeekBar seek2 = (SeekBar) findViewById(R.id.seekBar2);
		final TextView text11 = (TextView) findViewById(R.id.TextView22);
		final TextView text22 = (TextView) findViewById(R.id.TextView33);
		final TextView text33 = (TextView) findViewById(R.id.TextView44);
		final TextView text44 = (TextView) findViewById(R.id.TextView55);
		final TextView text55 = (TextView) findViewById(R.id.TextView66);
		final TextView text66 = (TextView) findViewById(R.id.TextView77);
		final TextView text77 = (TextView) findViewById(R.id.TextView88);
		seek2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				distance = progresValue;
				if (distance <= 25) {
					text11.setTypeface(null, Typeface.BOLD);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 0;
				} else if (distance > 25 && distance <= 75) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.BOLD);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 5;
				} else if (distance > 75 && distance <= 125) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.BOLD);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 10;
				} else if (distance > 125 && distance <= 175) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.BOLD);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 15;
				} else if (distance > 175 && distance <= 225) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.BOLD);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 20;
				} else if (distance > 225 && distance <= 275) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.BOLD);
					text77.setTypeface(null, Typeface.NORMAL);
					distance = 25;
				} else if (distance > 275 && distance <= 325) {
					text11.setTypeface(null, Typeface.NORMAL);
					text22.setTypeface(null, Typeface.NORMAL);
					text33.setTypeface(null, Typeface.NORMAL);
					text44.setTypeface(null, Typeface.NORMAL);
					text55.setTypeface(null, Typeface.NORMAL);
					text66.setTypeface(null, Typeface.NORMAL);
					text77.setTypeface(null, Typeface.BOLD);
					distance = 30;
				}
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Display the value in textview
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
		});

		// text111 ~ text555 are the numbers displayed for Rating from 0 to 4
		SeekBar seek3 = (SeekBar) findViewById(R.id.seekBar3);
		final TextView text111 = (TextView) findViewById(R.id.TextView222);
		final TextView text222 = (TextView) findViewById(R.id.TextView333);
		final TextView text333 = (TextView) findViewById(R.id.TextView444);
		final TextView text444 = (TextView) findViewById(R.id.TextView555);
		final TextView text555 = (TextView) findViewById(R.id.TextView666);
		seek3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				rating = progresValue;
				if (rating <= 35) {
					text111.setTypeface(null, Typeface.BOLD);
					text222.setTypeface(null, Typeface.NORMAL);
					text333.setTypeface(null, Typeface.NORMAL);
					text444.setTypeface(null, Typeface.NORMAL);
					text555.setTypeface(null, Typeface.NORMAL);
					rating = 0;
				} else if (rating > 35 && rating <= 115) {
					text111.setTypeface(null, Typeface.NORMAL);
					text222.setTypeface(null, Typeface.BOLD);
					text333.setTypeface(null, Typeface.NORMAL);
					text444.setTypeface(null, Typeface.NORMAL);
					text555.setTypeface(null, Typeface.NORMAL);
					rating = 1;
				} else if (rating > 115 && rating <= 190) {
					text111.setTypeface(null, Typeface.NORMAL);
					text222.setTypeface(null, Typeface.NORMAL);
					text333.setTypeface(null, Typeface.BOLD);
					text444.setTypeface(null, Typeface.NORMAL);
					text555.setTypeface(null, Typeface.NORMAL);
					rating = 2;
				} else if (rating > 190 && rating <= 265) {
					text111.setTypeface(null, Typeface.NORMAL);
					text222.setTypeface(null, Typeface.NORMAL);
					text333.setTypeface(null, Typeface.NORMAL);
					text444.setTypeface(null, Typeface.BOLD);
					text555.setTypeface(null, Typeface.NORMAL);
					rating = 3;
				} else if (rating > 265 && rating <= 300) {
					text111.setTypeface(null, Typeface.NORMAL);
					text222.setTypeface(null, Typeface.NORMAL);
					text333.setTypeface(null, Typeface.NORMAL);
					text444.setTypeface(null, Typeface.NORMAL);
					text555.setTypeface(null, Typeface.BOLD);					
					rating = 4;
				}
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Display the value in textview
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
		});

		// Feature program buttons
		Button obamaCare = (Button) findViewById(R.id.obamaCare);
		Button lowIncome = (Button) findViewById(R.id.lowIncome);
		Button charityProgram = (Button) findViewById(R.id.charityProgram);
		Button AAAProgram = (Button) findViewById(R.id.AAAProgram);
		Button BBBProgram = (Button) findViewById(R.id.BBBProgram);
		Button CCCProgram = (Button) findViewById(R.id.CCCProgram);
		Button DDDProgram = (Button) findViewById(R.id.DDDProgram);
		Button EEEProgram = (Button) findViewById(R.id.EEEProgram);
		Button FFFProgram = (Button) findViewById(R.id.FFFProgram);

		obamaCare.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		lowIncome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		charityProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		AAAProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		BBBProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		CCCProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		DDDProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		EEEProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});
		FFFProgram.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//DO SOMETHING
			}
		});

		
		// Below navigate buttons
		ImageView imageLocation = (ImageView) findViewById(R.id.imageLocation);
		ImageView imageFilter = (ImageView) findViewById(R.id.imageFilter);
		ImageView imageList = (ImageView) findViewById(R.id.imageList);
		ImageView imageWhat = (ImageView) findViewById(R.id.imageWhat);
		imageLocation.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Filter.this, MainActivity.class);
				finish();
				startActivity(intent);
			}
		});
		imageFilter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(Filter.this, Filter.class);
				finish();
				startActivity(intent);
			}
		});
		imageList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent =new Intent(Filter.this, List.class);
				finish();
				startActivity(intent);
			}
		});
		imageWhat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Filter.this, HospitalDetail.class);
				finish();
				startActivity(intent);
			}
		});

	}

}
