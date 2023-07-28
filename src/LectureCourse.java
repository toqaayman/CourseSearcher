import java.util.*;

/**
 * Represents a lecture course with an instructor, credit value, meeting days, and GTAs.
 */
public abstract class LectureCourse extends Course {

    private String instructor;
    private int credit;
    private Set<MeetDay> meetDays;
    private Collection<String> gtas;

    /**
     * Constructs a new lecture course with the given CRN, title, levels, instructor, credit value,
     * meeting days, and GTAs.
     *
     * @param crn        the CRN of the course
     * @param title      the title of the course
     * @param levels     the set of levels for the course
     * @param instructor the name of the instructor for the course
     * @param credit     the credit value for the course
     * @param meetDays   the set of meeting days for the course
     * @param gtas       the collection of GTAs for the course
     * @throws LectureCourseException if any parameter is invalid
     */
    public LectureCourse(String crn, String title, Set<String> levels, String instructor, int credit,
                         Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        super(crn, title, levels);
        if (instructor == null || instructor.isBlank()) {
            throw new LectureCourseException("instructor");
        }
        if (credit <= 0) {
            throw new LectureCourseException("credit");
        }
        if (meetDays == null || meetDays.isEmpty() || meetDays.size() > 2) {
            throw new LectureCourseException("meetDays");
        }
        if (gtas == null) {
            throw new LectureCourseException("gtas");
        }
        for (MeetDay meetDay : meetDays) {
            if (meetDay == null) {
                throw new LectureCourseException("meetDays");
            }
        }
        this.instructor = instructor;
        this.credit = credit;
        this.meetDays = new LinkedHashSet<>(meetDays);
        this.gtas = new ArrayList<>(gtas);
    }

    /**
     * Returns the name of the instructor for the course.
     *
     * @return the name of the instructor
     */
    public final String getInstructor() {
        return instructor;
    }

    /**
     * Returns the credit value for the course.
     *
     * @return the credit value
     */
    public final int getCredit() {
        return credit;
    }

    /**
     * Returns the set of meeting days for the course.
     *
     * @return the set of meeting days
     */
    public final Set<MeetDay> getMeetDays() {
        return meetDays;
    }

    /**
     * Returns the collection of GTAs for the course.
     *
     * @return the collection of GTAs
     */
    public final Collection<String> getGtas() {
        return gtas;
    }

    /**
     * Returns a string representation of the lecture course, including its instructor, credit value,
     * meeting days, and GTAs.
     *
     * @return a string representation of the lecture course
     */
    @Override
    public String toString() {
        return "instructor: " + instructor + ", credit: " + credit +
                ", meetDays: " + Arrays.deepToString(meetDays.toArray()) +
                ", gtas: " + Arrays.deepToString(gtas.toArray()) + ", " + super.toString();
    }

    @Override
    public abstract String getType();

    @Override
    public int compareTo(Course otherCourse) {
        // This method compares two lecture courses based on their credit values
        if (otherCourse instanceof LectureCourse) {
            LectureCourse otherLecture = (LectureCourse) otherCourse;
            return Integer.compare(this.credit, otherLecture.credit);
        }
        return super.compareTo(otherCourse);
    }
}