package com.texpo.myapplication;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by omar on 9/12/2017.
 */

public class ListAdapter extends BaseAdapter {

    Double mAmount = 0.00;
    Double mWidth;
    Double mHieght;
    Double mRates;
    Double mQty;
    Double mSFT;
    String mDesc;
    Integer mWastageValue;
    boolean bHeight;
    boolean bWidth;

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
        TextView xSign;
        EditText height;
        EditText width;
        EditText qty;
        EditText rates;
        LinearLayout lnDetails;
        RadioGroup rgrpWast;
        RadioButton rbtnWasteChoice;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, null);
            holder = new ViewHolder();
            holder.desc = (TextView) convertView.findViewById(R.id.desc);
            holder.sft = (TextView) convertView.findViewById(R.id.SFT);
            holder.xSign = (TextView) convertView.findViewById(R.id.xSign);
            holder.amount = (TextView) convertView.findViewById(R.id.amount);
            holder.height = (EditText) convertView.findViewById(R.id.height);
            holder.width = (EditText) convertView.findViewById(R.id.width);
            holder.qty = (EditText) convertView.findViewById(R.id.qty);
            holder.rates = (EditText) convertView.findViewById(R.id.rates);
            holder.lnDetails = (LinearLayout) convertView.findViewById(R.id.lnDetails);
            holder.rgrpWast = (RadioGroup) convertView.findViewById(R.id.rgrpWast);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DataModel item = productList.get(position);

        int selectedId = holder.rgrpWast.getCheckedRadioButtonId();
        holder.rbtnWasteChoice = (RadioButton) convertView.findViewById(selectedId);
        final View viewCheck = convertView;
        mWastageValue = 0;

        holder.rgrpWast.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                holder.rbtnWasteChoice = (RadioButton) viewCheck.findViewById(i);
                System.out.println("Radio ID:"+ holder.rbtnWasteChoice.getText());

                if (holder.rbtnWasteChoice.getText().toString().contains("3")) {
                    mWastageValue = 3;
                    calculateData(holder, position);
                } else if (holder.rbtnWasteChoice.getText().toString().contains("6")) {
                    mWastageValue = 6;
                    calculateData(holder, position);
                } else if (holder.rbtnWasteChoice.getText().toString().contains("9")) {
                    mWastageValue = 9;
                    calculateData(holder, position);
                } else {
                    mWastageValue = 0;
                    calculateData(holder, position);
                }
            }
        });

        System.out.println("radio:" + selectedId);

        holder.height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                calculateData(holder, position);
            }
        });

        holder.width.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateData(holder, position);

            }
        });

        holder.qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateData(holder, position);

            }
        });

        holder.rates.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateData(holder, position);

            }
        });

        holder.height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.lnDetails.getVisibility() == View.GONE) {
                    holder.lnDetails.setVisibility(View.VISIBLE);
                } else if(holder.lnDetails.getVisibility() == View.VISIBLE) {
                    holder.lnDetails.setVisibility(View.GONE);
                }
            }
        });

        holder.width.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.lnDetails.getVisibility() == View.GONE) {
                    holder.lnDetails.setVisibility(View.VISIBLE);
                } else if(holder.lnDetails.getVisibility() == View.VISIBLE) {
                    holder.lnDetails.setVisibility(View.GONE);
                }
            }
        });



        return convertView;
    }


    public void calculateData(ViewHolder holder, int pos){

        holder.lnDetails.setVisibility(View.VISIBLE);

        if (holder.height.getText().toString().equals("")){mHieght = 0.0;}
        else { mHieght = Double.valueOf(holder.height.getText().toString()); }

        if (holder.width.getText().toString().equals("")) { mWidth = 0.0; }
        else { mWidth = Double.valueOf(holder.width.getText().toString()); }

        if (holder.rates.getText().toString().equals("")) { mRates = 0.0; }
        else { mRates = Double.valueOf(holder.rates.getText().toString()); }

        if (holder.qty.getText().toString().equals("")) { mQty = 0.0; }
        else {  mQty= Double.valueOf(holder.qty.getText().toString()); }


        if (mWastageValue == 0) {
            mSFT = ((mHieght * mWidth)/144)*mQty;
            holder.sft.setText(mSFT.toString());
            mAmount = mSFT * mRates;
            holder.amount.setText(mAmount.toString());

            productList.get(pos).setAmount(mAmount.toString());
            productList.get(pos).setHeight(mHieght.toString());
            productList.get(pos).setWidth(mWidth.toString());
            productList.get(pos).setQty(mQty.toString());
            productList.get(pos).setSFT(mSFT.toString());
            productList.get(pos).setRates(mRates.toString());
            productList.get(pos).setDesc(mDesc);

        } else if ( mWastageValue == 3 ) {

            while ( checkTwo(mHieght, 3) ) {
                 mHieght = mHieght + 1;
                System.out.println("In here at height");

            }

            while ( checkTwo(mWidth, 3) ) {
                mWidth = mWidth + 1;
                System.out.println("In here at Width");
            }


            mSFT = ((mHieght * mWidth)/144)*mQty;
            holder.sft.setText(mSFT.toString());
            mAmount = mSFT * mRates;
            holder.amount.setText(mAmount.toString());

            productList.get(pos).setAmount(mAmount.toString());
            productList.get(pos).setHeight(mHieght.toString());
            productList.get(pos).setWidth(mWidth.toString());
            productList.get(pos).setQty(mQty.toString());
            productList.get(pos).setSFT(mSFT.toString());
            productList.get(pos).setRates(mRates.toString());
            productList.get(pos).setDesc(mDesc);
            System.out.println("Final mHeight:"+ mHieght + " , mWidth:" + mWidth);
        }else if ( mWastageValue == 6 ) {

            while ( checkTwo(mHieght, 6) ) {
                 mHieght = mHieght + 1;
                System.out.println("In here at height");

            }

            while ( checkTwo(mWidth, 6) ) {
                mWidth = mWidth + 1;
                System.out.println("In here at Width");
            }


            mSFT = ((mHieght * mWidth)/144)*mQty;
            holder.sft.setText(mSFT.toString());
            mAmount = mSFT * mRates;
            holder.amount.setText(mAmount.toString());

            productList.get(pos).setAmount(mAmount.toString());
            productList.get(pos).setHeight(mHieght.toString());
            productList.get(pos).setWidth(mWidth.toString());
            productList.get(pos).setQty(mQty.toString());
            productList.get(pos).setSFT(mSFT.toString());
            productList.get(pos).setRates(mRates.toString());
            productList.get(pos).setDesc(mDesc);
            System.out.println("Final mHeight:"+ mHieght + " , mWidth:" + mWidth);
        }else if ( mWastageValue == 9 ) {

            while ( checkTwo(mHieght, 9) ) {
                 mHieght = mHieght + 1;
                System.out.println("In here at height");

            }

            while ( checkTwo(mWidth, 9) ) {
                mWidth = mWidth + 1;
                System.out.println("In here at Width");
            }


            mSFT = ((mHieght * mWidth)/144)*mQty;
            holder.sft.setText(mSFT.toString());
            mAmount = mSFT * mRates;
            holder.amount.setText(mAmount.toString());

            productList.get(pos).setAmount(mAmount.toString());
            productList.get(pos).setHeight(mHieght.toString());
            productList.get(pos).setWidth(mWidth.toString());
            productList.get(pos).setQty(mQty.toString());
            productList.get(pos).setSFT(mSFT.toString());
            productList.get(pos).setRates(mRates.toString());
            productList.get(pos).setDesc(mDesc);
            System.out.println("Final mHeight:"+ mHieght + " , mWidth:" + mWidth);
        }


    }

    public boolean check(String str, int waste) {
        int n = str.length();
        int digitSum = 0;
        for (int i=0; i<n; i++)
            digitSum += (str.charAt(i)-'0');

        System.out.println("DigitSum:" + digitSum + " and "+ str);

        return (digitSum % 3 == 0);
    }

    public boolean checkTwo(Double toCheck, int waste){

        boolean ans;

        Double temp = toCheck/waste;

        if ( temp%1 == 0) {
            ans = false;
        } else {
            ans = true;
        }
        return ans;
    }
}