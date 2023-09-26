package colmenar.alberto.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloDeVida";
    private int contador = 0;
    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i(TAG, "onStart");
        contador++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i(TAG, "onStop");
        contador--;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i(TAG, "onPause");
        contador++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i(TAG, "onResume");
        contador++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.i(TAG, "onCreate");
        contador++;
    }
}