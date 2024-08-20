package ua.pp.hophey.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LinksRepository {

    public void saveAll(List<String> links){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("storage/links.json"), links);
            System.out.println("JSON сохранен в файл links.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
