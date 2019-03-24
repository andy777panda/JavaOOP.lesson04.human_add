package net.ukr.andy777;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 Lesson04
 1. Усовершенствуйте класс Group, добавив возможность интерактивного добавления объекта.
 */

public class AP {

	/**
	 * Randomizing int value in the range from A to B = метод випадкової
	 * генерації цілого числа в діапазоні від А до В
	 * 
	 * @param a
	 *            <code>int</code> minimum integer value of randimizing
	 * @param b
	 *            <code>int</code> maximum integer value of randimizing
	 * @return int value.
	 * @author ap
	 */
	public static int rndInteger(int a, int b) {
		return a + (int) (Math.random() * (b - a + 1));
	}

	/**
	 * Randomizing boolean value = метод випадкової генерації булевої величини
	 * 
	 * @return boolean value.
	 * @author ap
	 */
	public static boolean rndBoolean() {
		return Math.random() < 0.5;
	}

	/**
	 * Screen input integer value from a set range = метод екранного введення
	 * цілого числа з заданого діапазону
	 * 
	 * @param a
	 *            <code>int</code> minimum integer value of range
	 * @param b
	 *            <code>int</code> maximum integer value of range
	 * @param msg
	 *            <code>String</code> adding info-message
	 * @return int value.
	 * @author ap
	 */
	public static int inputIntegerDialog(int a, int b, String msg) {
		int res;
		for (;;) {
			try {
				res = Integer.valueOf(JOptionPane
						.showInputDialog("Input integer number in range " + a
								+ " - " + b + "\n" + msg));
				if ((res < a) || (res > b))
					JOptionPane.showMessageDialog(null, "number out of range");
				else
					break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			}
		}
		return res;
	}

	/**
	 * Swap elements of string array = обмін елементів String-масиву
	 * 
	 * @param arr
	 *            <code>String[]</code> array for swaping
	 * @param i
	 *            <code>int</code> array-element for swapping
	 * @param j
	 *            <code>int</code> array-element for swapping
	 * @return String[] swaped array.
	 * @author ap
	 */
	public static String[] swapArrElem(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
		return arr;
	}

//	/**
//	 * Bubble sort string array = метод бульбашкового сортування String-масиву
//	 * 
//	 * @param arr
//	 *            <code>String[]</code> array for sorting
//	 * @param az
//	 *            <code>int</code> sort direction (+0=AZ; -0=Z; 0=unsort)
//	 * @return String[] sorted array.
//	 * @author ap
//	 */
//	public static String[] sortArrayString(String[] arr, int az) {
//		boolean isSorted = false;
//		while (!isSorted) {
//			isSorted = true;
//			for (int i = 0; i < arr.length - 1; i++) {
//				if (arr[i].compareToIgnoreCase(arr[i + 1]) * az > 0) {
//					isSorted = false;
//					arr = swapArrElem(arr, i, i + 1);
//				}
//			}
//		}
//		return arr;
//	}

	/**
	 * Bubble sort nulls to the end of Student array = метод бульбашкового
	 * сортування null'ів в кінець Student-масиву
	 * 
	 * @param arr
	 *            <code>Student[]</code> array for sorting
	 * @return Student[] sorted array.
	 * @author ap
	 */
	public static Student[] sortArrayStudentNulls(Student[] arr) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == null && arr[i + 1] != null) {
					isSorted = false;
					Student temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * Resizing array of Students for given value = зміна розмірності масиву
	 * студентів на задану ведичину
	 * 
	 * @param arr
	 *            <code>String[]</code> array for resizing
	 * @param addSize
	 *            <code>int</code> value for resize of array
	 * @return Student[] resizied array
	 * @author ap
	 */
	public static Student[] resize(Student[] arr, int addSize) {
		Student[] temp = new Student[arr.length + addSize];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		return temp;
	}

	/**
	 * Randomizing second name from list depending of sex = метод випадкової
	 * генерації прізвища зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setSecondNameRnd(boolean sex) {
		// initializing list of male second names
		// = ініціалізація списку чоловічих прізвищ
		String[] secondNameM = { "АНДРІЄВ", "БОБРОВ", "ВОЛОДЬКОВ", "ДИМИТРІВ",
				"ЗАХАРЕНКОВ", "ІВАНОВ", "КОСТЕНКОВ", "МИКОЛАЄНКОВ",
				"НАЗАРЕНКОВ", "ОЛЕКСІЄНКОВ", "ПЕТРОВ", "РОМАНОВ", "СЕРГІЄВ",
				"ТАРАСОВ", "ФЕДОРОВ", "ЮХИМОВ" };

		// initializing list of female second names
		// = ініціалізація списку жіночих прізвищ
		String[] secondNameF = { "АНДРІЄВА", "БОБРОВА", "ВОЛОДЬКОВА",
				"ДИМИТРІВА", "ЗАХАРЕНКОВА", "ІВАНОВА", "КОСТЕНКОВА",
				"МИКОЛАЄНКОВА", "НАЗАРЕНКОВА", "ОЛЕКСІЄНКОВА", "ПЕТРОВА",
				"РОМАНОВА", "СЕРГІЄВА", "ТАРАСОВА", "ФЕДОРОВА", "ЮХИМОВА" };

		return (sex ? secondNameM[(int) (Math.random() * secondNameM.length)]
				: secondNameF[(int) (Math.random() * secondNameF.length)]);
	}

	/**
	 * Randomizing first name from list depending of sex = метод випадкової
	 * генерації імені зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setFirstNameRnd(boolean sex) {
		// initializing list of male first names
		// = ініціалізація списку чоловічих імен
		String[] firstNameM = { "Андрій", "Борис", "Володимир", "Дмитро",
				"Захар", "Іван", "Костянтин", "Микола", "Назар", "Олексій",
				"Петро", "Роман", "Сергій", "Тарас", "Федір", "Юхим" };

		// initializing list of female first names
		// = ініціалізація списку жіночих імен
		String[] firstNameF = { "Антоніна", "Віталіна", "Владлена", "Ангеліна",
				"Зоряна", "Іванна", "Людмила", "Марія", "Наталя", "Олександра",
				"Христина", "Романа", "Світлана", "Тетяна", "Уляна", "Юлія" };

		return (sex ? firstNameM[(int) (Math.random() * firstNameM.length)]
				: firstNameF[(int) (Math.random() * firstNameF.length)]);
	}

	/**
	 * Randomizing middle name from list depending of sex = метод випадкової
	 * генерації прізвища зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setMiddleNameRnd(boolean sex) {
		// initializing list of male middle names
		// = ініціалізація списку чоловічих імен по-батькові
		String[] middleNameM = { "Андрійович", "Борисович", "Володимирович",
				"Дмитрович", "Захарович", "Іванович", "Костянтинович",
				"Миколайович", "Назарович", "Олексійович", "Петрович",
				"Романович", "Сергійович", "Тарасович", "Федорович", "Юхимович" };

		// initializing list of female middle names
		// = ініціалізація списку жіночих імен по-батькові
		String[] middleNameF = { "Андріївна", "Борисівна", "Володимирівна",
				"Дмитрівна", "Захарівна", "Іванівна", "Костянтинівна",
				"Миколаївна", "Назарівна", "Олександрівна", "Павлівна",
				"Романівна", "Сергіївна", "Тарасівна", "Федорівна", "Юріївна" };

		return (sex ? middleNameM[(int) (Math.random() * middleNameM.length)]
				: middleNameF[(int) (Math.random() * middleNameF.length)]);
	}

	/**
	 * Randomizing high school from list = метод випадкової генерації вищого
	 * навчального закладу зі списку
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setHighScoolRnd() {
		// initializing list of high schools
		// = ініціалізація списку навчальних закладів
		String[] highScool = { "КНУ", "КПІ", "КНЕУ", "КМА", "КТЕУ", "НМУ",
				"МАУП", "НАУ" };

		return (highScool[(int) (Math.random() * highScool.length)]);
	}

	/**
	 * Method randomize initialazation of new Human element depending of age
	 * range and sex = Метод ініціалізації нового елементу класу Human в
	 * залежності від діапазону віку та статі
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of human
	 * @param a2
	 *            <code>int</code> maximum age of human
	 * @param sex
	 *            <code>boolean</code> sex of human
	 * @return Human element.
	 * @author ap
	 */
	public static Human rndHuman(int a1, int a2, boolean sex) {
		return new Human(setSecondNameRnd(sex), setFirstNameRnd(sex),
				setMiddleNameRnd(sex), rndInteger(a1, a2), sex);
	}

	/**
	 * Method randomize initialazation of new Student element depending of age
	 * range, sex and grade range = Метод ініціалізації нового елементу класу
	 * Student в залежності від діапазону віку, статі та діапазону року
	 * навчання.
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of student
	 * @param a2
	 *            <code>int</code> maximum age of student
	 * @param sex
	 *            <code>boolean</code> sex of student
	 * @param maxR
	 *            <code>int</code> maximum record number
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudent(int a1, int a2, boolean sex, int maxR,
			int g1, int g2) {
		return new Student(rndHuman(a1, a2, sex), rndInteger(1, maxR),
				setHighScoolRnd(), rndInteger(g1, g2));
	}

	/**
	 * Method randomize initialazation of new Student element (except for the
	 * specified HighScool) depending of age range, sex and grade range = Метод
	 * ініціалізації нового елементу класу Student (окрім вказаного вузу) в
	 * залежності від діапазону віку, статі та діапазону року навчання.
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of student
	 * @param a2
	 *            <code>int</code> maximum age of student
	 * @param sex
	 *            <code>boolean</code> sex of student
	 * @param maxR
	 *            <code>int</code> maximum record number
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @param highSchool
	 *            <code>String</code> name of higher school
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudentHS(int a1, int a2, boolean sex, int maxR,
			int g1, int g2, String highSchool) {
		return new Student(rndHuman(a1, a2, sex), rndInteger(1, maxR),
				highSchool, rndInteger(g1, g2));
	}

	/**
	 * Method randomize initialazation of new Student element depending of age
	 * range, sex and grade range = Метод ініціалізації нового елементу класу
	 * Student в залежності від діапазону віку, статі та діапазону року
	 * навчання.
	 * 
	 * @param hm
	 *            <code>Human</code> element of class Human
	 * @param maxR
	 *            <code>int</code> maximum record number
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudent(Human hm, int maxR, int g1, int g2) {
		return new Student(hm, rndInteger(1, maxR), setHighScoolRnd(),
				rndInteger(g1, g2));
	}

	/**
	 * Method randomize initialazation of new Student element depending of age
	 * range and sex = Метод ініціалізації нового елементу класу Student в
	 * залежності від діапазону віку та статі
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of student
	 * @param a2
	 *            <code>int</code> maximum age of student
	 * @param sex
	 *            <code>boolean</code> sex of student
	 * @param maxR
	 *            <code>int</code> maximum record number
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudent(int a1, int a2, boolean sex, int maxR) {
		return new Student(rndHuman(a1, a2, sex), rndInteger(1, maxR));
	}

	// Lesson04. Усовершенствуйте класс Group, добавив возможность
	// интерактивного добавления объекта.
	/**
	 * Print info-phrase AND Scanner input Integer value from a set range =
	 * метод друку інфо-фрази ТА введення зі сканеру цілого числа з заданого
	 * діапазону
	 * 
	 * @param msg
	 *            <code>String</code> info-phrase
	 * @param a
	 *            <code>int</code> minimum integer value of range
	 * @param b
	 *            <code>int</code> maximum integer value of range
	 * @return integer value of input number
	 * @author ap
	 */
	public static int scInputInteger(String msg, int a, int b)
			throws IOException {
		System.out.print(msg + "in range " + a + "-" + b + ": ");
		int res;
		for (;;) {
			try {
				res = Integer.valueOf(new Scanner(System.in).next());
				if ((res < a) || (res > b))
					System.out.print("number out of range. RE-" + msg);
				else
					break;
			} catch (NumberFormatException e) {
				System.out.print(" !!! error number. RE-" + msg + "in range "
						+ a + "-" + b + ": ");
			}
		}
		return res;
	}

	/**
	 * Print info-phrase AND input Integer value
	 * 
	 * @param msg
	 *            <code>String</code> info-phrase
	 * @return integer value of input number
	 * @author ap
	 */
	public static int scInputInteger(String msg) throws IOException {
		System.out.print(msg);
		int res;
		for (;;) {
			try {
				res = Integer.valueOf(new Scanner(System.in).next());
				break;
			} catch (NumberFormatException e) {
				System.out.print(" !!! error number. RE-" + msg);
			}
		}
		return res;
	}

	/**
	 * Print info-phrase AND input String value
	 * 
	 * @param msg
	 *            <code>String</code> info-phrase
	 * @return String value of first input word
	 * @author ap
	 */
	public static String scInputString(String msg) throws IOException {
		System.out.print(msg);
		return new Scanner(System.in).next();
	}

	/**
	 * Print info-phrase AND input boolean value
	 * 
	 * @param msg
	 *            <code>String</code> info-phrase
	 * @return boolean value. <code>true</code> if input letter y/Y
	 * @author ap
	 */
	public static boolean scInputBoolean(String msg) throws IOException {
		System.out.print(msg);
		return new Scanner(System.in).next().equalsIgnoreCase("y");
	}

	/**
	 * Method scanner-input of new Human element depending of age range = Метод
	 * ініціалізації нового елементу класу Human в залежності від діапазону
	 * віку.
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of student
	 * @param a2
	 *            <code>int</code> maximum age of student
	 * @return Human element.
	 * @author ap
	 */
	public static Human scInputHuman(int a1, int a2) {
		try {
			String secondName = AP.scInputString("input secondName: ");
			String firstName = AP.scInputString("input firstName: ");
			String middleName = AP.scInputString("input middleName: ");
			int age = AP.scInputInteger("input age: ", a1, a2);
			boolean sex = AP
					.scInputBoolean("sex Male? (\"y\"-male, other-famale): ");
			Human res = new Human(secondName, firstName, middleName, age, sex);
			return res;
		} catch (Exception е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
			return null;
		}
	}

	/**
	 * Method scanner-input of new Student element depending of grade range =
	 * Метод ініціалізації нового елементу класу Student в залежності від
	 * діапазону року навчання.
	 * 
	 * @param maxR
	 *            <code>int</code> maximum record number
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @return Student element.
	 * @author ap
	 */
	public static Student scInputStudent(Human human, int maxR, int g1, int g2) {
		try {
			int recordNumber = AP.scInputInteger("input cardRecord number: ",
					1, maxR);
			String highSchool = AP.scInputString("input highSchool: ");
			int yearStudy = AP
					.scInputInteger("input grade/yearStudy: ", g1, g2);
			Student res = new Student(human, recordNumber, highSchool,
					yearStudy);
			return res;
		} catch (Exception е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
			return null;
		}
	}

	// return string value of sort direction = метод повертає напрямок сортуання
	public static String direction(int aZ) {
		if (aZ > 0)
			return "aZ,123-sorted ";
		if (aZ < 0)
			return "Za,321-sorted ";
		else
			return "unsorted ";
	}

	public static int sign(int a) {
		if (a > 0)
			return 1;
		if (a < 0)
			return -1;
		return 0;
	}

	// Lesson05. 4. Реализовать обратный процесс. Т.е. считать данные о группе
	// из файла, и на их основе создать объект типа группа.

	// splitting a text file into words = розбивка текстового файлу на слова
	/**
	 * Method split a sign-separated text file into words = Метод розбивка
	 * текстового файлу з роділювачами на слова
	 * 
	 * @param filename
	 *            <code>String</code> file's name to read data
	 * @param separator
	 *            <code>String</code> file's sign-separator of values
	 * @return String array of data's elements.
	 * @author ap
	 */
	public static String[] wordsOfTextFile(String filename, String separator) {
		String[] res = new String[0];
		try {
			String str = null;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((str = br.readLine()) != null) {
				res = expandArray(res, str.split(separator));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error open file - " + filename);
		}
		return res;
	}

	// expanding String-array of additional array = розширення строкового масиву
	// додатковим масивом
	/**
	 * Method expand String-array of additional array = Метод розширення
	 * строкового масиву додатковим масивом
	 * 
	 * @param orig
	 *            <code>String[]</code> original array
	 * @param add
	 *            <code>String[]</code> adding array
	 * @return String array (orig+add)
	 * @author ap
	 */
	public static String[] expandArray(String[] orig, String[] add) {
		String[] res = new String[orig.length + add.length];
		System.arraycopy(orig, 0, res, 0, orig.length);
		System.arraycopy(add, 0, res, orig.length, add.length);
		return res;
	}

}
