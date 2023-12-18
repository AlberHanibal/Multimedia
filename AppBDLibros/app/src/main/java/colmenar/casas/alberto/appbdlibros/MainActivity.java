package colmenar.casas.alberto.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CrearBD crearBD;
    EditText cajaCodigo;
    EditText cajaTitulo;
    EditText cajaAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaCodigo = (EditText) findViewById(R.id.cajaCodigo);
        cajaTitulo = (EditText) findViewById(R.id.cajaTitulo);
        cajaAutor = (EditText) findViewById(R.id.cajaAutor);
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
        SQLiteDatabase bd = crearBD.getWritableDatabase();
        if (cajaCodigo.getText().toString().equals("") || cajaTitulo.getText().toString().equals("")
            || cajaAutor.getText().toString().equals("")) {
            verMensajeToast("Cajas vacías, debes introducir los datos");
        } else {
            String codigo = cajaCodigo.getText().toString();
            String titulo = cajaTitulo.getText().toString();
            String autor = cajaAutor.getText().toString();
            try {
                bd.execSQL("INSERT INTO Libros VALUES (?, ?, ?)", new Object[] {codigo, titulo, autor});
                verMensajeToast("Libro insertado");
            } catch (Exception sqlex) {
                verMensajeToast(sqlex.getMessage());
            }
        }
        limpiarCajas();
        bd.close();
    }

    public void borrarLibro(View v) {
        String codigo = cajaCodigo.getText().toString();
        String titulo = cajaTitulo.getText().toString();
        SQLiteDatabase bd = crearBD.getWritableDatabase();
        if (codigo.equals("") && titulo.equals("")) {
            verMensajeToast("Código y título vacío, debes introducir al menos uno");
        } else if (!codigo.equals("") && !titulo.equals("")) {
            bd.execSQL("DELETE FROM Libros WHERE codigo = ? AND titulo = ?", new Object[]{codigo, titulo});
            verMensajeToast("Borrado completado");
        } else if (!codigo.equals("")) {
            bd.execSQL("DELETE FROM Libros WHERE codigo = ?", new Object[]{codigo});
            verMensajeToast("Borrado completado");
        } else if (!titulo.equals("")) {
            bd.execSQL("DELETE FROM Libros WHERE titulo = ?", new Object[]{titulo});
            verMensajeToast("Borrado completado");
        }
        limpiarCajas();
        bd.close();
    }

    public void consultarLibros(View v) {
        Intent i = new Intent(this, VerLibros.class);
        startActivity(i);
    }

    public void verMensajeToast(String mensaje) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, mensaje, duracion);
        toast.show();
    }

    public void limpiarCajas() {
        cajaCodigo.setText("");
        cajaTitulo.setText("");
        cajaAutor.setText("");
    }
}