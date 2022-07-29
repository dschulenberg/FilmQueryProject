package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
   // app.test();   
    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner sc = new Scanner(System.in);
    
    startUserInterface(sc);
    
    sc.close();
  }

  private void startUserInterface(Scanner sc) {
	  boolean start =true;
	  do {
		  displayMenu();
		  
		  int userInput = 0;
		  userInput=tryCatchIntMenu(userInput,sc);
		  switch(userInput) {
		  case 1:
			  searchByFilmId(sc);
			  break;
		  case 2:
			  break;
		  case 3:
			  start=false;
			  break;
		  default:
			  System.out.println("Error, try again.");
				  break;
		  }
	  }while(start);
	  System.out.println("Thank you for using SDVideo, please come again. Goodbye.");
	  
	 System.out.println(db.findFilmById(12).toString());
	  
    db.findActorById(7);
    for(Actor actor: db.findActorsByFilmId(12) ) {
    	System.out.println(actor.toString());
    }
    }
  
  private void searchByFilmId(Scanner sc) {
	  System.out.println("Entera film id number:");
	  int filminput=0;
	  filminput = tryCatchInt(filminput, sc); 
	  db.findFilmById(filminput);
//	  System.out.println(db.findFilmById(filminput).toString());
	  
  }
  private void displayMenu() {
	  	System.out.println("--------------------------------------------------");
		System.out.println("Please choose a number from the following:");
		System.out.println("1. Look up a film by its id. ");
		System.out.println("2. Look up a film by a search keyword.");
		System.out.println("3. Exit the application.");
		System.out.println("--------------------------------------------------");
  }
	public int tryCatchIntMenu(int number, Scanner sc) {
		boolean start = true;
		do {
			try {
				number = sc.nextInt();
				if(number<=3 && number >=0) {
				start = false;
				}else {
					System.out.println("Enter a number 1-3 to continue.");
				}
			} catch (Exception e) {
				System.out.println("You must a number 1-3. Try again.");
				sc.nextLine();
				System.out.println();
			}
		} while (start);
		return number;
	}
	public int tryCatchInt(int number, Scanner sc) {
		boolean start = true;
		do {
			try {
				number = sc.nextInt();
				start = false;
				
			} catch (Exception e) {
				System.out.println("You must a number. Try again.");
				sc.nextLine();
				System.out.println();
			}
		} while (start);
		return number;
	}
}
