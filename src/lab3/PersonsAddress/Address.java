package lab3.PersonsAddress;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Класс-контейнер для хранения информации об адресе.
 */
public class Address
{
    // Поля класса
    private String Country;
    private String Region;
    private String City;
    private String Street;
    private String HouseNumber;
    private String Entryway;
    private String FlatNumber;

    /**
     * Конструктор класса-адреса.
     *
     * @param Country     страна проживания.
     * @param region      область
     * @param City        город.
     * @param Street      улица.
     * @param HouseNumber дом.
     * @param Entryway    подъезд
     * @param FlatNumber  квартира.
     */
    public Address(String Country, String region, String City, String Street, String HouseNumber, String Entryway, String FlatNumber)
    {
        this.Country = Country;
        this.Region = region;
        this.City = City;
        this.Street = Street;
        this.HouseNumber = HouseNumber;
        this.Entryway = Entryway;
        this.FlatNumber = FlatNumber;
    }

    /**
     * Конструктор класса объекта из одной строки
     * @param strAddress строка-адрес
     * @param divider используемый разделитель
     * @throws IllegalArgumentException если количество токенов в передаваемой строке не равно количеству полей класса
     */
    public Address(String strAddress, char divider){
        String[] strAddressArr = strAddress.split(Character.toString(divider));

        if (strAddressArr.length != 7){ throw new IllegalArgumentException(); }

        this.Country = strAddressArr[0].trim();
        this.Region = strAddressArr[1].trim();
        this.City = strAddressArr[2].trim();
        this.Street = strAddressArr[3].trim();
        this.HouseNumber = strAddressArr[4].trim();
        this.Entryway = strAddressArr[5].trim();
        this.FlatNumber = strAddressArr[6].trim();
    }

    /**
     * Конструктор класса объекта из одной строки
     * @param strAddress строка-адрес
     * @throws IllegalArgumentException если количество токенов в передаваемой строке не равно количеству полей класса
     */
    public Address(String strAddress){
        strAddress = strAddress.trim();
        StringTokenizer st = new StringTokenizer(strAddress, ",.;");

        if (st.countTokens() != 7){ throw new IllegalArgumentException(); }
        this.Country = st.nextToken().trim();
        this.Region = st.nextToken().trim();
        this.City = st.nextToken().trim();
        this.Street = st.nextToken().trim();
        this.HouseNumber = st.nextToken().trim();
        this.Entryway = st.nextToken().trim();
        this.FlatNumber = st.nextToken().trim();
    }

    /**
     * Геттер для поля страны.
     * @return страну данного адреса.
     */
    public String getCountry() {
        return Country;
    }
    /**
     * Геттер для поля области.
     * @return область данного адреса.
     */
    public String getRegion() {
        return Region;
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
     * Геттер для поля номера подъезда.
     * @return номер подъезда данного адреса.
     */
    public String getEntryway() {
        return Entryway;
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
     * Сеттер для поля области.
     * @param region новое значение для поля области.
     */
    public void setRegion(String region) {
        Region = region;
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
     * Сеттер для поля номера подъезда.
     * @param entryway новое значение для поля номера подъезда.
     */
    public void setEntryway(String entryway) {
        Entryway = entryway;
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
                    Objects.equals(Region, address.Region) &&
                    Objects.equals(City, address.City) &&
                    Objects.equals(Street, address.Street) &&
                    Objects.equals(HouseNumber, address.HouseNumber) &&
                    Objects.equals(Entryway, address.Entryway) &&
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
        return '[' +
                Country +
                ", " +
                Region +
                ", " +
                City +
                ", " +
                Street +
                ", " +
                HouseNumber +
                ", " +
                Entryway +
                ", " +
                FlatNumber +
                ']';
    }
}
