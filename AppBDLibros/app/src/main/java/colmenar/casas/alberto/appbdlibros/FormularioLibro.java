package colmenar.casas.alberto.appbdlibros;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioLibro extends AppCompatActivity {

    CrearBD crearBD;
    EditText cajaCodigo2;
    EditText cajaTitulo2;
    EditText cajaAutor2;
    EditText cajaSinopsis;
    private int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        codigo = getIntent().getIntExtra("libro", 0);
        crearBD = new CrearBD(this);
        cajaCodigo2 = findViewById(R.id.cajaCodigo2);
        cajaTitulo2 = findViewById(R.id.cajaTitulo2);
        cajaAutor2 = findViewById(R.id.cajaAutor2);
        cajaSinopsis = findViewById(R.id.cajaSinopsis);
        if (codigo != 0) {
            rellenarCampos();
        }
    }

    private void rellenarCampos() {
        cajaCodigo2.setVisibility(View.INVISIBLE);
        TextView tv = findViewById(R.id.textoCodigo2);
        tv.setVisibility(View.INVISIBLE);

        SQLiteDatabase bd = crearBD.getReadableDatabase();
        Cursor contenido = bd.rawQuery("SELECT titulo, autor, sinopsis FROM Libros WHERE codigo = '" + codigo + "'", null);
        if (contenido.moveToNext()) {
            cajaTitulo2.setText(contenido.getString(0));
            cajaAutor2.setText(contenido.getString(1));
            cajaSinopsis.setText(contenido.getString(2));
        }
        contenido.close();
        bd.close();
    }

    public void clickCancelar(View view) {
        if (codigo == 0) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent(this, InfoLibro.class);
            i.putExtra("libro", codigo);
            startActivity(i);
        }
    }

    public void clickGuardar(View view) {
        boolean operacionCompleta;
        if (codigo == 0) {
            operacionCompleta = insertarLibro();
        } else {
            operacionCompleta = modificarLibro();
        }
        if (operacionCompleta) {
            Intent i = new Intent(this, VerLibros.class);
            startActivity(i);
        }

    }

    private boolean insertarLibro() {
        SQLiteDatabase bd = crearBD.getWritableDatabase();
        if (cajaCodigo2.getText().toString().equals("") || cajaTitulo2.getText().toString().equals("")
                || cajaAutor2.getText().toString().equals("") || cajaSinopsis.getText().toString().equals("")) {
            verMensajeToast("Cajas vacías, debes introducir los datos");
            return false;
        } else {
            String codigo = cajaCodigo2.getText().toString();
            String titulo = cajaTitulo2.getText().toString();
            String autor = cajaAutor2.getText().toString();
            String sinopsis = cajaSinopsis.getText().toString();
            try {
                bd.execSQL("INSERT INTO Libros VALUES (?, ?, ?, ?)", new Object[] {codigo, titulo, autor, sinopsis});
                verMensajeToast("Libro insertado");
            } catch (Exception sqlex) {
                verMensajeToast("Ese codigo ya existe, inserte otro nuevo.");
                return false;
            }
        }
        bd.close();
        return true;
    }

    private boolean modificarLibro() {
        SQLiteDatabase bd = crearBD.getWritableDatabase();
        if (cajaTitulo2.getText().toString().equals("")
                || cajaAutor2.getText().toString().equals("") || cajaSinopsis.getText().toString().equals("")) {
            verMensajeToast("Cajas vacías, debes introducir los datos");
            return false;
        } else {
            String titulo = cajaTitulo2.getText().toString();
            String autor = cajaAutor2.getText().toString();
            String sinopsis = cajaSinopsis.getText().toString();
            try {
                bd.execSQL("UPDATE Libros SET titulo = ?, autor = ?, sinopsis = ? WHERE codigo = ?", new Object[] {titulo, autor, sinopsis, codigo});
                verMensajeToast("Libro modificado");
            } catch (Exception sqlex) {
                verMensajeToast("Error al modificar el libro");
                return false;
            }
        }
        bd.close();
        return true;
    }

    public void verMensajeToast(String mensaje) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, mensaje, duracion);
        toast.show();
    }
}
