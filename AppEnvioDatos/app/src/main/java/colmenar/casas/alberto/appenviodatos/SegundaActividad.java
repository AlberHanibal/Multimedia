package colmenar.casas.alberto.appenviodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        String nombreRecibido = getIntent().getStringExtra("nombre");
        TextView saludo = (TextView) findViewById(R.id.textoSaludar);
        String s = getResources().getString(R.string.textoSegunda);
        saludo.setText(String.format(s, nombreRecibido));

        Button botonRespuesta = (Button) findViewById(R.id.botonRespuesta);
        botonRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                darRespuesta();
            }
        });
    }

    public void darRespuesta() {
        EditText cajaRespuesta = (EditText) findViewById(R.id.cajaRespuesta);
        String respuesta = cajaRespuesta.getText().toString();
        Intent datos = new Intent();
        datos.putExtra("respuesta", respuesta);
        setResult(RESULT_OK, datos);
        finish();
    }
}