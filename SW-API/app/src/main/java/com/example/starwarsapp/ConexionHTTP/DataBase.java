package com.example.starwarsapp.ConexionHTTP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;


public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "SWAPI.db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableFilms = "create table films(id_films int" +
                ",title String, \n" +
                "episode_id      int,\n" +
                "opening_crawl   String ,\n" +
                "director        String, \n" +
                "producer        String ,\n" +
                "release_date    date  , \n" +
                "species         String , \n" +
                "starships       String , \n" +
                "vehicles        String , \n" +
                "characters      String , \n" +
                "planets         String , \n" +
                "url             String,    \n" +
                "created         String ,\n" +
                "edited          String )";

        String tablePeople = "create table people(id_peole int,name String,birth_year String,eye_color String,gender String,hair_color String,height String" +
                ",mass String,skin_color String,homeworld String,films array,species array,starships array ,vehicles array,url String,created String, edited String )";


        String tablePlanets = "create table planets(id_planet int, name   String ,\n" +
                "diameter         String, \n" +
                "rotation_period  String,\n" +
                "orbital_period   String,\n" +
                "gravity          String ,\n" +
                "population       String ,\n" +
                "climate          String ,\n" +
                "terrain          String ,\n" +
                "surface_water    String ,\n" +
                "residents       String,\n" +
                "films           array,\n" +
                "url             array,\n" +
                "created         String,\n" +
                "edited          String )";

        String tableSpecies = "create table species(id_species int,name String, \n" +
                "classification   String   , \n" +
                "designation      String     ,  \n" +
                "average_height   String  ,  \n" +
                "average_lifespan  String  ,\n" +
                "eye_colors        String       , \n" +
                "hair_colors    String     ,  \n" +
                "skin_colors String    ,   \n" +
                "language String        ,  \n" +
                "homeworld String       ,  \n" +
                "people array           ,  \n" +
                "films array            ,  \n" +
                "url String              , \n" +
                "created String          , \n" +
                "edited String )";

        String tableStarships = "create table starship(id_starship int ,name String , \n" +
                "model  String               ,  \n" +
                "starship_class String     ,   \n" +
                "manufacturer String        ,  \n" +
                "cost_in_credits String     ,  \n" +
                "length String               , \n" +
                "crew String                 , \n" +
                "passengers String           , \n" +
                "max_atmosphering_speed String,\n" +
                "hyperdrive_rating String   ,  \n" +
                "MGLT String                 , \n" +
                "cargo_capacity String       , \n" +
                "consumables String          ,    \n" +
                "films array                 , \n" +
                "pilots array                , \n" +
                "url String                  , \n" +
                "created String              , \n" +
                "edited String)";

        String tableVehicles = "create table vehicles(id_vhicle int,name String, \n" +
                "model String               ,   \n" +
                "vehicle_class String         , \n" +
                "manufacturer String         ,  \n" +
                "length String               ,  \n" +
                "cost_in_credits String      ,  \n" +
                "crew String                 ,  \n" +
                "passengers String            , \n" +
                "max_atmosphering_speed String, \n" +
                "cargo_capacity String        , \n" +
                "consumables   String ,\n" +
                "films array             ,      \n" +
                "pilots array            ,      \n" +
                "url String               ,     \n" +
                "created String            ,    \n" +
                "edited String)";

        sqLiteDatabase.execSQL(tablePeople);
        sqLiteDatabase.execSQL(tableFilms);
        sqLiteDatabase.execSQL(tablePlanets);
        sqLiteDatabase.execSQL(tableSpecies);
        sqLiteDatabase.execSQL(tableStarships);
        sqLiteDatabase.execSQL(tableVehicles);

    }

    public void insertDataFilms(int id_films, String title, int episode_id, String opening_crawl, String director, String producer,
                                Date release_date, String species, String starships, String vehicles, String characters, String planets,
                                String url, String created, String edited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_films", id_films);
        values.put("title", title);
        values.put("episode_id", episode_id);
        values.put("opening_crawl", opening_crawl);
        values.put("director", director);
        values.put("producer", producer);
        values.put("release_date", String.valueOf(release_date));
        values.put("species", species);
        values.put("starships", starships);
        values.put("vehicles", vehicles);
        values.put("characters", characters);
        values.put("planets", planets);
        values.put("url", url);
        values.put("created", created);
        values.put("edited", edited);
        sqLiteDatabase.insert("tableFilms", null, values);
    }

    public void insertDataPeople(int id_peole, String name, String birth_year, String eye_color,
                                 String gender, String hair_color, String height, String mass, String skin_color, String homeworld, String films, Array species,
                                 Array starships, String vehicles, String url, String created, String edited) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id_peole);
        values.put("name", name);
        values.put("birth_year", birth_year);
        values.put("eye_color", eye_color);
        values.put("gender", gender);
        values.put("hair_color", hair_color);
        values.put("height", height);
        values.put("mass", mass);
        values.put("skin_color", skin_color);
        values.put("homeworld", homeworld);
        values.put("films", films);
        values.put("species", String.valueOf(species));
        values.put("starships", String.valueOf(starships));
        values.put("vehicles", vehicles);
        values.put("url", url);
        values.put("vehicles", created);
        values.put("vehicles", edited);
        sqLiteDatabase.insert("tablePeople", null, values);
    }

    public void insertDataPlanet(int id_planet, String name, String diameter, String rotation_period, String orbital_period, String gravity,
                                 String population, String climate, String terrain, String surface_water,
                                 String residents, Array films, Array url,
                                 String created, String edited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_planet", id_planet);
        values.put("name", name);
        values.put("diameter", diameter);
        values.put("rotation_period", rotation_period);
        values.put("orbital_period", orbital_period);
        values.put("gravity", gravity);
        values.put("population", population);
        values.put("climate", climate);
        values.put("terrain", terrain);
        values.put("surface_water", surface_water);
        values.put("residents", residents);
        values.put("films", String.valueOf(films));
        values.put("name", name);
        values.put("url", String.valueOf(url));
        values.put("created", created);
        values.put("edited", edited);

        sqLiteDatabase.insert("tableplanet", null, values);
    }

    public void insertDataSpecies(int id_species, String name, String classification, String designation, String average_height, String average_lifespan, String eye_colors,
                                  String hair_colors, String skin_colors, String language, String homeworld, Array people, Array films,
                                  String url, String created, String edited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_species", id_species);
        values.put("name", name);
        values.put("classification", classification);
        values.put("designation", designation);
        values.put("average_height", average_height);
        values.put("average_lifespan", average_lifespan);
        values.put("eye_colors", eye_colors);
        values.put("hair_colors", hair_colors);
        values.put("skin_colors", skin_colors);
        values.put("language", language);
        values.put("homeworld", homeworld);
        values.put("people", String.valueOf(people));
        values.put("films", String.valueOf(films));
        values.put("url", url);
        values.put("created", created);
        values.put("edited", edited);

        sqLiteDatabase.insert("tablespecies", null, values);
    }

    public void insertDataStarship(int id_starship, String name, String modeL, String starship_class
            , String manufacturer, String cost_in_credits, String length, String crew, String passengers
            , String max_atmosphering_speed, String hyperdrive_rating, String MGLT, String cargo_capacity
            , String consumables, Array films, Array pilots, String url, String created, String edited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_starship", id_starship);
        values.put("name", name);
        values.put("modeL", modeL);
        values.put("starship_class", starship_class);
        values.put("manufacturer", manufacturer);
        values.put("cost_in_credits", cost_in_credits);
        values.put("length", length);
        values.put("name", name);
        values.put("crew", crew);
        values.put("passengers", passengers);
        values.put("max_atmosphering_speed", max_atmosphering_speed);
        values.put("hyperdrive_rating", hyperdrive_rating);
        values.put("MGLT", MGLT);
        values.put("cargo_capacity", cargo_capacity);
        values.put("consumables", consumables);
        values.put("consumables", name);
        values.put("films", String.valueOf(films));
        values.put("pilots", String.valueOf(pilots));
        values.put("url", url);
        values.put("created", created);
        values.put("edited", edited);

        sqLiteDatabase.insert("tablePlanets", null, values);
    }

    public void insertDataVehicles(int id_vhicle, String name, String model, String vehicle_class, String manufacturer, String length
            , String cost_in_credits, String crew, String passengers, String max_atmosphering_speed, String cargo_capacity, String consumables,
                                   Array films, Array pilots, String url, String created, String edited) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id_vhicle", id_vhicle);
        values.put("name", name);
        values.put("model", model);
        values.put("vehicle_class", vehicle_class);
        values.put("manufacturer", manufacturer);
        values.put("length", length);
        values.put("cost_in_credits", cost_in_credits);
        values.put("crew", crew);
        values.put("passengers", passengers);
        values.put("max_atmosphering_speed", max_atmosphering_speed);
        values.put("cargo_capacity", cargo_capacity);
        values.put("consumables", consumables);
        values.put("films", String.valueOf(films));
        values.put("pilots", String.valueOf(pilots));
        values.put("url", url);
        values.put("edited", edited);

        sqLiteDatabase.insert("tablevehicles", null, values);
    }

    public ArrayList fetchData() {
        ArrayList<String> stringArrayList = new ArrayList<String>();

        String fetchdataFilms = "select * from tableFilms";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursorf = sqLiteDatabase.rawQuery(fetchdataFilms, null);
        if (cursorf.moveToFirst()) {
            do {
                for (int x = 0; x < 16; x++) {
                    stringArrayList.add(cursorf.getString(x));
                }
            } while (cursorf.moveToNext());
        }

        String fetchdataPeople = "select * from tablePeople";
        Cursor cursorP = sqLiteDatabase.rawQuery(fetchdataPeople, null);
        if (cursorP.moveToFirst()) {
            do {
                for (int x = 0; x < 18; x++) {
                    stringArrayList.add(cursorf.getString(x));
                }
            } while (cursorP.moveToNext());
        }

        String fetchdataPlanet = "select * from tablePlanet";
        Cursor cursorPla = sqLiteDatabase.rawQuery(fetchdataPlanet, null);
        if (cursorPla.moveToFirst()) {
            do {
                for (int x = 0; x < 15; x++) {
                    stringArrayList.add(cursorPla.getString(x));
                }
            } while (cursorPla.moveToNext());
        }

        String fetchdataSpecies = "select * from tablespecies";
        Cursor cursorSpe = sqLiteDatabase.rawQuery(fetchdataSpecies, null);
        if (cursorSpe.moveToFirst()) {
            do {
                for (int x = 0; x < 16; x++) {
                    stringArrayList.add(cursorSpe.getString(x));
                }
            } while (cursorSpe.moveToNext());
        }

        String fetchdataPlanets = "select * from tablePlanets";
        Cursor cursorPlanet = sqLiteDatabase.rawQuery(fetchdataPlanets, null);
        if (cursorPlanet.moveToFirst()) {
            do {
                for (int x = 0; x < 15; x++) {
                    stringArrayList.add(cursorPlanet.getString(x));
                }
            } while (cursorPlanet.moveToNext());
        }

        String fetchdataVehicles = "select * from tablevehicles";
        Cursor cursorVh = sqLiteDatabase.rawQuery(fetchdataVehicles, null);
        if (cursorVh.moveToFirst()) {
            do {
                for (int x = 0; x < 17; x++) {
                    stringArrayList.add(cursorPlanet.getString(x));
                }
            } while (cursorVh.moveToNext());
        }

        return stringArrayList;
    }



    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DataBase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }


}
