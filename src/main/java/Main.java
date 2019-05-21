import Utils.HibernateUtil;
import entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    //private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("Create video");
        Video video = new Video();
        video.setDescription("Калигула");
        video.setId(1L);

        System.out.println("Create actor");
        Actor actor = new Actor();
        actor.setName("Девчонка из массовки звать Маня");
        actor.setBirthday("05 august 1994");
        actor.setId(12L);

        System.out.println("Create cast");
        Cast cast = new Cast();
        cast.setVideo(video);
        cast.setActor(actor);
        cast.setId(10L);

        System.out.println("Create Session");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Добавление записи в таблицу БД");
        Transaction tr = session.beginTransaction();
        session.save(video);
        session.save(actor);
        session.save(cast);
        tr.commit();
        session.close();
    }
}
