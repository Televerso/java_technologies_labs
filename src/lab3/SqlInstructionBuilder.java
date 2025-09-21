package lab3;

/**
 * Класс для построения SQL-запросов
 */
public class SqlInstructionBuilder {
    /**
     * Строит SQL-запрос для переноса данных из одной таблицы в другую студентов заданной группы с количеством долгов
     * не превышающих значение параметра. (сравнение идет строго больше)
     * @param id_Group номер группы
     * @param dolgCount количество долгов.
     * @return строка с SQL запросом
     */
    public static String sql_request(String id_Group, int dolgCount){
        String request = "INSERT INTO T_GroupSelected (id_Student, firstName, lastName, id_Group) \n" +
                "SELECT id_Student, firstName, lastName, id_Group \n" +
                "FROM T_Student \n" +
                "WHERE id_Group = '" + id_Group + "' \n" +
                "AND dolgCount > " + dolgCount + "\n";

        return request;
    }
}
