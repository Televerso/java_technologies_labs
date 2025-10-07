package lab4.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс бинарного дерева
 */
public class BinaryTree {
    /**
     * Класс узла дерева.
     * Содержит рекурсивные методы для работы с деревом
     */
    static class Node {
        private int data; // Поле с данными
        private Node left, right; // Поля-ссылки на другие узлы дерева

        /**
         * Конструктор узла
         * @param data содержимое узла
         */
        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        /**
         * @return значение поля data
         */
        public int getData() {
            return data;
        }

        /**
         * Рекурсивный метод вставки значения в дерево
         * @param data значение для вставки
         */
        public void insert(int data) {
            // Значение меньше текущего - идем в левую ветвь
            if (data < this.data) {
                // Если слева есть место, вставляем его туда
                if (this.left == null) {
                    this.left = new Node(data);
                }
                else {
                    // Иначе передаем значение дальше
                    left.insert(data);
                }
            }
            else {
                // Иначе идем в правую
                // Если справа есть место, вставляем его туда
                if (this.right == null) {
                    this.right = new Node(data);
                }
                else {
                    // Иначе передаем значение дальше
                    right.insert(data);
                }
            }
        }

        /**
         * Рекурсивный метод центрированного прохода по дереву
         * @param list список, в который записываются значения пройденных узлов
         */
        public void centerPass(List<Integer> list) {
            // Сначала идем влево, потом вставляем текущий элемент, потом идем вправо
            if (this.left != null) {
                this.left.centerPass(list);
            }
            list.add(this.data);
            if (this.right != null) {
                this.right.centerPass(list);
            }
        }

        /**
         * Рекурсивный метод прямого прохода по дереву
         * @param list список, в который записываются значения пройденных узлов
         */
        public void straightPass(List<Integer> list) {
            // Сначала вставляем текущий элемент, потом идем влево, потом идем вправо
            list.add(this.data);
            if (this.left != null) {
                this.left.straightPass(list);
            }
            if (this.right != null) {
                this.right.straightPass(list);
            }
        }

        /**
         * Рекурсивный метод обратного прохода по дереву
         * @param list список, в который записываются значения пройденных узлов
         */
        public void reversePass(List<Integer> list) {
            // Сначала  идем влево, потом идем вправо, потом вставляем текущий элемент
            if (this.left != null) {
                this.left.reversePass(list);
            }
            if (this.right != null) {
                this.right.reversePass(list);
            }
            list.add(this.data);
        }

        /**
         * Рекурсивный метод расчета максимальной глубины дерева
         * @return максимальная глубина дерева
         */
        public int maxDepth() {
            int leftNodeHeight = 0;
            int rightNodeHeight = 0;

            // Если слева или справа не пусто, то считаем высоту соответствующего поддерева
            if (this.left != null) {
                leftNodeHeight = this.left.maxDepth();
            }
            if (this.right != null) {
                rightNodeHeight = this.right.maxDepth();
            }
            // Находим максимальное и прибавляем 1 для подсчета текущего узла
            return Math.max(leftNodeHeight, rightNodeHeight) + 1;
        }

        /**
         * Рекурсивная функция для вывода дерева в консоль
         * @param rPref
         * @param cPref
         * @param lPref
         */
        public void print(String rPref, String cPref, String lPref) {
            if (this.right != null) {
                this.right.print(rPref + "  ", rPref + "┌─", rPref + "│ ");
            }
            System.out.println(cPref + this.data);
            if (this.left != null) {
                this.left.print(lPref + "│ ", lPref + "└─", lPref + "  ");
            }
        }
    }

    // Храним корень дерева в поле
    private Node root;

    /**
     * Базовый конструктор
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Метод для вставки значения в дерево
     * @param data передаваемое значение
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        }
        else{
            root.insert(data);
        }
    }

    /**
     * Метод центрированного прохода по дереву
     * @return список со значениями, в порядке, соответствующем центрированному проходу
     */
    public List<Integer> centerPass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.centerPass(list);
        return list;
    }

    /**
     * Метод прямого прохода по дереву
     * @return список со значениями, в порядке, соответствующем прямому проходу
     */
    public List<Integer> straightPass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.straightPass(list);
        return list;
    }

    /**
     * Метод обратного прохода по дереву
     * @return список со значениями, в порядке, соответствующем обратному проходу
     */
    public List<Integer> reversePass() {
        if (root == null) {
            throw new NullPointerException("Root is null");
        }
        List<Integer> list = new ArrayList<Integer>();
        root.reversePass(list);
        return list;
    }

    /**
     * Метод расчета количества элементов в дереве
     * @return количество элементов
     */
    public int length() {
        if (root == null) { throw new NullPointerException("Root is null"); }
        return this.centerPass().size(); // size() ))
    }

    /**
     * Метод расчета максимальной глубины дерева
     * @return максимальная глубина дерева, считается от 1...
     */
    public int maxDepth() {
        if (root == null) { throw new NullPointerException("Root is null"); }

        return root.maxDepth();
    }

    /**
     * Метод для вывода структуры дерева в консоль
     */
    public void print() {
        if (root == null) { throw new NullPointerException("Root is null"); }
        root.print("","",""); // Красиво же!
    }
}
