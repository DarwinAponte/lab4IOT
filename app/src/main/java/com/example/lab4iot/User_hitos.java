package com.example.lab4iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4iot.beans.Jugador;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class User_hitos extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Jugador> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hitos);

        TextView txtPUCP1=findViewById(R.id.txtPUCP1);
        TextView txtPUCP2=findViewById(R.id.txtPUCP2);
        TextView txtPUCP3=findViewById(R.id.txtPUCP3);
        TextView txtPUCP4=findViewById(R.id.txtPUCP4);
        TextView txtPUCP5=findViewById(R.id.txtPUCP5);
        TextView txtPUCP6=findViewById(R.id.txtPUCP6);
        TextView txtPUCP7=findViewById(R.id.txtPUCP7);
        TextView txtPUCP8=findViewById(R.id.txtPUCP8);
        TextView txtPUCP9=findViewById(R.id.txtPUCP9);
        TextView txtPUCP10=findViewById(R.id.txtPUCP10);
        TextView txtPUCP11=findViewById(R.id.txtPUCP11);

        TextView txtUPC1=findViewById(R.id.txtUPC1);
        TextView txtUPC2=findViewById(R.id.txtUPC2);
        TextView txtUPC3=findViewById(R.id.txtUPC3);
        TextView txtUPC4=findViewById(R.id.txtUPC4);
        TextView txtUPC5=findViewById(R.id.txtUPC5);
        TextView txtUPC6=findViewById(R.id.txtUPC6);
        TextView txtUPC7=findViewById(R.id.txtUPC7);
        TextView txtUPC8=findViewById(R.id.txtUPC8);
        TextView txtUPC9=findViewById(R.id.txtUPC9);
        TextView txtUPC10=findViewById(R.id.txtUPC10);
        TextView txtUPC11=findViewById(R.id.txtUPC11);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("encuentro_deportivo").child("PUCP TEAM");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Jugador jugador=dataSnapshot.getValue(Jugador.class);
//                    list.add(jugador);
                    System.out.println(jugador.getNombre());
                }

//                String player="txtPUCP";
//                boolean n=true;
//                for(Jugador jugador: list){
//                    if(n){
//                        txtPUCP1.setText(jugador.getNombre());
//                    }else {n=false;}
//
//                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}