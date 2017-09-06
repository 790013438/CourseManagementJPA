package snippets.bean;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link Course}
 */
public class CourseTest {
    @Test
    public void testValidate() {
        Course course = new Course();
        Assert.assertFalse(course.isValidCourse());
        course.setName("course1");
        Assert.assertFalse(course.isValidCourse());
        course.setCredits(-5);
        Assert.assertFalse(course.isValidCourse());
        course.setCredits(5);
        Assert.assertTrue(course.isValidCourse());
    }
}
