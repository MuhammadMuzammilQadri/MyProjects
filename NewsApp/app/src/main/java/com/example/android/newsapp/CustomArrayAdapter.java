package com.example.android.newsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.model.Results;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class CustomArrayAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Context context;
    private ArrayList<Results> results = null;

    public CustomArrayAdapter(AppCompatActivity context, ArrayList<Results> results) {
        this.context = context;
//        this.results = items;
        this.results = results;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Results getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.setUpText(getItem(position));
        loadImage(getItem(position), getItem(position).getFields().getThumbnail(), viewHolder);

        return convertView;
    }

    private void loadImage(Results results, String thumbnail, ViewHolder holder) {
        if (thumbnail != null && !thumbnail.trim().equals("")) {

            String url = thumbnail;
            new ImageDownloaderAsyncTask(holder.imageView, results, this).execute(url);

        } else if (results.getImage() != null) {
            holder.imageView.setImageBitmap(results.getImage());

        } else {
            holder.imageView.setImageResource(android.R.drawable.stat_sys_warning);
        }
    }

    class ViewHolder {
        TextView title;
        TextView author;
        ImageView imageView;

        ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
            imageView = (ImageView) view.findViewById(R.id.imageview);
        }

        void setUpText(Results results) {
            title.setText(results.getWebTitle());
            author.setText(results.getSectionName());
            if (results.getImage() != null)
                imageView.setImageBitmap(results.getImage());
            else
                imageView.setImageResource(android.R.drawable.stat_sys_warning);
        }
    }

}

