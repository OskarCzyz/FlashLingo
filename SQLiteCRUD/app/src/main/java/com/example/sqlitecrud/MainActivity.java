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
                updateStatuses();
                handler.postDelayed(this, 2000);
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
    private void updateStatuses() {
        Cursor cursor = databaseHelper.getSet("animals");
        int animals_avalible = 0;
        while(cursor.moveToNext()) {
            int counter = cursor.getInt(3);
            long guess = cursor.getLong(4);
            int cooldown = (int) (30 * Math.pow(2,counter) * 1000);
            if (guess + cooldown <= Calendar.getInstance().getTimeInMillis()) {
                animals_avalible++;
            }
        }

        tvStatusAnimals.setText(animals_avalible + "/" + 20);
        Cursor cursor2 = databaseHelper.getSet("plants");
        int plants_avalible = 0;
        while(cursor2.moveToNext()) {
            int counter = cursor2.getInt(3);
            long guess = cursor2.getLong(4);
            int cooldown = (int) (30 * Math.pow(2,counter) * 1000);
            if (guess + cooldown + 10000 <= Calendar.getInstance().getTimeInMillis()) plants_avalible++;
        }
        tvStatusPlants.setText(plants_avalible + "/" + 20);
        Cursor cursor3 = databaseHelper.getSet("tools");
        int tools_avalible = 0;
        while(cursor3.moveToNext()) {
            int counter = cursor3.getInt(3);
            long guess = cursor3.getLong(4);
            int cooldown = (int) (30 * Math.pow(2,counter) * 1000);
            if (guess + cooldown + 10000 <= Calendar.getInstance().getTimeInMillis()) tools_avalible++;
        }
        tvStatusTools.setText(tools_avalible + "/" + 20);
    }
}