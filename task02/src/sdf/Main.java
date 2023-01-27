package sdf;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        boolean stop = false;

        System.out.println("Welcome.");

        while (!stop) {
            Console cons = System.console();
            String userinput = cons.readLine("> ");
            String[] inputarray = userinput.trim().split(" ");

            if (inputarray.length == 1) {

                if (inputarray[0].equals(Constant.EXIT)) {
                    System.out.println("Bye bye");
                    stop = true;
                } else {
                    System.out.println("Invalid Command, Please try again!");
                }

            } else if (inputarray.length == 3) {
                Float number1, number2, result = 0f;
                if (inputarray[0].equals("$last")) {
                    number1 = getlast();
                } else {
                    number1 = Float.parseFloat(inputarray[0]);
                }

                if (inputarray[2].equals("$last")) {
                    number2 = getlast();
                } else {
                    number2 = Float.parseFloat(inputarray[2]);
                }

                switch (inputarray[1]) {
                    case Constant.ADD:
                        result = number1 + number2;
                        System.out.println(result);
                        updatelast(result.toString());
                        break;

                    case Constant.SUBTRACT:
                        result = number1 - number2;
                        System.out.println(result);
                        updatelast(result.toString());
                        break;

                    case Constant.DIVIDE:
                        result = number1 / number2;
                        System.out.println(result);
                        updatelast(result.toString());
                        break;

                    case Constant.MULTIPLY:
                        result = number1 * number2;
                        System.out.println(result);
                        updatelast(result.toString());
                        break;

                    default:
                        System.out.println("Invalid Operator , Please Try Again");
                        break;
                }

            } else {
                System.out.println("Invalid Command, Please try again!");
            }
        }

    }

    public static void updatelast(String lastresult) throws IOException {
        Path cithpath = Paths.get("last.dat");
        File cith = cithpath.toFile();
        FileWriter wr = new FileWriter(cith);
        wr.write(lastresult);
        wr.close();

    }

    public static Float getlast() throws FileNotFoundException, IOException {
        Path cithpath = Paths.get("last.dat");
        File cith = cithpath.toFile();
        if (!cith.exists()) {
            System.out.println("File Not Found - last.dat");
            System.exit(1);
        }

        FileReader fr = new FileReader(cith);
        BufferedReader br = new BufferedReader(fr);
        Float last = Float.parseFloat(br.readLine());// assume only 1st line contain the last value;
        br.close();
        return last;

    }

}
