package com.example.p3l01ayumeganfunapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    TextView countDisplay;
    int count = 0;
    int lucky_num = 8;
    int color_count = 0;

    TextView color_text;
    EditText name;
    String name_string = "anonymous";
    String [] colors;

    RadioButton leftRadBut, rightRadBut;
    Button next_color_button;

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
        greetingDisplay.setText(getString(R.string.greeting, "anonymous"));

        color_text = findViewById(R.id.color_text);
        colors = getResources().getStringArray(R.array.colors_array);

        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        next_color_button = findViewById(R.id.color_next);

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
            this.getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.green_light)); //Color.rgb(209, 252, 204)

        }
        else{
            greetingDisplay.setText(getString(R.string.greeting, name_string));
            this.getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        }
    }

    public void submit_name(View view) {
        name = findViewById(R.id.edit_name);
        name_string = String.valueOf(name.getText());
        greetingDisplay.setText(getString(R.string.greeting, name_string));

    }

    public void next_color(View view) {
        if(rightRadBut.isChecked())
            color_count++;
        else
            color_count--;
        color_count %= colors.length;
        if (color_count < 0)
            color_count = colors.length - 1;

        color_text.setText(colors[color_count]);
        next_color_button.setBackgroundColor(Color.parseColor(colors[color_count]));
    }
}
