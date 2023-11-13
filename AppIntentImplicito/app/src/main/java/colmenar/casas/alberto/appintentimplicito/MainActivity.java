package colmenar.casas.alberto.appintentimplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBotonEjecutar(View v) {
        Intent i = new Intent();
        int boton = v.getId();
        
        if (boton == R.id.botonBateria) {
            i.setAction(Intent.ACTION_POWER_USAGE_SUMMARY);
            startActivity(i);
        } else if (boton == R.id.botonNavegador) {
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.google.es"));
            startActivity(i);
        } else if (boton == R.id.botonSMS) {
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:5554433"));
            startActivity(i);
        } else if (boton == R.id.botonGaleria) {
            i.setAction(Intent.ACTION_GET_CONTENT);
            i.setType("image/*");
            startActivity(i);
        } else if (boton == R.id.botonAudio) {
            i.setAction(Intent.ACTION_GET_CONTENT);
            i.setType("audio/*");
            startActivity(i);
        } else if (boton == R.id.botonLlamar) {
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:5554433"));
            startActivity(i);
        }

    }
}