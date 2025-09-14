package lab2.AniVoice;

/**
 * Класс собаки
 */
public class Dog implements AniVoice{
    /**
     * Конструктор
     */
    public Dog(){}

    /**
     * Гав
     * @return "Гав-гав"
     */
    public String voice(){
        String what_does_it_say = "Гав-гав";
        System.out.println(what_does_it_say);
        return what_does_it_say;
    }
}
