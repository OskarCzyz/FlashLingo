package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

public class FlashCardActivity extends AppCompatActivity {

    private TextView tvFlashCardtext;
    private String EnglishText = "Cat";

    private String PolishText = "Kot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card);

        tvFlashCardtext = findViewById(R.id.tvFlashCardtext);

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
    }

}