package lab3.ShirtClass;

import java.util.StringTokenizer;

/**
 * Класс майки
 */
public class Shirt {
    // Поля с атрибутом final
    private final String id;
    private final String description;
    private final String color;
    private final String size;

    /**
     * Конструктор
     * @param id id
     * @param description описание товара
     * @param color цвет
     * @param size размер
     */
    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    /**
     * Конструктор копирования
     * @param shirt другой объект того же класса
     */
    public Shirt(Shirt shirt) {
        this.id = shirt.id;
        this.description = shirt.description;
        this.color = shirt.color;
        this.size = shirt.size;
    }

    /**
     * Коструктор создания объекта из строкового описания с 4-мя токенами
     * @param shirtString строковое описание создаваемого объекта
     * @throws IllegalArgumentException если количество токенов в переданной строке не соответствует количеству полей класса
     */
    public Shirt(String shirtString) {
        StringTokenizer st = new StringTokenizer(shirtString, ",.;");

        if (st.countTokens() != 4) {throw new IllegalArgumentException();}

        this.id = st.nextToken().trim();
        this.description = st.nextToken().trim();
        this.color = st.nextToken().trim();
        this.size = st.nextToken().trim();
    }

    /**
     * Метод toString выводит объяснение и значение полей построчно
     * @return построчное представление класса
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[\n");
        if (id != null) {
            builder.append("id: ").append(id).append("\n");
        }
        if (description != null) {
            builder.append("description: ").append(description).append("\n");
        }
        if (color != null) {
            builder.append("color: ").append(color).append("\n");
        }
        if (size != null) {
            builder.append("size: ").append(size).append("\n");
        }
        builder.append("]");

        return builder.toString();
    }
}
