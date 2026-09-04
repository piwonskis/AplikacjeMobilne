package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final int DICE_COUNT = 5;
    private static final int MIN_DIE_VALUE = 1;
    private static final int MAX_DIE_VALUE = 6;

    private static final int[] DICE_FACE_DRAWABLES = {
            R.drawable.k1, R.drawable.k2, R.drawable.k3,
            R.drawable.k4, R.drawable.k5, R.drawable.k6
    };

    private ImageView[] diceImageViews;
    private TextView roundScoreTextView;
    private TextView totalScoreTextView;

    private int totalGameScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        setUpButtonListeners();
    }

    private void initializeViews() {
        diceImageViews = new ImageView[]{
                findViewById(R.id.imageViewDie1),
                findViewById(R.id.imageViewDie2),
                findViewById(R.id.imageViewDie3),
                findViewById(R.id.imageViewDie4),
                findViewById(R.id.imageViewDie5)
        };
        roundScoreTextView = findViewById(R.id.textViewRoundScore);
        totalScoreTextView = findViewById(R.id.textViewTotalScore);
    }

    private void setUpButtonListeners() {
        Button rollDiceButton = findViewById(R.id.buttonRollDice);
        rollDiceButton.setOnClickListener(view -> performDiceRoll());

        Button resetScoreButton = findViewById(R.id.buttonResetScore);
        resetScoreButton.setOnClickListener(view -> resetGameScore());
    }

    private void performDiceRoll() {
        int[] rolledValues = rollDice(DICE_COUNT);
        displayDiceValues(rolledValues);

        int roundScore = calculateRoundScore(rolledValues);
        totalGameScore += roundScore;

        roundScoreTextView.setText(getString(R.string.round_score_format, roundScore));
        totalScoreTextView.setText(getString(R.string.total_score_format, totalGameScore));
    }

    private void resetGameScore() {
        totalGameScore = 0;
        resetDiceImages();
        roundScoreTextView.setText(getString(R.string.round_score_format, 0));
        totalScoreTextView.setText(getString(R.string.total_score_format, 0));
    }

    private int[] rollDice(int diceCount) {
        Random random = new Random();
        int[] rolledValues = new int[diceCount];
        for (int i = 0; i < diceCount; i++) {
            rolledValues[i] = MIN_DIE_VALUE + random.nextInt(MAX_DIE_VALUE - MIN_DIE_VALUE + 1);
        }
        return rolledValues;
    }

    private int calculateRoundScore(int[] diceValues) {
        int[] occurrenceCountByValue = new int[MAX_DIE_VALUE + 1];
        for (int value : diceValues) {
            occurrenceCountByValue[value]++;
        }

        int roundScore = 0;
        for (int value = MIN_DIE_VALUE; value <= MAX_DIE_VALUE; value++) {
            int occurrences = occurrenceCountByValue[value];
            if (occurrences >= 2) {
                roundScore += value * occurrences;
            }
        }
        return roundScore;
    }

    private void displayDiceValues(int[] diceValues) {
        for (int i = 0; i < diceValues.length; i++) {
            int drawableId = DICE_FACE_DRAWABLES[diceValues[i] - MIN_DIE_VALUE];
            diceImageViews[i].setImageResource(drawableId);
        }
    }

    private void resetDiceImages() {
        for (ImageView diceImageView : diceImageViews) {
            diceImageView.setImageResource(R.drawable.question);
        }
    }
}