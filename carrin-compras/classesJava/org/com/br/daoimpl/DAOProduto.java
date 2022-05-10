package org.com.br.daoimpl;

import java.util.List;

import org.com.br.dao.IDao;
import org.com.br.objetosNegocio.Product;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DAOProduto implements IDao<Product> {

	@Override
	public void save(Product produto) {
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    session.beginTransaction();
	    session.saveOrUpdate(produto);
	    session.getTransaction().commit();
	    session.close();
		
		
	}

	@Override
	public void delete(Product objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    Criteria cr = session.createCriteria(Product.class);
	    cr.add(Restrictions.isNull("dt_termino"));
	    @SuppressWarnings("unchecked")
		List<Product> l = cr.list();
	    session.close();
		
		return l;
	}

	@Override
	public Product find(int Id) {
	    Session session = HibernateUtil.createSessionFactory().openSession();
	    Criteria cr = session.createCriteria(Product.class);
	    cr.add(Restrictions.eq("id", Id));
	    @SuppressWarnings("unchecked")
	    List<Product> l = cr.list();
	    session.close();
	    return (Product) (l.size() == 0 ? null : l.get(0));

	}
	

}
