package snippets.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import snippets.bean.Teacher;
import snippets.service_bean.EntityManagerFactoryBean;

public class TeacherService {
    private EntityManagerFactory entityManagerFactory;

    public TeacherService (EntityManagerFactoryBean entityManagerFactoryBean) {
        entityManagerFactory = entityManagerFactoryBean.getEntityManagerFactory();
    }

    public void addTeacher (Teacher teacher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(teacher);
        entityTransaction.commit();
    }

    public List<Teacher> getTeacher() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
        TypedQuery<Teacher> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Teacher> teachers = typedQuery.getResultList();
        entityManager.close();
        return teachers;
    }

    public Teacher getTeacher (int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Teacher.class, id);
    }
}
