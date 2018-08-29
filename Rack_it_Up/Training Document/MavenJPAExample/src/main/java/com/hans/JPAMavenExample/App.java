package com.hans.JPAMavenExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = null;
        EntityManager em  = null;
        try {
        	emf = Persistence.createEntityManagerFactory("mavenJPA");
            System.out.println(emf);
            em = emf.createEntityManager();
            
            
            System.out.println("Start using inheritence example    -------------------------------------------------");
            Person person = new Person();
            person.setFirstName("Harish Kumar");
            person.setLastName("Gurram");
            em.getTransaction().begin();
            em.persist(person);
            Geek geek = new Geek();
            geek.setFirstName("Sai Kumar");
            geek.setLastName("Gurram");
            geek.setFavLanguage("Mechanical");
            em.persist(geek);
            System.out.println("End Of Using inheritence --------------------------------------------------------------\n");
            
            
            // Example using @Embedded and  @Embeddable
            System.out.println("Start using embedded and embeddable  and One to One example-----------------------------------------------\n");
            Employee employee = new Employee();
            PersnolInformation persnolInformation = new PersnolInformation();
            persnolInformation.setFirstName("Harish");
            persnolInformation.setLastName("Gurram");
            persnolInformation.setGender("M");
            persnolInformation.setMaritalStatus("Married");
            persnolInformation.setMobileNumber("0909009900");
            employee.setPersnolInformation(persnolInformation);
            Phone phone1 = new Phone();
            phone1.setMobileNumber("99889988998");
            Phone phone2 = new Phone();
            phone2.setMobileNumber("82373673873");
            List<Phone> phones = new ArrayList<Phone>();
            phones.add(phone1);
            phones.add(phone2);
            phone1.setEmployee(employee);
            phone2.setEmployee(employee);
            employee.setPhoneNumbers(phones);
            IDCard idc = new IDCard();
            idc.setCardNumber("1234");
            idc.setEmpNumber("GBS03795");
            employee.setIdCard(idc);
            idc.setEmployee(employee);
            em.persist(employee);
            em.getTransaction().commit();
            System.out.println("End using embedded and embeddable  and One to One example-----------------------------------------------\n");
            
            
            
            System.out.println("Start Criteria API Example -------------------------------------------\n");
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Geek> criteriaQuery = criteriaBuilder.createQuery(Geek.class);
            final Root<Geek> geek_ = criteriaQuery.from(Geek.class);
            criteriaQuery.where(criteriaBuilder.equal(geek_.get("id"), 2L));
            Geek geek2 = em.createQuery(criteriaQuery).getSingleResult();
            /*Geek p = em.find(Geek.class, 2L);*/
            System.out.println(geek2.getFavLanguage());
            System.out.println("End Criteria API Example -----------------------------------------\n");
            
            
            //TypedQuery example
            TypedQuery<Person> query = em.createQuery("from PERSON", Person.class);
            List<Person> persons = query.getResultList();
            TypedQuery<Employee> employeesQuery = em.createQuery("from Employee", Employee.class);
            List<Employee> employees = employeesQuery.getResultList();
            Employee e = employees.get(0);
            System.out.println(e.getIdCard().getCardNumber());
            System.out.println(e.getPhoneNumbers().get(0).getMobileNumber());
            IDCard id = em.find(IDCard.class, 1L);
            System.out.println(id.getEmployee().getPersnolInformation().getFirstName());
            System.out.println("\n\n");
            Phone phoneNumber1 = em.find(Phone.class, 1L);
            System.out.println(phoneNumber1.getEmployee().getPersnolInformation().getFirstName());
            Phone phoneNumber2 = em.find(Phone.class, 2L);
            System.out.println(phoneNumber2.getEmployee().getPersnolInformation().getFirstName());
            TypedQuery<Employee> phonesPerPerson = em.createQuery("Select p.employee from Phone as p where p.id = 1", Employee.class);
            System.out.println(phonesPerPerson.getSingleResult().getIdCard().getEmpNumber());
            
            //Using Join JPQL
            String joinQuery = "SELECT p from Phone p INNER JOIN p.employee pe Where pe. id = 1";
            TypedQuery<Phone> phoneQuery = em.createQuery(joinQuery, Phone.class);
            List<Phone> phoneList = phoneQuery.getResultList();
            System.out.println("\n\nUser has " + phoneList.size() + " Contact numbers.");
            
            //Join Query in native Java
            CriteriaQuery<Phone> phoneCriteriaQuery = criteriaBuilder.createQuery(Phone.class);
            Root<Phone> phoneRoot = phoneCriteriaQuery.from(Phone.class);
            phoneCriteriaQuery.select(phoneRoot);
            phoneCriteriaQuery.where(criteriaBuilder.equal(phoneRoot.get("employee").get("persnolInformation").get("firstName"), "Harish"));
            TypedQuery<Phone> phoneTypedQuery = em.createQuery(phoneCriteriaQuery);
            List<Phone> phonesLis = phoneTypedQuery.getResultList();
            System.out.println("\n\nNumber of phones employee have :: " + phonesLis.size());
            
            //Join using Join API
            CriteriaQuery<Employee> emploYeeQ = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> employeeR = emploYeeQ.from(Employee.class);
            Join<Employee, Phone> phoneJoin = employeeR.join("phoneNumbers", JoinType.INNER);
            emploYeeQ.select(employeeR).where(criteriaBuilder.equal(phoneJoin.get("mobileNumber"), "99889988998"));
            TypedQuery<Employee> empQ = em.createQuery(emploYeeQ);
            System.out.println("\n\n" + empQ.getSingleResult().getPersnolInformation().getFirstName());
            
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
