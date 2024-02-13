package colmenar.casas.alberto.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        MyArrayAdapter adapter = new MyArrayAdapter(this, items);
        listaLibros.setAdapter(adapter);
        contenido.close();
        bd.close();
    }

    public void onClickLibro(View view) {
        RelativeLayout rl = (RelativeLayout) listaLibros.getChildAt(listaLibros.getPositionForView(view));
        CardView cv = (CardView) rl.getChildAt(0);
        TextView tv = (TextView) cv.getChildAt(0);
        Intent i = new Intent(this, InfoLibro.class);
        i.putExtra("libro", Integer.parseInt(tv.getText().toString()));
        startActivity(i);
    }

    public void clickAtras(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}