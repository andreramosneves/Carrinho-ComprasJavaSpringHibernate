package org.com.br.repositories;

import java.util.List;

import org.com.br.dao.IDao;
import org.com.br.vo.Product;
import org.com.br.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*Esse também funciona, faz a mesma coisa de baixo*/
    //@Query("SELECT c FROM products c WHERE c.dt_termino is null")
    //@Override
    //public List<Product> findAll();

    /*Foi alterado o atributo em java, pois na documentação falava que trabalhava com as convenções do Java*/
    public List<Product> findByDtterminoNull();
}

/*
@Repository
public class ProductRepository implements IDao<Product> {

	@Override
	public void save(Product produto) {
            try (Session session = HibernateUtil.createSessionFactory().openSession()) {
                session.beginTransaction();
                session.saveOrUpdate(produto);
                session.getTransaction().commit();
            }
		
		
	}

	@Override
	public void delete(Product objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> list() {
            @SuppressWarnings("unchecked")
                    List<Product> l;
            try ( // TODO Auto-generated method stub
                    Session session = HibernateUtil.createSessionFactory().openSession()) {
                Criteria cr = session.createCriteria(Product.class);
                cr.add(Restrictions.isNull("dt_termino"));
                l = cr.list();
            }
		
		return l;
	}

	@Override
	public Product find(int Id) {
            @SuppressWarnings("unchecked")
                    List<Product> l;
            try (Session session = HibernateUtil.createSessionFactory().openSession()) {
                Criteria cr = session.createCriteria(Product.class);
                cr.add(Restrictions.eq("id", Id));
                l = cr.list();
            }
	    return (Product) (l.isEmpty() ? null : l.get(0));

	}
	

}
*/