package org.com.br.daoimpl;

import java.util.List;

import org.com.br.dao.IDao;
import org.com.br.objetosNegocio.Login;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

@Repository
public class DAOLogin implements IDao<Login> {

	public void save(Login login) {
		// TODO Auto-generated method stub
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(login);
	    session.getTransaction().commit();
	    session.close();
		
	}

	public void delete(Login objeto) {
		// TODO Auto-generated method stub
		
	}

	public List<Login> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Login find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Login find(String email, String password){
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    Criteria cr = session.createCriteria(Login.class);
	    cr.add(Restrictions.eq("email", email));
	    @SuppressWarnings("rawtypes")
		List l = cr.list();
	    session.close();
	    return (Login) (l.size() == 0 ? null : l.get(0));
	}
	
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setEmail("andre@gmail.com");
		login.setPassword(BCrypt.hashpw("123456", BCrypt.gensalt(10)));
		login.geraValoresDefault();
		new DAOLogin().save(login);
		System.out.println("passou aqui");
		System.exit(1);
	}
}


