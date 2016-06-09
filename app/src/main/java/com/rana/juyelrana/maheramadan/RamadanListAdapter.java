package com.rana.juyelrana.maheramadan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JuyelRana on 6/2/2016.
 */
public class RamadanListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Ramadan> ramadanList;
    private LayoutInflater inflater;

    public RamadanListAdapter(Activity activity, List<Ramadan> ramadanList) {

        this.activity = activity;
        this.ramadanList = ramadanList;
    }

    @Override
    public int getCount() {
        return ramadanList.size();
    }

    @Override
    public Object getItem(int position) {
        return ramadanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }if(convertView == null){
            convertView = inflater.inflate(R.layout.list_view, null);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.row_image);
        TextView romjan_date  = (TextView) convertView.findViewById(R.id.txtRomdandate);
        TextView today_date = (TextView) convertView.findViewById(R.id.txtTodayDate);
        TextView seheri_time = (TextView) convertView.findViewById(R.id.txt_list_view_seheri_time);
        TextView ifatr_time = (TextView) convertView.findViewById(R.id.txt_list_view_iftar_time);

        Ramadan ramadan = ramadanList.get(position);
        image.setImageResource(ramadan.getImage());
        romjan_date.setText(ramadan.getRomjan_date());
        today_date.setText(ramadan.getToday_date());
        seheri_time.setText(ramadan.getSeheri_time());
        ifatr_time.setText(ramadan.getIftar_time());


        return convertView;

    }
}
