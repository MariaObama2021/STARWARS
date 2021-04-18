package com.example.starwarsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    public ListView lista_Id;
    public ArrayAdapter<String> ejemplo_datos;
    Button bnPersona;
    Button bnPelicula;
    Button bnStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnPersona = findViewById(R.id.bt_People);
        bnPelicula = findViewById(R.id.bt_Film);
        bnStar = findViewById(R.id.bt_StarShip);
        selectItemLista();
        mostrarMostrarBBDD();


        bnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListadoDatosPersona();
                Toast.makeText(getApplicationContext(),
                        "Toast con gravity", Toast.LENGTH_SHORT).show();
            }
        });
        bnPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListadoDatosPelicula();
                Toast.makeText(getApplicationContext(),
                        "Toast con gravity", Toast.LENGTH_SHORT).show();
            }
        });
        bnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Toast con gravity", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Metod que muestrar lista
    public void selectItemLista() {

        lista_Id = findViewById(R.id.lista_Id);
    }

    //Metodo muestra la base de datos
    public void mostrarMostrarBBDD() {

        List<String> sw_Lista = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.selectLista)));

        ejemplo_datos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sw_Lista);

        this.lista_Id.setAdapter(getAdapterList(sw_Lista));

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    //Adaptador
    public ArrayAdapter<String> getAdapterList(List<String> listView) {
        return new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listView) {
            @Override
            public View getView(int position, View converView, ViewGroup parent) {
                View view = super.getView(position, converView, parent);
                return view;
            }
        };
    }


    //Metodo muestra una personas por el nº de peliculas
    public void mostrarListadoDatosPelicula() {
        String[] nomPersona = {"STAR WARS1", "STAR WARS2", "STAR WARS3", "STAR WARS4", "STAR WARS5", "STAR WARS6", "STAR WARS7"};
        String[] idPersona = {"1", "2", "3", "4", "5", "6", "7"};

        ArrayList<Map<String, Object>> listadoDatos = new ArrayList<>();

        int titulopelicula = nomPersona.length;

        for (int i = 0; i < titulopelicula; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("Nombre", nomPersona[i]);
            listItem.put("idPersona", idPersona[i]);
            listadoDatos.add(listItem);
        }

        Log.i("myTag", "Error --> " + listadoDatos);
        System.out.println(listadoDatos);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listadoDatos,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"Nombre", "idPersona"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.lista_Id.setAdapter(simpleAdapter);

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Metodo que selecciona varias peliculas y muestra la persona que conduce la nave mas manejada
    public void mostrarListadoDatosPersona() {
        String[] nomPersona = {"WARS1", "WARS2", "WARS3", "WARS4", "WARS5", "WARS6", "WARS7"};
        String[] numNave = {"10", "20", "3", "4", "5", "26", "87"};

        ArrayList<Map<String, Object>> listadoDatosPersonas = new ArrayList<>();

        int perosna = nomPersona.length;

        for (int v = 0; v < perosna; v++) {
            Map<String, Object> listItemP = new HashMap<>();
            listItemP.put("Nombre", nomPersona[v]);
            listItemP.put("Cant-Nave", numNave[v]);
            listadoDatosPersonas.add(listItemP);
        }

        // Log.i("myTag", "Error --> " + listadoDatos);
        // System.out.println(listadoDatos);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listadoDatosPersonas,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"Nombre", "Cant-Nave"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.lista_Id.setAdapter(simpleAdapter);

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);
                Toast.makeText(getBaseContext(), obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Mostrar datos de la Estrella(mostrar los datos de la tabla Starship)
    public void mostrarDatosEstrella() {


    }
}