package mod;

public enum Rooms {

	/*These arrays are used to determine the availability of rooms. True values mean the rooms can be booked for those dates. False means the rooms cannot be
	  booked for those dates.*/
	Low(new boolean[] {true, true, true, false, false, true, true, true, false, false, false, true, true, true, true, true, false, false, true, true, true, false, false, false, false, true, true, true, false, false, false}),
	Medium(new boolean[] {false, false, true, false, false, true, true, true, false, false, false, true, true, true, true, false, false, false, true, true, true, false, false, false, true, true, true, true, false, false, true}),
	High(new boolean[] {true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, true, true, true, true, true, false});

	private boolean[] _map;

	//This method returns the array that is selected.
	public boolean[] getArr() {
		return _map;
	}

	//This constructor sets the variable equal to an array.
	private Rooms(boolean[] map) {
		_map = map;
	}
}
