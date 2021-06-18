package com.example.cau1thoitiet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvThoiTiet;
    ArrayList<ThoiTiet> arrayListThoiTiet;
    ThoiTietAdapter adapter;
    EditText edtNgay, edtNhietDo;
    Button btnUpdate, btnView, btnAdd;
    int viTri = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        arrayListThoiTiet = new ArrayList<>();

        arrayListThoiTiet.add(new ThoiTiet("Monday",  R.drawable.icon, "18"));
        arrayListThoiTiet.add(new ThoiTiet("Tuesday", R.drawable.icon,"19"));
        arrayListThoiTiet.add(new ThoiTiet("Wednesday", R.drawable.icon, "19"));
        arrayListThoiTiet.add(new ThoiTiet("Thusday",R.drawable.icon,"18"));
        arrayListThoiTiet.add(new ThoiTiet("Friday",R.drawable.icon,"19"));
        arrayListThoiTiet.add(new ThoiTiet("Saturday",R.drawable.icon,"19"));
        arrayListThoiTiet.add(new ThoiTiet("Sunday",R.drawable.icon,"19"));

        adapter = new ThoiTietAdapter(this, R.layout.dong_thoi_tiet, arrayListThoiTiet);
        lvThoiTiet.setAdapter(adapter);

        delete();
        Add();
        UpDate();

    }

    private void anhXa() {
        lvThoiTiet = (ListView)findViewById(R.id.ListviewThoiTiet);
        edtNgay = (EditText) findViewById(R.id.editTextNgayThang);
        edtNhietDo = (EditText) findViewById(R.id.editTextNhietDo);
        btnUpdate = (Button) findViewById(R.id.button);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnview);

    }

    public void delete(){
        lvThoiTiet.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                arrayListThoiTiet.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void Add(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ngay = edtNgay.getText().toString();
                String Nhiet = edtNhietDo.getText().toString();
                arrayListThoiTiet.add(new ThoiTiet(Ngay, R.drawable.ic_baseline_cloud_queue_24, Nhiet));
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "ALO ALO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void UpDate(){
        lvThoiTiet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri = position;
                edtNgay.setText(arrayListThoiTiet.get(viTri).getNgayThang());
                edtNhietDo.setText(arrayListThoiTiet.get(viTri).getNhietDo());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListThoiTiet.set(viTri, new ThoiTiet(
                        edtNgay.getText().toString(),
                        R.drawable.ic_baseline_cloud_queue_24,
                        edtNhietDo.getText().toString()
                        ));
            }
        });

    }


}