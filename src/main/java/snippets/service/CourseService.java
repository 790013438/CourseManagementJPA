package snippets.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import snippets.bean.Course;
import snippets.service_bean.EntityManagerFactoryBean;

public class CourseService {
    private EntityManagerFactory entityManagerFactory;
    
    public CourseService(EntityManagerFactoryBean entityManagerFactoryBean) {
        this.entityManagerFactory = entityManagerFactoryBean.getEntityManagerFactory();
    }

    public List<Course> getCourses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        TypedQuery<Course> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Course> coursesList = typedQuery.getResultList();
        entityManager.close();
        return coursesList;
    }

    public void addCourse (Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(course);
        entityTransaction.commit();
    }

    public void updateCourse (Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager
                .getTransaction();
        entityTransaction.begin();
        entityManager.merge(course);
        entityTransaction.commit();
    }

    public Course getCourse (int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Course.class, id);
    }

    public void deleteCourse (Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Course mergedCourse = entityManager.find(Course.class, course.getId());
        entityManager.remove(mergedCourse);
        entityTransaction.commit();
    }
}
