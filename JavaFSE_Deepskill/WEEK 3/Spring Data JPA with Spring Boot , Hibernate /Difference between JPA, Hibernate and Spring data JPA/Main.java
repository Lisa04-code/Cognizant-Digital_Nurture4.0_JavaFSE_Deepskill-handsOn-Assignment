package jar;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(50000);
        
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}

