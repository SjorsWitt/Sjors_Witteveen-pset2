package com.example.sjors.sjors_witteveen_pset2;

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

    // new intent when continue buton is clicked
    public void onContinue(View view) {
        Intent intent = new Intent(this, FillInWordsActivity.class);
        startActivity(intent);
    }
}
