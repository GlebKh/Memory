package ru.glebproject.itschool.samsung.memory;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class ClassicalActivity extends AppCompatActivity {
    private int pic[];
    ImageButton button1;
    ImageButton button2;
    int b1_id;
    int b2_id;
    private int buttons[];
    int turn = 0;


    static String timeValue;
    static TextView turns;
    static TextView time;

    private Timer myTimer;
    private MyTimerTask myTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        pic = mas(12);
        pic = random(12);
        //print(pic, 12);
        button1 = null;
        button2 = null;
        buttons = buttons_checker();
        turns = (TextView)this.findViewById(R.id.turns_value);
        time = (TextView)this.findViewById(R.id.time_value);
        /*myTimer = new Timer();
        myTimerTask = new MyTimerTask();
        myTimer.schedule(myTimerTask, 0, 1000);*/

    }

    static void changeTimeValue(String s){
        timeValue = s;
        timeChange(s);
    }

    static void timeChange(String s){
        time.setText(s);
    }

    public void restart(View v){
        pic = mas(12);
        pic = random(12);
        //print(pic, 12);
        button1 = null;
        button2 = null;
        buttons = buttons_checker();
        for(int i = 0; i < 12; i++){
            ImageButton button = (ImageButton)this.findViewById(buttons[i]);
            button.setImageResource(R.drawable.oblozhka);
            button.setClickable(true);
        }
        turn = 0;
        turns.setText("" + turn);
        TextView win = (TextView)this.findViewById(R.id.win);
        win.setText("");
    }

    public void onClick(View v) {
        if(button1 == null){
            button1 = (ImageButton) v;
            int id1 = button1.getId();
            b1_id = searchButtons(id1);
            //Toast.makeText(ClassicalActivity.this, "" + pic[b1_id], Toast.LENGTH_SHORT).show();
            if(b1_id != -1) openButton(button1, pic[b1_id]);
                else Toast.makeText(ClassicalActivity.this, "Can't find button", Toast.LENGTH_LONG);
        } else {
            button2 = (ImageButton) v;
            int id2 = button2.getId();
            b2_id = searchButtons(id2);
            //Toast.makeText(ClassicalActivity.this, "" + pic[b2_id], Toast.LENGTH_SHORT).show();
            if(b2_id != -1) openButton(button2, pic[b2_id]);
                else Toast.makeText(ClassicalActivity.this, "Can't find button", Toast.LENGTH_LONG);

            if(pic[b1_id] == pic[b2_id]){
                //Toast.makeText(ClassicalActivity.this, "Right", Toast.LENGTH_SHORT).show();

                button1.setClickable(false);
                button2.setClickable(false);

                button1 = null;
                button2 = null;

                pic[b1_id] = -1;
                pic[b2_id] = -1;

                //print(pic, 12);
            } else {
                //Toast.makeText(ClassicalActivity.this, "Wrong", Toast.LENGTH_SHORT).show();

                setButtonsNotClickable();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        closeButton(button1);
                        closeButton(button2);
                        button1 = null;
                        button2 = null;
                        setButtonsClickable();
                    }
                }, 1700);

            }

            turn++;
            turns.setText("" + turn);
            if(win()){
                //Toast.makeText(ClassicalActivity.this, "You Win!", Toast.LENGTH_SHORT).show();
                TextView t = (TextView)this.findViewById(R.id.win);
                t.setText("You Win!");

            }
        }
    }

    private void setButtonsNotClickable(){
        for(int i = 0; i < 12; i++){
            ImageButton button = (ImageButton)this.findViewById(buttons[i]);
            button.setClickable(false);
        }
    }

    private void setButtonsClickable(){
        for(int i = 0; i < 12; i++){
            ImageButton button = (ImageButton)this.findViewById(buttons[i]);
            int c = searchButtons(buttons[i]);
            if(c != -1 && pic[c] != -1){
                button.setClickable(true);
            }
        }
    }

    private void openButton(ImageButton button, int n){
        switch (n){

            case 1: button.setImageResource(R.drawable.first);
                    return;
            case 2: button.setImageResource(R.drawable.second);
                    return;
            case 3: button.setImageResource(R.drawable.third);
                    return;
            case 4: button.setImageResource(R.drawable.fourth);
                    return;
            case 5: button.setImageResource(R.drawable.fifth);
                     return;
            case 6: button.setImageResource(R.drawable.sixth);
                     return;
            case 7: button.setImageResource(R.drawable.seventh);
                    return;
            case 8: button.setImageResource(R.drawable.eighth);
                    return;
            case 9: button.setImageResource(R.drawable.nineth);
                    return;

        }
    }

    private void closeButton(ImageButton button){
        button.setImageResource(R.drawable.oblozhka);
    }

    private boolean win(){


        for(int i = 0; i < 12; i++){
            if(pic[i] != -1){
                return false;
            }
        }

        return true;

    }

    private int searchButtons(int id){
        for(int i = 0; i < 12; i++){
            if(buttons[i] == id){
                return i;
            }
        }
        return -1;
    }

    private int[] buttons_checker(){
        int b[] = new int[12];

        b[0] = ((ImageButton)(this.findViewById(R.id.classical_pic0))).getId();
        b[1] = ((ImageButton)(this.findViewById(R.id.classical_pic1))).getId();
        b[2] = ((ImageButton)(this.findViewById(R.id.classical_pic2))).getId();
        b[3] = ((ImageButton)(this.findViewById(R.id.classical_pic3))).getId();
        b[4] = ((ImageButton)(this.findViewById(R.id.classical_pic4))).getId();
        b[5] = ((ImageButton)(this.findViewById(R.id.classical_pic5))).getId();
        b[6] = ((ImageButton)(this.findViewById(R.id.classical_pic6))).getId();
        b[7] = ((ImageButton)(this.findViewById(R.id.classical_pic7))).getId();
        b[8] = ((ImageButton)(this.findViewById(R.id.classical_pic8))).getId();
        b[9] = ((ImageButton)(this.findViewById(R.id.classical_pic9))).getId();
        b[10] = ((ImageButton)(this.findViewById(R.id.classical_pic10))).getId();
        b[11] = ((ImageButton)(this.findViewById(R.id.classical_pic11))).getId();

        return b;
    }

    private int[] random(int n){
        int b[] = new int[n];
        for(int i = 0; i < n; i++){
            int r = (int) (Math.random() * (n / 2 + 1));
            if(search(b, r, n) || r == 0){
                i--;
            } else {
                b[i] = r;
            }
        }
        return b;
    }

    private int[] mas(int n){
        int b[] = new int [n];
        for(int i = 0; i < n; i++){
            b[i] = -1;
        }
        return b;
    }

    private boolean search(int a[], int x, int n){
        boolean b = false;
        int c = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == x)c++;
        }
        if(c == 2)b = true;
        return b;
    }

    private void print(int b[], int n){
        TextView t = (TextView) this.findViewById(R.id.win);
        String s = "";
        for(int i = 0; i < n; i++){
            s = s + (b[i] + " ");
        }
        t.setText(s);
    }

    class MyTimerTask extends TimerTask {


        @Override
        public void run() {


            int min = 0, sec = 0;
            sec++;
            if(sec >= 60){
                sec = 0;
                min++;
            }
            if(min >= 60){
                ClassicalActivity.changeTimeValue("You Are you of time!");
            }
            String s = "";
            if(min / 10 == 0){
                s = "0" + min;
            }else{
                s = "" + min;
            }
            s += ":";
            if(sec / 10 == 0){
                s = s + "0" + sec;
            }else{
                s = s + sec;
            }
            ClassicalActivity.changeTimeValue(s);
        }
    }
}
