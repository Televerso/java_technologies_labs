package lab2.AniVoice;

/**
 * Класс кошки
 */
public class Cat implements AniVoice{

    /**
     * конструктор
     */
    public Cat(){}

    /**
     * Мяу
     * @return мяяяу (String)
     */
    public String voice() {
        String what_does_it_say = "Мяяяу";
        System.out.println(what_does_it_say);
        return what_does_it_say;
    }
}
