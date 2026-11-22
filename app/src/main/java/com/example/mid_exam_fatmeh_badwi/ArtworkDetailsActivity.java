package com.example.mid_exam_fatmeh_badwi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        TextView tvDetails = findViewById(R.id.tvDetails);

        String title = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        String year = getIntent().getStringExtra("year");

        tvDetails.setText(title + "\n" + artist + "\n" + year);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        findViewById(R.id.btnWebsite).setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Art"))));
    }
}