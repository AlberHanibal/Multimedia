package colmenar.casas.alberto.appbdlibros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
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
        listaLibros.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(listaLibros.getPositionForView(view));
            }
        });



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
        rl.getChildAt(0);
        // esto coge el card, falta el codigo
        System.out.println(listaLibros.getPositionForView(view));
        System.out.println();
        /*
        TextView tv = findViewById(R.id.cartaCodigo);
        System.out.println(tv.getText());
        */

        /*
        CardView cv = findViewById(view.getId());
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG; // Toast.LENGTH_LONG
        Toast toast = Toast.makeText(contexto, cv.getChildAt(0).toString(), duracion);
        toast.show();
*/
    }

}