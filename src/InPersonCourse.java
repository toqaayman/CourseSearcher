import java.util.Collection;
import java.util.Set;

public class InPersonCourse extends LectureCourse {

    /**
     * Constructs a new InPersonCourse object with the given parameters.
     *
     * @param crn        the course registration number
     * @param title      the course title
     * @param levels     the course levels
     * @param instructor the name of the course instructor
     * @param credit     the number of credits for the course
     * @param meetDays   the set of meeting days for the course
     * @param gtas       the collection of GTAs for the course
     *
     * @throws LectureCourseException if any of the parameters are null or invalid
     */
    public InPersonCourse(String crn, String title, Set<String> levels, String instructor,
                          int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }

    /**
     * Returns the type of the course.
     *
     * @return the type of the course ("In-Person")
     */
    @Override
    public String getType() {
        return "In-Person";
    }
}
