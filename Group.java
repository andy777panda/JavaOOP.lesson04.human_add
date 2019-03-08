package net.ukr.andy777;

import java.io.*;
import java.util.Arrays;

/*
 Lesson03
 3. Создать класс Группа/Group, который содержит массив из 10 объектов класса Студент/Student.
 Реализовать методы добавления, удаления студента из группы и поиска по фамилии.
 В случае попытки добавления 11го студента создать собственное исключение и обработать его.
 Определить метод toString() для группы так, чтобы он выводил список студентов в алфавитном порядке.

 Lesson04
 2. Реализуйте возможность сортировки списка студентов по фамилии.
 3. Реализуйте возможность сортировки по параметру (Фамилия, успеваемость и т. д.).

 Lesson05
 3. Усовершенствуйте класс, описывающий группу студентов, добавив возможность сохранения группы в файл.
 4. Реализовать обратный процесс. Т.е. считать данные о группе из файла, и на их основе создать объект типа группа.
 */
public class Group implements Reservist, Serializable {
	private String groupName; // group name = назва групи
	private String groupNumber; // group number = номер групи
	private int count; // amount of students in group = кількість студентів в групі
	private Student[] group = new Student[10]; // array Student[] = масив судентів
	private static int sortWay; // way of sorting = шлях сортування
	// parameter of sorting = параметр сортування
	private static String[] sortParam = { "0.unsorted ", "1.secondName ",
			"2.firstName ", "3.age ", "4.recordNumber " };

	/* constructors = конструктори */
	public Group() {
		super();
	}

	public Group(String groupName, String groupNumber) {
		super();
		this.groupName = groupName;
		this.groupNumber = groupNumber;
	}

	public Group(String groupName, String groupNumber, Student[] group) {
		super();
		this.groupName = groupName;
		this.groupNumber = groupNumber;
		this.group = group;
	}

	/* setters and getters = сеттери та геттери */

	// group name = назва групи
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	// group number = номер групи
	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	// array of Student[] = масив судентів
	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	// amount of students in group = кількість студентів в групі
	public int getCount() {
		return count;
	}

	// way of sorting = шлях сортування
	public static int getSortWay() {
		return sortWay;
	}

	public void setSortWay(int sortWay) {
		Group.sortWay = sortWay;
	}

	// parameter of sorting = параметр сортування
	public static String getSortParam(int i) {
		return sortParam[i];
	}

	public static String[] getSortParam() {
		return sortParam;
	}

	// toString method = метод виводу інформації про екземпляр класу Group
	@Override
	public String toString() {
		String resStr = "";
		int i = 0;
		for (Student st : group)
			resStr += "\n" + ++i + ". " + st;
		return "Group [" + groupName + " #" + groupNumber
				+ "] consists of such " + this.count + " students:" + resStr;
	}

	public String toStringNNC() {
		return "Group [" + groupName + " #" + groupNumber
				+ ", Number of students: " + this.count + "]";
	}

	/**
	 * Get string-line sorted elemets of group (array of Students) = метод
	 * отримання строкового рядка відсортованих елементів групи (масиву
	 * студентів)
	 * 
	 * @param az
	 *            <code>int</code> sort direction (+0=AZ; -0=ZA; 0=unsort)
	 * @return String value.
	 * @author ap
	 */
	public String getStSortGroup(int az) {
		String[] sts = new String[group.length];
		String resStr = "";
		for (int i = 0; i < group.length; i++) {
			try {
				sts[i] = group[i].toString();
			} catch (NullPointerException e) {
				sts[i] = "";
			}
		}
		sts = AP.sortArrayString(sts, az);
		for (int i = 0; i < sts.length; i++) {
			if (sts[i] != "")
				resStr += "\n" + sts[i];
		}
		return "Sorted " + AP.direction(az) + "\t Group [" + groupName + " #"
				+ groupNumber + "] consists of such students:" + resStr;
	}

	/**
	 * Get sorted elemets of group (array of Students) = метод отримання
	 * відсортованих елементів групи (масиву студентів)
	 * 
	 * @param az
	 *            <code>int</code> sort direction (+0=AZ; -0=ZA; 0=unsort)
	 * @return Group value.
	 * @author ap
	 */
	public Group getSortGroup(int sortWay) {
		Group.sortWay = sortWay;

		int jdk = AP.inputIntegerDialog(1, 2,
				"(1=sortByJDK1.6;   2=sortByJDK1.8)");
		if (jdk == 1) {
			AP.sortArrayStudentNulls(group);
			try {
				Arrays.sort(group, 0, count);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		if (jdk == 2) {
			// jdk1.8
			// Arrays.sort(group, Comparator.nullsLast(Student::compareTo));
		}
		return this;
	}

	// Реализовать метод добавления студента в группу. В случае попытки
	// добавления 11го студента создать собственное исключение и обработать его.
	/**
	 * Add Student to Group = метод додавання студента до групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void addStudentToGroup(Student st) throws MyException {
		System.out.print("Add student = додавання студента: " + st + " ==>> "
				+ "\n\t");
		String id = "(" + groupName + " #" + groupNumber + ")";

		// search same recordNumber in group =
		// пошук однакового номеру заліковки в групі
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getRecordNumber() == st.getRecordNumber()) {
					throw new MyException(3, id);
				}
			}
		}

		// search free place in group =
		// пошук вільного місця в групі
		boolean add = false;
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = st;
				count++;
				add = true;
				break;
			}
		}
		if (!add)
			throw new MyException(1, id);
		String resStr = "the student has been ADDED to the group"
				+ " = студента ДОДАНО до групи ";
		System.out.println(resStr + id);
	}

	/**
	 * Try-Catch method for add Student to Group = метод з контролем на
	 * виключення додавання студента до групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void tcAddStudentToGroup(Student st) {
		try {
			addStudentToGroup(st);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	// Реализовать метод удаления студента из группы.
	/**
	 * Remove Student from Group by recordNumber = метод видалення студента з
	 * групи по номеру заліковки
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void removeStudentFromGroup(Student st) throws MyException {
		System.out.print("Exclude student = виключення студента: " + st
				+ " ==>> " + "\n\t");
		String resStr = "an exception is not possible. student is not in the group"
				+ " = виключення не можливе. студент не в групі ";
		String id = "(" + groupName + " #" + groupNumber + ")";
		if (st == null)
			throw new MyException(2, id);
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null)
				continue;

			// if (group[i].equals(st)) {
			// !!!! methot EQUALS needs to be improved, for future =
			// метод потребує доопрацювання, на майбутнє

			// currently, identification is only on the recordNumber =
			// наразі ідентифікація лише по номеру заліковки
			if (group[i].getRecordNumber() == st.getRecordNumber()) {
				group[i] = null; // exclude student = видаляємо студента
				count--; // reduce counter = зменшуємо лічільник
				resStr = "the student is EXCUDED from the group"
						+ " = студента ВИКЛЮЧЕНО з групи ";
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
	public void tcRemoveStudentFromGroup(Student st) {
		try {
			removeStudentFromGroup(st);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	// Реализовать метод поиска студента по фамилии.
	/**
	 * Finding a student by second name = метод пошуку студента за прізвищем
	 * 
	 * @param sName
	 *            <code>String</code> second name(surname)
	 * @return count of found surnames
	 * @author ap
	 */
	public Student[] findSecondName(String sName) {
		Student[] res = new Student[0];// result array == масив результатів
		String id = "(" + groupName + " #" + groupNumber + ")";
		System.out.print("Find student in group = пошук студента в групі " + id
				+ ": " + sName + " ==>> ");
		String resStr = "";
		int q = 0; // finds counter = лічильник знахідок
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null)
				continue;
			if (group[i].getSecondName().equalsIgnoreCase(sName)) {
				// розширюємо масив знайдених студентів
				res = AP.resize(res, 1);
				// ініціалізуємо знайденого студента в масиві результатів
				res[q++] = group[i];
				resStr += "\n\t\t" + (i + 1) + ". " + group[i].toString();
			}
		}
		resStr = "\t found students = знайдено студентів: " + q + resStr;
		System.out.println(resStr);
		return res;
	}

	// Lesson04
	// 4. Реализуйте интерфейс Военком, который вернет из группы массив
	// студентов - юношей, которым больше 18 лет.
	/**
	 * Get list of Students of Group who meet the conditions reservists = метод
	 * отримання переліку Студентів Групи, які відповідають умові військомату
	 * 
	 * @return array of Students
	 * @author ap
	 */
	public Student[] getReservistList() {
		Student[] res = new Student[0];// result array == масив результатів
		for (Student st : this.group) {
			if (st != null) {
				if (st.isSex() && st.getAge() > RESERVIST_AGE) {
					res = AP.resize(res, 1);
					res[res.length - 1] = st;
				}
			}
		}
		return res;
	}

	// Lesson05
	// 3. Усовершенствуйте класс, описывающий группу студентов, добавив
	// возможность сохранения группы в файл.
	/**
	 * Save Group to file in TSV-format = метод запису до файлу Групи у
	 * TSV-форматі
	 * 
	 * @param fileName
	 *            <code>String</code> full name of file to save Group
	 * @author ap
	 */
	public void saveGroupToFile(String fileName) {
		// get Group by String = отримання Групи в Строковому виді
		String resStr = "";
		resStr = groupName + "\t" + groupNumber;
		resStr += "\n" + "# order" + "\t" + "SecondName" + "\t" + "FirstName"
				+ "\t" + "MiddleName" + "\t" + "Age" + "\t" + "Sex" + "\t"
				+ "# Record" + "\t" + "HighSchool" + "\t" + "YearStudy";
		int i = 0;
		for (Student st : group) {
			if (st == null)
				++i;
			else
				resStr += "\n" + ++i + "\t" + st.getSecondName() + "\t"
						+ st.getFirstName() + "\t" + st.getMiddleName() + "\t"
						+ st.getAge() + "\t" + (st.isSex() ? "male" : "female")
						+ "\t" + st.getRecordNumber() + "\t"
						+ st.getHighSchool() + "\t" + st.getYearStudy();
		}

		// save Group to file = запис групи до файлу

		// jdk1.7
		// try(PrintWriter pw = new PrintWriter(new File(fileName)){
		// pw.print(resStr);
		// } catch (FileNotFoundException e) {
		// System.out.println("Error found file" + fileName);
		// }

		// jdk1.6
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(fileName));
			pw.print(resStr);
		} catch (FileNotFoundException e) {
			System.out.println("Error found file" + fileName);
		} finally {
			pw.close();
		}

	}

	// Lesson05
	// 4. Реализовать обратный процесс. Т.е. считать данные о группе из файла, и
	// на их основе создать объект типа группа.
	/**
	 * Read File in TSV-format to Group = метод читання файлу у TSV-форматі до
	 * Групи
	 * 
	 * @param fileName
	 *            <code>String</code> full name of file to save Group
	 * @param separator
	 *            <code>String</code> separator to split a text file into words
	 * @author ap
	 */
	public Group readFileToGroup(String fileName, String separator) {
		// split a text file into words by separator = розбивка текстового
		// файлу на слова розділювачем
		String[] wtf = AP.wordsOfTextFile("group.csv", "\t");

		this.setGroupName(wtf[0]);
		this.setGroupNumber(wtf[1]);
		int q = 9; // number of Student elemets = кількість елементів
		// характеристики студента
		if (wtf.length == 2 + q)
			return this;
		for (int i = 1; i < (wtf.length - 2) / q; i++) {
			this.group[Integer.parseInt(wtf[i * q + 2 + 0]) - 1] = new Student(
					wtf[i * q + 2 + 1], wtf[i * q + 2 + 2], wtf[i * q + 2 + 3],
					Integer.parseInt(wtf[i * q + 2 + 4]), ((wtf[i * q + 2 + 5]
							.equals("male")) ? true : false), Integer
							.parseInt(wtf[i * q + 2 + 6]), wtf[i * q + 2 + 7],
					Integer.parseInt(wtf[i * q + 2 + 8]));
		}
		return this;
	}
}