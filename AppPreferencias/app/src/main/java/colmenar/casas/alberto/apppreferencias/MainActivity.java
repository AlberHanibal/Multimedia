package colmenar.casas.alberto.apppreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private final static String PREFERENCIA_MELODIA = "melodia";
    SharedPreferences preferencias = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = getPreferences(Context.MODE_PRIVATE);
        int id = preferencias.getInt(PREFERENCIA_MELODIA, R.id.radio0);
        RadioButton rb = (RadioButton) findViewById(id);
        rb.setChecked(true);
    }

    public void onAceptar (View v) {
        SharedPreferences.Editor editor = preferencias.edit();
        RadioGroup rg = (RadioGroup) findViewById(R.id.preferenciasMelodia);
        editor.putInt(PREFERENCIA_MELODIA, rg.getCheckedRadioButtonId());
        editor.commit();
        finish();
    }

    public void onCancelar (View v) {
        finish();
    }
}