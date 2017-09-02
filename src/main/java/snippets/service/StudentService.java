package snippets.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import snippets.bean.Student;
import snippets.service_bean.EntityManagerFactoryBean;

public class StudentService {
    private EntityManagerFactory entityManagerFactory;

    public StudentService (EntityManagerFactoryBean entityManagerFactoryBean) {
        entityManagerFactory = entityManagerFactoryBean.getEntityManagerFactory();
    }

    public void addStudent (Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(student);
        entityTransaction.commit();
    }

    public List<Student> getStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        TypedQuery<Student> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Student> studentsList = typedQuery.getResultList();
        entityManager.close();
        return studentsList;
    }
}
