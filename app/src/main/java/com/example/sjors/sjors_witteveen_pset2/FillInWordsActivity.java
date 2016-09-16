package com.example.sjors.sjors_witteveen_pset2;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class FillInWordsActivity extends Activity {

    private Story story;

    private TextView words_left;
    private EditText text_field;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_words);

        InputStream stream = null;
        AssetManager assetManager = getAssets();

        words_left = (TextView) findViewById(R.id.words_left);
        text_field = (EditText) findViewById(R.id.text_field);
        button = (Button) findViewById(R.id.button);

        try {
            String[] files = assetManager.list("mad_libs");
            int random = new Random().nextInt(files.length);
            stream = assetManager.open("mad_libs/" + files[random]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        story = new Story(stream);

        String text = story.getPlaceholderRemainingCount() + " words left";
        words_left.setText(text);
        text_field.setHint(story.getNextPlaceholder());

    }

    public void buttonClicked(View view) {
        story.fillInPlaceholder(text_field.getText().toString());
        text_field.getText().clear();

        if (story.isFilledIn()) {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("story", story.toString());
            startActivity(intent);

            finish();
        } else {
            String text;
            if (story.getPlaceholderRemainingCount() == 1) {
                text = story.getPlaceholderRemainingCount() + " word left";
                String string = "Finish";
                button.setText(string);
            } else {
                text = story.getPlaceholderRemainingCount() + " words left";
            }

            words_left.setText(text);
            text_field.setHint(story.getNextPlaceholder());
        }
    }
}
