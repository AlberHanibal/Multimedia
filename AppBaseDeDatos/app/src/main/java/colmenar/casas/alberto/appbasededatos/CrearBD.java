package colmenar.casas.alberto.appbasededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CrearBD extends SQLiteOpenHelper {

    public static final String NOMBREBD = "bdarticulos.sdb";
    public static final int VERSION = 1;
    public static final String NOMBRE_TABLA = "articulos";
    public static final String REF = "ref";
    public static final String NOMBRE = "nombre";

    public CrearBD(@Nullable Context context) {
        super(context, NOMBREBD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists articulos (ref integer primary key autoincrement not null, nombre text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
