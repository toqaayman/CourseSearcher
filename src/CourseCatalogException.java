/**
 * The `CourseCatalogException` class is a subclass of `IllegalStateException` and is used to represent an exception
 * that occurs when trying to add a course to a course catalog that already contains a course with the same CRN.
 */
public class CourseCatalogException extends IllegalStateException {

    /**
     * The CRN of the course that caused the exception.
     */
    private String crn;

    /**
     * The course object that caused the exception.
     */
    private Course course;

    /**
     * Creates a new instance of `CourseCatalogException` with the given CRN.
     * @param crn the CRN of the course that caused the exception.
     */
    public CourseCatalogException(String crn) {
        super("The course’s CRN is already in the catalog.");
        this.crn = crn;
    }

    /**
     * Returns the CRN of the course that caused the exception.
     * @return the CRN of the course that caused the exception.
     */
    public String getCrn() {
        return crn;
    }

    /**
     * Returns the course object that caused the exception.
     * @return the course object that caused the exception.
     */
    public Course getCourse() {
        return course;
    }
}
