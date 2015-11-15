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
	private int ratingStar;
	
	public HospitalListInfo(String hospitalName, String link, int review, double distance, String address, int price, int time, int ratingStar) {
		this.hospitalName = hospitalName;
		this.link = link;
		this.review = review;
		this.distance = distance;
		this.address = address;
		this.price = price;
		this.time = time;
		this.ratingStar = ratingStar;
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

	public int getRatingStar() {
		return ratingStar;
	}
}