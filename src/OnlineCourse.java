import java.util.Collection;
import java.util.Set;

/**
 * Represents an online lecture course. Extends the LectureCourse class and inherits its properties and methods.
 */
public class OnlineCourse extends LectureCourse {

    /**
     * Constructs a new OnlineCourse object with the given course details.
     *
     * @param crn the CRN number of the course
     * @param title the title of the course
     * @param levels the set of academic levels of the course
     * @param instructor the name of the instructor for the course
     * @param credit the credit hours for the course
     * @param meetDays the set of days on which the course meets
     * @param gtas the collection of names of GTAs for the course
     * @throws LectureCourseException if any of the course details are invalid
     */
    public OnlineCourse(String crn, String title, Set<String> levels, String instructor,
                        int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }

    /**
     * Returns the type of the course, which is "Online".
     *
     * @return the type of the course
     */
    @Override
    public String getType() {
        return "Online";
    }
}
