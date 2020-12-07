package com.example.pertemuan7;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<com.example.pertemuan7.buku> movieItems;
    public CustomListAdapter(Activity activity, List<com.example.pertemuan7.buku> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView namaakun = (TextView) convertView.findViewById(R.id.text_akun);
        TextView stok = (TextView) convertView.findViewById(R.id.text_stok);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        com.example.pertemuan7.buku m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        namaakun.setText("Harga : "+ m.get_harga());
        stok.setText("stok : "+ m.get_stok());
        return convertView;
    }
}

