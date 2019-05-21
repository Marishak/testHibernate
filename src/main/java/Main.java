import Utils.HibernateUtil;
import entity.*;
import org.hibernate.Session;
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
        Cast1 cast1 = new Cast1();
        cast1.setId(10L);
        cast1.setVideo(video);
        cast1.setActor(actor);

        System.out.println("Create Session");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Добавление записи в таблицу БД");
        Transaction tr = session.beginTransaction();
        System.out.println("Транзакцию воткнули");
        session.saveOrUpdate(video);
        session.saveOrUpdate(actor);
        System.out.println("ПЕРЕД CAST сэйв/апдейт");
        session.saveOrUpdate(cast1);
        System.out.println("Момент перед коммитом");
        tr.commit();
        System.out.println("После коммита");
        session.close();
        System.out.println("THE END");
    }
}
