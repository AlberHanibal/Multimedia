package colmenar.casas.alberto.appcuadrodedialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alertaDialogo = new AlertDialog.Builder(getActivity());
        alertaDialogo.setTitle(R.string.titulo);
        alertaDialogo.setMessage(R.string.textoCuadro);
        alertaDialogo.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                new MainActivity().mostrarMensaje(getActivity());
            }
        });
        alertaDialogo.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        return alertaDialogo.create();
    }
}
