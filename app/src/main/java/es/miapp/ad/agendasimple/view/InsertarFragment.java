package es.miapp.ad.agendasimple.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import es.miapp.ad.agendasimple.R;
import es.miapp.ad.agendasimple.model.entity.Persona;
import es.miapp.ad.agendasimple.viewmodel.PersonaViewModel;

public class InsertarFragment extends Fragment {

    public static final String EXTRA_REPLAY = "com.example.wordlistsql.REPLAY";
    private PersonaViewModel viewModel;

    private TextInputEditText tIETNombre, tIETApellidos, tIETTelefono, tIETFecNac, tIETLocalidad, tIETCalle, tIETNumero;
    private FloatingActionButton addPersona;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fg_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tIETNombre = view.findViewById(R.id.tIETNombre);
        tIETApellidos = view.findViewById(R.id.tIETApellidos);
        tIETTelefono = view.findViewById(R.id.tIETTelefono);
        tIETFecNac = view.findViewById(R.id.tIETFecNac);
        tIETLocalidad = view.findViewById(R.id.tIETLocalidad);
        tIETCalle = view.findViewById(R.id.tIETCalle);
        tIETNumero = view.findViewById(R.id.tIETNumero);

        addPersona = view.findViewById(R.id.addPersona);

        addPersona.setOnClickListener(v -> showAlertDialog(getContext(), view));
    }

    public void showAlertDialog(Context context, View view) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);

        builder.setTitle("¿Estás seguro de insertar este contacto?").setMessage("Seleccione una opción");

        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Snackbar.make(view, "¡Datos agregados correctamente!", Snackbar.LENGTH_SHORT)
                        .setAction("Ir a menú", null).show();

//                Fragment InsertarFragment = new Fragment();
//
//                Bundle bundle = new Bundle();
//
//                bundle.putString("tIETNombre", tIETNombre.getText().toString());
//                bundle.putString("tIETApellidos", tIETApellidos.getText().toString());
//                bundle.putInt("tIETTelefono", Integer.parseInt(tIETTelefono.getText().toString()));
//                bundle.putString("tIETFecNac", tIETFecNac.getText().toString());
//                bundle.putString("tIETLocalidad", tIETLocalidad.getText().toString());
//                bundle.putString("tIETCalle", tIETCalle.getText().toString());
//                bundle.putInt("tIETNumero", Integer.parseInt(tIETNumero.getText().toString()));
//
//                InsertarFragment.setArguments(bundle);

                viewModel = new ViewModelProvider(InsertarFragment.this).get(PersonaViewModel.class);
                viewModel.insertar(new Persona(tIETNombre.getText().toString(), tIETApellidos.getText().toString(), Integer.parseInt(tIETTelefono.getText().toString()), tIETFecNac.getText().toString(), tIETLocalidad.getText().toString(), tIETCalle.getText().toString(), Integer.parseInt(tIETNumero.getText().toString())));
            }
        });

        builder.setNegativeButton("No añadir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Snackbar.make(view, "Contacto no añadido", Snackbar.LENGTH_SHORT)
                        .setAction("Ir a menú", null).show();
            }
        });

        builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //  Action for 'NO' Button
                Snackbar.make(view, "Acción cancelada", Snackbar.LENGTH_SHORT).show();
                //  Cancel
                dialog.cancel();
            }
        });

        // Create AlertDialog:
        AlertDialog alert = builder.create();
        alert.show();

        Button bTNegative = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        Button bTPositive = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        bTNegative.setTextColor(Color.RED);
        bTPositive.setTextColor(Color.GREEN);
    }
}