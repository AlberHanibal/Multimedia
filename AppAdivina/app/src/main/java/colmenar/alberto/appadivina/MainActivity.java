package colmenar.alberto.appadivina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numeroOculto = 37;
    private int numeroJugado;
    EditText et = null;
    TextView textoIzq = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //elegir numero
        //Random dado = new Random();
        //int numeroOculto = dado.nextInt(100) + 1;
        et = (EditText) findViewById(R.id.cajaTexto);
        textoIzq = (TextView) findViewById(R.id.textoIzq);
        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == keyEvent.ACTION_DOWN) && (keyCode == keyEvent.KEYCODE_ENTER)) {
                    probar(v);
                    return true;
                } else return false;
            }
        });
    }

    public void probar(View v) {
        String mensaje;
        String mensajeFinal;
        numeroJugado = Integer.parseInt(et.getText().toString());
        if (numeroJugado < numeroOculto) {
            mensaje = getResources().getString(R.string.textoMenor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else if (numeroJugado > numeroOculto) {
            mensaje = getResources().getString(R.string.textoMayor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else {
            mensajeFinal = getResources().getString(R.string.textoAcierto);
        }
        textoIzq.setText(mensajeFinal);
        et.setText("");
    }
}