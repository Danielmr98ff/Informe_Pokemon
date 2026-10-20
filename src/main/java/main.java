import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {
    ObjectMapper objectMapper = new ObjectMapper();
     try (InputStream inputStream = main.class.getClassLoader().getResourceAsStream("pokemon.json")) {
        if (inputStream == null) {
            System.out.println("Json no encontrando");
            return;
        }
        List<Pokemon> pokedex = objectMapper.readValue(inputStream, new TypeReference<List<Pokemon>>(){}) ;
        System.out.println("Pokedex cargada");

        for (Pokemon p : pokedex) {

            System.out.println("ID:" + p.getId() + "Nombre:" + p.getNombre() + "Tipo:" + p.getTipo() + "Nivel:" + p.getNivel());
        }
     } catch (Exception e){
        e.printStackTrace();
    }
 }
