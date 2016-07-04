package com.example.android.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.booklisting.model.Items;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class CustomArrayAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Context context;
    private final ArrayList<Items> items;

    public CustomArrayAdapter(Context context, ArrayList<Items> items) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Items getItem(int position) {
        return items.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
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

        return convertView;
    }


    class ViewHolder {
        TextView title;
        TextView author;

        ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView) view.findViewById(R.id.author);
        }

        void setUpText(Items item) {
            if (item.getVolumeInfo().getTitle() != null)
                title.setText(item.getVolumeInfo().getTitle());
            String[] authors = item.getVolumeInfo().getAuthors();
            if (authors != null) {
                StringBuilder builder = new StringBuilder();
                builder.append(authors[0]);
                for(int i=1 ; i<authors.length; i++) {
                    builder.append(", ");
                    builder.append(authors[i]);
                }
                author.setText(builder.toString());
            }
            else
                author.setText("Unknown");
        }
    }
}
