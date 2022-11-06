package com.example.lab4iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lab4iot.beans.Jugador;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class User_hitos extends AppCompatActivity {

    RecyclerView recyclerView1, recyclerView2;
    ArrayList<Jugador> list1,list2;
    DatabaseReference databaseReference1,databaseReference2;
    MyAdapter adapter1, adapter2;
    FirebaseDatabase firebaseDatabase;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(User_hitos.this, UserActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_alineacion);

        firebaseDatabase = FirebaseDatabase.getInstance();

        //PARA EQUIPO B
        recyclerView1=findViewById(R.id.recycleView1);
        databaseReference1= firebaseDatabase.getReference("encuentro_deportivo").child("UPC SPORT");
        list1=new ArrayList<>();
        recyclerView1.setLayoutManager(new LinearLayoutManager(User_hitos.this));
        adapter1 = new MyAdapter(this,list1);
        recyclerView1.setAdapter(adapter1);

        //PARA EQUIPO A
        recyclerView2=findViewById(R.id.recycleView2);
        databaseReference2= firebaseDatabase.getReference("encuentro_deportivo").child("PUCP SPORT");
        list2=new ArrayList<>();
        recyclerView2.setLayoutManager(new LinearLayoutManager(User_hitos.this));
        adapter2 = new MyAdapter(this,list2);
        recyclerView2.setAdapter(adapter2);

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Jugador jugador=dataSnapshot.getValue(Jugador.class);
                    list1.add(jugador);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Jugador jugador=dataSnapshot.getValue(Jugador.class);
                    list2.add(jugador);
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}