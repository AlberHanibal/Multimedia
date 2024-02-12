package colmenar.casas.alberto.appbdlibros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Libro> {


    public MyArrayAdapter(@NonNull Context context, Libro[] libros) {
        super(context, 0, libros);
    }

    public MyArrayAdapter(@NonNull Context context, List<Libro> listaLibros) {
        super(context, 0, listaLibros);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Libro l = getItem(position);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.libro_lista, parent, false);
        TextView tv = v.findViewById(R.id.textoCarta);
        String carta = String.format("Código: %s%n" +
                                    "Autor: %s%n" +
                                    "Título: %s%n", l.getCodigo(), l.getAutor(), l.getTitulo());
        tv.setText(carta);
        tv = v.findViewById(R.id.cartaCodigo);
        tv.setText(String.format("%s", l.getCodigo()));
        return v;
    }
}
