package com.example.starwarsapp.ConexionHTTP;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import androidx.room.Database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class conexionJSON {
    ArrayList arrayList;
    String str = "";
    ListView listView;
    DataBase dataBase;


    /*films string -- The URL root for Film resources
    people string -- The URL root for People resources
    planets string -- The URL root for Planet resources
    species string -- The URL root for Species resources
    starships string -- The URL root for Starships resources
    vehicles string -- The URL root for Vehicles resources*/
    public void leerDatosAPI() {

    }



    /*public class  getNames extends AsyncTask<Void,Void,Void> {


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

                        ArrayList<String[]> nameList;
                        nameList.add(arrayString);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
            return null;
        }
    }*/
}
