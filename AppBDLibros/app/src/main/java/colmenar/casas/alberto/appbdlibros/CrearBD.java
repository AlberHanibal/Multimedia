package colmenar.casas.alberto.appbdlibros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CrearBD extends SQLiteOpenHelper {
    public CrearBD(@Nullable Context context) {
        super(context, "bdLibros", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists Libros (codigo integer primary key not null, titulo text, autor text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
