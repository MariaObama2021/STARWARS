package com.example.starwarsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public ListView lista_Id;
    public ArrayAdapter<String> ejemplo_datos;
    public ArrayList<String> dato_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectItemLista();
        mostrarLista();
    }

    //Metod que muestrar lista
    public void selectItemLista() {

        lista_Id = findViewById(R.id.lista_Id);
    }

    //Metodo que rellena la lista
    public void mostrarLista() {

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

    //Mostrar los datos de la API
    public void mostrarListadoDatos(){

    }
}