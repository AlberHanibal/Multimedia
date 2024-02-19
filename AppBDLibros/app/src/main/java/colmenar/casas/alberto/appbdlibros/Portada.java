package colmenar.casas.alberto.appbdlibros;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Portada extends AppCompatActivity {
    AnimationDrawable animacionPaginas;

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
    }

    public void clickMusica(View v) {
        // enchufarla de base, si se pulsa se apaga y se cambia la imagen del botón

    }

    public void clickVideo(View v) {

    }
}
