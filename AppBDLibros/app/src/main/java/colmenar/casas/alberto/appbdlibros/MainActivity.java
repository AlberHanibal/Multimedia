package colmenar.casas.alberto.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CrearBD crearBD;
    EditText cajaCodigo;
    TextView cajaTitulo;
    TextView cajaAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaCodigo = (EditText) findViewById(R.id.cajaCodigo);
        cajaTitulo = findViewById(R.id.cajaTitulo);
        cajaAutor = findViewById(R.id.cajaAutor);
        crearBD = new CrearBD(this);
    }

    public void consultarLibro(View v) {
        String codigo = cajaCodigo.getText().toString();
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        Cursor contenido = bd.rawQuery("SELECT titulo, autor FROM Libros WHERE codigo = '" + codigo + "'", null);
        if (contenido.moveToNext()) {
            cajaTitulo.setText(contenido.getString(0));
            cajaAutor.setText(contenido.getString(1));
        }
        contenido.close();
        bd.close();
    }

    public void insertarLibro(View v) {
        Intent i = new Intent(this, FormularioLibro.class);
        startActivity(i);
    }

    public void consultarLibros(View v) {
        Intent i = new Intent(this, VerLibros.class);
        startActivity(i);
    }
}