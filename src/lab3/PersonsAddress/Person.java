package lab3.PersonsAddress;

import java.util.Calendar;

/**
 * Класс-контейнер для хранения информации о человеке.
 */
public class Person
{
    // Поля с данными о человеке.
    private final int PersonID;
    private String PersonName;
    private String PersonSurname;
    private String PersonLastname;
    private Calendar PersonBirthday; // Дата рождения.

    private Address PersonAddress; // Адрес человека.

    /**
     * Конструктор класса человека.
     * @param Id идентификатор.
     * @param Name имя человека.
     * @param Surname фамилия человека.
     * @param Birthday день рождения человека с типом Calendar.
     * @param Address адрес человека с типом Address.
     */
    public Person(int Id, String Name, String Surname, String Lastname, Calendar Birthday, Address Address)
    {
        this.PersonID = Id;
        this.PersonName = Name;
        this.PersonSurname = Surname;
        this.PersonLastname = Lastname;
        this.PersonBirthday = Birthday;
        this.PersonAddress = Address;
    }


    /**
     * Геттер для поля Id.
     * @return Id человека.
     */
    public int getPersonID()
    {
        return PersonID;
    }

    /**
     * Геттер для поля имени.
     * @return имя человека.
     */
    public String getPersonName()
    {
        return PersonName;
    }

    /**
     * Геттер для поля фамилии.
     * @return фамилия человека.
     */
    public String getPersonSurname()
    {
        return PersonSurname;
    }

    /**
     * Геттер для поля отчества.
     * @return отчество человека.
     */
    public String getPersonLastname() {
        return PersonLastname;
    }

    /**
     * Геттер для поля даты рождения.
     * @return дата рождения человека с типом данных Calendar.
     */
    public Calendar getPersonBirthday()
    {
        return PersonBirthday;
    }

    /**
     * Геттер для поля адреса.
     * @return адрес человека с типом данных Address.
     */
    public Address getPersonAddress()
    {
        return PersonAddress;
    }


    /**
     * Сеттер для поля имени человека.
     * @param personName новое значение поля имени.
     */
    public void setPersonName(String personName)
    {
        this.PersonName = personName;
    }

    /**
     * Сеттер для поля фамилии человека.
     * @param personSurname новое значение фамилии.
     */
    public void setPersonSurname(String personSurname)
    {
        this.PersonSurname = personSurname;
    }

    /**
     * Сеттер для поля отчества человека.
     * @param personLastname новое значение отчества.
     */
    public void setPersonLastname(String personLastname) {
        PersonLastname = personLastname;
    }

    /**
     * Сеттер для поля даты рождения человека.
     * @param personBirthday новое значение даты рождения.
     */
    public void setPersonBirthday(Calendar personBirthday)
    {
        this.PersonBirthday = personBirthday;
    }

    /**
     * Сеттер для поля адреса человека.
     * @param personAddress новое значение адреса.
     */
    public void setPersonAddress(Address personAddress)
    {
        this.PersonAddress = personAddress;
    }


    /**
     * Метод toString для класса человека.
     * @return Строковое представление экземпляра класса для вывода в консоль.
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(PersonID) // ID
                .append(" : ")
                .append(PersonSurname) // Фамилия
                .append(" : ");

        // Имя
        if (PersonName != null){
            str.append(PersonName);
            str.append(" : ");
        }
        // Отчество
        if (PersonLastname != null){
            str.append(PersonLastname);
            str.append(" : ");
        }

        str.append(PersonBirthday.get(Calendar.YEAR)) // год рождения
                .append(" : ")
                .append(PersonAddress.toString()) // адрес проживания
                .append("\n");
        return str.toString();
    }

    /**
     * Метод для вывода ФИО человека в формате Фамилия И.О. Учитывает возможность отсутствия имени и/или отчества.
     * @return строку с ФИО человека
     */
    public String nameToString()
    {
        StringBuilder str = new StringBuilder();

        str.append(PersonSurname).append(' '); // Вывод фамилии целиком, с пробелом

        // Вывод первой буквы имени с точкой, если оно есть
        if (PersonName != null){
            str.append(PersonName.charAt(0));
            str.append(".");
        }
        // Вывод первой буквы отчества с точкой, если оно есть
        if (PersonLastname != null){
            str.append(PersonLastname.charAt(0));
            str.append(".");
        }

        return str.toString();
    }
}
