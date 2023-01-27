package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        if (args.length != 1) {
            System.out.println("Please indicate the File Name");
            System.exit(1);
        }

        Map<String, Integer> wordscount = new HashMap<>();
        Float totalwords = 0f;

        String filename = args[0];
        Path cithpath = Paths.get(filename);
        File cith = cithpath.toFile();
        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);
        String line;

        //read file and remove punctuations
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("\\.|\\,|\\:|\\!|\\?|\\-|\\(|\\)|\\{|\\}|\\'|\"", " ");
            line = line.toUpperCase();
            String[] wordsarray = line.trim().split(" ");
            for (int i = 0; i < wordsarray.length; i++) {
                String word = wordsarray[i];
                if (!word.equals("")) {
                    totalwords = totalwords + 1;
                    if (wordscount.containsKey(word)) {
                        int existingcount = wordscount.get(word);
                        wordscount.put(word, existingcount + 1);

                    } else {
                        wordscount.put(word, 1);
                    }
                }
            }
        }

        br.close();
        fr.close();


        System.out.println("#################################################################");
        System.out.println("TOTAL WORDS IN DOCUMENT = " + totalwords);

        // Loop and find the highest and print and remove from collection
        for (int i = 1; i <= 10; i++) {
            float highestcount = 0;
            String highestword = "";
            float frequency = 0f;
            for (String x : wordscount.keySet()) {
                if (wordscount.get(x) > highestcount) {
                    highestword = x;
                    highestcount = wordscount.get(x);
                    frequency = highestcount / totalwords;
                }
            }
            System.out.println(i + "." + highestword + " Count=" + highestcount + " Term Frequency=" + frequency);
            wordscount.remove(highestword);
        }

        System.out.println("#################################################################");

    }

}