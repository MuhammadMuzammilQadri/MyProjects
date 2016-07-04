package com.example.android.tourgide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourgide.Model.DataHandler;
import com.example.android.tourgide.Model.Park;
import com.example.android.tourgide.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by panacloud on 04/07/16.
 */
public class ParkGridViewAdapter extends BaseAdapter {
    private ArrayList<Park> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public ParkGridViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mItems = DataHandler.getInstance(context).getParks();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Park getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.park_grid_item, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        int randomHeight = (new Random().nextInt(250))+500;
        ((ViewGroup)convertView).setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,randomHeight) );

        Park park = getItem(i);

        viewHolder.imageView.setImageDrawable(park.getImageOfPark());
        viewHolder.title.setText(park.getName());
        viewHolder.address.setText(park.getAddress());

        return convertView;

    }

    class ViewHolder {
        ImageView imageView;
        TextView title;
        TextView address;

        ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.picture);
            title = (TextView) view.findViewById(R.id.title);
            address = (TextView) view.findViewById(R.id.address);
        }
    }
}