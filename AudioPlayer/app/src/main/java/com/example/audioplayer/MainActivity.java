package com.example.audioplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button platButton;
    private SeekBar positionBar,volumeBar;
    private TextView elapsedTimeLable,remainingTimeLable;
    private MediaPlayer mediaPlayer;
    private int totalTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        platButton=(Button) findViewById (R.id.playB);
        elapsedTimeLable=(TextView) findViewById (R.id.elapsedTimeLabel);
        remainingTimeLable=(TextView) findViewById (R.id.remainingTimeLabel);

        mediaPlayer= MediaPlayer.create (R.raw.files);
        mediaPlayer.setLooping (true);
        mediaPlayer.seekTo (0);
        mediaPlayer.setVolume (0.5f,0.5f);
        totalTime=mediaPlayer.getDuration ();
        positionBar=(SeekBar)findViewById (R.id.positionBar);
        positionBar.setMax (totalTime);
        positionBar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener ( ) {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo (progress);
                    positionBar.setProgress (progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        volumeBar=(SeekBar)findViewById (R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener ( ) {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNumber=progress/100f;
                mediaPlayer.setVolume (volumeNumber,volumeNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Thread (new Runnable ( ) {
            @Override
            public void run() {
                while (mediaPlayer!=null){
                    try
                    {
                        Message message=new Message ();
                        message.what=mediaPlayer.getCurrentPosition ();
                    }catch (InterruptedException e){

                    }
                }
            }
        })


    }
    private Handler handler=new Handler()
    {
        @Override
        public  void handleMessage(Message message)
        {
            int currentposition=message.what;
            positionBar.setProgress (currentposition);

            String elapsedTime=createTimeLable (currentposition);
            elapsedTimeLable.setText(elapsedTime);
            String remainingTime=createTimeLable (totalTime-currentposition);
            remainingTimeLable.setText ("-"+remainingTime);
        }
    };
    public String createTimeLable(int time){
        String timelable="";
        int min=time/1000/60;
        int sec=time/1000%60;
        timelable=min+":";
        if (sec<10)
            timelable+="0";
        timelable+=sec;
        return
                 timelable;



    }

public void playBtnClick(View view){
        if (!mediaPlayer.isPlaying ()){
            mediaPlayer.start ();
            platButton.setBackgroundResource (R.drawable.song);
        }
}
}
