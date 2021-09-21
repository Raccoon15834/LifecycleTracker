package das.anusha.lifecycletracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences.Editor myNums;
    SharedPreferences myNumSaves;
    String prefTag = "das.anusha.lifecycleTracker.myNums";
    TextView onDestroyLbl2, onCreateLbl1;
    TextView onCreateLbl2, onStartLbl1;
    TextView onStartLbl2, onResumeLbl1;
    TextView onResumeLbl2, onPauseLbl1;
    TextView onPauseLbl2, onStopLbl1;
    TextView onStopLbl2, onRestartLbl1;
    TextView onRestartLbl2, onDestroyLbl1;
    int onCreateRunNum = 0;
    int onStartRunNum = 0;
    int onResumeRunNum = 0;
    int onPauseRunNum = 0;
    int onStopRunNum = 0;
    int onRestartRunNum = 0;
    int onDestroyRunNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNumSaves = getSharedPreferences(prefTag, Context.MODE_PRIVATE);
        myNums = myNumSaves.edit(); //make sure to apply putINts

        onCreateLbl1 = findViewById(R.id.onCreateLbl1);
        onCreateLbl1.setText("App created: "+ myNumSaves.getInt("onCreateLife", 0));
        onStartLbl1 = findViewById(R.id.onStartLbl1);
        onStartLbl1.setText("App started: "+ myNumSaves.getInt("onStartLife", 0));
        onResumeLbl1 = findViewById(R.id.onResumeLbl1);
        onResumeLbl1.setText("App resumed: "+ myNumSaves.getInt("onResumeLife", 0));
        onPauseLbl1 = findViewById(R.id.onPauseLbl1);
        onPauseLbl1.setText("App paused: "+ myNumSaves.getInt("onPauseLife", 0));
        onStopLbl1 = findViewById(R.id.onStopLbl1);
        onStopLbl1.setText("App stopped: "+ myNumSaves.getInt("onStopLife", 0));
        onRestartLbl1 = findViewById(R.id.onRestartLbl1);
        onRestartLbl1.setText("App restarted: "+ myNumSaves.getInt("onRestartLife", 0));
        onDestroyLbl1 = findViewById(R.id.onDestroyLbl1);
        onDestroyLbl1.setText("App destroyed: "+ myNumSaves.getInt("onDestroyLife", 0));
        onCreateLbl2 = findViewById(R.id.onCreateLbl2);
        onCreateLbl2.setText("onCreate this run: " +onCreateRunNum);
        onStartLbl2 = findViewById(R.id.onStartLbl2);
        onStartLbl2.setText("onStart this run: " +onStartRunNum);
        onResumeLbl2 = findViewById(R.id.onResumeLbl2);
        onResumeLbl2.setText("onResume this run: " +onResumeRunNum);
        onPauseLbl2 = findViewById(R.id.onPauseLbl2);
        onPauseLbl2.setText("onPause this run: " +onPauseRunNum);
        onStopLbl2 = findViewById(R.id.onStopLbl2);
        onStopLbl2.setText("onStop this run: " +onStopRunNum);
        onRestartLbl2 = findViewById(R.id.onRestartLbl2);
        onRestartLbl2.setText("onRestart this run: " +onRestartRunNum);
        onDestroyLbl2 = findViewById(R.id.onDestroyLbl2);
        onDestroyLbl2.setText("onDestroy this run: " +onDestroyRunNum);

        int newInt = myNumSaves.getInt("onCreateLife", 0)+1;
        myNums.putInt("onCreateLife", newInt);
        myNums.apply();
        onCreateRunNum++;
        onCreateLbl1.setText("App created: "+ newInt);
        onCreateLbl2.setText("onCreate this run: "+ onCreateRunNum);
    }

    @Override
    protected void onStart() {
        super.onStart();
        int newInt = myNumSaves.getInt("onStartLife", 0)+1;
        myNums.putInt("onStartLife", newInt);
        myNums.apply();
        onStartRunNum++;
        onStartLbl1.setText("App started: "+ newInt);
        onStartLbl2.setText("onStart this run: "+ onStartRunNum);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int newInt = myNumSaves.getInt("onResumeLife", 0)+1;
        myNums.putInt("onResumeLife", newInt);
        myNums.apply();
        onResumeRunNum++;
        onResumeLbl1.setText("App resumed: "+ newInt);
        onResumeLbl2.setText("onResume this run: "+ onResumeRunNum);
    }
    protected void onPause() {
        super.onPause();
        int newInt = myNumSaves.getInt("onPauseLife", 0)+1;
        myNums.putInt("onPauseLife", newInt);
        myNums.apply();
        onPauseRunNum++;
        onPauseLbl1.setText("App paused: "+ newInt);
        onPauseLbl2.setText("onPause this run: "+ onPauseRunNum);
    }
    protected void onStop() {
        super.onStop();
        int newInt = myNumSaves.getInt("onStopLife", 0)+1;
        myNums.putInt("onStopLife", newInt);
        myNums.apply();
        onStopRunNum++;
        onStopLbl1.setText("App stopped: "+ newInt);
        onStopLbl2.setText("onStop this run: "+ onStopRunNum);
    }
    protected void onRestart() {
        super.onRestart();
        int newInt = myNumSaves.getInt("onRestartLife", 0)+1;
        myNums.putInt("onRestartLife", newInt);
        myNums.apply();
        onRestartRunNum++;
        onRestartLbl1.setText("App restarted: "+ newInt);
        onRestartLbl2.setText("onRestart this run: "+ onRestartRunNum);
    }

    @Override
    public boolean isDestroyed() {
        int newInt = myNumSaves.getInt("onDestroyLife", 0)+1;
        myNums.putInt("onDestroyLife", newInt);
        myNums.apply();
        return super.isDestroyed();
    }


    public void lifeReset(View view) {
       myNums.putInt("onCreateLife", 0);
       onCreateLbl1.setText("App created: "+0);
       myNums.putInt("onStartLife", 0);
       onStartLbl1.setText("App started: "+0);
       myNums.putInt("onResumeLife", 0);
       onResumeLbl1.setText("App resumed: "+0);
       myNums.putInt("onPauseLife", 0);
       onPauseLbl1.setText("App paused: "+0);
       myNums.putInt("onStopLife", 0);
       onStopLbl1.setText("App stopped: "+0);
       myNums.putInt("onRestartLife", 0);
       onRestartLbl1.setText("App restarted: "+0);
       myNums.putInt("onDestroyLife", 0);
       onDestroyLbl1.setText("App destroyed: "+0);

    }

    public void runReset(View view) {
        onCreateRunNum = 0;
        onCreateLbl2.setText("onCreate this run: "+0 );
        onStartRunNum = 0;
        onStartLbl2.setText("onStart this run: "+0 );
        onResumeRunNum = 0;
        onResumeLbl2.setText("onResume this run: "+0 );
        onPauseRunNum = 0;
        onPauseLbl2.setText("onPause this run: "+0 );
        onStopRunNum = 0;
        onStopLbl2.setText("onStop this run: "+0 );
        onRestartRunNum = 0;
        onRestartLbl2.setText("onRestart this run: "+0 );
        onDestroyRunNum = 0;
        onDestroyLbl2.setText("onDestroy this run: "+0 );
    }
}

//P3L05aDasAnushaLifecycle.apk
//Video, main activity java
//embellish- new apk and video

//reset
//Create and Use a Custom Class with an appropriate name to store your variables (use alt+insert to generate getters and setters)
//Using GSON/JSON to convert object to String




