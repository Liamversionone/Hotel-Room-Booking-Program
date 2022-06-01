package mod;

import javax.swing.JOptionPane;

public class Overseer {

	//These private instance variables are used to store data within the class, such as options for selection, as well as String, int, and boolean values.
	private String[] options = {"Low Cost", "Medium Cost", "High Cost"};
	private String[] options2 = {"Yes", "No"};
	private boolean[] available;
	private String dates;
	private Rooms room;
	private String roomType;
	private String beginning;
	private String ending;
	private int begin;
	private int end;
	private boolean booked = false;
	private boolean incorrect = true;
	private String cardNumber;
	private int cost;
	private boolean parsible;
	private int type;
	private int type2;
	
	/*This constructor is what is used to run all of the helper methods for the program. It executes code that creates windows for the user to interact with.
	  The windows allow the user to select what kind of room they want to book, what dates they want to book them, and how much they will cost.*/
	public Overseer() {
		JOptionPane.showMessageDialog(null, "Welcome to TotallyTrivago!");
		type = JOptionPane.showOptionDialog(null, "Choose which type of room you would like to book:", "Room selector", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		map(type);
		while(!booked) {
			while(incorrect) {
				parsible = false;
				beginning = JOptionPane.showInputDialog(null, "What is the first day you would like to book?\n\n" + dates);
				if(beginning.equals("1") || beginning.equals("2") || beginning.equals("3") || beginning.equals("4") || beginning.equals("5") || beginning.equals("6") || beginning.equals("7") || beginning.equals("8") || beginning.equals("9") || beginning.equals("10") || beginning.equals("11") || beginning.equals("12") || beginning.equals("13") || beginning.equals("14") || beginning.equals("15") || beginning.equals("16") || beginning.equals("17") || beginning.equals("18") || beginning.equals("19") || beginning.equals("20") || beginning.equals("21") || beginning.equals("22") || beginning.equals("23") || beginning.equals("24") || beginning.equals("25") || beginning.equals("26") || beginning.equals("27") || beginning.equals("28") || beginning.equals("29") || beginning.equals("30") || beginning.equals("31")) {
					parsible = true;
				}
				else if(beginning.equalsIgnoreCase("terminate")) {
					JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "That is not a valid date!");
				}
				if(parsible) {
					begin = Integer.parseInt(beginning);
					if(begin != 31 && !available[begin]) {
						JOptionPane.showMessageDialog(null, "You cannot book this room because there is no extra time to clean.");
					}
					else {
						incorrect = false;
					}
				}
			}
			if(begin < 30 && !available[begin + 1]) {
				end = begin + 1;
				JOptionPane.showMessageDialog(null, "You may only book this room for one day.");
			}
			else {
				incorrect = true;
				while(incorrect) {
					parsible = false;
					ending = JOptionPane.showInputDialog(null, "What is the last day you would like to book?\n\n" + dates);
					if(ending.equals("1") || ending.equals("2") || ending.equals("3") || ending.equals("4") || ending.equals("5") || ending.equals("6") || ending.equals("7") || ending.equals("8") || ending.equals("9") || ending.equals("10") || ending.equals("11") || ending.equals("12") || ending.equals("13") || ending.equals("14") || ending.equals("15") || ending.equals("16") || ending.equals("17") || ending.equals("18") || ending.equals("19") || ending.equals("20") || ending.equals("21") || ending.equals("22") || ending.equals("23") || ending.equals("24") || ending.equals("25") || ending.equals("26") || ending.equals("27") || ending.equals("28") || ending.equals("29") || ending.equals("30") || ending.equals("31")) {
						parsible = true;
					}
					else if(beginning.equalsIgnoreCase("terminate")) {
						JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(null, "That is not a valid date!");
					}
					if(parsible) {
						end = Integer.parseInt(ending);
						if(!check(begin, end)) {
							JOptionPane.showMessageDialog(null, "You cannot book these dates all together.");
						}
						else if(end != 31 && !available[end]) {
							JOptionPane.showMessageDialog(null, "You cannot book this room because there is no extra time to clean.");
						}
						else {
							incorrect = false;
						}
					}
				}
				booked = true;
			}
		}
		if(type == 0) {
			cost = 100;
			roomType = "Low-end";
		}
		else if(type == 1) {
			cost = 225;
			roomType = "Medium tier";
		}
		else {
			cost = 5000;
			roomType = "High-end";
		}
		cardNumber = JOptionPane.showInputDialog(null, "So you would like a " + roomType + " room from " + begin + " to " + end + ".\n This will cost " + (end - begin + 1) * cost + "\n\nPlease enter your credit card number to proceed:");
		if(cardNumber.equalsIgnoreCase("terminate")) {
			JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "Thank you for booking with TotallyTrivago. Hope you enjoy your stay!");
		int another = JOptionPane.showOptionDialog(null, "Would you like to book another room?", "Another room?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
		if(another == 0) {
			parsible = false;
			type2 = JOptionPane.showOptionDialog(null, "Choose which type of room you would like to book:", "Room selector", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			map(type2, begin, end);
			booked = false;
			incorrect = true;
			while(!booked) {
				while(incorrect) {
					beginning = JOptionPane.showInputDialog(null, "What is the first day you would like to book?\n\n" + dates);
					if(beginning.equals("1") || beginning.equals("2") || beginning.equals("3") || beginning.equals("4") || beginning.equals("5") || beginning.equals("6") || beginning.equals("7") || beginning.equals("8") || beginning.equals("9") || beginning.equals("10") || beginning.equals("11") || beginning.equals("12") || beginning.equals("13") || beginning.equals("14") || beginning.equals("15") || beginning.equals("16") || beginning.equals("17") || beginning.equals("18") || beginning.equals("19") || beginning.equals("20") || beginning.equals("21") || beginning.equals("22") || beginning.equals("23") || beginning.equals("24") || beginning.equals("25") || beginning.equals("26") || beginning.equals("27") || beginning.equals("28") || beginning.equals("29") || beginning.equals("30") || beginning.equals("31")) {
						parsible = true;
					}
					else if(beginning.equalsIgnoreCase("terminate")) {
						JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
						System.exit(0);
					}
					else {
						JOptionPane.showMessageDialog(null, "That is not a valid date!");
					}
					if(parsible) {
						begin = Integer.parseInt(beginning);
						if(begin != 31 && !available[begin]) {
							JOptionPane.showMessageDialog(null, "You cannot book this room because there is no extra time to clean.");
						}
						else {
							incorrect = false;
						}
					}
				}
				if(begin < 30 && !available[begin + 1]) {
					end = begin + 1;
					JOptionPane.showMessageDialog(null, "You may only book this room for one day.");
				}
				else {
					incorrect = true;
					while(incorrect) {
						parsible = false;
						ending = JOptionPane.showInputDialog(null, "What is the last day you would like to book?\n\n" + dates);
						if(ending.equals("1") || ending.equals("2") || ending.equals("3") || ending.equals("4") || ending.equals("5") || ending.equals("6") || ending.equals("7") || ending.equals("8") || ending.equals("9") || ending.equals("10") || ending.equals("11") || ending.equals("12") || ending.equals("13") || ending.equals("14") || ending.equals("15") || ending.equals("16") || ending.equals("17") || ending.equals("18") || ending.equals("19") || ending.equals("20") || ending.equals("21") || ending.equals("22") || ending.equals("23") || ending.equals("24") || ending.equals("25") || ending.equals("26") || ending.equals("27") || ending.equals("28") || ending.equals("29") || ending.equals("30") || ending.equals("31")) {
							parsible = true;
						}
						else if(beginning.equalsIgnoreCase("terminate")) {
							JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
							System.exit(0);
						}
						else {
							JOptionPane.showMessageDialog(null, "That is not a valid date!");
						}
						if(parsible) {
							end = Integer.parseInt(ending);
							if(!check(begin, end)) {
								JOptionPane.showMessageDialog(null, "You cannot book these dates all together.");
							}
							else if(end != 31 && !available[end]) {
								JOptionPane.showMessageDialog(null, "You cannot book this room because there is no extra time to clean.");
							}
							else {
								incorrect = false;
							}
						}
					}
					booked = true;
				}
			}
			if(type2 == 0) {
				cost = 100;
				roomType = "Low-end";
			}
			else if(type2 == 1) {
				cost = 225;
				roomType = "Medium tier";
			}
			else {
				cost = 5000;
				roomType = "High-end";
			}
			cardNumber = JOptionPane.showInputDialog(null, "So you would like a " + roomType + " room from " + begin + " to " + end + ".\n This will cost " + (end - begin + 1) * cost + "\n\nPlease enter your credit card number to proceed:");
			if(cardNumber.equalsIgnoreCase("terminate")) {
				JOptionPane.showMessageDialog(null, "So sad to see you go. Have a good day.");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Thank you for booking with TotallyTrivago. Hope you enjoy your stay!");
		}
		else {
			System.exit(0);
		}
	
	
	}
	
	/*This method sets the dates String instance variable to a String that displays all of the related dates of the month. This is found by using the number of
	  values within the selected room type's array of values.*/
	private void map(int x) {
		dates = "";
		if(x == 0) {
			room = Rooms.Low;
		}
		if(x == 1) {
			room = Rooms.Medium;
		}
		if(x == 2) {
			room = Rooms.High;
		}
		available = room.getArr();
		String space = "  ";
		int num = 1;
		for(int i = 0; i < available.length; i++) {
			if(available[i] && num < 10) {
				dates += num + space;
			}
			else if(available[i]) {
				dates += num + " ";
			}
			else {
				dates += "X" + space;
			}
			if(num % 7 == 0) {
				dates += "\n";
			}
			num++;
		}
	}
	
	/*This method sets the dates String instance variable to a String that displays all of the related dates of the month. This is found by using the number of
	  values within the selected room type's array of values. It also sets the dates that have been booked to false, showing that they can no longer be booked.*/
	private void map(int x, int y, int z) {
		dates = "";
		if(x == 0) {
			room = Rooms.Low;
		}
		if(x == 1) {
			room = Rooms.Medium;
		}
		if(x == 2) {
			room = Rooms.High;
		}
		available = room.getArr();
		if(type2 == type) {
			for(int i = y - 1; i <= z; i++) {
				available[i] = false;
			}
		}
		String space = "  ";
		int num = 1;
		for(int i = 0; i < available.length; i++) {
			if(available[i] && num < 10) {
				dates += num + space;
			}
			else if(available[i]) {
				dates += num + " ";
			}
			else {
				dates += "X" + space;
			}
			if(num % 7 == 0) {
				dates += "\n";
			}
			num++;
		}
	}
	
	//This method checks to see if the rooms selected are available.
	private boolean check(int x, int y) {
		for(int i = x - 1; i < y; i++) {
			if(!available[i]) {
				return false;
			}
		}
		return true;
	}
}
