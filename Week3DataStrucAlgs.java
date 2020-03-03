/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3datastrucalgs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author loganbecker
 */
public class Week3DataStrucAlgs {

    /**
     * @throws java.io.FileNotFoundException
     */
    //array list of string words created to hold words from file
    public static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        

        System.out.println("Logan Becker: beckerl2@csp.edu");

        System.out.println("I certify that this is my own work.");

        System.out.println();

        //new scanner to scan file
        Scanner s = new Scanner(System.in);

        //try loop checking for file
        try {

            //scans .txt file
            s = new Scanner(new File("words.txt"));

            //catch fnf exception
        } catch (FileNotFoundException e) {

            //if file is not found print file not found
            System.out.println("File not found.");
        }

        //while loop goes through file while file has next line
        while (s.hasNextLine()) {

            //adds words to array list of strings called words
            words.add(s.nextLine().toLowerCase());
        }

        //for loop to run 10 iterations of radix sort algorithm
        for (int k = 9; k >= 0; k--) {

            //new array list of array lists of strings to hold the words
            ArrayList<ArrayList<String>> buckets = new ArrayList<>();

            //adds words to bucket they correspond with
            for (int i = 0; i < 27; i++) {

                //adds words to array list within the array list of Strings
                buckets.add(new ArrayList<>());
            }

            //performs radix sort for each iteration of string length
            words = performRadixSortIteration(words, buckets, k);

            System.out.println();

            //prints index iterating on
            System.out.println("Iterating on index: " + k);

            //displays Array list of words
            displayWordList(words);
        }
    }

    //creates method to perform radix sort and returns array list of extracted words
    public static ArrayList<String> performRadixSortIteration(ArrayList<String> words, ArrayList<ArrayList<String>> buckets, int iteration) {

        //for loop to perform radix sort
        for (int i = 0; i < words.size(); i++) {

            //creates string value word to hold words
            String word = words.get(i);

            //gets index for word
            int val = getBucketIndexForWord(word, iteration);

            //place in correct bucket
            placeInBucket(buckets, val, words.get(i));
        }

        //new array list created for extracted array list of strings
        ArrayList<String> newList = extractFromBucket(buckets, words);

        //returns array list
        return newList;
    }

    //method is created to place words in buckets
    public static void placeInBucket(ArrayList<ArrayList<String>> buckets, int bucketLocation, String word) {

        //adds words on correct index to Array list of array list of Strings: buckets
        buckets.get(bucketLocation).add(word);

    }

    //method created to return array list of strings
    public static ArrayList<String> extractFromBucket(ArrayList<ArrayList<String>> buckets, ArrayList<String> words) {

        //array list created to hold extracted values
        ArrayList<String> extractedList = new ArrayList<>();

        //for loop to create 27 buckets for 26 letters of the alphabet and a bucket for words with no letters
        for (int i = 0; i < buckets.size(); i++) {

            //array list of strings temp created to hold values to extract
            ArrayList<String> temp = buckets.get(i);

            //for loop to create a new array list of extracted values
            for (int j = 0; j < temp.size(); j++) {

                //adds values of temp array of strings to new array list of strings
                extractedList.add(temp.get(j));

            }
        }

        //returns extracted array list of strings
        return extractedList;

    }

    //creates method to display the word list
    public static void displayWordList(ArrayList<String> words) {

        //iterator to go through Array list of strings: words
        words.forEach((word) -> {

            //index of 9 to start
            int index = 9;

            //prints word in words and a blank char
            System.out.print(word + " ");

            //subtracts 1 from the index
            index--;

        });

        //prints a new line
        System.out.println();
    }

    //method to get bucket index for the string of a word returns int for the bucket number
    static int getBucketIndexForWord(String word, int index) {

        //if the word is has a shorter length than the index it is iterating on it returns 26 for the last bucket
        if (word.length() <= index) {

            //returns 26 for the last bucket
            return 26;
        }

        //char variable created to get char at index
        char first = word.charAt(index);

        //converts char to its ordinal value in ASCII
        int ord = first;

        //int variable created called val 
        //ordinal value - 97 gets correct index for buckets
        int val = (ord - 97);

        //returns char position in alphabet
        return val;
    }

    public static void insertionSort(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int currentElement = x[i];
            int k;
            for (k = i - 1; k >= 0 && x[k] > currentElement; k--) {
                x[k + 1] = x[k];
            }
            x[k + 1] = currentElement;
        }

    }

    public static void bubbleSort(int[] x) {

        boolean needNextPass = true;

        for (int k = 1; k < x.length && needNextPass; k++) {

            needNextPass = false;

            for (int i = 0; i < x.length - k; i++) {

                if (x[i] > x[i + 1]) {

                    int temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;

                    needNextPass = true;

                }
            }

        }

    }

}
