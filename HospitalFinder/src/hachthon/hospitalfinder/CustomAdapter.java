package hachthon.hospitalfinder;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<HospitalListInfo> {

	static class ViewHolderItem {
		TextView textView;
		ImageView imageView;
		RatingBar ratingBar;
		TextView review;
		TextView distance;
		TextView address;
		TextView price;
		TextView time;
	}

	private final Activity context;
	private HospitalListInfo[] list;
	ImageView img;
	Bitmap bitmap;
	ProgressDialog pDialog;
	ViewHolderItem viewHolder;

	public CustomAdapter(Activity context, HospitalListInfo[] list) {
		super(context, R.layout.custom_listview, list);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.list = list;
	}

	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			viewHolder = new ViewHolderItem();
			LayoutInflater inflater = context.getLayoutInflater();
			view = inflater.inflate(R.layout.custom_listview, null, true);
			viewHolder.textView = (TextView) view.findViewById(R.id.hospitalName);
			viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView1);
			viewHolder.ratingBar = (RatingBar) view.findViewById(R.id.ratingBar1);
			viewHolder.review = (TextView) view.findViewById(R.id.rating);
			viewHolder.distance = (TextView) view.findViewById(R.id.distance);
			viewHolder.address = (TextView) view.findViewById(R.id.address);
			viewHolder.price = (TextView) view.findViewById(R.id.price);
			viewHolder.time = (TextView) view.findViewById(R.id.time);
			viewHolder.textView.setText(list[position].getHospitalName());
			Picasso.with(context).load(list[position].getImage()).into(viewHolder.imageView);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderItem) view.getTag();
		}
		viewHolder.ratingBar.setNumStars(list[position].getRatingStar());
		viewHolder.review.setText(list[position].getReview() + " Reviews");
		viewHolder.distance.setText(list[position].getDistance() + "mi");
		viewHolder.address.setText(list[position].getAddress());
		viewHolder.price.setText("$" + list[position].getPrice());
		viewHolder.time.setText(list[position].getTime() + "min");
		return view;
	}
}