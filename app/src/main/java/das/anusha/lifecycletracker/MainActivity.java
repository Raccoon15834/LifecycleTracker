package das.anusha.lifecycletracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SharedPreferences.Editor myNums;
    String prefTag = "das.anusha.lifecycleTracker.myNums";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences myNumSaves = getSharedPreferences(prefTag, Context.MODE_PRIVATE);
        myNums = myNumSaves.edit(); //make sure to apply putINts


    }
}

//P3L05aDasAnushaLifecycle.apk
//Video, main activity java
//embellish- new apk and video

//reset
//Create and Use a Custom Class with an appropriate name to store your variables (use alt+insert to generate getters and setters)
//Converting lists of objects
//Using GSON/JSON to convert object to String

