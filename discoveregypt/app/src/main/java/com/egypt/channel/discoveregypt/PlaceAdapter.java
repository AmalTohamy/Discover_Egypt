package com.egypt.channel.discoveregypt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shohayeb on 12/01/2018.
 */

public class PlaceAdapter extends ArrayAdapter<SpinnerItem> {
    private int mycount;

    public PlaceAdapter(@NonNull Context context, @NonNull List<SpinnerItem> objects) {
        super(context, 0, objects);
        mycount = objects.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);

    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();


        SpinnerItem spinnerItem = getItem(position);


        if (position == mycount - 1) {
            viewHolder.view.setVisibility(View.INVISIBLE);

        } else {
            viewHolder.view.setVisibility(View.VISIBLE);
        }
        Bitmap drawable = decodeSampledBitmapFromResource(getContext().getResources(), spinnerItem.getImageResource(), 80, 80);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(drawable);
        viewHolder.imageView.setImageDrawable(bitmapDrawable);
        viewHolder.name.setText(spinnerItem.getName());
        viewHolder.shortLocation.setText(spinnerItem.getShortLocation());

        return convertView;

    }


    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    class ViewHolder {
        ImageView imageView;
        TextView name;
        TextView shortLocation;
        View view;

        ViewHolder(View convertView) {
            this.imageView = convertView.findViewById(R.id.spinner_historical_place_image);
            this.name = convertView.findViewById(R.id.spinner_historical_place_name);
            this.shortLocation = convertView.findViewById(R.id.spinner_historical_place_short_location);
            this.view = convertView.findViewById(R.id.view);
        }
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
