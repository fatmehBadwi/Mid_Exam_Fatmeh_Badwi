package com.example.mid_exam_fatmeh_badwi;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    TextView tvCounter, tvTitle, tvArtist;
    ImageView ivArtwork;
    Button btnPrevious, btnNext;
    int currentIndex = 0;
    int[] images = {R.drawable.mona_lisa, R.drawable.starry_night, R.drawable.scream,
            R.drawable.pearl_earring, R.drawable.persistence_of_memory, R.drawable.great_wave};
    String[] titles = {"Mona Lisa", "The Starry Night", "The Scream",
            "Girl with a Pearl Earring", "The Persistence of Memory", "The Great Wave off Kanagawa"};
    String[] artists = {"Leonardo da Vinci", "Vincent van Gogh", "Edvard Munch",
            "Johannes Vermeer", "Salvador Dalí", "Hokusai"};
    String[] years = {"1503", "1889", "1893", "1665", "1931", "1831"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        tvTitle = findViewById(R.id.tvTitle);
        tvArtist = findViewById(R.id.tvArtist);
        ivArtwork = findViewById(R.id.ivArtwork);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("index");
        }

        btnNext.setOnClickListener(v -> {
            currentIndex++;
            updateUI();
        });

        btnPrevious.setOnClickListener(v -> {
            currentIndex--;
            updateUI();
        });
        ivArtwork.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
            intent.putExtra("title", titles[currentIndex]);
            intent.putExtra("artist", artists[currentIndex]);
            intent.putExtra("year", years[currentIndex]);
            startActivity(intent);
        });
        updateUI();
    }

    private void updateUI() {
        ivArtwork.setImageResource(images[currentIndex]);
        tvTitle.setText(titles[currentIndex]);
        tvArtist.setText(artists[currentIndex] + " (" + years[currentIndex] + ")");
        tvCounter.setText((currentIndex + 1) + " / " + images.length);

        btnPrevious.setEnabled(currentIndex > 0);
        btnNext.setEnabled(currentIndex < images.length - 1);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", currentIndex);
    }
}