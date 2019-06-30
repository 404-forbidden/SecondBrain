package com.example.secondbrain;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
/*
public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<LocationItem> locationItems;
    private ArrayList<DBItem> importantItems;
    private ArrayList<DBItem> personalItems;
    private LayoutInflater inflater;
    private String tableName;
    DataManager dataManager;

    public MyAdapter(String tableName) {
        dataManager = new DataManager(null);
        this.tableName = tableName;
        dataManager.viewLocationList(locationItems);
        dataManager.viewImportantList(importantItems);
        dataManager.viewPersonalList(personalItems);
    }

    @Override
    public int getCount() {
        int size = locationItems.size();
        switch (tableName){
            case "location":
                break;
            case "important":
                size = importantItems.size();
                break;
            case "personal":
                size = personalItems.size();
                break;
        }
        return size;
    }

    @Override
    public Object getItem(int position) {
        switch (tableName){
            case "location":
                return locationItems.get(position);
            case "important":
                return importantItems.get(position);
            case "personal":
                return personalItems.get(position);
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item, parent, false);
        }

        ImageView iv = convertView.findViewById(R.id.iv_item);
        TextView tv = convertView.findViewById(R.id.tv_item);

        switch (tableName){
            case "location":
                final LocationItem locationItem = (LocationItem)getItem(position);
                iv.setImageResource(R.mipmap.ic_location);
                iv.setBackgroundColor(0xf98bed);
                tv.setText(locationItem.getFirst());
                break;
            case "important":
                final DBItem importantItem = (DBItem)getItem(position);
                iv.setImageResource(R.mipmap.ic_important);
                iv.setBackgroundColor(0xb78300);
                tv.setText(importantItem.getFirst());
                break;
            case "personal":
                final DBItem personalItem = (DBItem)getItem(position);
                iv.setImageResource(R.mipmap.ic_personal);
                iv.setBackgroundColor(0xf2f07d);
                tv.setText(personalItem.getFirst());
                break;

        }

        return convertView;
    }
}
*/
