package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // System.out.println("OK this works");
        if (args.length != 1) {
            System.out.println("Please indicate the File Name");
            System.exit(1);
        }

        String filename = args[0];
        Path cithpath = Paths.get(filename);
        File cith = cithpath.toFile();

        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            // remove punctuations

            line = line.replaceAll("\\.|\\,|\\:|\\!|\\?|\\-|\\(|\\)|\\{|\\}|\\'|\"", " ");
            line = line.toUpperCase();
            String[] wordsarray = line.trim().split(" ");
            for(int i = 0 ; i < wordsarray.length ; i++){
                String word = wordsarray[i];
                if(!word.equals("")){
                    System.out.println(word);
                }



            }



        }

    }

}