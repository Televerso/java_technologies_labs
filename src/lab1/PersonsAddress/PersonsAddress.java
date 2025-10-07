package lab1.PersonsAddress;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Класс для работы с массивом объектов "человек".
 */
public class PersonsAddress
{
    private List<Person> persons; // Массив объектов

    /**
     * Конструктор с одним параметром.
     * @param persons готовый массив объектов.
     */
    public PersonsAddress(List<Person> persons)
    {
        this.persons = persons;
    }

    /**
     * Метод поиска человека по фамилии.
     * @param surname фамилия человека.
     * @return список объектов типа Person с заданной фамилией.
     */
    public List<Person> findBySurname(String surname)
    {
        // Поиск методом перебора, соответствующие условию объекта помещаются в возвращаемый список.
        List<Person> matching_surname_list = new ArrayList<Person>();
        for(Person person : persons)
        {
            if(person.getPersonSurname().equals(surname))
            {
                matching_surname_list.add(person);
            }
        }
        return matching_surname_list;
    }

    /**
     * Метод для поиска по адресу.
     * @param address объект типа Address.
     * @return список объектов типа Person с соответствующим адресом.
     */
    public List<Person> findByAddress(Address address)
    {
        // Поиск методом перебора, соответствующие условию объекта помещаются в возвращаемый список.
        List<Person> matching_address_list = new ArrayList<Person>();
        for(Person person : persons)
        {
            if(person.getPersonAddress().equals(address))
            {
                matching_address_list.add(person);
            }
        }
        return matching_address_list;
    }

    /**
     * Метод поиска человека по атрибуту адреса.
     * <hr>
     * @param attribute атрибут адреса, по которому производится поиск.
     * @param level уровень атрибута:
     *              <ul>
     *              <li> 0 - страна</li>
     *              <li> 1 - город</li>
     *              <li> 2 - улица</li>
     *              <li> 3 - номер дома</li>
     *              <li> 4 - номер квартиры</li>
     *              </ul>
     * <hr>
     * @return список объектов типа Person с соответствующим адресом.
     */
    public List<Person> findByAddressAttribute(String attribute, int level)
    {
        // Поиск методом перебора, соответствующие условию объекта помещаются в возвращаемый список.
        List<Person> matching_attribute_list = new ArrayList<Person>();
        for(Person person : persons)
        {
            // This is awful
            switch(level){
                case 0:
                    if(person.getPersonAddress().getCountry().equals(attribute))
                        matching_attribute_list.add(person);
                    break;
                case 1:
                    if(person.getPersonAddress().getCity().equals(attribute))
                        matching_attribute_list.add(person);
                    break;
                case 2:
                    if(person.getPersonAddress().getStreet().equals(attribute))
                        matching_attribute_list.add(person);
                    break;
                case 3:
                    if(person.getPersonAddress().getHouseNumber().equals(attribute))
                        matching_attribute_list.add(person);
                    break;
                case 4:
                    if(person.getPersonAddress().getFlatNumber().equals(attribute))
                        matching_attribute_list.add(person);
                    break;
            }
        }
        return matching_attribute_list;
    }

    /**
     * Метод поиска человека, родившегося в заданном диапазоне дат.
     * @param starting_date -
     * @param ending_date
     * <br> Промежуток дат, между которыми осуществляется поиск.
     * @return список объектов типа Person с соответствующими датами рождения.
     */
    public List<Person> findPersonByDateRange(Calendar starting_date, Calendar ending_date)
    {
        // Поиск методом перебора, соответствующие условию объекта помещаются в возвращаемый список.
        List<Person> matching_dates_list = new ArrayList<Person>();
        for(Person person : persons)
        {
            // Добавляет объект в список если начальная дата промежутка идет до его даты рождения и
            // конечная дата промежутка идет после его даты рождения.
            // Сравнение внутри методов строгое.
            if(starting_date.before(person.getPersonBirthday()) && ending_date.after(person.getPersonBirthday()))
            {
                matching_dates_list.add(person);
            }
        }
        return matching_dates_list;
    }

    /**
     * Метод поиска самого старшего человека.
     * @return Объект типа Person, родившегося раньше всех.
     */
    public Person findOldest()
    {
        // Поиск минимального значения методом перебора.
        Person oldest = null;
        Calendar current_oldest = Calendar.getInstance();

        for(Person person : persons)
        {
            if(current_oldest.compareTo(person.getPersonBirthday()) > 0)
            {
                oldest = person;
                current_oldest = person.getPersonBirthday();
            }
        }
        return oldest;
    }

    /**
     * Метод поиска самого младшего человека.
     * @return Объект типа Person, родившегося позже всех.
     */
    public Person findYoungest()
    {
        // Поиск максимального значения методом перебора.
        Person youngest = null;
        Calendar current_youngest = new GregorianCalendar(1900,Calendar.JANUARY,1);

        for(Person person : persons)
        {
            if(current_youngest.compareTo(person.getPersonBirthday()) < 0)
            {
                youngest = person;
                current_youngest = person.getPersonBirthday();
            }
        }
        return youngest;
    }

    /**
     * Поиск людей, живущих на одной улице.
     * @param Country страна проживания.
     * @param City город проживания.
     * @param Street улица проживания.
     * @return список объектов типа Person с соответствующим адресом.
     */
    public List<Person> findSameStreet(String Country, String City, String Street)
    {
        // Поиск методом перебора, соответствующие условию объекта помещаются в возвращаемый список.
        List<Person> matching_street_list = new ArrayList<Person>();
        for(Person person : persons)
        {
            // В разных городах и странах могут быть улицы с одинаковыми названиями, поэтому, чтобы найти
            // людей, живущих на одной улице, нужно также проверить и их страны и города проживания.
            if(person.getPersonAddress().getCountry().equals(Country))
                if(person.getPersonAddress().getCity().equals(City))
                    if(person.getPersonAddress().getStreet().equals(Street))
                        matching_street_list.add(person);
        }
        return matching_street_list;
    }

    /**
     * Метод toString для класса PersonsAddress.
     * @return Строковое представление таблицы со списком людей.
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for(Person person : persons)
        {
            str.append(person.toString());
        }
        return str.toString();
    }
}
