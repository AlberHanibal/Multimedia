package colmenar.casas.alberto.invocacionremota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPulsame(View v) {
        Intent i = new Intent();
        i.setClassName("colmenar.casas.alberto.appintent", "colmenar.casas.alberto.appintent.MainActivity");
        startActivity(i);
    }
}