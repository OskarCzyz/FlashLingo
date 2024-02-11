package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.example.sqlitecrud.database.DatabaseHelper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private TextView tvStatusAnimals, tvStatusPlants, tvStatusTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimals = findViewById(R.id.btnAnimals);
        Button btnTools = findViewById(R.id.btnTools);
        Button btnPlants = findViewById(R.id.btnPlants);

        tvStatusAnimals = findViewById(R.id.tvStatusAnimals);
        tvStatusPlants = findViewById(R.id.tvStatusPlants);
        tvStatusTools = findViewById(R.id.tvStatusTools);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        Handler handler = new Handler();
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                updateAvailabilityAndTextView("animals", tvStatusAnimals);
                updateAvailabilityAndTextView("plants", tvStatusPlants);
                updateAvailabilityAndTextView("tools", tvStatusTools);
                handler.postDelayed(this, 1000);
            }
        };
// Start the initial runnable task by posting through the handler
        handler.post(runnableCode);

        btnAnimals.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
            intent.putExtra("SET", "animals");
            startActivity(intent);
        });
        btnTools.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
            intent.putExtra("SET", "tools");
            startActivity(intent);
        });
        btnPlants.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
            intent.putExtra("SET", "plants");
            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    private void updateAvailabilityAndTextView(String setName, TextView textView) {
        Cursor cursor = databaseHelper.getSet(setName);
        int availableItems = 0;
        long lowest = Long.MAX_VALUE;
        while (cursor.moveToNext()) {
            int counter = cursor.getInt(3);
            long guess = cursor.getLong(4);
            int cooldown = (int) (30 * Math.pow(2, counter) * 1000);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (guess + cooldown <= currentTime) {
                availableItems++;
            } else if (lowest > guess + cooldown - currentTime) {
                lowest = guess + cooldown - currentTime;
            }
        }
        if (availableItems == 0 && lowest > 0) {
            long minutes = (lowest / 1000) / 60;
            long seconds = (lowest / 1000) % 60;
            @SuppressLint("DefaultLocale") String formattedTime = String.format("%d:%02d", minutes, seconds);
            textView.setText("Review " + formattedTime);
        } else {
            textView.setText(availableItems + "/" + 20);
        }
    }
}