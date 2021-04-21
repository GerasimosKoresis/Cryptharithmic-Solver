# Cryptharithmic-Solver
An exercise in a pset for course " Artificial Intelligence"

To run the program copy and paste to a Java IDE the CryptoMain.java file where all the code is as well as the main

As the program starts you will be asked to insert the first addant of the puzzle, then the second and then the sum of the cryptarithmic puzzle.

An example would be:

      TO
    + TO
- - - - - - - - -
     FOR
     
     
You are then asked to insert in what numerical system shall the puzzle be examined as to whether it can be solved

The available options are for senary or decimal system, but should you like to test it on another numerical system of your preference, 
you just have to meddle a bit with the numberSystem() function, meaning to comment out the if()/else() that checks that you answered 6 or 10.

The basis under which the puzzle is solved is through backtracking an constraint problem satisfaction algorithm. 
We assign values to the puzzle letters and check if the solve the puzzle, if not it means we didnt assign the correct values and try again.
In case the puzzle does not have a solution, it will not print out anything
