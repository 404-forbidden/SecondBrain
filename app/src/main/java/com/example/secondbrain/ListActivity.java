package com.example.secondbrain;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<DBItem> DBItems;
    private ArrayAdapter<DBItem> adapter;
    private ListView lv;
    private int id;
    private String tableName;
    private TextView tvTitle;
    RadioButton rb1, rb2, rb3;
    RadioGroup radioGroup;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tvTitle = findViewById(R.id.tv_list);
        rb1 = findViewById(R.id.rb_list_1);
        rb2 = findViewById(R.id.rb_list_2);
        rb3 = findViewById(R.id.rb_list_3);

        lv = findViewById(R.id.lv_list);
        radioGroup = findViewById(R.id.rg_list);

        id = radioGroup.getCheckedRadioButtonId();

        DBItems = new ArrayList<>(); //size = 0
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DBItems);
        lv.setAdapter(adapter);
        dataManager = new DataManager(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DBItem selectedItem = DBItems.get(position);

                Intent intent = new Intent(ListActivity.this, UpdateActivity.class);
                intent.putExtra("item", selectedItem);
                intent.putExtra("tableName", tableName);
                startActivity(intent);
                onResume();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;

                //확인 다이얼로그 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("삭제 확인");
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (tableName){
                            case "location":
                                dataManager.deleteLocation(DBItems.get(pos).getId());
                                DBItems.remove(pos);
                                break;
                            case "important":
                                dataManager.deleteImportant(DBItems.get(pos).getId());
                                DBItems.remove(pos);
                                break;
                            case "personal":
                                dataManager.deletePersonal(DBItems.get(pos).getId());
                                DBItems.remove(pos);
                                break;
                        }

                        adapter.notifyDataSetChanged();
                        onResume();
                    }
                });
                builder.setNegativeButton("취소", null);
                builder.show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        switch (id){
            case R.id.rb_list_1:
                tableName = "location";
                adapter.addAll(dataManager.selectLocationList());
                break;
            case R.id.rb_list_2:
                tableName = "important";
                adapter.addAll(dataManager.selectImportantList());
                break;
            case R.id.rb_list_3:
                tableName = "personal";
                adapter.addAll(dataManager.selectPersonalList());
                break;
        }
        adapter.notifyDataSetChanged();
    }

    public void onClick(View v) {
        id = radioGroup.getCheckedRadioButtonId();
        onResume();
    }
}
