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
    // logo, icono
    // añadir sonido ambiente de biblioteca con botón de stop y play que cambie la imagen
    // añadir a la BD imagen en URL, modificar la clase libro para imagen, sinopsis, etc
    // lista de libros como https://www.google.com/search?q=interfaz+biblioteca&tbm=isch&ved=2ahUKEwjW1Zi8pvODAxUbfqQEHbHpADkQ2-cCegQIABAA&oq=interfaz+biblioteca&gs_lcp=CgNpbWcQAzoFCAAQgAQ6CggAEIAEEIoFEEM6BggAEAgQHjoGCAAQBxAeUKUPWJgbYPIbaABwAHgAgAFyiAGEB5IBAzUuNJgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=wJSvZdb1HZv8kdUPsdODyAM&bih=739&biw=1600&rlz=1C1GCEU_esES1075ES1075#imgrc=hcqlJ5WK5cxRqM
        // con info (?) o al click de la imagen nueva información
    //

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

    }
}
