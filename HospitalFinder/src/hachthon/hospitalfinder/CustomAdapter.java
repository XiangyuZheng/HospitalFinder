package hachthon.hospitalfinder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
 
	private final Activity context;
	private final String[] itemname;
	private final Integer[] imgid;
	private final Integer[] review;
	private final Double[] distance;
	private final String[] address;
	private final Integer[] price;
	private final Integer[] time;
	
	
	public CustomAdapter(Activity context, String[] itemname, Integer[] imgid, Integer[] review, Double[] distance, String[] address, Integer[] price, Integer[] time) {
		super(context, R.layout.custom_listview, itemname);
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.itemname=itemname;
		this.imgid=imgid;
		this.review=review;
		this.distance=distance;
		this.address=address;
		this.price=price;
		this.time=time;
	}
	
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.custom_listview, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
		RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.ratingBar1);
		TextView review = (TextView) rowView.findViewById(R.id.rating);
		TextView distance = (TextView) rowView.findViewById(R.id.distance);
		TextView address = (TextView) rowView.findViewById(R.id.address);
		TextView price = (TextView) rowView.findViewById(R.id.price);
		TextView time = (TextView) rowView.findViewById(R.id.time);
		
		txtTitle.setText(itemname[position]);
		imageView.setImageResource(imgid[position]);
		ratingBar.setTag(new Integer(position));
		review.setText(this.review[position] + " Reviews");
		distance.setText(this.distance[position] + "mi");
		address.setText(this.address[position]);
		price.setText("$" + this.price[position]);
		time.setText("/ " +this.time[position] + "min");

		return rowView;
		
	};
}