package lab2.GameOfDice;


/**
 * Класс игрока компьютера.
 * Содержит информацию об игроке, включая результат последнего броска этого игрока. <p>
 * Игрок-компьютер не требует подтверждения броска костей, не открывает диалог в консоли и просто сразу кидает кубики.
 */
public class AiPlayerImpl implements Player
{
    private final int id; // Id игрока.
    private int last_score; // Результат последнего броска.

    /**
     * Конструктор класса игрока-компьютера.
     * @param id идентификатор данного игрока.
     */
    public AiPlayerImpl(int id)
    {
        this.id = id;
        this.last_score = 0;
    }

    /**
     * Геттер для идентификатора игрока.
     * @return id - идентификатор игрока.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Геттер для получения результата последнего броска.
     * @return Последний результат броска для данного игрока.
     */
    public int getLastScore()
    {
        return last_score;
    }

    /**
     * Метод для броска костей текущим игроком.
     * @return Результат броска текущим игроком.
     */
    public int throwDice(DiceBox dice)
    {
        // Текущий игрок - компьютер, сразу бросаем кости.
        this.last_score = dice.throwDie();
        return this.last_score;
    }
}