package snippets.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean (name="student")
@RequestScoped
public class Student extends Person {

    private static final long serialVersionUID = 1L;

    private Date enrolledsince;

    public Date getEnrolledsince() {
        return enrolledsince;
    }

    public void setEnrolledsince(Date enrolledsince) {
        this.enrolledsince = enrolledsince;
    }

}
