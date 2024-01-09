package colmenar.casas.alberto.apprepvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    public VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView =(VideoView)findViewById(R.id.video);
        /*
        videoView.setVideoPath("/mnt/sdcard/movies/funnycat.mp4");
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        */
        videoView.setVideoPath("http://personales.upv.es/~jtomas/video.3gp");
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();
    }
}