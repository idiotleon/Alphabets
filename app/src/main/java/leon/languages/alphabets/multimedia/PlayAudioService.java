package leon.languages.alphabets.multimedia;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import leon.languages.alphabets.others.CommonConstants;
import leon.languages.alphabets.R;

public class PlayAudioService extends Service {
    private static final String LOG_TAG = PlayAudioService.class.getSimpleName();

    private MediaPlayer mediaPlayer;
    private int audioUrl;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(LOG_TAG, "PlayAudioService onCreate().");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        audioUrl = intent.getIntExtra(CommonConstants.ITEM_SELECTED_AUDIO_URL, R.raw.hindi_k);
        mediaPlayer = MediaPlayer.create(this, audioUrl);
        mediaPlayer.start();
        Log.v(LOG_TAG, "Media Player started.");
        if (mediaPlayer.isLooping() != true) {
            Log.e(LOG_TAG, "Problem in Playing audio");
        }
        return 1;
    }

    public void onStop() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void onPause() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

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
