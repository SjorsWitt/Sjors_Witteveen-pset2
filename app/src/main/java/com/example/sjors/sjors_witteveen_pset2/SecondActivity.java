package com.example.sjors.sjors_witteveen_pset2;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SecondActivity extends Activity {

    private Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        InputStream stream = null;
        AssetManager assetManager = getAssets();

        try {
            String[] files = assetManager.list("mad_libs");
            int random = new Random().nextInt(files.length);
            stream = assetManager.open("mad_libs/" + files[random]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Story story = new Story(stream);
        TextView test = (TextView) findViewById(R.id.test);
        test.setText(story.toString());
    }

}
