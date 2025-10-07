package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс для игры в кости.
 * Включает в себя два вложенных класса - класс костей и класс игрока.
 */
public class GameOfDice
{
    int round_number_n; // Номер текущего раунда

    private int player_count; // Количество игроков.
    private DiceBox dice; // Объект, обрабатывающий операции с костями.
    private Player[] players; // Список игроков - объектов-экземпляров класса Player.
    private int last_winner; // Id игрока, победившего в последнем раунде.
    private int[] N_wins; // Массив, хранящий количество выигрышей каждого из игроков в соответствии с их Id.

    /**
     * Класс для работы с костями.
     */
    private class DiceBox
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

    /**
     * Класс игрока.
     * Содержит информацию об игроке, включая результат последнего броска этого игрока. <p>
     * Игрок-компьютер не требует подтверждения броска костей, не открывает диалог в консоли и просто сразу кидает кубики.
     */
    private class Player
    {
        private final int id; // Id игрока.
        private boolean isAi; // Является ли данный игрок "компьютером". По умолчанию false.
        private int last_score; // Результат последнего броска.

        /**
         * Конструктор класса игрока.
         * @param id идентификатор данного игрока.
         */
        public Player(int id)
        {
            this.id = id;
            this.isAi = false;
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
         * Геттер для флага "компьютера" игрока.
         * @return Является ли данный игрок "компьютером" или нет.
         */
        public boolean isAi()
        {
            return isAi;
        }

        /**
         * Устанавливает флаг компьютера для данного игрока. <p>
         * @param flag флаг "компьютера".
         */
        public void setAiFlag(boolean flag)
        {
            this.isAi = flag;
        }

        /**
         * Метод для броска костей текущим игроком.
         * @return Результат броска текущим игроком.
         */
        public int throwDice()
        {
            if (this.isAi)
            {
                // Если текущий игрок - компьютер, то сразу бросаем костей.
                this.last_score = dice.throwDie();
                return this.last_score;
            }
            else
            {
                // Иначе просим игрока о подтверждении броска костей.
                System.out.printf("Игрок %d, кидайте кубик! \n", this.id);
                Scanner input = new Scanner(System.in);
                String player_throw = input.nextLine();
                if (player_throw != null && !player_throw.isEmpty() && !player_throw.equals(" ")) {
                    this.last_score = dice.throwDie();
                    return this.last_score;
                }
                else return -1;

            }
        }
    }

    /**
     * Конструктор для самой игры в кости.
     * @param N количество игроков.
     * @param K количество костей.
     */
    public GameOfDice(int N, int K)
    {
        this.round_number_n = 0;

        this.player_count = N;
        this.dice = new DiceBox(K); // Инициализируем класс костей для этой игры.

        // Инициализируем всех игроков.
        this.players = new Player[this.player_count];
        for(int i = 0; i < this.player_count; ++i)
            this.players[i] = new Player(i+1);
        // Последний игрок в списке - компьютер.
        this.players[this.player_count-1].setAiFlag(true);

        this.last_winner = 0;
        // Инициализируем массив с числом выигрышей у каждого игрока - заполняем его нулями.
        this.N_wins = new int[this.player_count];
        for(int i = 0; i < this.player_count; ++i)
            this.N_wins[i] = 0;
    }

    /**
     * Метод, воспроизводящий один раунд игры в кости
     * @return Id игроков с максимальным счетом в раунде
     */
    private List<Integer> playRound()
    {
        this.round_number_n++;

        List<Integer> max_dice_id = new ArrayList<>();

        // Первым ходит победитель прошлого раунда.
        for(int i = 0; i < this.player_count; ++i)
        {
            // Игроки по очереди кидают кости.
            int curr_dice = players[(i + last_winner) % player_count].throwDice();
            // Если игрок отказался бросать кости:
            if (curr_dice < 0)
            {
                // Выводим сообщение в консоль.
                System.out.printf("Игрок %d отказался продолжать игру, игра завершится преждевременно.\n",
                        (i + last_winner) % player_count + 1);
                return new ArrayList<>(); // Завершаем раунд с кодом -1.
            }

            // Выводится сообщение в консоль.
            System.out.printf("Игрок %d выбросил число %d\n", (i + last_winner) % player_count + 1, curr_dice);
            // Запоминается игрока, выбросивший наивысшую сумму очков.
            if (max_dice_id.isEmpty() || this.players[max_dice_id.get(0)].last_score < curr_dice)
            {
                max_dice_id.clear();
                max_dice_id.add((i + last_winner) % player_count);
            }
            // В случае ничьей все игроки с максимальным счетом добавляются в список
            else if (this.players[max_dice_id.get(0)].last_score == curr_dice)
            {
                max_dice_id.add((i + last_winner) % player_count);
            }
        }

        return max_dice_id;
    }



    /**
     * Метод в котором ведется цикл игры до ее конца.
     * @param n_wins Количество выигрышей у одного игрока, до которого продолжается игра.
     */
    public void play(int n_wins)
    {
        int counter = 0;
        while(counter < 1000)
        {
            ++counter;
            List<Integer> round_winners = this.playRound(); // Игроки играют один раунд.
            // Один из игроков отказался кидать кости:
            if (round_winners.isEmpty())
            {
                // Находим игрока с максимальным количеством выигрышей:
                int max_wins = 0;
                for (int i = 0; i < this.player_count; ++i)
                {
                    if(this.N_wins[i] > max_wins)
                    {
                        max_wins = this.N_wins[i];
                    }
                }
                // он является победителем в это игре.
                System.out.printf("В игре победил игрок %d!!!\n", max_wins+1);
                return;
            }
            // Если есть явный победитель
            else if (round_winners.size() == 1)
            {
                this.last_winner = round_winners.get(0); // Победитель раунда запоминается - с него начнется ход в следующем раунде.
                // Выводится сообщение о победе игрока с наивысшим количеством очков в этом раунде.
                System.out.printf("В раунде %d победил игрок %d!\n", this.round_number_n, this.last_winner+1);
                this.N_wins[this.last_winner]++; // Количество побед для игрока победителя увеличивается на 1.

                // Проверка условия окончания игры:
                for (int i = 0; i < this.player_count; ++i)
                {
                    if (this.N_wins[i] == n_wins) {
                        System.out.printf("В игре победил игрок %d!!!\n", i+1);
                        return;
                    }
                }
            }
            // Если победителя нет - то есть если у двух и более игроков одинаковый счет
            else
            {
                // Вывод соответствующего сообщения
                StringBuilder message = new StringBuilder();
                message.append("В раунде ");
                message.append(round_number_n);
                message.append(" у игроков ");
                for (int i = 0; i < round_winners.size()-1; ++i)
                {
                    message.append(round_winners.get(i)+1);
                    message.append(", ");
                }
                message.append(round_winners.get(round_winners.size()-1)+1);
                message.append(" одинаковый счет, победителей нет! \n");

                System.out.println(message);

                // Дальше ничего не делаем, переходим в цикле к следующему раунду
            }
        }
    }
}
