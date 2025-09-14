package lab2.AniVoice;

/**
 * Класс коровы
 */
public class Cow implements AniVoice {
    /**
     * Конструктор
     */
    public Cow(){}

    /**
     * Му
     * @return "Мууу"
     */
    public String voice() {
        String what_does_it_say = "Мууу";
        System.out.println(what_does_it_say);
        return what_does_it_say;
    }
}
