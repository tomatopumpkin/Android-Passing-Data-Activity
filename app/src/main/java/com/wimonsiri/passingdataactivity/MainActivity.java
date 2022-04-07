package com.wimonsiri.passingdataactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    private static final int PLAY_GAME = 1010;
    private EditText textName, textScore;
    private String playerName = "Somchai";
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = (EditText) findViewById(R.id.fieldName);
        textScore = (EditText) findViewById(R.id.fieldScore);
// display initial values
        textName.setText(playerName);
        textScore.setText(""+score);
// setup button listener
        Button startButton = (Button) findViewById(R.id.playBtn);
        startButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                startGame();
            }
        });
    }
    private void startGame() {
        Intent launchGame = new Intent(this, PlayGameActivity.class);
// passing information to launched activity
        score = Integer.parseInt(textScore.getText().toString());
        playerName = textName.getText().toString();
        launchGame.putExtra("score", score);
        launchGame.putExtra("playerName", playerName);
        startActivityForResult(launchGame, PLAY_GAME);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == PLAY_GAME) && (resultCode == RESULT_OK)) {
            score = data.getExtras().getInt("score");
            playerName = data.getExtras().getString("playerName");
// show it has changed
            textName.setText(playerName);
            textScore.setText(""+score);
        }
    }
}