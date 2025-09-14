package lab2.Cat;

/**
 * Класс, имплементирующий интерфейс CatInterface
 */
public class CatImpl implements CatInterface {
    private final String name; // Имя кошки

    private boolean hungry; // Флажок голодности кошки (по умолчанию true)

    /**
     * Конструктор класса
     * @param name имя кошки
     */
    public CatImpl(String name) {
        this.name = name;
        this.hungry = true;
    }

    /**
     * Геттер для имени кошки
     * @return значение поля имени
     */
    public String getName() {return name;}

    /**
     * Проверка состояния голодности кошки
     * @return true\false - голодна ли кошка
     */
    public boolean isHungry() {
        if (hungry) {
            System.out.println("I'm hungry, bro!"); // lol
        }
        else {
            System.out.println("I just want to sleep for a bit, OK?"); // ZzzZZzzZZz
        }
        return hungry;
    }

    /**
     * Кормит кошку
     * (флажок в false)
     */
    public void feed() {
        System.out.println("You feed the cat that goes by " + name);
        this.hungry = false;
    }
}
