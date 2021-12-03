package edu.neu.coe.info6205.finalProject.util;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class FileUtil {

    /**
     * Reads a csv file from the input path.
     * Converts the csv file contents into list of string where each string is a line in the file.
     * returns the list of strings.
     * @param filePath
     * @return
     */
    public static List<String> readFile(String filePath){

        List<String> data= new ArrayList<>();
        String line = "";
        try (   FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);)
        {

            //bufferedReader.readLine(); //Skip the header line
            while ((line = bufferedReader.readLine()) != null)
            {
                data.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


    /**
     * Writes a list of strings to a csv file in the given input path.
     * Each string in the input list is written as a new line in the csv file.
     * @param data
     * @param filePath
     */
    public static void writeToFile(List<String> data, String filePath) {


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));){

            for (String line : data)
            {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.14.1</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
    </dependencies>
* */
