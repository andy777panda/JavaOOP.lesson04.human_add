package net.ukr.andy777;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 Lesson08
 1. Используя стандартные методы сериализации создайте мини-базу данных для работы с группами студентов 
 (возможность записи и чтения базы из файла по запросу пользователя).
 = для груп студентів створюємо клас-Факультет
 */

public class Faculty implements Serializable {
	private static final long serialVersionUID = 1L;
	private String facultyName; // faculty name = назва факультету
	private String facultyId; // faculty Id = ід-номер факультету
	private List<Group> faculty = new ArrayList<Group>(); // List Groups =
	private int maxGroupsFaculty = 10;

	// список груп

	/* constructors = конструктори */
	public Faculty() {
		super();
	}

	public Faculty(String facultyName, String facultyId) {
		super();
		this.facultyName = facultyName;
		this.facultyId = facultyId;
	}

	public Faculty(String facultyName, String facultyId, String highSchool,
			List<Group> faculty) {
		super();
		this.facultyName = facultyName;
		this.facultyId = facultyId;
		this.faculty = faculty;
	}

	/* setters and getters = сеттери та геттери */

	// faculty name = назва факультету
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	// faculty Id = ід-номер факультету
	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	// array Group[] = масив груп
	public List<Group> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Group> faculty) {
		this.faculty = faculty;
	}

	// toString method = метод виводу інформації про екземпляр класу Faculty
	@Override
	public String toString() {
		String resStr = "";
		int i = 0;
		for (Group gr : faculty)
			resStr += System.getProperty("line.separator") + ++i + ". " + gr;
		return "Faculty[" + facultyName + " id:" + facultyId
				+ "] consists of such " + faculty.size() + " groups:" + resStr;
	}

	public String toStringGs() {
		String resStr = "";
		int i = 0, qS = 0;
		for (Group gr : faculty) {
			if (gr != null)
				qS += gr.getGroup().size();
			resStr += System.getProperty("line.separator") + ++i + ". "
					+ ((gr == null) ? null : gr.toStringNNC());
		}
		return "Faculty[" + facultyName + " id:" + facultyId
				+ "] consists of such " + faculty.size() + " groups of " + qS
				+ " students:" + resStr;
	}

	public String toStringNIC() {
		int qS = 0;
		for (Group gr : faculty)
			if (gr != null)
				qS += gr.getGroup().size();
		return "Faculty[" + facultyName + " id:" + facultyId
				+ ", Number of groups: " + faculty.size()
				+ ", Number of students: " + qS + "]";
	}

	// метод додавання групи до факультету. У випадку спроби додавання 11ої
	// групи - спрацьовує власне виключення та обробляється.
	/**
	 * Add Group to Faculy = метод додавання групи до факультету
	 * 
	 * @param gr
	 *            <code>Group</code> element of class Group
	 * @author ap
	 */
	public void addGroupToFaculty(Group gr) throws MyException {
		System.out.print("Add group = додавання групи: " + gr + "\n ==>> "
				+ "\t");
		String id = "(" + facultyName + " id:" + facultyId + ")<-("
				+ gr.toStringNNC() + ")";

		// search same groupNumber in faculty =
		// пошук однакового номеру групи на факультеті
		for (int i = 0; i < faculty.size(); i++)
			if (faculty.get(i).getGroupNumber() == gr.getGroupNumber())
				throw new MyException(4, id);

		// search free place on faculty = пошук вільного місця на факультеті
		boolean add = false;
		if (faculty.size() < maxGroupsFaculty) {
			faculty.add(gr);
			add = true;
		}
		if (!add)
			throw new MyException(5, id);
		String resStr = "the group has been ADDED to the faculty"
				+ " = групу ДОДАНО на факультет ";
		System.out.println(resStr + "\n\t" + id);
	}

	/**
	 * Try-Catch method for add Group to Faculty = метод з контролем на
	 * виключення додавання групи на факультет
	 * 
	 * @param gr
	 *            <code>Group</code> element of class Group
	 * @author ap
	 */
	public void tcAddGroupToFaculty(Group gr) {
		try {
			addGroupToFaculty(gr);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	// Реализовать метод удаления группы из факультета.
	/**
	 * Remove Group from Faculty by groupNumber = метод видалення групи з
	 * факультет по номеру групи
	 * 
	 * @param gr
	 *            <code>Group</code> element of class Group
	 * @author ap
	 */
	public void removeGroupFromFaculty(Group gr) throws MyException {
		System.out.print("Exclude group = видалення групи: " + gr.toStringNNC()
				+ " ==>> " + "\n\t");
		String resStr = "an exception is not possible. group is not on the faculty"
				+ " = виключення не можливе. група не на факультеті";
		String id = "(" + facultyName + " id:" + facultyId + ")";
		if (gr == null)
			throw new MyException(6, id);
		for (int i = 0; i < faculty.size(); i++) {
			if (faculty.get(i).equals(gr)) {
				faculty.remove(i); // exclude group = видаляємо групу
				resStr = "the group is EXCUDED from the faculty"
					+ " = групу ВИКЛЮЧЕНО з факультету";
				break;
			}
		}
		System.out.println(resStr + id);
	}

	/**
	 * Try-Catch method for remove Student from Group = метод з контролем на
	 * виключення видалення студента з групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void tcRemoveGroupFromFaculty(Group gr) {
		try {
			removeGroupFromFaculty(gr);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	// Lesson08
	// 1. Используя стандартные методы сериализации создайте мини-базу данных
	// для работы с группами студентов
	// (возможность записи и чтения базы из файла по запросу пользователя).
	/**
	 * Save Faculty to file by Serializable-methods = метод запису Факультету до
	 * файлу методами серіалізації
	 * 
	 * @param fileName
	 *            <code>String</code> full name of file to save Faculty
	 * @author ap
	 */
	public void saveFacultyToFile(String fileName) {
		// save Faculty to serializable-file = запис Факультету до файлу
		// методами серіалізації
		try {
			ObjectOutputStream OOS = new ObjectOutputStream(
					new FileOutputStream(fileName));
			OOS.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR save group !!!");
		}
	}

	// Lesson08
	// 1. Используя стандартные методы сериализации создайте мини-базу данных
	// для работы с группами студентов
	// (возможность записи и чтения базы из файла по запросу пользователя).
	/**
	 * Read serializable-File to Faculty = метод десеріалізацї файлу до
	 * Факультету
	 * 
	 * @param fileName
	 *            <code>String</code> full name of file to read Faculty
	 * @author ap
	 */
	public Faculty readFileToFaculty(String fileName) {
		Faculty res = null;
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
					fileName));
			res = (Faculty) OIS.readObject();
		} catch (IOException e) {
			System.out.println("ERROR load faculty - IOException!!!");
		} catch (ClassNotFoundException e) {
			System.out
					.println("ERROR load faculty - ClassNotFoundException!!!");
		}
		return res;
	}
}