package postenApp.com.alab.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import postenApp.com.alab.entity.Pack;

@Repository
@Qualifier("mySql")
public class MySql implements PackageDao {

	private Configuration con;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;

	public Collection<Pack> getAllPrices() {
		List<Pack> list = new ArrayList<Pack>();
		con = new Configuration().configure().addAnnotatedClass(Pack.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();

		list = session.createCriteria(Pack.class).list();
		tx.commit();
		return list;
	}

	public Pack getPriceByWeight(int weight) {
		con = new Configuration().configure().addAnnotatedClass(Pack.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		Pack pack = (Pack) session.get(Pack.class, weight);
		
		tx.commit();
		return pack;
	}

	public void insertPackage(Pack pack) {
		con = new Configuration().configure().addAnnotatedClass(Pack.class);

		con.addAnnotatedClass(postenApp.com.alab.entity.Pack.class);
		con.configure();
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();

		session.save(pack);

		tx.commit();

	}

	public void removePack(int weight) {
		con = new Configuration().configure().addAnnotatedClass(Pack.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();

		Pack pack = new Pack();
		pack.setWeight(weight);

		session.delete(pack);

		tx.commit();

	}

	public void updatePack(Pack pack) {
		// TODO Auto-generated method stub

	}

}
