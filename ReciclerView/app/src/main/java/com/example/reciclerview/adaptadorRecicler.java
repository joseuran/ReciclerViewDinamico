package com.example.reciclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptadorRecicler extends RecyclerView.Adapter<adaptadorRecicler.ViewHolder> {

    public List<ModeloPersona> listaData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        Spinner mpago;
        ImageView imagen;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            nombre = (TextView) view.findViewById(R.id.applicant_name);
            mpago = (Spinner) view.findViewById(R.id.payment_method_list);
            imagen = (ImageView) view.findViewById(R.id.indicator_has_account);
        }

    }

    public adaptadorRecicler(List<ModeloPersona> modeloP) {
        this.listaData = modeloP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(vista);
    }


    @Override
    public void onBindViewHolder(@NonNull adaptadorRecicler.ViewHolder holder, int position) {
        int pos = position;
        holder.nombre.setText(listaData.get(position).getNombre());
        String[] lenguajes = {"Seleccione", "abonos", "pagos chiquitos", "transferencia"};
        ArrayAdapter<String> aSpinner = new ArrayAdapter<String>(holder.mpago.getContext(), android.R.layout.simple_spinner_dropdown_item, lenguajes);
        holder.mpago.setAdapter(aSpinner);
        holder.mpago.setSelection(listaData.get(position).getTipoPago());

        asignarImagen(holder, position);

        holder.mpago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positionSpinner, long id) {

                asignarImagen(holder, positionSpinner);
                listaData.set(pos,new ModeloPersona(listaData.get(pos).getNombre(),positionSpinner));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void asignarImagen(adaptadorRecicler.ViewHolder holder, int positionSpinner){
        switch (positionSpinner) {
            case 0:
                holder.imagen.setImageResource(R.drawable.has_account);
                break;
            case 1:
                holder.imagen.setImageResource(R.drawable.dinero);
                break;
            case 2:
                holder.imagen.setImageResource(R.drawable.recibo);
                break;

            case 3:
                holder.imagen.setImageResource(R.drawable.transferencia);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listaData.size();
    }
}
