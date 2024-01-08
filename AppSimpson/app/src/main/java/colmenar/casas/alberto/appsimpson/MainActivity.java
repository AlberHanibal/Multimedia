package colmenar.casas.alberto.appsimpson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    String[] titulos;
    String[] descripciones;
    int[] imagenes = {R.drawable.hommer, R.drawable.marge, R.drawable.bart3, R.drawable.lisa, R.drawable.magie};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        titulos = res.getStringArray(R.array.titulo);
        descripciones = res.getStringArray(R.array.descripcion);
        lista=(ListView) findViewById(R.id.lista);
        ListaAdapter adapter = new ListaAdapter(this, titulos, imagenes, descripciones);
        lista.setAdapter(adapter);
    }
}