package schoolDeBe.Program2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import schoolDeBe.models.Courses;

import javax.security.auth.login.AppConfigurationEntry;

public class Program {
    public static void main(String[] args){

        System.out.println("Hello Hibernate!");
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory()){

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Courses course = Courses.create();

            session.save(course);

            Courses retrivedCourse = session.get(Courses.class, course.getId());
            System.out.println(retrivedCourse.toString());

            retrivedCourse.updateTitle();
            retrivedCourse.updateTitle();
            session.update(retrivedCourse);

            session.delete(retrivedCourse);

            session.getTransaction().commit();


        }
        catch (Exception e){
            e.printStackTrace();
        };


    }
}
