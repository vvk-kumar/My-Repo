package com.hans.JPAMavenExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class StudentApp {

	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = null;
        EntityManager em  = null;
        try {
        	emf = Persistence.createEntityManagerFactory("mavenJPA");
            System.out.println(emf);
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student student = new Student();
            student.setName("Harish Kumar");
            student.setFatherName("Lakshmi Narayana");
            List<String> nicknames = new ArrayList<String>();
            nicknames.add("Gurram");
            nicknames.add("Hari");
            student.setNickNames(nicknames);
            em.persist(student);
            em.getTransaction().commit();
            Student s = em.find(Student.class, 1L);
            System.out.println(s.getNickNames().get(0));
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	if(em != null) {
        		em.close();
        	}
        	if(emf != null) {
        		emf.close();
        	}
        }
		/*final MasterStatus ims = em.find(MasterStatus.class, 32L);
		System.out.println(ims.getDescription());
		final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<MasterStatus> criteriaQuery = criteriaBuilder.createQuery(MasterStatus.class);
		final Root<MasterStatus> statusRoot = criteriaQuery.from(MasterStatus.class);
		criteriaQuery.where(criteriaBuilder.equal(statusRoot.get("statusCode"), "REGISTRATION_INITIATED"),
				criteriaBuilder.and(criteriaBuilder.equal(statusRoot.get("type"), "REGI")));
		System.out.println(em.createQuery(criteriaQuery).getSingleResult().getId());*/
    }
}
