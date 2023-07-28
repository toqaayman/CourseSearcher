import java.util.Collection;
import java.util.Set;

/**
 * Represents a hybrid course that combines both in-person and online instruction.
 */
public class HybridCourse extends LectureCourse {

    /**
     * Constructs a new hybrid course with the specified parameters.
     *
     * @param crn        the course reference number
     * @param title      the title of the course
     * @param levels     the academic levels that the course is offered at
     * @param instructor the name of the instructor
     * @param credit     the number of credits the course is worth
     * @param meetDays   the days of the week the course meets
     * @param gtas       the graduate teaching assistants for the course
     *
     * @throws LectureCourseException if any of the parameters are invalid
     */
    public HybridCourse(String crn, String title, Set<String> levels, String instructor,
                        int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }

    /**
     * Returns the type of the course as a string.
     *
     * @return the type of the course
     */
    @Override
    public String getType() {
        return "Hybrid";
    }
}
