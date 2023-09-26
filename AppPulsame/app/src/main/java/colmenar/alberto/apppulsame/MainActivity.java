package colmenar.alberto.apppulsame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int numveces = 0;
    private static final String TAG = "Pulsame";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonPulsado(View v) {
        numveces++;
        Button boton = (Button)v;
        Resources res = getResources();
        String numPulsados = res.getQuantityString( R.plurals.numPulsaciones, numveces, numveces);
        boton.setText(numPulsados);
        android.util.Log.d(TAG, "botonPulsado " + numveces);
    }
}