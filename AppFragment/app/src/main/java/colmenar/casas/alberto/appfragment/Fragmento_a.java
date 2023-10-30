package colmenar.casas.alberto.appfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragmento_a extends Fragment implements View.OnClickListener {

    EnviarMensaje em = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_a, container, false);
    }

    public void onActivityCreated(Bundle SavedInstanceState) {
        super.onActivityCreated(SavedInstanceState);
        em = (EnviarMensaje) getActivity();
        Button b = (Button) getActivity().findViewById(R.id.botonA);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText et = (EditText) getActivity().findViewById(R.id.cajaTexto);
        em.enviarDato(et.getText().toString());
    }
}