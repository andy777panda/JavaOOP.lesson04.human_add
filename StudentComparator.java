package net.ukr.andy777;

// Lesson04
// 2. Реализуйте возможность сортировки списка студентов по фамилии.
// 3. Реализуйте возможность сортировки по параметру (Фамилия, успеваемость
// и т. д.).

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student one, Student two) {
		switch (Group.getSortWay()) {
		case 1: // secondName-aZ
			return (one.secondName.compareToIgnoreCase(two.getSecondName()) > 0) ? 1
					: (one.secondName.compareToIgnoreCase(two.getSecondName()) < 0) ? -1
							: 0;
		case -1: // secondName-Za
			return (-one.secondName.compareToIgnoreCase(two.getSecondName()) > 0) ? 1
					: (-one.secondName.compareToIgnoreCase(two.getSecondName()) < 0) ? -1
							: 0;
		case 2: // firstName-aZ
			return (one.firstName.compareToIgnoreCase(two.firstName) > 0) ? 1
					: (one.firstName.compareToIgnoreCase(two.firstName) < 0) ? -1
							: 0;
		case -2: // firstName-Za
			return (-one.firstName.compareToIgnoreCase(two.firstName) > 0) ? 1
					: (-one.firstName.compareToIgnoreCase(two.firstName) < 0) ? -1
							: 0;
		case 3: // age-aZ
			return (one.age - two.age > 0) ? 1 : (one.age - two.age < 0) ? -1
					: 0;
		case -3: // age-Za
			return (-one.age + two.age > 0) ? 1 : (-one.age + two.age < 0) ? -1
					: 0;
		case 4: // recordNumber-aZ
			return (one.recordNumber - two.recordNumber > 0) ? 1
					: (one.recordNumber - two.recordNumber < 0) ? -1 : 0;
		case -4: // recordNumber-Za
			return (-one.recordNumber + two.recordNumber > 0) ? 1
					: (-one.recordNumber + two.recordNumber < 0) ? -1 : 0;
		default:
			return 0;
		}
	}
}