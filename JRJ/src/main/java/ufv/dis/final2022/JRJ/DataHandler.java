package ufv.dis.final2022.JRJ;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataHandler {

    private static final String PATH = "swapi.json";


    public static ArrayList<Entity> leerEntities() throws IOException {
        ArrayList<Entity> entities = new ArrayList<>();

        RuntimeTypeAdapterFactory<Entity> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Entity.class, "type")
                .registerSubtype(People.class, "people")
                .registerSubtype(Starship.class, "starship");

        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
        //Si hubiese fechas ponemos lo de abajo y la fecha en este formato (puede estar en otro orden el formato)
        //Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd hh:mm:ss").create();

        //Leemos el fichero
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./src/main/resources/" + PATH))); // Funcion que lee el fichero
            Type datoListType = new TypeToken<ArrayList<Entity>>(){}.getType();
            entities = gson.fromJson(reader, datoListType); //Convierte el fichero json que tenemos, a arraylist de productos
            reader.close(); //Cerramos el fichero

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        }


        return entities;
    }

    public static void guardarEntity(ArrayList<Entity> entities) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Si hubiese fechas ponemos lo de abajo y la fecha en este formato (puede estar en otro orden el formato)
        //Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd hh:mm:ss").create();
        String json = gson.toJson(entities); //Recibe arraylist y lo convierte a json y luego escribimos el json en un fichero
        PrintWriter printer = new PrintWriter("./src/main/resources/" + PATH); // Creamos el objeto que puede escribir en fichero
        printer.print(json); //Escribimos el json en el fichero
        printer.close(); //Cerramos el fichero
    }

    public static void altaEntity(Entity entity) throws IOException {
        ArrayList<Entity> entities = leerEntities();
        entities.add(entity);
        guardarEntity(entities);

        //Si queremos que no se repitan los productos de nuestro json
        /* if(entities.contains(entity)){
            System.out.println("Ya existe el producto");
        }else{
            entities.add(entity);
            guardarEntity(entities);
        }*/
    }

}


