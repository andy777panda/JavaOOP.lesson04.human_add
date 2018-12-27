package net.ukr.andy777;

import java.util.Arrays;

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
 */

public class Main {
	public static void main(String[] args) {

		int q = AP.inputIntegerDialog(0, 12,
				"amount of students for fist user-initializing");
		Group gr1 = new Group("Group1", "123/45");

		// initializing array of students = ініціалізація переліку студентів
		for (int i = 0; i < q; i++)
			// ручне введення кожного
			gr1.tcAddStudentToGroup(AP.scInputStudent(AP.scInputHuman(17, 23),
					20, 1, 6));

		for (int i = 0; i < 8; i++)
			// add a few random students = додавання кількох випадкових
			// студентів
			gr1.tcAddStudentToGroup(AP.rndStudent(17, 23, AP.rndBoolean(), 20,
					1, 6));
		System.out.println();
		System.out.println(gr1 + "\n");

		// Lesson04
		// sort by the input parameter = сортування за введеним параметром
		int sortWay = AP.inputIntegerDialog(-4, 4, "way of sorting: \n"
				+ "[POSITIVE(>0)=ascending(aZ,123);"
				+ " NEGATIVE(<0)=descending(Za,321)]\n"
				+ Arrays.toString(Group.getSortParam()));
		int sortSign = AP.sign(sortWay);
		System.out.println(Group.getSortParam(sortWay * sortSign)
				+ AP.direction(sortSign) + "\t" + gr1.getSortGroup(sortWay)
				+ "\n");

		// Lesson04
		// output array reservists = вивід масиву резервістів
		System.out.println("ReservistList:");
		int i = 0;
		if (gr1.getReservistList().length == 0)
			System.out.println("NO reservists in Group");
		for (Student st : gr1.getReservistList()) {
			System.out.println(++i + ". " + st);
		}

		// з попереднього завдання Lesson03
		/*
		 * // remove students from group = виключення студентів з групи for (int
		 * i = 0; i < 3; i++) { // особа на випадковій позиції у списку групи
		 * gr1.tcRemoveStudentFromGroup(gr1.getGroup()[AP.rndInteger(0, 9)]); //
		 * випадкова особа з випадковим номером заліковки
		 * gr1.tcRemoveStudentFromGroup(AP.rndStudent(17, 23, AP.rndBoolean(),
		 * 20)); // не визначена особа gr1.tcRemoveStudentFromGroup(null); }
		 * System.out.println(); System.out.println(gr1 + "\n"); // Add students
		 * to group = додавання студентів до групи for (int i = 0; i < 5; i++)
		 * gr1.tcAddStudentToGroup(AP.rndStudent(17, 23, AP.rndBoolean(), 20));
		 * System.out.println(); System.out.println(gr1 + "\n"); // Finding a
		 * student by second name = метод пошуку студента за прізвищем for (int
		 * i = 0; i < 10; i++) { Student[] sts =
		 * gr1.findSecondName(AP.setSecondNameRnd(AP .rndBoolean())); Group gr2
		 * = new Group("findGroup2", "678/90", sts); // знайдені студенти
		 * відсортовані за зростанням System.out.println(gr2.getStSortGroup(1) +
		 * "\n"); } // AZ-sort = сортування переліку зростанням
		 * System.out.println(gr1.getStSortGroup(1) + "\n"); // ZA-sort =
		 * сортування переліку спаданням
		 * System.out.println(gr1.getStSortGroup(-1) + "\n"); // unsorted = не
		 * сортований перелік System.out.println(gr1.getStSortGroup(0) + "\n");
		 * // original = оригінальна база System.out.println(gr1 + "\n");
		 */
	}
}