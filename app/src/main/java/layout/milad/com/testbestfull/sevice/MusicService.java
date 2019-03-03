package layout.milad.com.testbestfull.sevice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import layout.milad.com.testbestfull.activity.ListOfSongsActivity;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(ListOfSongsActivity.absolutePath);
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
            Log.i("show", "Error: " + e.toString());
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
