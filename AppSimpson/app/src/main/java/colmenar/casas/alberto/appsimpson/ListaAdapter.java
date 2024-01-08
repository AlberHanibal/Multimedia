package colmenar.casas.alberto.appsimpson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaAdapter extends ArrayAdapter<String> {

    Context contexto;
    int[] imagenes;
    String[] titulos;
    String[] descripciones;

    ListaAdapter(Context c, String [] tit, int [] imgs, String [] desc){
        super(c, R.layout.itemlista, R.id.titulo, tit);
        this.contexto=c;
        this.imagenes=imgs;
        this.titulos=tit;
        this.descripciones=desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        View fila = inflater.inflate(R.layout.itemlista, parent, false);
        ImageView imagen = (ImageView) fila.findViewById(R.id.imagen);
        TextView titulo = (TextView) fila.findViewById(R.id.titulo);
        TextView descripcion = (TextView) fila.findViewById(R.id.descripcion);
        imagen.setImageResource(imagenes[position]);
        titulo.setText(titulos[position]);
        descripcion.setText(descripciones[position]);
        return fila;
    }

}
