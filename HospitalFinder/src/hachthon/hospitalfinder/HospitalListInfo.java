package hachthon.hospitalfinder;

import java.io.InputStream;
import java.net.URL;

import android.graphics.drawable.Drawable;

public class HospitalListInfo {

	private String hospitalName;
	private int review;
	private double distance;
	private String address;
	private int price;
	private int time;
	private Drawable link;
	
	public HospitalListInfo(String hospitalName, String link, int review, double distance, String address, int price, int time) {
		this.hospitalName = hospitalName;
		this.link = LoadImageFromWebOperations(link);
		this.review = review;
		this.distance = distance;
		this.address = address;
		this.price = price;
		this.time = time;
	}

	
	public static Drawable LoadImageFromWebOperations(String url) {
	    try {
	        InputStream is = (InputStream) new URL(url).getContent();
	        Drawable d = Drawable.createFromStream(is, "src name");
	        return d;
	    } catch (Exception e) {
	        return null;
	    }
	}
	
	public String getHospitalName() {
		return hospitalName;
	}

	public Drawable getImage() {
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
}