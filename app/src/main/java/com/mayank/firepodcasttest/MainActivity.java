package com.mayank.firepodcasttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    FirebaseStorage storage;
    StorageReference storageRef;
    StorageReference pathRef;
    TextView tv1;
    TextView tv2;
    Handler handler;
    TextView tv3;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListeners();

    }

    private void initListeners() {

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://firebasestorage.googleapis.com/v0/b/firepodcasttest.appspot.com/o/Audio%2FBECHARA%20RIBBON.mp3?alt=media&token=2ab40d7a-beb0-48e5-b5da-92a970bc43d2";
                if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=null;
                    }
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Buffering");
                progressDialog.show();
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressDialog.dismiss();
                        mediaPlayer.start();
                        seekBar.setMax(mediaPlayer.getDuration());
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(mediaPlayer!=null)
                                {
                                    int pos=mediaPlayer.getCurrentPosition();
                                    seekBar.setProgress(pos);
                                }
                                handler.postDelayed(this,200);
                            }
                        });

                    }
                });

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://firebasestorage.googleapis.com/v0/b/firepodcasttest.appspot.com/o/Audio%2FHAATHI%20AUR%20CHOOHE.mp3?alt=media&token=43325f6f-0052-4cce-b0c8-bca4e36536e3";

                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Buffering");
                progressDialog.show();
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressDialog.dismiss();
                        mediaPlayer.start();
                        seekBar.setMax(mediaPlayer.getDuration());
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(mediaPlayer!=null)
                                {
                                    int pos=mediaPlayer.getCurrentPosition();
                                    seekBar.setProgress(pos);
                                }
                                handler.postDelayed(this,200);
                            }
                        });

                    }
                });

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://firebasestorage.googleapis.com/v0/b/firepodcasttest.appspot.com/o/Audio%2FHow%20to%20tell%20a%20true%20princess%20edited%20version.mp3?alt=media&token=7c173ab7-5e3c-4cea-8614-b007e6b1dec2";
                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;
                }
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Buffering");
                progressDialog.show();
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressDialog.dismiss();
                        mediaPlayer.start();
                        seekBar.setMax(mediaPlayer.getDuration());
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(mediaPlayer!=null)
                                {
                                    int pos=mediaPlayer.getCurrentPosition();
                                    seekBar.setProgress(pos);
                                }
                                handler.postDelayed(this,200);
                            }
                        });

                    }
                });

            }
        });




    }

    private void initData() {
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        handler=new Handler();
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void initView() {
        tv1=findViewById(R.id.tvAudio1);
        tv2=findViewById(R.id.tvAudio2);
        tv3=findViewById(R.id.tvAudio3);
        seekBar=findViewById(R.id.pbProgressBar);
    }
}
