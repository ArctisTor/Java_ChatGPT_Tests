package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
//        while ((line = in.readLine()) != null) {
//            //System.out.println(line);
//            System.out.println(sequenceOfNumbers(line));
//        }
        System.out.println(sequenceOfNumbers("40 40 40 40 29 29 29 29 29 29 29 29 57 57 92 92 92 92 92 86 86 86 86 86 86 86 86 86 86"));


        String word = "blah";
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.charAt(i));
        }
    }

    public static String sequenceOfNumbers(String sequence) {
        String sequenceString = "";
        try (BufferedReader reader = new BufferedReader(new StringReader(sequence))){
            String line;
            int occurance = 0;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                int targetNumber = 0;

                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (occurance == 0) {
                        occurance++;
                        targetNumber = num;
                    } else if (targetNumber == num) {
                        occurance++;
                    } else {
                        sequenceString += occurance + " " + targetNumber + " ";
                        occurance = 0;
                    }

                }

            }
        } catch (Exception e) {

        }
        return sequenceString;
    }
}
