package uap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Car {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> ID = new ArrayList<String>();
	ArrayList<String> Brand = new ArrayList<String>();
	ArrayList<String> Classification = new ArrayList<String>();
	ArrayList<String> Model = new ArrayList<String>();
	ArrayList<String> Status = new ArrayList<String>();
	ArrayList<Integer> Price = new ArrayList<Integer>();

	public Car() {
		int chs = 0;

		do {
			System.out.println("GUz' Super Showroom!");
			System.out.println("====================");
			System.out.println("\n\n");
			System.out.println("1. Add New Car");
			System.out.println("2. Remove Car");
			System.out.println("3. Restock Car");
			System.out.println("4. View Cars");
			System.out.println("5. Sell Car");
			System.out.println("6. Exit");

			do {
				System.out.print("Choose: ");
				chs = sc.nextInt();
				sc.nextLine();
			} while (chs < 1 || chs > 6);
			switch (chs) {
			case 1:
				cls();
				addCar();
				break;
			case 2:
				cls();
				remove();
				break;
			case 3:
				cls();
				change();
				break;
			case 4:
				cls();
				view();
				break;
			case 5:
				cls();
				sell();
				break;
			case 6:
				System.out.println("Good Bye");
			}
		} while (chs != 6);
	}

	public void cls() {
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
	}

	public void addCar() {
		String iBrand, iModel, iClassification;
		int iPrice = 0;
		do {
			System.out.print("Select Brand [Ferrari | Porsche | Bugatti | McLaren]: ");
			iBrand = sc.nextLine();
		} while (!iBrand.equals("Ferrari") && !iBrand.equals("Porsche") && !iBrand.equals("Bugatti")
				&& !iBrand.equals("McLaren"));

		do {
			System.out.print("Input Car Model [5..20]: ");
			iModel = sc.nextLine();
			if (iModel.length() > 20) {
				System.out.println("Input 20 Character Only!");
			}
		} while (iModel.length() < 5 || iModel.length() > 20);

		do {
			System.out.print("Car Classification [Supercar | Classic | Muscle]: ");
			iClassification = sc.nextLine();
		} while (!iClassification.equalsIgnoreCase("Supercar") && !iClassification.equalsIgnoreCase("Classic")
				&& !iClassification.equalsIgnoreCase("Muscle"));

		do {
			try {
				System.out.print("Input Car Price (USD) [min. 30.0000]: ");
				iPrice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Input Number Only\n");
			}
		} while (!(iPrice >= 30000));
		String a = iBrand.substring(0, 2);

		Random random = new Random();
		int x = random.nextInt(900) + 100;

		String re = iModel.replaceAll("\\s+", "_");

		String id = (a + "-" + x + "-" + re);
		ID.add(id);
		Brand.add(iBrand);
		Model.add(iModel);
		Classification.add(iClassification);
		Status.add("Available");
		Price.add(iPrice);
		System.out.println("Success to Add!");
		sc.nextLine();
		cls();
	}

	public void view() {
		if (Brand.size() == 0) {
			System.out.println("-No car in collection yet-");
		}
		for (int i = 0; i < ID.size(); i++) {
			System.out.println("List Of Cars \n");
			System.out.println("=============================== \n \n");
			System.out.println("=============================== \n");
			System.out.println("ID          		: " + ID.get(i));
			System.out.println("Brand        		: " + Brand.get(i));
			System.out.println("Classification      	: " + Classification.get(i));
			System.out.println("Car Model      		: " + Model.get(i));
			System.out.println("Status      		: " + Status.get(i));
			System.out.println("Price (USD)      	: " + Price.get(i));
			System.out.println("=============================== \n");
		}
	}

	public void remove() {
		int chs2 = 0;
		int str = Brand.size();
		if (Brand.size() == 0) {
			System.out.println("-No car in collection yet-");
		}
		do {
			try {
				System.out.println("Choose [1.." + str + "]");
				chs2 = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Input Number Only!");
			}
		} while (chs2 < 1 || chs2 > str);
		ID.remove(chs2 - 1);
		Brand.remove(chs2 - 1);
		Classification.remove(chs2 - 1);
		Model.remove(chs2 - 1);
		Status.remove("Available");
		Price.remove(chs2 - 1);
	}

	public void change() {
		for (int i = 0; i < ID.size(); i++) {
			if (Status.equals("Not Available")) {
				Status.set(4, "Available");
			}
		}
	}

	public void sell() {
		int chs3 = 0;
		int str = Brand.size();
		if (Brand.size() == 0) {
			System.out.println("-No car in collection yet-");
		}

		view();
		do {
			try {
				System.out.println("Choose [1.." + str + "]");
				chs3 = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Input Number Only!");
			}
		} while (chs3 < 1 || chs3 > str);

		for (int i = 0; i < ID.size(); i++) {
			int total = (int) (Price.get(chs3) + (Price.get(chs3) * 0.1));

			ID.get(chs3 - 1);
			Brand.get(chs3 - 1);
			Classification.get(chs3 - 1);
			Model.get(chs3 - 1);
			Status.get(chs3 - 1);
			Price.get(chs3 - 1);

			System.out.println("Price After Tax (10%): " + total);
			System.out.println("Enjoy Your Car!");
			Status.set(4, "Not Available");
			sc.nextLine();
		}
	}

	public static void main(String[] args) {
		new Car();
	}

}
