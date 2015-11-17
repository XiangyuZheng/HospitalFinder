package hachthon.hospitalfinder;

import java.io.InputStream;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.Toast;

public class HospitalListInfo {

	private String hospitalName;
	private int review;
	private double distance;
	private String address;
	private int price;
	private int time;
	private String link;
	private String phoneNumber;
	private String openHours;
	private String feature;
	private String featureDetail;
	private String specialty1;
	private String specialty2;
	private String review1;
	private String review2;

	public HospitalListInfo(String hospitalName, String link, int review, double distance, String address, int price, int time, String phoneNumber, String openHours
								, String feature, String featureDetail, String specialty1, String specialty2, String review1, String review2) {
		this.hospitalName = hospitalName;
		this.link = link;
		this.review = review;
		this.distance = distance;
		this.address = address;
		this.price = price;
		this.time = time;
		this.phoneNumber = phoneNumber;
		this.openHours = openHours;
		this.feature = feature;
		this.featureDetail = featureDetail;
		this.specialty1 = specialty1;
		this.specialty2 = specialty2;
		this.review1 = review1;
		this.review2 = review2;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getImage() {
		return link;
	}

	public int getReview() {
		return review;
	}

	public double getDistance() {
		return distance;
	}

	public String getAddress() {
		return address;
	}

	public int getPrice() {
		return price;
	}

	public int getTime() {
		return time;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getOpenHours() {
		return openHours;
	}
	
	public String getFeature() {
		return feature;
	}
	
	public String getFeatureDetail() {
		return featureDetail;
	}
	
	public String getSpecialty1() {
		return specialty1;
	}
	
	public String getSpecialty2() {
		return specialty2;
	}
	
	public String getReview1() {
		return review1;
	}
	
	public String getReview2() {
		return review2;
	}
}