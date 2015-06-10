package com.aliworld.counter;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button bAddOne,bReset,bSub;
    private TextView tv,totalClk;
    static int counter=0;
    private Handler handler=new Handler();
    static int totalClick=0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Total number of clicks
        
        totalClick=0;

        bAddOne=(Button)findViewById(R.id.bAdd);
        bReset=(Button)findViewById(R.id.bReset);
        bSub=(Button)findViewById(R.id.bSub);
        tv=(TextView)findViewById(R.id.textView);
        totalClk=(TextView)findViewById(R.id.textView2);

        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.ring);

        bAddOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                handler.postDelayed(runnable,100);

                return false;
            }
        });

        bAddOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP)
                    //mediaPlayer.release();
                    handler.removeCallbacks(runnable);
                return false;
            }
        });

        bAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                totalClick++;
                mediaPlayer.start();
                tv.setText(""+counter);
                totalClk.setText(""+totalClick);
            }
        });


        bSub.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                handler.postDelayed(runnable1,100);

                return false;
            }
        });

        bSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP)
                    //mediaPlayer.release();
                    handler.removeCallbacks(runnable1);
                return false;
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                totalClick++;
                mediaPlayer.start();
                tv.setText(""+counter);
                totalClk.setText(""+totalClick);
            }
        });



        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter = 0;
                totalClick++;
                mediaPlayer.start();
                tv.setText(""+counter);
                totalClk.setText(""+totalClick);

            }
        });



    }


    private Runnable runnable=new Runnable() {
        @Override
        public void run() {

            counter++;
            mediaPlayer.start();
            tv.setText(""+counter);
            Log.i("","Value of Counter "+counter);
            handler.postDelayed(this,100);

        }
    };


    private Runnable runnable1=new Runnable() {
        @Override
        public void run() {

            counter--;
            mediaPlayer.start();
            tv.setText(""+counter);
            Log.i("","Value of Counter "+counter);
            handler.postDelayed(this,100);

        }
    };



}
