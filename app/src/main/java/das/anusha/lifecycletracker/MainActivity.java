package das.anusha.lifecycletracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences myNumSaves;
    String prefTag = "das.anusha.lifecycleTracker.myNums";
    TextView onDestroyLbl2, onCreateLbl1;
    TextView onCreateLbl2, onStartLbl1;
    TextView onStartLbl2, onResumeLbl1;
    TextView onResumeLbl2, onPauseLbl1;
    TextView onPauseLbl2, onStopLbl1;
    TextView onStopLbl2, onRestartLbl1;
    TextView onRestartLbl2, onDestroyLbl1;
    dataCount onCreateData;
    dataCount onStartData;
    dataCount onResumeData;
    dataCount onPauseData;
    dataCount onStopData;
    dataCount onRestartData;
    dataCount onDestroyData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myNumSaves = getSharedPreferences(prefTag, Context.MODE_PRIVATE);
        //initializing data classes
        onCreateData = new dataCount("Creates this life: ", "Runtime creates: ", myNumSaves);
        onStartData = new dataCount("Starts this life: ", "Runtime starts: ", myNumSaves);
        onResumeData = new dataCount("Resumes this life: ", "Runtime resumes: ", myNumSaves);
        onPauseData = new dataCount("Pauses this life: ", "Runtime pauses: ", myNumSaves);
        onStopData = new dataCount("Stops this life: ", "Runtime stops: ", myNumSaves);
        onRestartData = new dataCount("Restarts life: ", "Runtime restarts: ", myNumSaves);
        onDestroyData = new dataCount("Destroys this life: ", "Runtime destroys: ", myNumSaves);
        //initializing text views
        onCreateLbl1 = findViewById(R.id.onCreateLbl1);
        onCreateLbl2 = findViewById(R.id.onCreateLbl2);
        onStartLbl1 = findViewById(R.id.onStartLbl1);
        onStartLbl2 = findViewById(R.id.onStartLbl2);
        onResumeLbl1 = findViewById(R.id.onResumeLbl1);
        onResumeLbl2 = findViewById(R.id.onResumeLbl2);
        onPauseLbl1 = findViewById(R.id.onPauseLbl1);
        onPauseLbl2 = findViewById(R.id.onPauseLbl2);
        onStopLbl1 = findViewById(R.id.onStopLbl1);
        onStopLbl2 = findViewById(R.id.onStopLbl2);
        onRestartLbl1 = findViewById(R.id.onRestartLbl1);
        onRestartLbl2 = findViewById(R.id.onRestartLbl2);
        onDestroyLbl1 = findViewById(R.id.onDestroyLbl1);
        onDestroyLbl2 = findViewById(R.id.onDestroyLbl2);
        //setting first texts
        onCreateLbl1.setText(onCreateData.incrCount1());
        onCreateLbl2.setText(onCreateData.incrCount2());
        onStartLbl1.setText(onStartData.getMyLbl1());
        onStartLbl2.setText(onStartData.getMyLbl2());
        onResumeLbl1.setText(onResumeData.getMyLbl1());
        onResumeLbl2.setText(onResumeData.getMyLbl2());
        onPauseLbl1.setText(onPauseData.getMyLbl1());
        onPauseLbl2.setText(onPauseData.getMyLbl2());
        onStopLbl1.setText(onStopData.getMyLbl1());
        onStopLbl2.setText(onStopData.getMyLbl2());
        onRestartLbl1.setText(onRestartData.getMyLbl1());
        onRestartLbl2.setText(onRestartData.getMyLbl2());
        onDestroyLbl1.setText(onDestroyData.getMyLbl1());
        onDestroyLbl2.setText(onDestroyData.getMyLbl2());
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartLbl1.setText(onStartData.incrCount1());
        onStartLbl2.setText(onStartData.incrCount2());
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeLbl1.setText(onResumeData.incrCount1());
        onResumeLbl2.setText(onResumeData.incrCount2());
    }
    protected void onPause() {
        super.onPause();
        onPauseLbl1.setText(onPauseData.incrCount1());
        onPauseLbl2.setText(onPauseData.incrCount2());
    }
    protected void onStop() {
        super.onStop();
        onStopLbl1.setText(onStopData.incrCount1());
        onStopLbl2.setText(onStopData.incrCount2());
    }
    protected void onRestart() {
        super.onRestart();
        onRestartLbl1.setText(onRestartData.incrCount1());
        onRestartLbl2.setText(onRestartData.incrCount2());
    }

    @Override
    public boolean isDestroyed() {
        onDestroyLbl1.setText( onDestroyData.incrCount1());
        onDestroyLbl2.setText( onDestroyData.incrCount2());
        return super.isDestroyed();
    }


    public void lifeReset(View view) {
       onCreateData.resetLife();
       onStartData.resetLife();
       onResumeData.resetLife();
       onPauseData.resetLife();
       onStopData.resetLife();
       onRestartData.resetLife();
       onDestroyData.resetLife();
       onCreateLbl1.setText(onCreateData.getMyLbl1());
       onStartLbl1.setText(onStartData.getMyLbl1());
       onResumeLbl1.setText(onResumeData.getMyLbl1());
       onPauseLbl1.setText(onPauseData.getMyLbl1());
       onStopLbl1.setText(onStopData.getMyLbl1());
       onRestartLbl1.setText(onRestartData.getMyLbl1());
       onDestroyLbl1.setText(onDestroyData.getMyLbl1());
    }

    public void runReset(View view) {
        onCreateData.resetRun();
        onStartData.resetRun();
        onResumeData.resetRun();
        onPauseData.resetRun();
        onStopData.resetRun();
        onRestartData.resetRun();
        onDestroyData.resetRun();
        onCreateLbl2.setText(onCreateData.getMyLbl2());
        onStartLbl2.setText(onStartData.getMyLbl2());
        onResumeLbl2.setText(onResumeData.getMyLbl2());
        onPauseLbl2.setText(onPauseData.getMyLbl2());
        onStopLbl2.setText(onStopData.getMyLbl2());
        onRestartLbl2.setText(onRestartData.getMyLbl2());
        onDestroyLbl2.setText(onDestroyData.getMyLbl2());
    }
}

//P3L05aDasAnushaLifecycle.apk
//Video, main activity java
//embellish- new apk and video





