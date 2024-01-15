package colmenar.casas.alberto.appsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        TextView texto = findViewById(R.id.sensores);
        List<Sensor> listaSensores = sm.getSensorList(Sensor.TYPE_ALL);
        StringBuffer sb = new StringBuffer();
        sb.append("Tu móvil tiene ")
                .append(listaSensores.size())
                .append(" sensores\n\n");
        for (Sensor s: listaSensores)
            sb.append(s.getName()).append("\n");
        texto.setText(sb.toString());
    }
}