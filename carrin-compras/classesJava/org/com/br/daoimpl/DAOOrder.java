package org.com.br.daoimpl;

import java.util.List;

import org.com.br.dao.IDao;
import org.com.br.objetosNegocio.Kart;
import org.com.br.objetosNegocio.Order;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class DAOOrder implements IDao<Order> {

	@Override
	public void save(Order objeto) {
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(objeto);
	    session.getTransaction().commit();
	    session.close();		
	}

	@Override
	public void delete(Order objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> list() {
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    Criteria cr = session.createCriteria(Order.class);
		@SuppressWarnings("unchecked")
		List<Order> l = cr.list();
	    session.close();
	    return l;
	}

	
	/*Como estava como problema por utilizar a palavra chave order, fiz uma gambiarra para corrigir sem ter que alterar para que tivesse a mesma funcionalidade tanto feito em PHP como em Java*/
	public List<Order> listaPedidosPorUsuario(int idUser) {
		Session session = HibernateUtil.createSessionFactory().openSession();
		Query q = session.createQuery("SELECT e FROM kart p inner join p.order e WHERE p.user.id = :idUser AND p.order.id is not null GROUP BY e.id" );
		q.setParameter("idUser", idUser);
	    @SuppressWarnings("unchecked")
		List<Order> l = q.list();
	    session.close();
	    return l;
	}	
		
	
	@Override
	public Order find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
