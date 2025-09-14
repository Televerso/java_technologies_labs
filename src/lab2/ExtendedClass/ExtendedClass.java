package lab2.ExtendedClass;


import java.util.Objects;

public class ExtendedClass {
    // Поля текущего класса
    private byte b;
    private int i;
    private double d;
    private String s;

    /**
     * Конструктор класса
     * @param b параметр типа byte
     * @param i параметр типа int
     * @param d параметр типа double
     * @param s параметр типа String
     */
    public ExtendedClass(byte b, int i, double d, String s) {
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }

    /**
     * Геттер для поля b
     * @return значение поля b
     */
    public byte getB() {
        return b;
    }
    /**
     * Геттер для поля i
     * @return значение поля i
     */
    public int getI() {
        return i;
    }
    /**
     * Геттер для поля d
     * @return значение поля d
     */
    public double getD() {
        return d;
    }
    /**
     * Геттер для поля s
     * @return значение поля s
     */
    public String getS() {
        return s;
    }

    /**
     * Сеттер для поля b
     * @param b новое значение поля b
     */
    public void setB(byte b) {
        this.b = b;
    }
    /**
     * Сеттер для поля i
     * @param i новое значение поля i
     */
    public void setI(int i) {
        this.i = i;
    }
    /**
     * Сеттер для поля d
     * @param d новое значение поля d
     */
    public void setD(double d) {
        this.d = d;
    }
    /**
     * Сеттер для поля s
     * @param s новое значение поля s
     */
    public void setS(String s) {
        this.s = s;
    }

    /**
     * Метод toString для класса ExtendedClass
     * @return строковое представление экземпляра класса
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExtendedClass [b=");
        builder.append(b);
        builder.append(", i=");
        builder.append(i);
        builder.append(", d=");
        builder.append(d);
        builder.append(", s=");
        builder.append(s);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Метод equals для объекта класса ExtendedClass
     * @param obj объект, с которым будет сравниваться текущий
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {return false;} // Проверка на null
        if (getClass() != obj.getClass()) {return false;} // Проверка на соответствие типов
        if (this == obj) {return true;} // Проверка ссылок на объекты

        ExtendedClass other = (ExtendedClass) obj; // Приведение к одному типу
        // Сравнение значений всех полей класса и возвращение результата
        return (b == other.b) && (i == other.i) && (d == other.d) && (s.equals(other.s));
    }

    /**
     * Метод hashCode класса ExtendedClass
     * @return хэш-представление текущего экземпляра
     */
    @Override
    public int hashCode() {
        // Метод Objects.hash принимает на вход набор параметров и воспринимает их как массив объектов;
        // делает это посредством вызова метода Arrays.hashCode для данного массива
        return Objects.hash(b, i, d, s);
    }
}
