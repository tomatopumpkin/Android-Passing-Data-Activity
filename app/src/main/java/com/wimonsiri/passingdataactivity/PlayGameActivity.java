package com.wimonsiri.passingdataactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class PlayGameActivity extends AppCompatActivity {
    private EditText playerName, playerScore;
    int score;
    String author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        playerName = (EditText) findViewById(R.id.fieldPlayerName);
        playerScore = (EditText) findViewById(R.id.fieldPlayerScore);
// reading information passed to activity
        Intent intent = getIntent();
// return -1 if not initialized by calling activity
        score = intent.getIntExtra("score", -1);
// return [] if not initialized by calling activity
        author = intent.getStringExtra("playerName");
// display initial values
        playerName.setText(author);
        playerScore.setText( "" + score);
// setup button listener
        Button endButton = (Button) findViewById(R.id.back_button);
        endButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = getIntent();
                author = playerName.getText().toString();
                score = Integer.parseInt( playerScore.getText().toString() );
                i.putExtra("score",score);
                i.putExtra("playerName", author);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
