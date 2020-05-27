package com.example.b10701111_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class addActivity extends AppCompatActivity {

    private EditText name;
    private TextView show_name;
    private Button OK;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name);
        show_name = findViewById(R.id.show_name);
        OK = findViewById(R.id.OK);

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_name.setText(name.getText().toString());
                Intent intent = getIntent();
                intent.putExtra("book_isbn", "123456789");
                setResult(REQUEST_CODE, intent);
                finish();
            }
        });

        Button OK = findViewById(R.id.OK);
    }
}
