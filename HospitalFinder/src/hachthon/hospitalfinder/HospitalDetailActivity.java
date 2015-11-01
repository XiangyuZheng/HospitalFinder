
package hachthon.hospitalfinder;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HospitalDetailActivity extends FragmentActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitaldetail);

        ImageView hospitalImage = (ImageView) findViewById(R.id.hospitalImage);
        // HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

        TextView hospitalName = (TextView) findViewById(R.id.hospitalName);
        // hospitalName.setText(nameHospital);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        // ratingBar.setRating(ratingNumber);

        TextView reviewNum = (TextView) findViewById(R.id.reviewNumber);
        // reviewNum.setText(reviewNumber + " Reviews");

        TextView distance = (TextView) findViewById(R.id.distance);
        // distance.setText(distanceNumber + " mi");

        TextView phoneNum = (TextView) findViewById(R.id.phoneNumber);
        phoneNum.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_call,
                0, 0, 0);
        // phoneNum.setText(phoneNumber);

        TextView addr = (TextView) findViewById(R.id.address);
        addr.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_directions, 0, 0, 0);
        // addr.setText(address);

        TextView openhours = (TextView) findViewById(R.id.openhours);
        openhours.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_my_calendar,
                0, 0, 0);
        // openhours.setText(openHours);

        TextView website = (TextView) findViewById(R.id.website);
        website.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_info_details,
                0, 0, 0);
        // website.setText(websiteInfo);

        TextView review = (TextView) findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // WHAT DOES REVIEW DO???
            }
        });

        TextView bookmark = (TextView) findViewById(R.id.bookmark);
        bookmark.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // WHAT DOES bookmark DO???
            }
        });

        TextView appointment = (TextView) findViewById(R.id.appointment);
        appointment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // WHAT DOES appointment DO???
            }
        });

        ImageView featureImage1 = (ImageView) findViewById(R.id.featureImage1);
        // HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

        TextView featureName1 = (TextView) findViewById(R.id.feature1);
        // featureName1.setText(feature1);

        TextView featureContent1 = (TextView) findViewById(R.id.featureContent1);
        // featureContent1.setText(contentFeature1);

        ImageView specialtyImage1 = (ImageView) findViewById(R.id.specialtyImage1);
        // HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

        TextView special1 = (TextView) findViewById(R.id.specialty1);
        // special1.setText(specialty1);

        ImageView specialtyImage2 = (ImageView) findViewById(R.id.specialtyImage2);
        // HOW DO I BRING THE IMAGE FILE FROM THE WEB LINK????

        TextView special2 = (TextView) findViewById(R.id.specialty2);
        // special2.setText(specialty2);

        ImageView reviewIcon1 = (ImageView) findViewById(R.id.reviewIcon1);
        // CHOOSE BETWEEN HAPPY OR SAD ICON

        TextView reviewContent1 = (TextView) findViewById(R.id.reviewContent1);
        // reviewContent1.setText(review1);

        ImageView reviewIcon2 = (ImageView) findViewById(R.id.reviewIcon2);
        // CHOOSE BETWEEN HAPPY OR SAD ICON

        TextView reviewContent2 = (TextView) findViewById(R.id.reviewContent2);
        // reviewContent2.setText(review2);
    }
}
