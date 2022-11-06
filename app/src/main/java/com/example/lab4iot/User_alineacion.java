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

public class User_alineacion extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReferencePUCP,databaseReferenceUPC;
    ArrayList<Jugador> list = new ArrayList<>();
    ArrayList<Jugador> listUPC = new ArrayList<>();

    ArrayList<TextView> txtPUCPplayer = new ArrayList<>();
    ArrayList<TextView> txtUPCplayer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hitos);

        txtPUCPplayer.add(findViewById(R.id.txtPUCP1));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP2));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP3));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP4));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP5));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP6));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP7));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP8));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP9));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP10));
        txtPUCPplayer.add(findViewById(R.id.txtPUCP11));

        txtUPCplayer.add(findViewById(R.id.txtUPC1));
        txtUPCplayer.add(findViewById(R.id.txtUPC2));
        txtUPCplayer.add(findViewById(R.id.txtUPC3));
        txtUPCplayer.add(findViewById(R.id.txtUPC4));
        txtUPCplayer.add(findViewById(R.id.txtUPC5));
        txtUPCplayer.add(findViewById(R.id.txtUPC6));
        txtUPCplayer.add(findViewById(R.id.txtUPC7));
        txtUPCplayer.add(findViewById(R.id.txtUPC8));
        txtUPCplayer.add(findViewById(R.id.txtUPC9));
        txtUPCplayer.add(findViewById(R.id.txtUPC10));
        txtUPCplayer.add(findViewById(R.id.txtUPC11));






        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReferencePUCP= firebaseDatabase.getReference("encuentro_deportivo").child("PUCP SPORT");
        databaseReferencePUCP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Jugador jugador=dataSnapshot.getValue(Jugador.class);
                    list.add(jugador);
                    System.out.println(jugador.getNombre());
                }
                for(int i=0; i<Math.min(list.size(),txtPUCPplayer.size());i++){
                   txtPUCPplayer.get(i).setText(list.get(i).getNombre());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReferenceUPC= firebaseDatabase.getReference("encuentro_deportivo").child("UPC SPORT");
        databaseReferenceUPC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Jugador jugador=dataSnapshot.getValue(Jugador.class);
                    listUPC.add(jugador);
                    System.out.println(jugador.getNombre());
                }
                for(int i=0; i<Math.min(listUPC.size(),txtUPCplayer.size());i++){
                    txtUPCplayer.get(i).setText(listUPC.get(i).getNombre());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}