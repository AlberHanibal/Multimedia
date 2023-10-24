package colmenar.casas.alberto.apptoast;

import static android.view.Gravity.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsame(View v) {
        Context contexto = getApplicationContext();
        /*
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(contexto, R.string.textoToast, duracion);
        toast.setGravity(CENTER, 0, 0);
         */
        Toast toast = new Toast(contexto);
        toast.setDuration(Toast.LENGTH_LONG);
        /*
        DatePicker calendario = new DatePicker(contexto);
        toast.setView(calendario);
         */
        TimePicker hora = new TimePicker(contexto);
        toast.setView(hora);
        toast.show();
    }
}