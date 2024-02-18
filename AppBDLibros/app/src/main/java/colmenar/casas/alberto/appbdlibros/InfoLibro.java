package colmenar.casas.alberto.appbdlibros;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoLibro extends AppCompatActivity {
    CrearBD crearBD;
    TextView infoTitulo;
    TextView infoAutor;
    TextView infoSinopsis;
    private int codigo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_libro);
        codigo = getIntent().getIntExtra("libro", 0);
        crearBD = new CrearBD(this);
        infoTitulo = findViewById(R.id.infoTitulo);
        infoAutor = findViewById(R.id.infoAutor);
        infoSinopsis = findViewById(R.id.infoSinopsis);
        infoLibro(codigo);
    }

    public void infoLibro(int codigo) {
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        Cursor contenido = bd.rawQuery("SELECT titulo, autor, sinopsis FROM Libros WHERE codigo = '" + codigo + "'", null);
        if (contenido.moveToNext()) {
            infoTitulo.setText(contenido.getString(0));
            infoAutor.setText(contenido.getString(1));
            infoSinopsis.setText(contenido.getString(2));
        }
        contenido.close();
        bd.close();
    }

    public void clickAtras(View view) {
        Intent i = new Intent(this, VerLibros.class);
        startActivity(i);
    }

    public void borrarLibro(View view) {
        SQLiteDatabase bd = crearBD.getWritableDatabase();
        bd.execSQL("DELETE FROM Libros WHERE codigo = ?", new Object[]{codigo});
        bd.close();
        verMensajeToast("Borrado completado");
        Intent i = new Intent(this, VerLibros.class);
        startActivity(i);
    }

    public void modificarLibro(View view) {
        Intent i = new Intent(this, FormularioLibro.class);
        i.putExtra("libro", codigo);
        startActivity(i);
    }

    public void verMensajeToast(String mensaje) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(contexto, mensaje, duracion);
        toast.show();
    }
}
