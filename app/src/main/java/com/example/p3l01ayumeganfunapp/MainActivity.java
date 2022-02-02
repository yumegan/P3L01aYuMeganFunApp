package com.example.p3l01ayumeganfunapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    TextView countDisplay;
    int count = 0;
    int lucky_num = 8;

    String [] planets;
//    ColorDrawable defaultBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextView textView = new TextView(this);
//        textView.setText(R.string.greet_dad);
        setContentView(R.layout.activity_main); // instantiates xml file

        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        countDisplay = findViewById(R.id.count_textview);
        countDisplay.setText(getString(R.string.count, count));

        planets = getResources().getStringArray(R.array.planets_array);

//        defaultBackground = ((ColorDrawable) view.getBackground()).getColor();
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("incrementing: " + ++count);
//                Log.i("incrementing", ""+count); // i - information, v - verbose, ...
                countDisplay.setText(getString(R.string.count, count));
                checkLucky(view);
            }
        });


    }

    public void decrement(View view) {
        System.out.println("decrementing: " + --count);
        countDisplay.setText(getString(R.string.count, count));

        checkLucky(view);
    }

    public void checkLucky(View view){
        if(count == lucky_num){
            System.out.println("lucky!");
            greetingDisplay.setText(R.string.congrats_msg);
            this.getWindow().getDecorView().setBackgroundColor(0xffffff00);

        }
        else{
            greetingDisplay.setText(R.string.greeting);
            this.getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);

        }
    }
}
