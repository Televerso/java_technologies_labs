package lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для решения квадратных уравнений. Каждый экземпляр класса является независимым квадратным уравнением.
 * Коэффициенты указываются при инициализации экземпляра класса и имеют модификатор final. Дискриминант вычисляется посредством вложенного класса.
 */
public class SquareSolver
{
    // Поля - коэффициенты квадратного уравнения
    private final double coef_a;
    private final double coef_b;
    private final double coef_c;

    // У каждого квадратного уравнения есть свой экземпляр класса, обрабатывающего операции с дискриминантом.
    private final DiscriminantFinder disc_finder;

    /**
     * Конструктор класса квадратных уравнений. Здесь задаются значение коэффициентов квадратного уравнения.
     * @param a коэффициент a
     * @param b коэффициент b
     * @param c коэффициент c
     */
    public SquareSolver(double a, double b, double c)
    {
        this.coef_a = a;
        this.coef_b = b;
        this.coef_c = c;

        // Инициализируется экземпляр класса поиска дискриминанта.
        // Дискриминант вычисляется именно на этом этапе.
        this.disc_finder = new DiscriminantFinder();
    }


    /**
     * Геттер для коэффициента a.
     * @return значение коэффициента a.
     */
    public double getCoefA()
    {
        return coef_a;
    }
    /**
     * Геттер для коэффициента b.
     * @return значение коэффициента b.
     */
    public double getCoefB()
    {
        return coef_b;
    }
    /**
     * Геттер для коэффициента c.
     * @return значение коэффициента c.
     */
    public double getCoefC()
    {
        return coef_c;
    }

    /**
     * Класс для вычисления значения дискриминанта. Дискриминант вычисляется во время инициализации экземпляра класса.
     */
    private class DiscriminantFinder
    {
        // Поля класса
        // D - значение дискриминанта.
        // sign - поле, хранящее знак дискриминанта, для быстрого доступа к информации о знаке.
        private final double D;
        private final byte sign;

        /**
         * Конструктор класса, вычисляющего дискриминант. Именно тут происходит вычисление значение дискриминанта, и,
         * следовательно, инициализация полей класса.
         */
        DiscriminantFinder()
        {
            this.D = (SquareSolver.this.coef_b * SquareSolver.this.coef_b) -
                    4*(SquareSolver.this.coef_a * SquareSolver.this.coef_c);
            this.sign = (byte) Math.signum(this.D);
        }

        /**
         * Геттер для получения значения дискриминанта.
         * @return значение дискриминанта d.
         */
        public double getD()
        {
            return D;
        }

        /**
         * Геттер для получения значения знака дискриминанта.
         * @return -1 если дискриминант отрицательный; <p>
         *     0 если дискриминант равен 0; <p>
         *         1 если дискриминант положительный.
         */
        public byte getSign()
        {
            return sign;
        }
    }

    /**
     * Метод, вычисляющий корни квадратного уравнения.
     * @return список, содержащий 0, 1 или 2 элемента в зависимости от количества вещественных корней.
     */
    public List<Double> solve()
    {
        List<Double> solution = new ArrayList<Double>(); // Список, в который будет записываться ответ.
        switch (this.disc_finder.sign)
        {
            case -1:
                break; // Дискриминант отрицательный, корней нет.
            case 0:
                solution.add((-this.coef_b)/(2*this.coef_a)); // Дискриминант = 0, один корень.
                break;
            case 1:
                // Дискриминант положительный, вычисляются оба корня.
                solution.add((-this.coef_b-Math.sqrt(this.disc_finder.getD())) / (2*this.coef_a));
                solution.add((-this.coef_b+Math.sqrt(this.disc_finder.getD())) / (2*this.coef_a));
        }
        return solution;
    }


    /**
     * Метод toString для строкового представления объекта квадратного уравнения.
     */
    @Override
    public String toString()
    {
        return "{ " +
                this.coef_a + "*x^2 + " +
                this.coef_b + "*x + " +
                this.coef_c +
                " ; D=" + this.disc_finder.getD() +
                " }";
    }
}
