package lab2.Cat;

/**
 * Интерфейс кошки (голодной)
 */
public interface CatInterface {
    /**
     * Метод для кормления кошки
     */
    public void feed();

    /**
     * Метод проверки, голодна ли кошка
     * @return bool-значение голодности кошки
     */
    public boolean isHungry();
}
