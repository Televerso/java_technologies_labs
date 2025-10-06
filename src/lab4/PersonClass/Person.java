package lab4.PersonClass;

import java.util.Calendar;
import java.util.Locale;

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

    /**
     * Конструктор класса человека.
     * @param Id идентификатор.
     * @param Name имя человека.
     * @param Surname фамилия человека.
     * @param Birthday день рождения человека с типом Calendar.
     */
    public Person(int Id, String Name, String Surname, String Lastname, Calendar Birthday)
    {
        this.PersonID = Id;
        this.PersonName = Name;
        this.PersonSurname = Surname;
        this.PersonLastname = Lastname;
        this.PersonBirthday = Birthday;
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

        str.append(birthdayToString('s')) // дата рождения
                .append("\n");
        return str.toString();
    }

    /**
     * Метод для вывода даты рождения человека в заданном формате.
     * @param format формат выводимой даты. Поддерживает значения 's', 'm', 'l'.
     * @return строку с датой рождения человека
     */
    public String birthdayToString(char format)
    {
        StringBuilder str = new StringBuilder();

        switch (format) {
            case 's':
                str.append(PersonBirthday.get(Calendar.DAY_OF_MONTH));
                str.append('.');
                if (PersonBirthday.get(Calendar.MONTH) + 1 < 10)
                    str.append('0');
                str.append(PersonBirthday.get(Calendar.MONTH) + 1);
                str.append('.');
                str.append(PersonBirthday.get(Calendar.YEAR));
                break;
            case 'm':
                str.append(PersonBirthday.get(Calendar.DAY_OF_MONTH));
                str.append('-');
                str.append(PersonBirthday.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH));
                str.append('-');
                str.append(PersonBirthday.get(Calendar.YEAR));
                break;
            case 'l':
                str.append(PersonBirthday.get(Calendar.DAY_OF_MONTH));
                str.append(" - ");
                str.append(PersonBirthday.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
                str.append(" - ");
                str.append(PersonBirthday.get(Calendar.YEAR));
                break;
            default:
                str.append(PersonBirthday.get(Calendar.YEAR));
        }
        return str.toString();
    }
}
