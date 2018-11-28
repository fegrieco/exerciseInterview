package com.lastminute.exercise.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static List<String> readFileLineByLine (String fileName)  {

        BufferedReader reader;
        ArrayList lines = new ArrayList();
        try {
            InputStreamReader streamReader = new InputStreamReader (FileUtil.class.getClassLoader().getResourceAsStream(fileName));
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


}
