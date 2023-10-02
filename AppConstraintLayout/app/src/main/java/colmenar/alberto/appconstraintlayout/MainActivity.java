package colmenar.alberto.appconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button botonV, botonO;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imagenAndroid);
        botonO = (Button) findViewById(R.id.botonOcultar);
        botonO.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ocultarImagen();
            }
        });
        botonV = (Button)  findViewById(R.id.botonVer);
        botonV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                verImagen();
            }
        });
    }

    private void ocultarImagen() {
        imagen.setVisibility(View.INVISIBLE);
    }
    private void verImagen() {
        imagen.setVisibility(View.VISIBLE);
    }
}