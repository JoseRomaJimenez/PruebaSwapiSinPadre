package ufv.dis.final2022.JRJ;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class Controlador {


    @PostMapping(path = "/descargar", produces = "application/json", consumes = "application/json")

    public ResponseEntity<Entity> descargar(@RequestBody SolicitudDescarga solicitudDescarga) {

        String peopleString = null;
        try {
            peopleString = API.getEntitySwapi(solicitudDescarga);
            Gson gson = new Gson();

            if (solicitudDescarga.getEntity().equals("people")) {

                People people = gson.fromJson(peopleString, People.class);
                DataHandler.altaEntity(people);

                return ResponseEntity.ok(people);

            } else {

                Starship starship = gson.fromJson(peopleString, Starship.class);
                DataHandler.altaEntity(starship);

                return ResponseEntity.ok(starship);
            }
        } catch (IOException e) {
           return ResponseEntity.notFound().build();
        } catch (InterruptedException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping(value ={ "/consultar/{num}","/consultar"})
    public ResponseEntity<ArrayList<Entity>> consultar(@PathVariable(required = false) Integer num) {

        try {
            ArrayList<Entity> entities = DataHandler.leerEntities();
            if(num == null){
                return new ResponseEntity(entities, HttpStatus.OK);
            }else {
                return new ResponseEntity(entities.get(num), HttpStatus.OK);
            }
        } catch (IOException e) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }



}




