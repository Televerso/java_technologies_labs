package lab2.GameOfDice;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для игры в кости.
 */
public class GameOfDice2
{
    int round_number_n; // Номер текущего раунда

    private int player_count; // Количество игроков.
    private DiceBox dice; // Объект, обрабатывающий операции с костями.
    private Player[] players; // Список игроков - объектов-экземпляров класса Player.
    private int last_winner; // Id игрока, победившего в последнем раунде.
    private int[] N_wins; // Массив, хранящий количество выигрышей каждого из игроков в соответствии с их Id.


    /**
     * Конструктор для самой игры в кости.
     * @param N количество игроков.
     * @param K количество костей.
     */
    public GameOfDice2(int N, int K)
    {
        this.round_number_n = 0;

        this.player_count = N;
        this.dice = new DiceBox(K); // Инициализируем класс костей для этой игры.

        // Инициализируем всех игроков.
        this.players = new Player[this.player_count];
        for(int i = 0; i < this.player_count-1; ++i)
            this.players[i] = new RealPlayerImpl(i+1);
        // Последний игрок в списке - компьютер.
        this.players[this.player_count-1] = new AiPlayerImpl(this.player_count);

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
            int curr_dice = players[(i + last_winner) % player_count].throwDice(dice);
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
            // Запоминается игрок, выбросивший наивысшую сумму очков.
            if (max_dice_id.isEmpty() || this.players[max_dice_id.get(0)].getLastScore() < curr_dice)
            {
                max_dice_id.clear();
                max_dice_id.add((i + last_winner) % player_count);
            }
            // В случае ничьей все игроки с максимальным счетом добавляются в список
            else if (this.players[max_dice_id.get(0)].getLastScore() == curr_dice)
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
                message.append(" одинаковый счет, победителей нет!");

                System.out.println(message);

                // Дальше ничего не делаем, переходим в цикле к следующему раунду
            }
        }
    }
}
