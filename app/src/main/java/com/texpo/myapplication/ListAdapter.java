package com.texpo.myapplication;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
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
        EditText desc;
        TextView sft;
        TextView amount;
        TextView xSign;
        EditText height;
        EditText width;
        EditText qty;
        EditText rates;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, null);
            holder = new ViewHolder();
            holder.desc = (EditText) convertView.findViewById(R.id.desc);
            holder.sft = (TextView) convertView.findViewById(R.id.SFT);
            holder.xSign = (TextView) convertView.findViewById(R.id.xSign);
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

        holder.height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                holder.amount.setText(holder.height.getText().toString());
            }
        });

        return convertView;
    }
}