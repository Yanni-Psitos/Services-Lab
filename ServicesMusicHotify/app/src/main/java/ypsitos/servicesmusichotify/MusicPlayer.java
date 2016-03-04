package ypsitos.servicesmusichotify;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by YPsitos on 3/4/16.
 */
public class MusicPlayer extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
        
            MediaPlayer player;
            Thread thread;
        
            public MusicPlayer() {
        
        
            }
        
            @Override
    public IBinder onBind(Intent intent) {
                throw new UnsupportedOperationException("Not current.");
            }
        
            @Override
    public void onCreate() {
                super.onCreate();
                String url = "http://download.lisztonian.com/music/download/ClairdeLune-113.mp3";
                player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.prepareAsync();
        
                player.setOnPreparedListener(this);
                player.setOnCompletionListener(this);
        
            }
        
            @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
                Runnable runnable = new Runnable() {
                    @Override
            public void run() {
                        player.start();
                    }
                };
                thread = new Thread(runnable);
                if (intent.getBooleanExtra("PLAY",false)) {
                    Log.i("MUSIC", "PLAY");
                    thread.start();
                }
                else {
                    Log.i("MUSIC","PAUSE");
                    player.pause();
                }
                return super.onStartCommand(intent, flags, startId);
            }
        
            @Override
    public void onCompletion(MediaPlayer mp) {
                    onDestroy();
            }
        
            @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        
            @Override
    public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        
        
        
            @Override
    public void onDestroy() {
                super.onDestroy();
               player.release();
        
            }
        }
