package com.example.android.tabletennisscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int ScoreA = 0;
    int ScoreB = 0;
    int SetsA = 0;
    int SetsB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Increase the score for Player A by 1 point.
     */
    public void addpointPlayerA(View v) {
        ScoreA = ScoreA +1;
        displayForPlayerA(ScoreA);
        if ((ScoreA >=11) && ((ScoreA - ScoreB) >=2)) {
            SetsA = SetsA + 1;
            ScoreA = 0;
            ScoreB = 0;
            displayForSetsA(SetsA);
            displayForPlayerA(ScoreA);
            displayForPlayerB(ScoreB);

            }
            if ((SetsA >=3)) {
                String WinnerMessage = "Player A wins!:)";
                DisplayWinnerMessageA(WinnerMessage);
            }


        }
    public void DisplayWinnerMessageA(String WinnerMessage) {
        TextView scoreView = (TextView) findViewById(R.id.SetsA);
        scoreView.setText(WinnerMessage);
    }
    public void DisplayWinnerMessageB(String WinnerMessage) {
        TextView scoreView = (TextView) findViewById(R.id.SetsB);
        scoreView.setText(WinnerMessage);

 }

    private void displayForSetsA(int setsA) {
        TextView scoreView = (TextView) findViewById(R.id.SetsA);
        scoreView.setText(String.valueOf(setsA));

    }
    private void displayForSetsB(int setsB) {
        TextView scoreView = (TextView) findViewById(R.id.SetsB);
        scoreView.setText(String.valueOf(setsB));
    }


    /**
     * Displays the given score for Player A.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreA);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Increase the score for Player B by 1 point.
     */
    public void addpointPlayerB(View v) {
        ScoreB = ScoreB + 1;
        displayForPlayerB(ScoreB);
        if ((ScoreB >= 11) && ((ScoreB - ScoreA) >= 2)) {
            SetsB = SetsB + 1;
            ScoreA = 0;
            ScoreB = 0;
            displayForSetsB(SetsB);
            displayForPlayerA(ScoreA);
            displayForPlayerB(ScoreB);
        }
        if ((SetsB >=3)) {
            String WinnerMessage = "Player B wins!:)";
            DisplayWinnerMessageB(WinnerMessage);
        }
    }



    /**
     * Displays the given score for Player B.
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.ScoreB);
        scoreView.setText(String.valueOf(score));
    }
    public void resetTheScores(View v){
        SetsA = 0;
        SetsB = 0;
        ScoreA = 0;
        ScoreB = 0;
        displayForSetsA(SetsA);
        displayForSetsB(SetsB);
        displayForPlayerA(ScoreA);
        displayForPlayerB(ScoreB);

    }
    }
