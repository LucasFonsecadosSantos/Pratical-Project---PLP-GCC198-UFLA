/**
 *
 *  CITY MANAGER 1.0 June 26, 2017.
 *  Pratical Project by Paradigms and Programming Languages
 *  GCC198 - Federal University of Lavras (UFLA)
 *
 *  @author Lucas Fonseca dos Santos
 *  @author Leticia Ferreira
 */
package gui;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Gui {

    private Scanner scanner;

    public Gui() {
        scanner = new Scanner(System.in);
    }

    public int callMenu(){
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+           CITY MANAGER SYSTEM v1.0               +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.println("+                                                  +");
        System.out.println("+ What do you want here?                           +");
        System.out.println("+ [1] Add a new city                               +");
        System.out.println("+ [2] Remove a city                                +");
        System.out.println("+ [3] Edit a city                                  +");
        System.out.println("+ [4] Enter a city to manager it                   +");
        System.out.println("+ [5] Print out                                    +");
        System.out.println("+                                                  +");
        System.out.println("+ [-99] EXIT                                       +");
        System.out.println("+                                                  +");
        System.out.println("+==================================================+");
        System.out.print("[#] ENTER YOUR OPTION: ");
        return scanner.nextInt();
    }

    public List<String> createCityInformations() {
        List<String> informations = new ArrayList<String>();
        while(scanner.hasNextLine()) {
            scanner.nextLine();
        }
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ REGISTER A NEW CITY                              +");
        System.out.println("+--------------------------------------------------+");
        System.out.println("+ [#] City Name: ");
        informations.add(scanner.nextLine());
        System.out.println("+ [#] Amount City Population (Enter a integer value): ");
        informations.add(scanner.nextLine());
        System.out.println("+ [#] PIB (Enter a integer or decimal value): ");
        informations.add(scanner.nextLine());
        return informations;
    }

}