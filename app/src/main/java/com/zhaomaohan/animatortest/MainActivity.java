package com.zhaomaohan.animatortest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonTogether;
    private Button buttonSequentially;
    private Button buttonValue;
    private ObjectAnimator objectAnimator1;
    private ObjectAnimator objectAnimator2;
    private ObjectAnimator objectAnimator3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        buttonTogether = findViewById(R.id.buttonTogether);
        buttonSequentially = findViewById(R.id.buttonSequentially);
        buttonValue = findViewById(R.id.buttonValue);

        objectAnimator1 = ObjectAnimator.ofFloat(imageView,"translationX",0F,200F);
        objectAnimator2= ObjectAnimator.ofFloat(imageView,"translationY",0F,200F);
        objectAnimator3 = ObjectAnimator.ofFloat(imageView,"rotation",0F,360F);

        buttonTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
                animatorSet.start();
            }
        });

        buttonSequentially.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(objectAnimator1,objectAnimator2,objectAnimator3);
                animatorSet.start();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"我是图片",Toast.LENGTH_SHORT).show();
            }
        });



        buttonValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
                valueAnimator.setDuration(5000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer value = (Integer) valueAnimator.getAnimatedValue();

                        buttonValue.setText(""+value);
                    }
                });
                valueAnimator.start();
            }
        });
    }
}
