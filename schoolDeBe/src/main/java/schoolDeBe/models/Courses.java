package schoolDeBe.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Courses")
public class Courses {
    //В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.

    private static final String[] titles = new  String[] {"ТФКП", "Векторно тензорный анализ", "ММФ", "Дифф.Ур",
            "Квант.Мех", "НАНО.Лазеры"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;
    public int duration;

    public Courses() {
    }

    public Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Courses create(){
        return new Courses(titles[random.nextInt(titles.length)], random.nextInt(7,20));
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration(){
        duration = random.nextInt(7,20);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
