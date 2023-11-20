package colmenar.alberto.appadivina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AccionesDialogo {

    private int numeroOculto;
    private int numeroJugado;
    private int numIntentos;
    EditText et = null;
    TextView textoIzq = null;
    TextView textoIntentos = null;
    Button botonProbar = null;
    Button botonVolverAJugar = null;
    TextView textoVolverAJugar = null;
    private static final String STATE_NUM_ELEGIDO = "numeroOculto";
    private static final String STATE_NUM_INTENTOS= "numIntentos";
    private static final String STATE_MENSAJE = "mensajeFinal";
    String mensajeFinal = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.cajaTexto);
        textoIzq = (TextView) findViewById(R.id.textoIzq);
        textoIntentos = (TextView) findViewById(R.id.textoIntentos);
        botonProbar = (Button) findViewById(R.id.botonProbar);
        botonVolverAJugar = (Button) findViewById(R.id.botonVolverAJugar);
        botonVolverAJugar.setVisibility(View.INVISIBLE);
        textoVolverAJugar = (TextView) findViewById(R.id.textoVolverAJugar);
        textoVolverAJugar.setVisibility(View.INVISIBLE);
        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == android.view.KeyEvent.ACTION_DOWN) && (keyCode == android.view.KeyEvent.KEYCODE_ENTER)) {
                    probar(v);
                    return true;
                } else return false;
            }
        });
        if (savedInstanceState == null) {
            // partida de 0
            jugar();
        } else {
            numeroOculto = savedInstanceState.getInt(STATE_NUM_ELEGIDO);
            numIntentos = savedInstanceState.getInt(STATE_NUM_INTENTOS);
            if (numeroOculto == -1) {
                // partida acabada
                lanzarDialogo();
            } else {
                // partida inacabada
                textoIzq.setText(savedInstanceState.getString(STATE_MENSAJE));
                actualizarIntentos();
            }
        }
        //crearNumeroAleatorio();

    }
    private void crearNumeroAleatorio() {
        numIntentos = 0;
        Random dado = new Random();
        numeroOculto = dado.nextInt(100) + 1;
    }
    public void probar(View v) {
        String mensaje;
        numeroJugado = Integer.parseInt(et.getText().toString());
        if (numeroJugado > numeroOculto) {
            mensaje = getResources().getString(R.string.textoMenor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else if (numeroJugado < numeroOculto) {
            mensaje = getResources().getString(R.string.textoMayor);
            mensajeFinal = String.format(mensaje, numeroJugado);
        } else {
            lanzarDialogo();
            //finalPartida();
            //mensajeFinal = getResources().getString(R.string.textoAcierto);
        }
        textoIzq.setText(mensajeFinal);
        et.setText("");
        numIntentos++;
        actualizarIntentos();
    }
    private void actualizarIntentos() {
        String texto = getResources().getQuantityString(R.plurals.intentos, numIntentos, numIntentos);
        textoIntentos.setText(texto);
    }
    private void finalPartida() {
        botonVolverAJugar.setVisibility(View.VISIBLE);
        textoVolverAJugar.setVisibility(View.VISIBLE);
        et.setVisibility(View.INVISIBLE);
        botonProbar.setVisibility(View.INVISIBLE);
        textoIzq.setVisibility(View.INVISIBLE);
        textoIntentos.setVisibility(View.INVISIBLE);
    }

    public void jugar() {
        crearNumeroAleatorio();
        botonVolverAJugar.setVisibility(View.INVISIBLE);
        textoVolverAJugar.setVisibility(View.INVISIBLE);
        et.setVisibility(View.VISIBLE);
        botonProbar.setVisibility(View.VISIBLE);
        textoIzq.setVisibility(View.VISIBLE);
        textoIntentos.setVisibility(View.VISIBLE);
        textoIzq.setText(R.string.textoIzq);
        textoIntentos.setText("");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        jugar();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        finish();
        //finalPartida();
    }

    public void lanzarDialogo() {
        numeroOculto = -1;
        Dialogo dialogo = new Dialogo();
        dialogo.show(getSupportFragmentManager(), "tagDialogo");
    }

    @Override
    public void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt(STATE_NUM_ELEGIDO, numeroOculto);
        estado.putInt(STATE_NUM_INTENTOS, numIntentos);
        if (mensajeFinal.equals("")) {
            mensajeFinal = getResources().getString(R.string.textoIzq);
        }
        estado.putString(STATE_MENSAJE, mensajeFinal);
    }

}