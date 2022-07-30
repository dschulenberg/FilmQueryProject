package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();

	}

	private void launch() {
		Scanner sc = new Scanner(System.in);

		startUserInterface(sc);

		sc.close();
	}

	private void startUserInterface(Scanner sc) {
		boolean start = true;
		do {
			displayMenu();

			int userInput = 0;
			userInput = tryCatchIntMenu(userInput, sc);
			switch (userInput) {
			case 1:
				searchByFilmId(sc);
				break;
			case 2:
				searchByKeyword(sc);
				break;
			case 3:
				start = false;
				break;
			default:
				System.out.println("Error, try again.");
				break;
			}
		} while (start);
		System.out.println("Thank you for using SDVideo, please come again. Goodbye.");

	}

	private void searchByFilmId(Scanner sc) {
		System.out.println("Enter a film id number:");
		int filminput = 0;
		filminput = tryCatchInt(filminput, sc);
		Film userFilm = db.findFilmById(filminput);
		if (userFilm == null) {
			System.out.println("Film is not found. Returning to menu.");
		} else {
			System.out.println("--------------------------------------------------");
			System.out.println(userFilm.filmInfo());
		}

	}

	private void searchByKeyword(Scanner sc) {
		System.out.println("Enter a keyword to search by title or description:");
		String userString = sc.next();
		String keyword = "%" + userString + "%";
		List<Film> userFilms = db.findFilmByKeyword(keyword);
		if (userFilms.size() == 0) {
			System.out.println("No film found with that keyword. Returning to menu.");
		} else {
			for (Film each : userFilms) {
				System.out.println("--------------------------------------------------");
				System.out.println(each.filmInfo());
			}
		}

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
				if (number <= 3 && number >= 0) {
					start = false;
				} else {
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
