package com.example.android.inventoryapp;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.inventoryapp.models.DataHandler;
import com.example.android.inventoryapp.models.Product;

import java.util.ArrayList;

/**
 * Created by Muhammad Muzammil on 7/4/2016.
 */

public class CustomArrayAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final Context context;
    private ArrayList<Product> products = null;

    public CustomArrayAdapter(AppCompatActivity context, ArrayList<Product> products) {
        this.context = context;
//        this.products = items;
        this.products = products;
        DataHandler.getInstance().setCustomArrayAdapter(this);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    public void removeItem(int postion){
        products.remove(postion);
        notifyDataSetChanged();
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

        viewHolder.setUpFields(getItem(position));

        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView quantity;
        TextView price;
        ImageView imageView;

        ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.name);
            quantity = (TextView) view.findViewById(R.id.quantity);
            price = (TextView) view.findViewById(R.id.price);
            imageView = (ImageView) view.findViewById(R.id.imageview);
        }

        void setUpFields(Product products) {
            name.setText(products.getName());
            quantity.setText(Integer.toString(products.getQuantity()));
            price.setText(Double.toString(products.getPrice()));

            if (products.getImage() != null)
                imageView.setImageBitmap(products.getImage());
            else
                imageView.setImageResource(android.R.drawable.stat_sys_warning);
        }
    }

}

