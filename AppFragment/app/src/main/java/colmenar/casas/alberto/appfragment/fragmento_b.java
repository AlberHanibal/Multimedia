package colmenar.casas.alberto.appfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragmento_b extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_b, container, false);
    }

    public void recibir (String msg) {
        TextView tv = (TextView) getActivity().findViewById(R.id.textoB);
        tv.setText(msg);
    }
}