package colmenar.alberto.appradiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void botonAceptar(View v) {
        RadioGroup opciones = (RadioGroup) findViewById(R.id.radioGroup);
        TextView textoRespuesta = (TextView) findViewById(R.id.textoRespuesta);
        System.out.println(R.id.radio1);
        System.out.println(opciones.getCheckedRadioButtonId());
        int opcionDada = opciones.getCheckedRadioButtonId();
        if (opcionDada == R.id.radio1) {
            textoRespuesta.setText(R.string.respAndroid);
        } else if (opcionDada == R.id.radio2) {
            textoRespuesta.setText(R.string.respIos);
        } else if (opcionDada == R.id.radio3) {
            textoRespuesta.setText(R.string.respWindows);
        } else if (opcionDada == R.id.radio4) {
            textoRespuesta.setText(R.string.respSimbian);
        } else if (opcionDada == R.id.radio5) {
            textoRespuesta.setText(R.string.respOtros);
        }
    }
}