package colmenar.casas.alberto.appenviodatos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SECONDARY_ACTIVITY_TAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saludar();
            }
        });
    }

    public void saludar() {
        EditText tx = (EditText) findViewById(R.id.cajaNombre);
        String texto = tx.getText().toString();
        if (texto.isEmpty()) {
            Toast toast = Toast.makeText(this, R.string.textoAlerta, Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent i = new Intent(this, SegundaActividad.class);
            i.putExtra("nombre", texto);
            startActivityForResult(i, SECONDARY_ACTIVITY_TAG);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String respuesta;
        if ((resultCode == RESULT_CANCELED) || (data.getStringExtra("respuesta").isEmpty())) {
            respuesta = getResources().getString(R.string.textoAlerta2);
        } else {
            respuesta = data.getStringExtra("respuesta");
        }
        Context contexto = getApplicationContext();
        Toast.makeText(contexto, respuesta, Toast.LENGTH_LONG).show();
    }
}