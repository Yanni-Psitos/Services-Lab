package ypsitos.servicesmusichotify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     
                 @Override
         protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);
         
                        // NotificationCompat.Builder builder = NotificationCompat
                         
                                 
                                                 Button playButton = (Button)findViewById(R.id.play_button);
                 playButton.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                                 Intent play = new Intent(MainActivity.this,MusicPlayer.class);
                                 play.putExtra("PLAY", true);
                                 startService(play);
                             }
                     });
                 Button pauseButton = (Button)findViewById(R.id.pause_button);
                 pauseButton.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                                 Intent pause = new Intent(MainActivity.this,MusicPlayer.class);
                                 pause.putExtra("PLAY", false);
                                 startService(pause);
                             }
                     });
                 Button stopButton =(Button)findViewById(R.id.stop_button);
                 stopButton.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                                 Intent stop = new Intent(MainActivity.this,MusicPlayer.class);
                                 stopService(stop);
                             }
                     });
         
                     }
     }
