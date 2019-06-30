package com.example.secondbrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DataManager dataManager;
    DBItem item;
    EditText etTitle, etContent, etEtc, etFirst, etLocation;
    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etTitle = findViewById(R.id.et_update_title);
        etContent = findViewById(R.id.et_update_content);
        etEtc = findViewById(R.id.et_update_etc);
        etFirst = findViewById(R.id.et_update_first);
        etLocation = findViewById(R.id.et_update_location);
        dataManager = new DataManager(this);

        Intent intent = getIntent();
        tableName = intent.getSerializableExtra("tableName").toString();
        item = (DBItem)intent.getSerializableExtra("item");
        etTitle.setText(item.getTitle());
        etContent.setText(item.getContent());
        etEtc.setText(item.getEtc());
        etFirst.setText(item.getFirst());
        if(tableName.equals("location")) {
            LocationItem locationItem = (LocationItem)item;
            etLocation.setText(locationItem.getLocation());
        }
    }

    public void onClick(View v){
        String title = etTitle.getText().toString();
        String content = etContent.getText().toString();
        String etc = etEtc.getText().toString();
        String first = etFirst.getText().toString();
        String location = etLocation.getText().toString();

        switch (v.getId()){
            case R.id.tv_update_submit:
                if(title.trim().getBytes().length <= 0) {
                    Toast.makeText(this, "제목을 입력하세요", Toast.LENGTH_SHORT).show();
                }else if(content.trim().getBytes().length <= 0){
                    Toast.makeText(this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                }else if(first.trim().getBytes().length <= 0){
                    Toast.makeText(this, "첫 화면에 나타날 문장을 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    switch (tableName){
                        case "location":
                            dataManager.updateLocation(item.getId(), title, content, etc, first, location);
                        case "important":
                            dataManager.updateImportant(item.getId(), title, content, etc, first);
                        case "personal":
                            dataManager.updatePersonal(item.getId(), title,content,etc, first);
                    }
                    Toast.makeText(this, "변경하였습니다~", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }
}
