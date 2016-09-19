package com.example.sjors.sjors_witteveen_pset2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoryActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // get story String from previous activity
        Intent intent = getIntent();
        String story = intent.getExtras().getString("story");

        // set TextView to story String
        TextView story_text = (TextView) findViewById(R.id.story_text);
        story_text.setText(story);
    }

    // go back to start when button clicked
    public void newStory(View view) {
        finish();
    }
}
