package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int scoreX = 0, scoreY = 0;
    int activePlayer = 0;
    //activePlayer Meaning
    //0 -> X
    //1 -> O

    int [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //gameState Meaning
    //0 -> X
    //1 -> O
    //2 -> blank

    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};
    public void playerTap(View view){

        TextView status = findViewById(R.id.status);
        TextView scoreOfX = findViewById(R.id.scoreOfX);
        TextView scoreOfY = findViewById(R.id.scoreOfY);
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        //If someone wins
        if (!gameActive){
            gameReset(view);
        }
        //Code to animate the entrance of X and O on gamepad and change status text trunwise
        if(gameState[tappedImage] == 2 && gameActive) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                status.setText("O's Turn - Tap to Play");

            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText("X's Turn - Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check if any player has won
        for (int[] winPosition : winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2){
                //Somebody has won
                String winnerStr;
                gameActive = false;
                //If X has won
                if(gameState[winPosition[0]] == 0){
                    winnerStr = "X has Won!";
                    status.setTextSize(30);
                    status.setTextColor(Color.parseColor("#cd141c"));
                    scoreX++;
                    scoreOfX.setText(" " +scoreX);

                }
                //Else O has won
                else{
                    winnerStr = "O has Won!";
                    status.setTextSize(30);
                    status.setTextColor(Color.parseColor("#2fbbf4"));
                    scoreY++;
                    scoreOfY.setText("" + scoreY);
                }
                //Update the status for winner announcement
                status.setText(winnerStr);
                break;
            }
        }
        //If its a Draw...
        if(gameState[0] != 2 &&
                gameState[1] != 2 &&
                gameState[2] != 2 &&
                gameState[3] != 2 &&
                gameState[4] != 2 &&
                gameState[5] != 2 &&
                gameState[6] != 2 &&
                gameState[7] != 2 &&
                gameState[8] != 2 &&
                gameActive) status.setText("It\'s a Draw!");


    }

    //Function to reset the Score
    public void resetScore(View view){
        scoreX = 0;
        scoreY = 0;
        TextView scoreOfX = (TextView) findViewById(R.id.scoreOfX);
        TextView scoreOfY = (TextView) findViewById(R.id.scoreOfY);
        scoreOfX.setText("" + 0);
        scoreOfY.setText("" + 0);
    }

    //Function to reset the Gamepad
    public void gameReset(View view){

        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setTextColor(Color.parseColor("#000000"));
        status.setText("X's Turn - Tap to Play");
        gameActive = true;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}