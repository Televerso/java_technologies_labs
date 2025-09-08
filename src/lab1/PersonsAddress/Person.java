package lab1.PersonsAddress;

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
    public Person(int Id, String Name, String Surname, Calendar Birthday, Address Address)
    {
        this.PersonID = Id;
        this.PersonName = Name;
        this.PersonSurname = Surname;
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
        str.append(PersonID)
                .append(" : ")
                .append(PersonName)
                .append(" : ")
                .append(PersonSurname)
                .append(" : ")
                .append(PersonBirthday.get(Calendar.YEAR))
                .append(" : ")
                .append(PersonAddress.toString())
                .append("\n");
        return str.toString();
    }
}
