package snippets.service_bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import snippets.bean.Course;
import snippets.service.CourseService;

@ManagedBean(name="courseServiceBean")
@RequestScoped
public class CourseServiceBean {
    @ManagedProperty(value="#{course}")
    private Course course;

    private CourseService courseService;
    
    @ManagedProperty(value="#{emFactoryBean}")
    private EntityManagerFactoryBean entityManagerFactoryBean;

    private String errMsg = null;

    @PostConstruct
    public void init() {
        courseService = new CourseService(entityManagerFactoryBean);
    }

    public String addCourse() {
        courseService.addCourse(course);
        return "listCourse";
    }
    
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setEntityManagerFactoryBean(EntityManagerFactoryBean entityManagerFactoryBean) {
        this.entityManagerFactoryBean = entityManagerFactoryBean;
    }

}
