package xz.sean.mr_all_wise;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PilgrimageActivity extends AppCompatActivity {
    private TextView scoreText;
    private int score;
    private int modeId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilgrimage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //setScore
        scoreText=(TextView) findViewById(R.id.score);
        score = Integer.parseInt(scoreText.getText().toString());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScore(modeId);
            }
        });
    }

    private void addScore(int ModeId){
        int deltaScore = (int) (Math.pow(-1,ModeId)*10* Math.random());
        score += deltaScore;
        String toastText = "";
        if (ModeId == 0){
            toastText="增加了"+deltaScore+"分!";
        }else {
            toastText="减少了"+deltaScore+"分!";
        }
        Toast.makeText(PilgrimageActivity.this,toastText,Toast.LENGTH_SHORT).show();
        scoreText.setText(score+"");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pilgrimage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.action_reverse:
                String toastText="";
                if (modeId==0){
                    modeId = 1;
                    toastText="进入反奶模式！";
                }else {
                    modeId = 0;
                    toastText="进入加分模式！";
                }
                Toast.makeText(PilgrimageActivity.this,toastText,Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
