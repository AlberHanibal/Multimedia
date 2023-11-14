package colmenar.casas.alberto.appsalvarinstancia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int valor = 0;
    TextView texto;
    private final static String VALOR_GUARDADO = "valor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.textView);

        if (savedInstanceState != null) {
            valor = savedInstanceState.getInt(VALOR_GUARDADO);
            texto.setText(String.valueOf(valor));
        } else {
            texto.setText(R.string.valorInicial);
        }
    }

    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt(VALOR_GUARDADO, valor);
    }
    public void sumarUno (View v) {
        valor++;
        texto.setText(String.valueOf(valor));
    }

    public void restarUno (View v) {
        valor--;
        texto.setText(String.valueOf(valor));
    }
}