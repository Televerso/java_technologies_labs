package lab1.PersonsAddress;

import java.util.Objects;

/**
 * Класс-контейнер для хранения информации об адресе.
 */
public class Address
{
    // Поля класса
    private String Country;
    private String City;
    private String Street;
    private String HouseNumber;
    private String FlatNumber;

    /**
     * Конструктор класса-адреса.
     * @param Country страна проживания.
     * @param City город.
     * @param Street улица.
     * @param HouseNumber дом.
     * @param FlatNumber квартира.
     */
    public Address(String Country, String City, String Street, String HouseNumber, String FlatNumber)
    {
        this.Country = Country;
        this.City = City;
        this.Street = Street;
        this.HouseNumber = HouseNumber;
        this.FlatNumber = FlatNumber;
    }


    /**
     * Геттер для поля страны.
     * @return страну данного адреса.
     */
    public String getCountry() {
        return Country;
    }

    /**
     * Геттер для поля города.
     * @return город данного адреса.
     */
    public String getCity() {
        return City;
    }

    /**
     * Геттер для поля улицы.
     * @return улицу данного адреса.
     */
    public String getStreet() {
        return Street;
    }

    /**
     * Геттер для поля номера дома.
     * @return номер дома данного адреса.
     */
    public String getHouseNumber() {
        return HouseNumber;
    }

    /**
     * Геттер для поля номера дома.
     * @return номер дома для данного адреса.
     */
    public String getFlatNumber() {
        return FlatNumber;
    }


    /**
     * Сеттер для поля страны.
     * @param country новое значение для поля страны.
     */
    public void setCountry(String country) {
        this.Country = country;
    }

    /**
     * Сеттер для поля города.
     * @param city новое значение для поля города.
     */
    public void setCity(String city) {
        this.City = city;
    }

    /**
     * Сеттер для поля улицы.
     * @param street новое значение для поля улицы.
     */
    public void setStreet(String street) {
        this.Street = street;
    }

    /**
     * Сеттер для поля номера дома.
     * @param house_number новое значение для поля номера дома.
     */
    public void setHouseNumber(String house_number) {
        this.HouseNumber = house_number;
    }

    /**
     * Сеттер для поля номера квартиры.
     * @param flatNumber новое значение для поля номера квартиры.
     */
    public void setFlatNumber(String flatNumber) {
        this.FlatNumber = flatNumber;
    }


    /**
     * Метод equals для сравнения эквивалентности двух адресов.
     * @param address_obj другой объект, с которым будет проводиться сравнение.
     * @return true если адреса эквивалентны, в противном случае false.
     */
    @Override
    public boolean equals(Object address_obj) {
        if (address_obj == null) return false; // Сравнение на null
        if (this == address_obj) return true; // Прямое сравнение ссылок на объекты
        if (address_obj instanceof Address) // Сравнение типов объектов
        {
            Address address = (Address) address_obj; // Приведение к одному типу
            // Сравнение всех полей объектов
            return Objects.equals(Country, address.Country) &&
                    Objects.equals(City, address.City) &&
                    Objects.equals(Street, address.Street) &&
                    Objects.equals(HouseNumber, address.HouseNumber) &&
                    Objects.equals(FlatNumber, address.FlatNumber);
        }
        return false;
    }

    /**
     * Метод toString для адреса.
     * @return Строковое представление адреса для вывода в консоль.
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(Country);
        str.append(", ");
        str.append(City);
        str.append(", ");
        str.append(Street);
        str.append(", ");
        str.append(HouseNumber);
        str.append(", ");
        str.append(FlatNumber);
        str.append(']');
        return str.toString();
    }
}
