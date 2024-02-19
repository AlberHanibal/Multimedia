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
            db.execSQL("INSERT INTO Libros VALUES('2222', 'El Camino de los Reyes', 'Brandon Sanderson', 'El camino de los reyes es una novela de fantasía épica escrita por el autor estadounidense Brandon Sanderson y el primer libro de la saga El archivo de las tormentas.')");
            db.execSQL("INSERT INTO Libros VALUES('1111', 'La Primera Ley', 'Joe Abercombrie', 'La Primera Ley es una serie de fantasía escrita por el autor británico Joe Abercrombie. Consiste en una trilogía, tres novelas.')");
            db.execSQL("INSERT INTO Libros VALUES('1212', 'Amanecer Rojo', 'Pierce Brown', 'Las novela, están ambientada en un futuro en el planeta Marte, y sigue al minero Darrow mientras se infiltra en las filas de la élite de la sociedad.')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
