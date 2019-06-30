package com.example.secondbrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_main_write:
                intent = new Intent(this, WriteActivity.class);
                break;
            case R.id.btn_main_list:
                intent = new Intent(this, ListActivity.class);
                break;
        }
        startActivity(intent);
    }

}
