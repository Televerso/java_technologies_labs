package lab2.GameOfDice;

/**
 * Интерфейс для классов игрока
 */
public interface Player {
    /**
     * Метод для получения Id игрока
     * @return Id игрока
     */
    public int getId();

    /**
     * Метод для получения счета игрока в последнем броске
     * @return результат последнего броска игрока
     */
    public int getLastScore();

    /**
     * Метод броска костей - заставляет игрока бросить кости
     * @param dice объект типа DiceBox - кости в данной игре
     * @return сумма очков, выпавших на костях
     */
    public int throwDice(DiceBox dice);
}
