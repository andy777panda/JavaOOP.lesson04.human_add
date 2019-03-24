package net.ukr.andy777;

import java.util.*;

/*
 Lesson03
 1. Создать класс Человек/Human, описывающий человека (Ф.,И.,О., возраст, пол)
 Создать метод, выводящий информацию о человеке.
 2. На основе класса Человек/Human создать класс Студент/Student. И переопределить метод вывода информации.
 3. Создать класс Группа/Group, который содержит массив из 10 объектов класса Студент/Student.
 Реализовать методы добавления, удаления студента из группы и поиска по фамилии.
 В случае попытки добавления 11го студента создать собственное исключение и обработать его.
 Определить метод toString() для группы так, чтобы он выводил список студентов в алфавитном порядке.
 4. Нарисовать UML диаграмму проекта.
 Lesson04
 1. Усовершенствуйте класс Group, добавив возможность интерактивного добавления объекта.
 2. Реализуйте возможность сортировки списка студентов по фамилии.
 3. Реализуйте возможность сортировки по параметру (Фамилия, успеваемость и т. д.).
 4. Реализуйте интерфейс Военком, который вернет из группы массив студентов - юношей, которым больше 18 лет.
 5. Протестируйте его работу.
 Lesson05
 3. Усовершенствуйте класс, описывающий группу студентов, добавив возможность сохранения группы в файл.
 4. Реализовать обратный процесс. Т.е. считать данные о группе из файла, и на их основе создать объект типа группа.
 Lesson08
 1. Используя стандартные методы сериализации создайте мини-базу данных для работы с группами студентов 
 (возможность записи и чтения базы из файла по запросу пользователя).
 Lesson09
 2. Модифицируйте класс «Группа» для более удобных методов работы с динамическими массивами.
 */

public class Main {
	public static void main(String[] args) {

		Group gr1 = new Group("Group1", "123/45");

		System.out.println("== наповнення групи вручну");
		gr1 = manualInputStudents(gr1);

		System.out.println("== автоматичне випадкове наповнення групи");
		gr1 = autoInputStudents(gr1);

		System.out.println("== автоматичне виключення студентів з групи");
		gr1 = autoRemoveStudents(gr1);

		System.out.println("==== запис/читання в/з файлів group.csv");
		saveReadGroupFile(gr1);

		System.out.println("== пошук студента за прізвищем");
		findStudent(gr1, AP.setSecondNameRnd(AP.rndBoolean()));

		System.out.println("== сортування за введеним параметром");
		gr1 = sortStudents(gr1);

		System.out.println("ReservistList:");
		reservists(gr1);

		// з попереднього завдання Lesson08
		Faculty fc1 = new Faculty("IT-faculty", "fc.001");
		System.out.println("==== наповнення факультету групами");
		fc1 = autoInputGroups(fc1);

		System.out.println("=== видалення випадкової групи з факультету");
		fc1 = autoRemoveGroup(fc1);

		System.out.println("=== serializable-запис факультету до файлу");
		fc1.saveFacultyToFile(fc1.getFacultyName());

		System.out.println("\n"
				+ "=== формування факультету з зовнішного serializable-файлу");
		Faculty fc2 = new Faculty().readFileToFaculty(fc1.getFacultyName());

		System.out
				.println("\n=== перевірка зчитаного факультету з прочитаного "
						+ "serializable-файлу");
		System.out.println(fc2.toStringGs() + "\n");

	}

	// ручне введення кожного студента
	private static Group manualInputStudents(Group gr) {
		int q = AP.inputIntegerDialog(0, 12,
				"amount of students for fist user-initializing");
		for (int i = 0; i < q; i++)
			gr.tcAddStudentToGroup(AP.scInputStudent(AP.scInputHuman(17, 23),
					20, 1, 6));
		return gr;
	}

	// автоматичне введення кожного студента
	private static Group autoInputStudents(Group gr) {
		for (int i = 0; i < AP.rndInteger(10, 12); i++)
			gr.tcAddStudentToGroup(AP.rndStudent(17, 23, AP.rndBoolean(), 30,
					1, 6));
		System.out.println(gr + "\n");
		return gr;
	}

	// автоматичне введення кожного студента
	private static Group autoRemoveStudents(Group gr) {
		// випадкова особа з групи з випадковим номером заліковки
		gr.tcRemoveStudentFromGroup(gr.getGroup().get(
				AP.rndInteger(0, gr.getGroup().size())));
		// випадкова особа
		gr.tcRemoveStudentFromGroup(AP.rndStudent(17, 23, true, 20));
		// null-особа
		gr.tcRemoveStudentFromGroup(null);
		System.out.println(gr + "\n");
		return gr;
	}

	// запис/читання в/з файлів group.csv
	private static void saveReadGroupFile(Group gr) {
		System.out.println("== запис групи до файлу group.csv");
		gr.saveGroupToFile("group.csv");

		System.out.println(System.getProperty("line.separator")
				+ "== формування групи з зовнішного файлу group.csv");
		Group gr2 = new Group();
		gr2.readFileToGroup("group.csv", "\t");

		System.out
				.println(System.getProperty("line.separator")
						+ "== перевірка сформованої групи з прочитаного файлу group.csv");
		System.out.println(gr2 + System.getProperty("line.separator"));

		System.out.println("== запис нової групи до файлу groupCopy.csv"
				+ System.getProperty("line.separator"));
		gr2.saveGroupToFile("groupCopy.csv");
	}

	// Finding a student by second name = метод пошуку студента за прізвищем
	private static Group findStudent(Group gr, String secondName) {
		Group grRes = new Group();
		for (int i = 0; i < 10; i++) {
			grRes = new Group("findGroup3", "678/90", new ArrayList<Student>(gr
					.findSecondName(secondName)));
			System.out.println(grRes + System.getProperty("line.separator"));
		}
		return grRes;
	}

	// sort by the input parameter = сортування за введеним параметром
	private static Group sortStudents(Group gr) {
		int sortWay = AP.inputIntegerDialog(-4, 4, "way of sorting: \n"
				+ "[POSITIVE(>0)=ascending(aZ,123);"
				+ " NEGATIVE(<0)=descending(Za,321)]\n"
				+ Arrays.toString(Group.getSortParam()));
		int sortSign = AP.sign(sortWay);
		System.out.println(Group.getSortParam(sortWay * sortSign)
				+ AP.direction(sortSign) + "\t" + gr.getSortGroup(sortWay)
				+ System.getProperty("line.separator"));
		return gr;
	}

	// output array reservists = вивід масиву резервістів
	private static void reservists(Group gr) {
		List<Student> res = gr.getReservistList();
		int i = 0;
		if (res.size() == 0)
			System.out.println("NO reservists in Group");
		for (Student st : res)
			System.out.println(++i + ". " + st);
	}

	// автоматичне введення кожної групи
	private static Faculty autoInputGroups(Faculty fc) {
		System.out
				.println("== автоматичне формування груп випадкових студентів");
		// додаткова група для контролю переповнення факультету
		for (int i = 0; i < 12; i++) {
			// initializing a Group with a name and number = ініціалізація Групи
			// з ім'ям та номером
			Group gr = new Group("Group" + (i + 1), (i + 1) * 111 + "/"
					+ (i + 1) * 11);

			// automatic filling a random group of students of one higher school
			// = автоматичне випадкове наповнення групи студентами одного вузу;
			for (int s = 0; s < AP.rndInteger(5, 11); s++)
				gr.tcAddStudentToGroup(AP.rndStudentHS(17, 23, AP.rndBoolean(),
						100, (i / 2 + 1), (i / 2 + 1), "КПІ"));

			// adding a group to the faculty = додавання групи до факультету
			fc.tcAddGroupToFaculty(gr);

			// print general faculty = друк загального складу факультету
			System.out.println("======>> " + "\t" + fc.toStringNIC()
					+ System.getProperty("line.separator")
					+ System.getProperty("line.separator"));
		}

		System.out
				.println("=== груповий склад факультету ====================\n"
						+ fc.toStringGs()
						+ System.getProperty("line.separator"));
		return fc;
	}

	// remove randome group from faculty = видалення випадкової групи з
	// факультету
	private static Faculty autoRemoveGroup(Faculty fc) {
		fc.tcRemoveGroupFromFaculty(fc.getFaculty().get(
				AP.rndInteger(0, fc.getFaculty().size())));
		System.out.println(fc.toStringGs()
				+ System.getProperty("line.separator"));
		return fc;
	}
}