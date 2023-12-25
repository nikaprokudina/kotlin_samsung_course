package ru.myitschool.lab23;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreText = findViewById(R.id.score_text);
        FloatingActionButton fabTopLeft = findViewById(R.id.fab_top_left);
        FloatingActionButton fabTopRight = findViewById(R.id.fab_top_right);
        FloatingActionButton fabBottomLeft = findViewById(R.id.fab_bottom_left);
        FloatingActionButton fabBottomRight = findViewById(R.id.fab_bottom_right);

        View.OnClickListener fabClickListener = view -> {
            count++;
            scoreText.setText(String.valueOf(count));
        };

        fabTopLeft.setOnClickListener(fabClickListener);
        fabTopRight.setOnClickListener(fabClickListener);
        fabBottomLeft.setOnClickListener(fabClickListener);
        fabBottomRight.setOnClickListener(fabClickListener);

        scoreText.setOnClickListener(view -> {
            count = 0;
            scoreText.setText("0");
            Snackbar.make(view, "Сброс счетчика", Snackbar.LENGTH_SHORT).show();
        });
    }
}


/*
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
*/