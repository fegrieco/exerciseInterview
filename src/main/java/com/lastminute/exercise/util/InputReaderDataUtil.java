package com.lastminute.exercise.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputReaderDataUtil {

    private static final Logger logger = LoggerFactory.getLogger(InputReaderDataUtil.class);

    public static List<String> readFileLineByLine (String fileName)  {

        BufferedReader reader;
        ArrayList lines = new ArrayList();
        try {
            InputStreamReader streamReader = new InputStreamReader (InputReaderDataUtil.class.getClassLoader().getResourceAsStream(fileName));
            reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
           logger.error("error read file",e);
        }
        return  lines;
    }

    public static List<String> readerFromJson(String json){
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(json).getAsJsonObject();
        JsonArray arrayElements = obj.getAsJsonArray("shopping_basket");
        List<String> lines = new ArrayList<>();
       arrayElements.forEach(elem ->lines.add(elem.getAsString()));
        return lines ;

    }


}
