package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sqlitecrud.database.DatabaseHelper;
import com.example.sqlitecrud.model.FlashCard;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Calendar;
public class FlashCardActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private final ArrayList<FlashCard> FlashCardSet = new ArrayList<>();
    private String SET_NAME = "Blad kategorii";
    private TextView tvFlashCardtext;
    private TextView tvStatus;

    private int currentFlashCardIndex = -1;
    private String EnglishText = "Cat";
    private String PolishText = "Kot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        TextView tvCategory = findViewById(R.id.tvCategory);
        tvStatus = findViewById(R.id.tvStatus);
        tvFlashCardtext = findViewById(R.id.tvFlashCardtext);
        ImageButton btnKnownWord = findViewById(R.id.btnKnownWord);
        ImageButton btnUnKnownWord = findViewById(R.id.btnUnKnownWord);
        databaseHelper = new DatabaseHelper(FlashCardActivity.this);

        // Get set name
        if (getIntent().hasExtra("SET")) {
            SET_NAME = getIntent().getStringExtra("SET");
        }

        currentFlashCardIndex = -1;

        assert SET_NAME != null;
        String str = SET_NAME.substring(0, 1).toUpperCase() + SET_NAME.substring(1);
        tvCategory.setText(str);

        storeSetInList();

        nextFlashCard();

        //FlashCardAnimation
        tvFlashCardtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(tvFlashCardtext, "scaleX", 1f, 0f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(tvFlashCardtext, "scaleX", 0f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (tvFlashCardtext.getText() == EnglishText) {
                            tvFlashCardtext.setText(PolishText);
                        } else {
                            tvFlashCardtext.setText(EnglishText);
                        }

                        oa2.start();
                    }
                });
                oa1.start();
            }
        });

        //Known word button
        btnKnownWord.setOnClickListener(view -> {
            databaseHelper.updateTable(FlashCardSet.get(currentFlashCardIndex), SET_NAME, true);
            nextFlashCard();
        });

        //Unknown word button
        btnUnKnownWord.setOnClickListener(view -> {
            databaseHelper.updateTable(FlashCardSet.get(currentFlashCardIndex), SET_NAME, false);
            nextFlashCard();
        });
    }
    //Get flashcards from set
    private void storeSetInList() {
        Cursor cursor = databaseHelper.getSet(SET_NAME);
        while(cursor.moveToNext()) {
            String eng = cursor.getString(1);
            String pl = cursor.getString(2);
            int counter = cursor.getInt(3);
            long guess = cursor.getLong(4);
            FlashCard flashCard = new FlashCard(eng, pl, counter, guess);
            // check if cooldown has passed
            int cooldown = (int) (60 * Math.pow(2,flashCard.getCounter()) * 100);
            if (flashCard.getGuess_time() + cooldown + 1000 <= Calendar.getInstance().getTimeInMillis()) FlashCardSet.add(flashCard);
        }

    }

    //Update view with new flashcard
    @SuppressLint("SetTextI18n")
    private void nextFlashCard() {
        currentFlashCardIndex++;
        if (currentFlashCardIndex >= FlashCardSet.size()) {
            if (FlashCardSet.size() == 0) {
                new MaterialAlertDialogBuilder(FlashCardActivity.this).setTitle("Not enough time has passed").setMessage("You still remember those words pretty well!").setPositiveButton("Ok", (dialogInterface, i) -> finish()).setCancelable(false).show();
            } else {
                new MaterialAlertDialogBuilder(FlashCardActivity.this).setTitle("Good job!").setMessage("Congratulations you successfully reviewed set \"" + SET_NAME + "\". Now you may comeback to this set but only after some time passes, so you can check if you still remember those words. ").setPositiveButton("Ok", (dialogInterface, i) -> finish()).setCancelable(false).show();
            }
        } else {
            EnglishText = FlashCardSet.get(currentFlashCardIndex).getEng();
            PolishText = FlashCardSet.get(currentFlashCardIndex).getPl();
            tvFlashCardtext.setText(EnglishText);
            tvStatus.setText(currentFlashCardIndex + 1 + "/" + FlashCardSet.size());
        }
    }
}