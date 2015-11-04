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
	private HospitalListInfo[] list;

	public CustomAdapter(Activity context, HospitalListInfo[] list) {
		//  EEE RRR RRR OOO RRR ???
		super(context, R.layout.custom_listview, 0);
		// TODO Auto-generated constructor stub

		this.context = context;
		this.list = list;
	}

	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.custom_listview, null, true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
		RatingBar ratingBar = (RatingBar) rowView.findViewById(R.id.ratingBar1);
		TextView review = (TextView) rowView.findViewById(R.id.rating);
		TextView distance = (TextView) rowView.findViewById(R.id.distance);
		TextView address = (TextView) rowView.findViewById(R.id.address);
		TextView price = (TextView) rowView.findViewById(R.id.price);
		TextView time = (TextView) rowView.findViewById(R.id.time);

		txtTitle.setText(list[position].getHospitalName());
		imageView.setImageDrawable(list[position].getImage());
		ratingBar.setTag(new Integer(position));
		review.setText(list[position].getReview() + " Reviews");
		distance.setText(list[position].getDistance() + "mi");
		address.setText(list[position].getAddress());
		price.setText("$" + list[position].getPrice());
		time.setText("/ " + list[position].getTime() + "min");
		return rowView;
	};
}
