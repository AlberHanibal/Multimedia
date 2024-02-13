package colmenar.casas.alberto.appbdlibros;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoLibro extends AppCompatActivity {
    CrearBD crearBD;
    TextView infoTitulo;
    TextView infoAutor;
    TextView infoSinopsis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_libro);
        int codigo = getIntent().getIntExtra("libro", 0);
        crearBD = new CrearBD(this);
        infoTitulo = findViewById(R.id.infoTitulo);
        infoAutor = findViewById(R.id.infoAutor);
        infoSinopsis = findViewById(R.id.infoSinopsis);
        infoLibro(codigo);
    }

    public void infoLibro(int codigo) {
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        Cursor contenido = bd.rawQuery("SELECT titulo, autor FROM Libros WHERE codigo = '" + codigo + "'", null);
        if (contenido.moveToNext()) {
            infoTitulo.setText(contenido.getString(0));
            infoAutor.setText(contenido.getString(1));
        }
        contenido.close();
        bd.close();
    }

    public void clickAtras(View view) {
        Intent i = new Intent(this, VerLibros.class);
        startActivity(i);
    }
}
