package net.ukr.andy777;

/*
 4. Реализуйте интерфейс Военком, который вернет из группы массив студентов - юношей, которым больше 18 лет.
 */

public interface Reservist {
	public static int RESERVIST_AGE=18;
	
	public Student[] getReservistList();
}
