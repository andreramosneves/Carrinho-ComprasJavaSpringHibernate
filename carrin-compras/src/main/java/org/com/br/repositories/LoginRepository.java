package org.com.br.repositories;

import org.com.br.vo.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.com.br.dao.IDao;
import java.util.List;
import javax.persistence.EntityTransaction;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByEmail(String email);
}

/*
@Repository
public class LoginRepository implements IDao<Login> {

    @Override
    public void save(Login login) {
        try ( // TODO Auto-generated method stub
                Session session = HibernateUtil.createSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(login);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Login objeto) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Login> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Login find(int Id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Login findByEmail(String email) {
        Login l1;
        try (Session session = HibernateUtil.createSessionFactory().openSession()) {
            Criteria cr = session.createCriteria(Login.class);
            cr.add(Restrictions.eq("email", email));
            @SuppressWarnings("rawtypes")
            List l = cr.list();
            //session.evict(l.get(0));
            l1 = (Login) (l.isEmpty() ? null : l.get(0));
        }

        return l1;
    }

    public static void main(String[] args) {
        Login login = new Login();
        //login.setEmail("andreramosneves@yahoo.com.br");
        //login.setPassword(BCrypt.hashpw("123", BCrypt.gensalt(10)));
        System.out.println(new LoginRepository().findByEmail("andreramosneves@yahoo.com.br"));
        //System.out.println(new LoginRepository().find("andreramosneves@yahoo.com.br", "123"));
        //System.out.println("passou aqui");
        System.exit(0);
    }

}
*/