package lab2.GameOfDice;

import java.util.Random;

/**
 * Класс для работы с костями.
 */
public class DiceBox
{
    // Задается и инициализируется генератор случайных чисел
    private static final int seed = (int) System.currentTimeMillis();
    private static final Random rng = new Random(seed);

    private final int dice_count; // Поля для количества костей

    /**
     * Конструктор класса DiceBox.
     * @param dice_count количество бросаемых костей.
     */
    public DiceBox(int dice_count)
    {
        this.dice_count = dice_count;
    }

    /**
     * Геттер для количества костей.
     * @return количество костей для текущего экземпляра класса.
     */
    public int getDiceCount()
    {
        return dice_count;
    }

    /**
     * Метод, бросающий кости. <p>
     * Кости бросаются последовательно, результаты бросков складываются и возвращается сумма чисел,
     * выпавших на костях.
     * @return результат броска костей.
     */
    public int throwDie()
    {
        int s = 0;
        for(int i = 0; i < this.dice_count; ++i)
            s += rng.nextInt(5) + 1; // Значение от 0 до 5, к нему прибавляется 1

        return s;
    }
}
