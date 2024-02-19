package colmenar.casas.alberto.appbdlibros;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Portada extends AppCompatActivity {
    AnimationDrawable animacionPaginas;
    MediaPlayer mp;
    ImageButton musica;
    VideoView video;
    ImageButton botonVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);
        ImageView imagen = findViewById(R.id.animacionLibro);
        imagen.setBackgroundResource(R.drawable.animacion);
        animacionPaginas = (AnimationDrawable) imagen.getBackground();
        animacionPaginas.start();
        TextView textoPulsa = findViewById(R.id.textoPulsa);
        AlphaAnimation anim = new AlphaAnimation(1, 0.4f);
        anim.setDuration(3000);
        anim.setRepeatCount(Animation.INFINITE);
        textoPulsa.startAnimation(anim);

        musica = findViewById(R.id.botonMusica);
        mp = MediaPlayer.create(this, R.raw.sound);
        mp.start();

        botonVideo = findViewById(R.id.botonVideo);
        video = findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        video.setVideoURI(path);

    }

    public void clickAnimacion(View v) {
        if (animacionPaginas.isRunning()) {
            animacionPaginas.stop();
        } else {
            animacionPaginas.start();
        }
    }

    public void clickSiguiente(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        mp.pause();
    }

    public void clickMusica(View v) {
        if (mp.isPlaying()) {
            mp.pause();
            musica.setImageResource(android.R.drawable.ic_media_play);
        } else {
            mp.start();
            musica.setImageResource(android.R.drawable.ic_media_pause);
        }
    }

    public void clickVideo(View v) {
        if (mp.isPlaying()) {
            clickMusica(v);
        }
        if (video.isPlaying()) {
            video.pause();
            video.setVisibility(View.INVISIBLE);
            botonVideo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.primario)));
        } else {
            video.setVisibility(View.VISIBLE);
            video.start();
            botonVideo.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.secundario)));

        }

    }
}
