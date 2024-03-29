package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView leftDie, rightDie;
    private static Random rand;
    private static int[] diceArray;
    Button higherRollButton, lowerRollButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftDie = findViewById(R.id.img_dice_left);
        rightDie = findViewById(R.id.img_dice_right);
        higherRollButton = findViewById(R.id.btn_roll_higher);
        lowerRollButton = findViewById(R.id.btn_roll_lower);
        resultTextView = findViewById(R.id.txt_result);

        diceArray = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        rand = new Random();

        higherRollButton.setOnClickListener(this);
        lowerRollButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int randComputer = rand.nextInt(6);
        int randUser = rand.nextInt(6);
        leftDie.setImageResource(diceArray[randComputer]);
        rightDie.setImageResource(diceArray[randUser]);
        String result = "Computer Win!";

        if(randComputer == randUser)
            result = "Its a Tie!";
        else if(v.getId() == R.id.btn_roll_higher && randComputer < randUser)
            result = "You Win!";
        else if(v.getId() == R.id.btn_roll_lower && randComputer > randUser)
            result = "You Win!";

        resultTextView.setText(result);

    }
}