package snippets.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@ManagedBean (name="teacher")
@RequestScoped
public class Teacher extends Person {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name="designation")
    private String designation;

    public boolean isValidTeacher() {
        return getName() != null;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
