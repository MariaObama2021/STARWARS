package com.example.starwarsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.starwarsapp.ConexionHTTP.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    public ListView lista_Id;
    public ArrayAdapter<String> ejemplo_datos;
    public String url="https://swapi.dev/api/";
    ArrayList<String[]> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Metodo muestra una personas por el nº de peliculas
    public void clickMostrarListadoDatosPelicula(View view) {
        String[] nomPersona = {"ANAKIN1", "ANAKIN2", "ANAKIN3", "ANAKIN4", "ANAKIN5", "ANAKIN6", "ANAKIN7"};
        String[] idPersona = {"1", "2", "3", "4", "5", "6", "7"};

        ArrayList<Map<String, Object>> listadoDatos = new ArrayList<>();

        int titulopelicula = nomPersona.length;

        for (int i = 0; i < titulopelicula; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("Nombre", nomPersona[i]);
            listItem.put("idPersona", idPersona[i]);
            listadoDatos.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listadoDatos,
                android.R.layout.simple_list_item_2,
                new String[]{"Nombre", "idPersona"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.lista_Id.setAdapter(simpleAdapter);

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);
                // Toast.makeText(getBaseContext(), obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Metodo que selecciona varias peliculas y muestra la persona que conduce la nave mas manejada
    public void clickMostrarListadoDatosPersona(View view) {
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

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listadoDatosPersonas,
                android.R.layout.simple_list_item_2,
                new String[]{"Nombre", "Cant-Nave"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.lista_Id.setAdapter(simpleAdapter);

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);

            }
        });

    }

    //Mostrar datos de la Estrella(mostrar los datos de la tabla Starship)
    public void clickMostrarDatosEstrella(View view) {


    }

    //Metod que muestrar lista
    public void clickRecargarLista(View view) {
        lista_Id = findViewById(R.id.lista_Id);
        nameList=new ArrayList<String[]>();

        mostrarMostrarBBDD();
    }

    public class  getNames extends AsyncTask<Void,Void,Void>{

        

        @Override
        protected Void doInBackground(Void... voids) {
            Handler handler=new Handler();
            String jsonString= handler.httServiceCall(url);
            if(jsonString !=null){
                try {
                    JSONObject jsonObject=new JSONObject(jsonString);
                    JSONArray jsonArray=jsonObject.getJSONArray("people");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String name = jsonObject1.getString("name");
                        String gender = jsonObject1.getString("gender");
                        String skin_color = jsonObject1.getString("skin_color");
                        String films = jsonObject1.getString("films");
                        String species = jsonObject1.getString("species");
                        String starships = jsonObject1.getString("starships");
                        String vehicles =jsonObject1.getString("vehicles");
                        String url = jsonObject1.getString("url");

                     String [] arrayString ={name,gender,skin_color,films,species,starships,vehicles,url};

                     nameList.add(arrayString);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error lectura del JSON",Toast.LENGTH_SHORT).show();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error lectura del JSON",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            } else{
                Toast.makeText(getApplicationContext(), " ERROR EN EL SERVICIO",Toast.LENGTH_SHORT).show();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "ERROR EN EL SERVICIO",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            return null;
        }
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

    //Metodo muestra la base de datos
    public void mostrarMostrarBBDD() {

        List<String> sw_Lista = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.selectLista)));

        ejemplo_datos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sw_Lista);

        this.lista_Id.setAdapter(getAdapterList(sw_Lista));

        lista_Id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Object obj = lista_Id.getAdapter().getItem(position);
                //Toast.makeText(getBaseContext(), obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}