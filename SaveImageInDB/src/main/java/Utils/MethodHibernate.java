package Utils;

import HibernateConfig.HibernateConfig;
import jakarta.persistence.Query;
import org.example.Product;
import org.hibernate.Session;

import java.util.List;

public class MethodHibernate {
    private Session session;

    public MethodHibernate() {
        this.session =HibernateConfig.getFactory().openSession();
    }

    public void Insert(Product pd){
        try {
            session.getTransaction().begin();
            session.persist(pd);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            session.close();
        }
    }
    public void ShowAll(){
        try {
            session.getTransaction().begin();
            Query query=session.createQuery("from Product ");
            List<Product> list=query.getResultList();
            list.forEach(e-> System.out.println(e.getDescribe()));
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            session.close();
        }
    }
}
