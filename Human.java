package net.ukr.andy777;

import java.io.Serializable;

/*
 1. Создать класс Человек/Human, описывающий человека (Ф.,И.,О., возраст, пол)
 Создать метод, выводящий информацию о человеке.
 */

public class Human implements Serializable {

	protected String secondName; // surname = прізвище
	protected String firstName; // name = ім'я
	protected String middleName; // patronymic = по-батькові
	protected int age; // years old = вік
	protected boolean sex; // gender = стать

	/* constructors = конструктори */
	public Human() {
		super();
	}

	public Human(String secondName, String firstName, String middleName,
			int age, boolean sex) {
		super();
		this.secondName = secondName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.age = age;
		this.sex = sex;
	}

	/* setters and getters = сеттери та геттери */

	// surname = прізвище
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	// name = ім'я
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// patronymic = по-батькові
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	// years old = вік
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// gender = стать (true = male/чоловіча)
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	// toString method = метод виводу інформації про екземпляр класу Human
	@Override
	public String toString() {
		return "Human [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female") + ")]";
	}

	// !!!! methot needs to be improved, for future = метод потребує
	// доопрацювання, на майбутнє
	/**
	 * Comparing two instances of a class Human = метод порівняння двох
	 * екземпляір класу Human
	 * 
	 * @param person
	 *            <code>Human</code> instances of a class Human
	 * @return boolean true-value if equals
	 * @author ap
	 */
	public boolean equals(Human person) {
		boolean res = false;
		if (this.secondName.equals(person.getSecondName())
				&& this.firstName.equals(person.getFirstName())
				&& this.middleName.equals(person.getMiddleName())
				&& this.age == person.getAge() && this.sex == person.isSex()) {
			res = true;
		}
		return res;
	}
}