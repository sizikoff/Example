package com.apps.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageView butilka;
    private final Random random = new Random();
    private int lastDir;
    private boolean spinning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        butilka = findViewById(R.id.bottle);
    }

    public void spin(View v) {
        if (!spinning) {
            int newDir = random.nextInt(2900);
            float pivotX = butilka.getWidth() / 2.0f;
            float pivotY = butilka.getHeight() / 2.0f;
            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            lastDir = newDir;
            butilka.startAnimation(rotate);
        }
    }
}