package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimals = findViewById(R.id.btnAnimals);
        Button btnTools = findViewById(R.id.btnTools);
        Button btnPlants = findViewById(R.id.btnPlants);

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
}