package com.example.b10701111_hw2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] from = {"title"};
    private int[] to = {R.id.item_title};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    private SimpleAdapter adapter;

    private static final int REQUEST_CODE = 1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                String result = data.getStringExtra("book_isbn");
                Log.d("HKT", "result:" + result);
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 取得點選項目的id
        int id = item.getItemId();

        // 依照id判斷點了哪個項目並做相應事件
        switch (id) {
            case R.id.setting:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, settingActivity.class);
                startActivity(intent1);
                MainActivity.this.finish();
                break;

            case R.id.add:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, addActivity.class);
                startActivity(intent2);
                MainActivity.this.finish();
                break;
        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add =  findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        listView = findViewById(R.id.list);
        initListView();



    }
    private void initListView(){

        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"Test1");
        data.add(d0);

        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"Test2");
        data.add(d1);

        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"Test3");
        data.add(d2);

        adapter = new SimpleAdapter(this,data,R.layout.item,from,to);
        listView.setAdapter(adapter);



    }

}
