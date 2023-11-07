package colmenar.casas.alberto.actividadgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final double descFamiliaNum = 0.2;
    private final double descDiscapacidad = 0.3;
    private final int descTarjetaDorada = 5;
    private double precioBillete;
    private int edad;
    private double precioFinal;
    EditText cajaPrecio;
    EditText cajaEdad;
    RadioGroup radioGroup;
    CheckBox checkTarjeta;
    CheckBox checkDiscapacidad;
    TextView textoErrores;
    TextView textoCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaPrecio = (EditText) findViewById(R.id.cajaCoste);
        cajaEdad = (EditText) findViewById(R.id.cajaEdad);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkTarjeta = (CheckBox) findViewById(R.id.checkTarjeta);
        checkDiscapacidad = (CheckBox) findViewById(R.id.checkDiscapacidad);
        textoErrores = (TextView) findViewById(R.id.textoErrores);
        textoCalculo = (TextView) findViewById(R.id.textoCalculo);
    }

    // Método que calcula el precio del billete con todos sus descuentos
    public void calcular(View v) {
        textoErrores.setText("");
        textoCalculo.setText("");
        if (cajaPrecio.getText().length() != 0) {
            precioBillete = Double.parseDouble(cajaPrecio.getText().toString());
            double descuentoProvisional = 0;
            if (checkTarjeta.isChecked()) {
                if (cajaEdad.getText().length() != 0) {
                    edad = Integer.parseInt(cajaEdad.getText().toString());
                    if (edad >= 60) {
                        descuentoProvisional = descuentoProvisional + descTarjetaDorada;
                    } else {
                        textoErrores.setText(R.string.textoErrorEdad);
                        checkTarjeta.setChecked(false);
                    }
                } else {
                    textoErrores.setText(R.string.textoErrorEdad);
                    checkTarjeta.setChecked(false);
                }
            }
            if (checkDiscapacidad.isChecked()) {
                descuentoProvisional = descuentoProvisional + (precioBillete * descDiscapacidad);
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.radioNumerosa) {
                descuentoProvisional = descuentoProvisional + (precioBillete * descFamiliaNum);
            }
            precioFinal = precioBillete - descuentoProvisional;
            Resources res = getResources();
            String finalt = res.getString(R.string.textoFinal ,precioFinal, descuentoProvisional);
            textoCalculo.setText(finalt);
        } else {
            textoErrores.setText(R.string.textoErrorCoste);
        }
    }
    public void limpiar(View v) {
        textoErrores.setText("");
        textoCalculo.setText("");
        cajaPrecio.setText("");
        cajaEdad.setText("");
        checkTarjeta.setChecked(false);
        checkDiscapacidad.setChecked(false);
        radioGroup.clearCheck();
    }

}
