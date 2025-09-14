package lab2.GameOfDice;

import java.util.Scanner;

/**
 * Класс игрока.
 * Содержит информацию об игроке, включая результат последнего броска этого игрока. <p>
 */
public class RealPlayerImpl implements Player {
    private final int id; // Id игрока.
    private int last_score; // Результат последнего броска.

    /**
     * Конструктор класса игрока.
     * @param id идентификатор данного игрока.
     */
    public RealPlayerImpl(int id) {
        this.id = id;
        this.last_score = 0;
    }

    /**
     * Геттер для идентификатора игрока.
     * @return id - идентификатор игрока.
     */
    public int getId() {
        return id;
    }

    /**
     * Геттер для получения результата последнего броска.
     * @return Последний результат броска для данного игрока.
     */
    public int getLastScore() {
        return last_score;
    }


    /**
     * Метод для броска костей текущим игроком.
     * @return Результат броска текущим игроком.
     */
    public int throwDice(DiceBox dice) {
        // Просим игрока о подтверждении броска костей.
        System.out.printf("Игрок %d, кидайте кубик! \n", this.id);
        Scanner input = new Scanner(System.in);
        String player_throw = input.nextLine();
        // Возвращаем результат броска; если игрок отказался бросать - возвращаем -1
        if (player_throw != null && !player_throw.isEmpty() && !player_throw.equals(" ")) {
            this.last_score = dice.throwDie();
            return this.last_score;
        } else return -1;

    }
}

