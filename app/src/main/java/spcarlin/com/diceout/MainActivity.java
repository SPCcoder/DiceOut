package spcarlin.com.diceout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView rollResult;
    Button rollButton;

    ArrayList<ImageView> diceImageViews;
    //field to hold the score
    int score;
    Random rand;

    int die1;
    int die2;
    int die3;

    ArrayList<Integer> dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        score = 0;

        rollResult = (TextView) findViewById(R.id.rollResult); // R refers to project
        rollButton = (Button)findViewById(R.id.rollButton);

        rand = new Random();

        dice = new ArrayList<Integer>();

        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);
        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);

        //create toast
        Toast.makeText(getApplicationContext(), "Welcome to Diceout!",Toast.LENGTH_SHORT).show();
    }

    public void rollDice(View view) {
        rollResult.setText("Clicked");
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        //clear array
        dice.clear();

        dice.add(die1);
        dice.add(die2);
        dice.add(die3);


        String mesg = "You rolled a " + die1 + ", a " + die2 + ", and a " + die3;

        rollResult.setText(mesg);

        ImageView diceImg1 = (ImageView) findViewById(R.id.die1Image);
        ImageView diceImg2 = (ImageView) findViewById(R.id.die2Image);
        ImageView diceImg3 = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(diceImg1);
        diceImageViews.add(diceImg2);
        diceImageViews.add(diceImg3);

        //int num = rand.nextInt(6)+1;
        //String randomValue = "Number generated: " + num;
        //Toast.makeText(getApplicationContext(), randomValue, Toast.LENGTH_SHORT).show();
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
}
