package net.ukr.andy777;

import java.io.Serializable;

/*
 Lesson03
 2. На основе класса Человек/Human создать класс Студент/Student. И переопределить метод вывода информации.

 Lesson04
 2. Реализуйте возможность сортировки списка студентов по фамилии.
 3. Реализуйте возможность сортировки по параметру (Фамилия, успеваемость и т. д.).
 */

public class Student extends Human implements Serializable {

	// protected Human human; // екземпляр класу Human
	protected int recordNumber; // record number = номер заліковки
	protected String highSchool; // higher school = навчальний заклад
	protected int yearStudy; // year of study = рік навчання

	/* constructors = конструктори */
	public Student() {
		super();
	}

	public Student(Human human, int recordNumber, String highSchool,
			int yearStudy) {
		super(human.getSecondName(), human.getFirstName(), human
				.getMiddleName(), human.getAge(), human.isSex());
		this.recordNumber = recordNumber;
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
	}

	public Student(Human human, int recordNumber) {
		super(human.getSecondName(), human.getFirstName(), human
				.getMiddleName(), human.getAge(), human.isSex());
		this.recordNumber = recordNumber;
	}

	public Student(String secondName, String firstName, String middleName,
			int age, boolean sex, int recordNumber, String highSchool,
			int yearStudy) {
		super(secondName, firstName, middleName, age, sex);
		this.recordNumber = recordNumber;
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
	}

	public Student(String secondName, String firstName, String middleName,
			int age, boolean sex, int recordNumber) {
		super(secondName, firstName, middleName, age, sex);
		this.recordNumber = recordNumber;
	}

	/* setters and getters = сеттери та геттери */

	// higher school = навчальний заклад
	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	// year of study = рік навчання
	public int getYearStudy() {
		return yearStudy;
	}

	public void setYearStudy(int yearStudy) {
		this.yearStudy = yearStudy;
	}

	// record number = номер заліковки
	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	// toString method = перевизначений метод виводу інформації про екземпляр
	// класу Student
	@Override
	public String toString() {
		return "Student [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female")
				+ ") recordNumber-" + recordNumber + ", HighSchool-"
				+ highSchool + ", grade-" + yearStudy + "]";
	}

	public String toStringSFMnSRn() {
		return "Student [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female")
				+ ") recordNumber-" + recordNumber + "]";
	}

	/**
	 * Comparing two instances of a class Student = метод порівняння двох
	 * екземпляір класу Student
	 * 
	 * @param student
	 *            <code>Student</code> instances of a class Student
	 * @return boolean true-value if equals
	 * @author ap
	 */
	public boolean equals(Student student) {
		boolean res = false;
		if (this.secondName.equals(student.getSecondName())
				&& this.firstName.equals(student.getFirstName())
				&& this.middleName.equals(student.getMiddleName())
				&& this.age == student.getAge() && this.sex == student.isSex()
				&& this.recordNumber == student.getRecordNumber()
				&& this.highSchool.equals(student.getHighSchool())
				&& this.yearStudy == student.getYearStudy())
			res = true;
		return res;
	}
}
