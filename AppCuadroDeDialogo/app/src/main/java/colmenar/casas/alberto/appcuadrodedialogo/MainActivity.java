package colmenar.casas.alberto.appcuadrodedialogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.boton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();
            }
        });
    }

    public void mostrarDialogo() {
        Dialogo d = new Dialogo();
        d.show(getSupportFragmentManager(), "tagDialogo");
    }

    public void mostrarMensaje(Context contexto) {
        Toast toast = Toast.makeText(contexto, R.string.textoToast, Toast.LENGTH_LONG);
        toast.show();
    }
}