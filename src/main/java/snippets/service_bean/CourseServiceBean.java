package snippets.service_bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import snippets.bean.Course;

@ManagedBean(name="courseServiceBean")
@RequestScoped
public class CourseServiceBean {
    @ManagedProperty(value="#{course}")
    private Course course;

    private String errMsg = null;

    public String addCourse() {
        return "listCourse";
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

}
