package colmenar.casas.alberto.appanimacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    Animation rotacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imagen);
    }

    public void clickRotacion(View v) {
        rotacion = AnimationUtils.loadAnimation(this, R.anim.tween);
        rotacion.reset();
        imagen.startAnimation(rotacion);
    }

    public void clickTraslate(View v) {
        rotacion = AnimationUtils.loadAnimation(this, R.anim.translate);
        rotacion.reset();
        imagen.startAnimation(rotacion);
    }

    public void clickEscala(View v) {
        rotacion = AnimationUtils.loadAnimation(this, R.anim.escala);
        rotacion.reset();
        imagen.startAnimation(rotacion);
    }

    public void clickMezcla(View v) {
        rotacion = AnimationUtils.loadAnimation(this, R.anim.mezcla);
        rotacion.reset();
        imagen.startAnimation(rotacion);
    }
}