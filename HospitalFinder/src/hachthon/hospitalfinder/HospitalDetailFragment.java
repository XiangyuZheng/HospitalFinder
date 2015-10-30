package hachthon.hospitalfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HospitalDetailFragment extends Fragment {

	protected int ratingNumber;
	protected int reviewNumber;
	protected String nameHospital;
	protected int distanceNumber;
	protected int phoneNumber;
	protected String address;
	protected String openHours;
	protected String websiteInfo;
	protected String feature1;
	protected String contentFeature1;
	protected String specialty1;
	protected String specialty2;
	protected String review1;
	protected String review2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.hospitaldetail, container, false);
		ImageView hospitalImage = (ImageView) getView().findViewById(R.id.hospitalImage);
		// HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

		TextView hospitalName = (TextView) getView().findViewById(R.id.hospitalName);
		hospitalName.setText(nameHospital);

		RatingBar ratingBar = (RatingBar) getView().findViewById(R.id.ratingBar);
		ratingBar.setRating(ratingNumber);

		TextView reviewNum = (TextView) getView().findViewById(R.id.reviewNumber);
		reviewNum.setText(reviewNumber + " Reviews");

		TextView distance = (TextView) getView().findViewById(R.id.distance);
		distance.setText(distanceNumber + " mi");

		TextView phoneNum = (TextView) getView().findViewById(R.id.phoneNumber);
		phoneNum.setText(phoneNumber);

		TextView addr = (TextView) getView().findViewById(R.id.address);
		addr.setText(address);

		TextView openhours = (TextView) getView().findViewById(R.id.openhours);
		openhours.setText(openHours);

		TextView website = (TextView) getView().findViewById(R.id.website);
		website.setText(websiteInfo);

		TextView review = (TextView) getView().findViewById(R.id.review);
		review.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// WHAT DOES REVIEW DO???
			}
		});

		TextView bookmark = (TextView) getView().findViewById(R.id.bookmark);
		bookmark.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// WHAT DOES bookmark DO???
			}
		});

		TextView appointment = (TextView) getView().findViewById(R.id.appointment);
		appointment.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// WHAT DOES appointment DO???
			}
		});

		ImageView featureImage1 = (ImageView) getView().findViewById(R.id.featureImage1);
		// HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

		TextView featureName1 = (TextView) getView().findViewById(R.id.feature1);
		featureName1.setText(feature1);

		TextView featureContent1 = (TextView) getView().findViewById(R.id.featureContent1);
		featureContent1.setText(contentFeature1);

		ImageView specialtyImage1 = (ImageView) getView().findViewById(R.id.specialtyImage1);
		// HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

		TextView special1 = (TextView) getView().findViewById(R.id.specialty1);
		special1.setText(specialty1);

		ImageView specialtyImage2 = (ImageView) getView().findViewById(R.id.specialtyImage2);
		// HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

		TextView special2 = (TextView) getView().findViewById(R.id.specialty2);
		special2.setText(specialty2);

		ImageView reviewIcon1 = (ImageView) getView().findViewById(R.id.reviewIcon1);
		// CHOOSE BETWEEN HAPPY OR SAD ICON

		TextView reviewContent1 = (TextView) getView().findViewById(R.id.reviewContent1);
		reviewContent1.setText(review1);

		ImageView reviewIcon2 = (ImageView) getView().findViewById(R.id.reviewIcon2);
		// CHOOSE BETWEEN HAPPY OR SAD ICON

		TextView reviewContent2 = (TextView) getView().findViewById(R.id.reviewContent2);
		reviewContent2.setText(review2);

		return view;

		/*
		 * TextView text = new TextView(getActivity());
		 * text.setGravity(Gravity.CENTER); text.setText(
		 * "Hospital Detail Fragment"); text.setTextSize(20 *
		 * getResources().getDisplayMetrics().density); text.setPadding(20, 20,
		 * 20, 0); LinearLayout mainLayout = new LinearLayout(getActivity());
		 * mainLayout.setLayoutParams(new
		 * LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		 * mainLayout.setGravity(Gravity.CENTER); mainLayout.addView(text);
		 * return mainLayout;
		 */
	}
}
