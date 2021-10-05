package das.anusha.lifecycletracker;

import android.content.SharedPreferences;
import android.widget.TextView;

public class dataCount {
    private String myLbl1, myLbl2;
    private int count1 = 0;
    private int count2 = 0;
    private TextView lifeText, runText;
    private SharedPreferences lifeSaves;
    private SharedPreferences.Editor editSaves;

    public dataCount(String myLbl1, String myLbl2, SharedPreferences lifeSaves) {
        this.myLbl1 = myLbl1; //also key for shared prefs
        this.myLbl2 = myLbl2;
        this.lifeSaves = lifeSaves;
        editSaves = lifeSaves.edit();
    }

    public String getMyLbl1() {
        return myLbl1 + lifeSaves.getInt(myLbl1, 0);
    }
    public String getMyLbl2() {
        return myLbl2 + count2;
    }


    public String incrCount1() {
        count1 = lifeSaves.getInt(myLbl1, 0)+1;
        editSaves.putInt(myLbl1, count1);
        editSaves.apply();
        return myLbl1 + count1;
    }

    public String incrCount2() {
        this.count2 = count2+1;
        return myLbl2 + count2;
    }
    public void resetLife(){
        count1=0;
        editSaves.putInt(myLbl1, 0);
        editSaves.apply();
    }
    public void resetRun(){
        count2=0;
    }
}
