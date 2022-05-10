package org.com.br.daoimpl;

import java.util.List;

import org.com.br.dao.IDao;
import org.com.br.objetosNegocio.Kart;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DAOKart implements IDao<Kart> {

	
	@Override
	public void save(Kart objeto) {
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    session.beginTransaction();
	    session.saveOrUpdate(objeto);
	    session.getTransaction().commit();
	    session.close();
		
	}

	@Override
	public void delete(Kart objeto) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Kart> list() {
		// TODO Auto-generated method stub
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    Criteria cr = session.createCriteria(Kart.class);
	    cr.add(Restrictions.isNull("dt_termino"));
	    @SuppressWarnings("unchecked")
		List<Kart> l = cr.list();
	    session.close();
	    return l;  
	}

	
	public List<Kart> listUser(int idUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.createSessionFactory().openSession();
		Query q = session.createQuery("SELECT p FROM kart p WHERE p.user.id = :idUser AND p.order.id is null" );
		q.setParameter("idUser", idUser);
	    @SuppressWarnings("unchecked")
		List<Kart> l = q.list();
	    session.close();
	    return l;
	}	
	
	
	@Override
	public Kart find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
