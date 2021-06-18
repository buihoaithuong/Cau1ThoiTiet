package com.example.cau1thoitiet;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThoiTietAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    List<ThoiTiet> thoiTietList;

    public ThoiTietAdapter(Context context, int layout, List<ThoiTiet> thoiTietList) {
        this.context = context;
        this.layout = layout;
        this.thoiTietList = thoiTietList;
    }

    @Override
    public int getCount() {
        return thoiTietList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        // ánh xạ view
        TextView txtNgayThang = (TextView) convertView.findViewById(R.id.textViewday);
        TextView txtNhietDo = (TextView) convertView.findViewById(R.id.textViewnhietDo);
        ImageView imgThoiTiet = (ImageView) convertView.findViewById(R.id.imageView);

        // gán giá trị
        ThoiTiet thoiTiet = thoiTietList.get(position);

        txtNgayThang.setText(thoiTiet.getNgayThang());
        txtNhietDo.setText(thoiTiet.getNhietDo());
        imgThoiTiet.setImageResource(thoiTiet.getHinh());

        return convertView;
    }
}
