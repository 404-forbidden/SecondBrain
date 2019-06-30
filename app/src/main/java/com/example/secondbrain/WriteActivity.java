package com.example.secondbrain;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.Mac;

public class WriteActivity extends AppCompatActivity {

    EditText etTitle, etContent, etEtc, etFirst, etLocation;
    TextView tvBtn;
    DataManager dataManager;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        etTitle = findViewById(R.id.et_write_title);
        etContent = findViewById(R.id.et_write_content);
        etEtc = findViewById(R.id.et_write_etc);
        etFirst = findViewById(R.id.et_write_first);
        etLocation = findViewById(R.id.et_write_location);
        tvBtn = findViewById(R.id.tv_write_submit);
        radioGroup = findViewById(R.id.rg_write);
        dataManager = new DataManager(this);
    }

    //on click submit
    public void onClick(View v){
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();
        String etc = etEtc.getText().toString();
        String first = etFirst.getText().toString();
        String location = etLocation.getText().toString();
        int id = radioGroup.getCheckedRadioButtonId();

        if(title.trim().getBytes().length <= 0) {
            Toast.makeText(this, "제목을 입력하세요", Toast.LENGTH_SHORT).show();
        }else if(content.trim().getBytes().length <= 0){
            Toast.makeText(this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
        }else if(first.trim().getBytes().length <= 0){
            Toast.makeText(this, "첫 화면에 나타날 문장을 입력하세요", Toast.LENGTH_SHORT).show();
        }else {

            switch (id) {
                case R.id.rb_write_1:
                    if(location.trim().getBytes().length <=0){
                        Toast.makeText(this, "위치를 입력하세요", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    LocationItem locationItem = new LocationItem(title, content, etc, first, location);
                    dataManager.insertLocation(locationItem);
                    Toast.makeText(this, "추가하였습니다", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case R.id.rb_write_2:
                    DBItem importantItem = new DBItem(title, content, etc, first);
                    dataManager.insertImportant(importantItem);
                    Toast.makeText(this, "추가하였습니다", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case R.id.rb_write_3:
                    DBItem personalItem = new DBItem(title, content, etc, first);
                    dataManager.insertPersonal(personalItem);
                    Toast.makeText(this, "추가하였습니다", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
            }
        }
    }
}
