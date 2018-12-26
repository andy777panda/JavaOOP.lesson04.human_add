package net.ukr.andy777;

public class MyException extends Exception {

	private int code;
	private String id;

	MyException(int code, String id) {
		this.code = code;
		this.id = id;
	}

	public String toString() {
		String res;
		switch (this.code) {
		case 1:
			res = "1. group is full, NO PLACES = група заповнена, немає місць для студента ";
			break;
		case 2:
			res = "2. student NOT SPECIFIED OR place in the group is NOT OCCUPIED = "
					+ "студента не зазначено АБО місце в групі НЕ ЗАЙНЯТЕ ";
			break;
		case 3:
			res = "3. same recordNumber is in group's student = "
					+ "аналогічний однаковий номер заліковки вже є у студента групи ";
			break;
		default:
			res = "indescribable exception = неописане виключення";
			break;
		}
		return "MyException [" + res + id + "]";
	}
}
