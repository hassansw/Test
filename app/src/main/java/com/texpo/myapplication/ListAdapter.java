package com.texpo.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by omar on 9/12/2017.
 */

public class ListAdapter extends BaseAdapter {

    public ArrayList<DataModel> productList;
    Activity activity;

    public ListAdapter(Activity activity, ArrayList<DataModel> productList) {
        super();
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView desc;
        TextView sft;
        TextView amount;

        EditText height;
        EditText width;
        EditText qty;
        EditText rates;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, null);
            holder = new ViewHolder();
            holder.desc = (TextView) convertView.findViewById(R.id.desc);
            holder.sft = (TextView) convertView.findViewById(R.id.SFT);
            holder.amount = (TextView) convertView.findViewById(R.id.amount);
            holder.height = (EditText) convertView.findViewById(R.id.height);
            holder.width = (EditText) convertView.findViewById(R.id.width);
            holder.qty = (EditText) convertView.findViewById(R.id.qty);
            holder.rates = (EditText) convertView.findViewById(R.id.rates);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DataModel item = productList.get(position);
        holder.desc.setText(item.getProduct().toString());
        holder.amount.setText(item.getPrice().toString());
        holder.sft.setText(item.getPrice().toString());

        return convertView;
    }
}