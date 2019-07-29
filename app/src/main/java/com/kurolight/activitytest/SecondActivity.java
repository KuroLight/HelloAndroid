package com.kurolight.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            Intent intent = getIntent();
            String data = intent.getStringExtra("extra_data");
            Log.d(TAG, data);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }


        Button bt21 = findViewById(R.id.bt21);
        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "this is from second activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "this is 2nd press back");
        setResult(RESULT_OK, intent);
        finish();
    }
}
