package colmenar.alberto.appetiquetas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView etiqueta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta1 = findViewById(R.id.etiqueta1);
        String texto = etiqueta1.getText().toString();
        texto += "123";
        etiqueta1.setText(texto);
        etiqueta1.setBackgroundColor(Color.LTGRAY);

        et = findViewById(R.id.cajaTexto);
        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    cambiarTexto();
                    return true;
                } else return false;
            }
        });
    }
    public void cambiarTexto() {
        String texto = et.getText().toString();
        etiqueta1.setText(texto);
    }
}