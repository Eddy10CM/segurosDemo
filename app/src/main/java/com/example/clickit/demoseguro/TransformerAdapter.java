package com.example.clickit.demoseguro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;

/**
 * Created by clickit on 26/08/16.
 */
public class TransformerAdapter extends BaseAdapter {

    private Context mContext;

    public TransformerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return SliderLayout.Transformer.values().length;
    }

    @Override
    public Object getItem(int position) {
        return SliderLayout.Transformer.values()[position].toString();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView t = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item,null);
        t.setText(getItem(position).toString());
        return t;
    }
}