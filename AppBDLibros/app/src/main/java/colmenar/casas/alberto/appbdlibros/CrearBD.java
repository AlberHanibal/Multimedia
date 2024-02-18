package colmenar.casas.alberto.appbdlibros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CrearBD extends SQLiteOpenHelper {
    public CrearBD(@Nullable Context context) {
        super(context, "bdLibros", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            SQLiteDatabase   dbe = SQLiteDatabase.openDatabase("bdLibros", null,0);
        } catch(SQLiteException e){
            db.execSQL("create table if not exists Libros (codigo integer primary key not null, titulo varchar(40), autor varchar(30), sinopsis varchar(200))");
            db.execSQL("INSERT INTO Libros VALUES('2222', 'El Camino de los Reyes', 'Brandon Sanderson', 'God');");
            // más
        }
        //db.execSQL("create table if not exists Libros (codigo integer primary key not null, titulo varchar(30), autor varchar(20), sinopsis varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
