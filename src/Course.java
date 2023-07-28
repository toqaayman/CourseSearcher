import java.util.*;

/**
 * This abstract class represents a course with a CRN, a title, and a set of levels, and implements the Comparable interface.
 */
public abstract class Course implements Comparable<Course> {

    /**
     * The CRN of the course.
     */
    private String crn;

    /**
     * The title of the course.
     */
    private String title;

    /**
     * The set of levels of the course.
     */
    private Set<String> levels;

    /**
     * Constructs a course with the specified CRN, title, and levels.
     *
     * @param crn the CRN of the course
     * @param title the title of the course
     * @param levels the set of levels of the course
     * @throws LectureCourseException if any of the constructor arguments is null or empty, or if the title length is not between 15 and 40 characters
     */
    public Course(String crn, String title, Set<String> levels) throws LectureCourseException {
        if (crn == null || title == null || levels == null || levels.isEmpty() || levels.contains(null)) {
            throw new LectureCourseException("Constructor arguments cannot be null or empty");
        }
        this.crn = crn;
        this.title = title;
        this.levels = new HashSet<>(levels); // or new LinkedHashSet<>(levels)
        if (this.title.length() < 15 || this.title.length() > 40) {
            throw new IllegalArgumentException("Title length must be between 15 and 40 characters");
        }
    }

    /**
     * Returns the CRN of the course.
     *
     * @return the CRN of the course
     */
    public final String getCrn() {
        return crn;
    }

    /**
     * Returns the title of the course.
     *
     * @return the title of the course
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Returns an unmodifiable set of the levels of the course.
     *
     * @return an unmodifiable set of the levels of the course
     */
    public final Set<String> getLevels() {
        return Collections.unmodifiableSet(levels);
    }

    /**
     * Returns the type of the course as a string.
     *
     * @return the type of the course as a string
     */
    public abstract String getType();

    /**
     * Returns true if this course is equal to the specified object.
     *
     * @param obj the object to compare to
     * @return true if this course is equal to the specified object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course other = (Course) obj;
            return crn.equals(other.crn);
        }
        return false;
    }

    /**
     * Compares this course to the specified course by their titles.
     *
     * @param other the other course to compare to
     * @return a negative integer, zero, or a positive integer as this course is less than, equal to, or greater than the specified course
     */
    @Override
    public int compareTo(Course other) {
        return this.getTitle().compareTo(other.getTitle());
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string representation of the course
     */
    @Override
    public String toString() {
        return String.format("type: %s, CRN: %s, title: %s, levels: %s",
                getType(), crn, title, Arrays.deepToString(levels.toArray()));
    }
}