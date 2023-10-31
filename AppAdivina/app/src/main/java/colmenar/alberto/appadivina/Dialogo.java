package colmenar.alberto.appadivina;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialogo  extends DialogFragment {
    AccionesDialogo accionesDialogo;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertaFin = new AlertDialog.Builder(getActivity());
        alertaFin.setMessage(R.string.textoAcierto);
        alertaFin.setTitle(R.string.tituloDialog);
        alertaFin.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                accionesDialogo.onDialogPositiveClick(Dialogo.this);
            }
        });
        alertaFin.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                accionesDialogo.onDialogNegativeClick(Dialogo.this);
            }
        });
        return alertaFin.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        accionesDialogo = (AccionesDialogo) context;
    }
}
