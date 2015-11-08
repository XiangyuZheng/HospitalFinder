package hachthon.hospitalfinder;

import java.io.InputStream;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

		viewHolder = new ViewHolderItem();
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.custom_listview, null, true);

		viewHolder.textView = (TextView) rowView.findViewById(R.id.hospitalName);
		viewHolder.ratingBar = (RatingBar) rowView.findViewById(R.id.ratingBar1);
		viewHolder.review = (TextView) rowView.findViewById(R.id.rating);
		viewHolder.distance = (TextView) rowView.findViewById(R.id.distance);
		viewHolder.address = (TextView) rowView.findViewById(R.id.address);
		viewHolder.price = (TextView) rowView.findViewById(R.id.price);
		viewHolder.time = (TextView) rowView.findViewById(R.id.time);
		viewHolder.textView.setText(list[position].getHospitalName());
		new LoadImage().execute(list[position].getImage());
		viewHolder.ratingBar.setTag(new Integer(position));
		viewHolder.review.setText(list[position].getReview() + " Reviews");
		viewHolder.distance.setText(list[position].getDistance() + "mi");
		viewHolder.address.setText(list[position].getAddress());
		viewHolder.price.setText("$" + list[position].getPrice());
		viewHolder.time.setText(list[position].getTime() + "min");
		return rowView;
	};

	private class LoadImage extends AsyncTask<String, String, Bitmap> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(context); //////////////////////////
			pDialog.setMessage("Loading Image ....");
			pDialog.show();
		}

		protected Bitmap doInBackground(String... args) {
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}
	}

	protected void onPostExecute(Bitmap image) {
		if (image != null) {
			viewHolder = new ViewHolderItem();
			LayoutInflater inflater = context.getLayoutInflater();
			View rowView = inflater.inflate(R.layout.custom_listview, null, true);
			viewHolder.imageView = (ImageView) rowView.findViewById(R.id.imageView1);
			viewHolder.imageView.setImageBitmap(image);
			pDialog.dismiss();
		} else {
			pDialog.dismiss();
//			Toast.makeText(context, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
		}
	}
}