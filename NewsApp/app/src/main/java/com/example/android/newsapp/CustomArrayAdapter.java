package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.model.DataHandler;
import com.example.android.newsapp.model.Entries;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class CustomArrayAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Context context;
    private final ArrayList<Entries> entriesList = DataHandler.getInstance().getEntriesList();

    public CustomArrayAdapter(Context context) {
        this.context = context;
//        this.entriesList = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return entriesList.size();
    }

    @Override
    public Entries getItem(int position) {
        return entriesList.get(position);
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
        loadImage(getItem(position), viewHolder);

        return convertView;
    }

    private void loadImage(Entries entry, ViewHolder holder) {
        if (entry.getImage() == null &&
                entry.getMediaGroups() != null && entry.getMediaGroups().length > 0
                && entry.getMediaGroups()[0].getContents() != null && entry.getMediaGroups()[0].getContents().length > 1
                && entry.getMediaGroups()[0].getContents()[1].getUrl() != null && !entry.getMediaGroups()[0].getContents()[1].getUrl().trim().equals("")) {

            String url = entry.getMediaGroups()[0].getContents()[1].getUrl();
            new ImageDownloaderAsyncTask(holder.imageView, entry, this).execute(url);

        } else if (entry.getImage() != null) {
            holder.imageView.setImageBitmap(entry.getImage());

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

        void setUpText(Entries entry) {
            title.setText(entry.getTitle());
            author.setText(entry.getAuthor().trim().equals("") ? "Author: Unknown" : "Author: " + entry.getAuthor().trim());
            if (entry.getImage() != null)
                imageView.setImageBitmap(entry.getImage());
            else
                imageView.setImageResource(android.R.drawable.stat_sys_warning);
        }
    }

}

