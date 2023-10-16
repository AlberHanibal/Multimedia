package colmenar.alberto.appradiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup opciones;
    TextView textoRespuesta;
    CheckBox chCamara;
    CheckBox chBluetooth;
    CheckBox chSonido;
    TextView textoCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opciones = (RadioGroup) findViewById(R.id.radioGroup);
        opciones = (RadioGroup) findViewById(R.id.radioGroup);
        textoRespuesta = (TextView) findViewById(R.id.textoRespuesta);
        chCamara = (CheckBox) findViewById(R.id.checkBoxCamara);
        chBluetooth = (CheckBox) findViewById(R.id.checkBoxBluetooth);
        chSonido = (CheckBox) findViewById(R.id.checkBoxSonido);
        textoCheckbox = (TextView) findViewById(R.id.textoCheckbox);

        opciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                comprobarRadios();
            }
        });
    }

    public void botonAceptar(View v) {
        comprobarRadios();
        if (chCamara.isChecked()) {
            textoCheckbox.append("\n" + getString(R.string.textoCamara));
        }
        if (chBluetooth.isChecked()) {
            textoCheckbox.append("\n" + getString(R.string.textoBluetooth));
        }
        if (chSonido.isChecked()) {
            textoCheckbox.append("\n" + getString(R.string.textoSonido));
        }
    }
    public void comprobarRadios() {
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