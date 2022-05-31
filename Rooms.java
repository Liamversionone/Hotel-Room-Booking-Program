package mod;

public enum Rooms {

	Low(new boolean[] {true, true, true, false, false, true, true, true, false, false, false, true, true, true, true, true, false, false, true, true, true, false, false, false, false, true, true, true, false, false, false}),
	Medium(new boolean[] {false, false, true, false, false, true, true, true, false, false, false, true, true, true, true, false, false, false, true, true, true, false, false, false, true, true, true, true, false, false, true}),
	High(new boolean[] {true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, true, true, true, true, true, false});

	private boolean[] _map;

	public boolean[] getArr() {
		return _map;
	}

	private Rooms(boolean[] map) {
		_map = map;
	}
}
