package colmenar.casas.alberto.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VerLibros extends AppCompatActivity {

    CrearBD crearBD;
    ListView listaLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_libros);
        listaLibros = (ListView) findViewById(R.id.listaLibros);
        crearBD = new CrearBD(this);
        consultarLibros();
    }

    public void consultarLibros() {
        List <Libro> items = new ArrayList <Libro>();
        SQLiteDatabase bd = crearBD.getReadableDatabase();
        Cursor contenido = bd.rawQuery("select * from libros", null);
        int i=0;
        Libro libro;
        while (contenido.moveToNext() && i<contenido.getCount()) {
            libro = new Libro(contenido.getInt(0), contenido.getString(1), contenido.getString(2));
            items.add(libro);
            i++;
        }
        ArrayAdapter <Libro> adapter=new ArrayAdapter<Libro>(this, android.R.layout.simple_list_item_1, items);
        listaLibros.setAdapter(adapter);
        contenido.close();
        bd.close();
    }

}