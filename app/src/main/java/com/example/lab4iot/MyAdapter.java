package com.example.lab4iot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4iot.beans.Jugador;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public MyAdapter(Context context, ArrayList<Jugador> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<Jugador> list;




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_jugador,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Jugador jugador=list.get(position);
        holder.nombre.setText(jugador.getNombre());
        holder.apellido.setText(jugador.getApellido());
        //holder.hito.setText(jugador.getHito());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,apellido,hito;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.textName);
            apellido=itemView.findViewById(R.id.txtLastName);
            //hito=itemView.findViewById(R.id.textHito);


        }
    }
}














