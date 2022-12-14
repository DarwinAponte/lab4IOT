package com.example.lab4iot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab4iot.beans.Jugador;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        firebaseDatabase = FirebaseDatabase.getInstance();
    }



    public void guardarInfoDeportivo(View view) {
        DatabaseReference ref = firebaseDatabase.getReference();
        DatabaseReference refEncuentroDeportivo = ref.child("encuentro_deportivo");

        Spinner editTextEquipo = (Spinner)findViewById(R.id.inputEquipoSpinner);
        EditText editTextNombreJugador = findViewById(R.id.inputNombreJugador);
        EditText editTextApellidoJugador = findViewById(R.id.inputApellidoJugador);
        EditText editTexHito = findViewById(R.id.inputHito);
        String equipo = editTextEquipo.getSelectedItem().toString();

        DatabaseReference refEquipo = refEncuentroDeportivo.child(equipo);

        //HashMap<String,String> hashMap = new HashMap<>();
        //hashMap.put("nombre",editTextNombre.getText().toString());
        //hashMap.put("apellido",editTextApellido.getText().toString());
        //ref.setValue(hashMap);
        Jugador jugador = new Jugador();
        jugador.setNombre(editTextNombreJugador.getText().toString());
        jugador.setApellido(editTextApellidoJugador.getText().toString());
        jugador.setHito(editTexHito.getText().toString());

        DatabaseReference refJugador = refEquipo.push();

        refJugador.setValue(jugador).addOnSuccessListener(unused -> {
            //Snackbar.make(findViewById(R.id.MainActivityLayout),"Usuario registrado correctamente",2000).show();
            Toast.makeText(Admin.this, "Se registro jugador", Toast.LENGTH_SHORT).show();
            editTextNombreJugador.setText("");
            editTextApellidoJugador.setText("");
            editTexHito.setText("");
        });
    }
}