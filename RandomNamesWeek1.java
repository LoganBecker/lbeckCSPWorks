//
//
//Logan Becker
//Data Structures and Algorithms
//Week 1
//Professor Tucker
//
//

package randomnamesweek1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomNamesWeek1 {

    public static void main(String[] args) throws FileNotFoundException {

        //main method throws fnf exception if .txt file does not exist
        
        ArrayList<String> fNames = new ArrayList<>();

        //Array List created to hold the values of the first names
        
        ArrayList<String> lNames = new ArrayList<>();

        //Array List created to hold the values of the last names
        
        ArrayList<Name> randomNames = new ArrayList<>();
        
        //Array List created to hold randomly generated names
        
        Map<String, ArrayList<String>> nameMap = new HashMap<>();
        
        //creates new hash map to connect first names to last names
                
        try ( 
                
                //try block for fnf exception 
                
                Scanner s1 = new Scanner(new File("firstnames.txt"))) {
            
            //scanner object created to traverse through .txt file of first names
            
            while (s1.hasNext()) {

                //while scanner has text to read
                
                fNames.add(s1.nextLine());

                //names are added into array list for first names
                
            }
        }
        
        catch (Exception e){
                    System.out.println("File not found.");
                    }
        
            //catches file not found exception and prints "file not found" if the file is not found

        try (
                
                //try block for fnf exception
                
                Scanner s2 = new Scanner(new File("lastnames.txt"))) {
            //scanner object created to traverse through .txt file of last names
            
            
            while (s2.hasNext()) {

                //while scanner has text to read
                lNames.add(s2.nextLine());

                //names are added into array for first names
            }
        }
        catch (Exception e){
                    System.out.println("File does not exist.");
                    }
        
            //catches file not found exception and prints "file not found" if the file is not found


        Random rand = new Random();

        //creates random object to randomly generate names
        
        System.out.println("Generated Names: \n");

        //prints
        
        for (int i = 1; i <= 20; i++) {

            //for loop to create 20 random names 
            
            String randFName = fNames.get(rand.nextInt(fNames.size()));

            //gets a random first name from array of first names
            
            String randLName = lNames.get(rand.nextInt(lNames.size()));

            //gets a random last name from array of last names
            
            Name fullName = new Name(randFName, randLName);

            //constructor creates a randomly generated name from the two random first and last names
            
            System.out.println(i + "." + " " + fullName);

            //prints index. full random name
            
            randomNames.add(fullName);
            
            //adds new full randomly generated name to random names array

        }

        Collections.sort(randomNames, (Name o1, Name o2) -> o1.fName.compareTo(o2.fName));

        //uses a lambda expression and the sort method as well as the compareTo() method from the comparable interface to compare two objects, in this case names, by their first names
        
        System.out.println();
        System.out.println("Sorted by first name: \n");

        randomNames.forEach((name) -> {
            
            //uses the forEach() method from the interable interface to go through each random name and print them in sorted order
            
            System.out.println(name);
            
            //prints the sorted names
            
        });

        Collections.sort(randomNames, (Name o1, Name o2) -> o1.lName.compareTo(o2.lName));

        //uses a lambda expression and the sort method as well as the compareTo() method from the comparable interface to compare two objects, in this case names, by their last names

        
        System.out.println();
        System.out.println("Sorted by last name: \n");

        randomNames.forEach((name) -> {
            
            //uses the forEach() method from the interable interface to go through each random name and print them in sorted order
            
            System.out.println(name);
            
            //prints the sorted names
            
        });

        
        randomNames.forEach((name) -> {
            
            //uses the iterable method forEach to run through each name
        
            String first = name.fName;
            
            //gets the first name from the full name
            
            if (!nameMap.containsKey(first)) {
                
                //if the hash map doesn't have a key for the first name 
            
                nameMap.put(first, new ArrayList<>());
                
                //puts first name in map and creates an array list of strings
            }
            
            nameMap.get(first).add(name.lName);
            
            //otherwise gets the first name key and adds last name to the array list in the map
        
        });
        

        System.out.println();
        System.out.println("Combine all names by First Name: \n");
        
        //prints
        
        nameMap.keySet().stream().map((fName) -> {
            
            //uses lambda expression to go through first names
            
            System.out.println(fName);
            
            //prints first name
            
            return fName;
            
            //returns first name
            
        }).forEachOrdered((String fName) -> {
            
            //uses lambda expression for each ordered first name
            
            nameMap.get(fName).forEach((lName) -> {
                
                //gets first name for each last name
            
                System.out.println("\t" + lName);
                
                //prints last name for as many instances of that last name
            });
        });
        
    }
}
