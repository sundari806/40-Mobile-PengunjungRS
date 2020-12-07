package com.example.pertemuan7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead  extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    private ListView mListView;
    private com.example.pertemuan7.CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<com.example.pertemuan7.buku> ListKosmetik = new ArrayList<com.example.pertemuan7.buku>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new com.example.pertemuan7.CustomListAdapter(this, ListKosmetik );
        mListView = (ListView) findViewById(R.id.list_kosmetik);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKosmetik.clear();

        List<com.example.pertemuan7.buku> contacts = db.ReadKosmetik();
        for (com.example.pertemuan7.buku cn : contacts) {
            com.example.pertemuan7.buku judulModel = new com.example.pertemuan7.buku();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_harga(cn.get_harga());
            judulModel.set_stok(cn.get_stok());
            ListKosmetik.add(judulModel);
            if ((ListKosmetik.isEmpty()))
                Toast.makeText(com.example.pertemuan7.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        com.example.pertemuan7.buku obj_itemDetails = (com.example.pertemuan7.buku) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sharga = obj_itemDetails.get_harga();
        String Sstok = obj_itemDetails.get_stok();
        Intent goUpdel = new Intent(com.example.pertemuan7.MainRead.this, com.example.pertemuan7.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iharga", Sharga);
        goUpdel.putExtra("Istok", Sstok);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListKosmetik.clear();
        mListView.setAdapter(adapter_off);
        List<com.example.pertemuan7.buku> contacts = db.ReadKosmetik();
        for (com.example.pertemuan7.buku cn : contacts) {
            com.example.pertemuan7.buku judulModel = new com.example.pertemuan7.buku();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_harga(cn.get_harga());
            judulModel.set_stok(cn.get_stok());
            ListKosmetik.add(judulModel);
            if ((ListKosmetik.isEmpty()))
                Toast.makeText(com.example.pertemuan7.MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
