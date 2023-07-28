import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 CourseCatalog class represents a collection of available courses, where each course is

 represented by a unique CRN and a Course object. The class provides methods for adding new

 courses, searching for courses based on a specified search criteria, and sorting the catalog

 based on the course title. The catalog is stored as a List of AvailableCourse objects, where

 each AvailableCourse object holds a CRN and a Course object.
 */
public class CourseCatalog {
    private List<AvailableCourse<String, Course>> catalog;

    /**

     Constructs a new CourseCatalog object with an empty catalog list.
     */
    public CourseCatalog() {
        this.catalog = new ArrayList<>();
    }
    /**

     Adds a new course to the catalog with the specified CRN and Course object.
     @param crn the CRN of the course to be added
     @param course the Course object to be added
     @throws CourseCatalogException if the course is null, or if a course with the same CRN already exists in the catalog, or if the CRN is null or empty
     */
    public void add(String crn, Course course) throws CourseCatalogException {
        if (course == null) {
            throw new CourseCatalogException("Cannot add a null course to the catalog.");
        }
        if (crn == null || crn.isEmpty()) {
            throw new CourseCatalogException("CRN cannot be null or empty.");
        }
        for (AvailableCourse<String, Course> availableCourse : catalog) {
            if (availableCourse.getKey().equals(crn)) {
                throw new CourseCatalogException("A course with the same CRN already exists in the catalog.");
            }
        }
        catalog.add(new AvailableCourse<>(crn, course));
    }

    /**

     Searches for courses in the catalog based on a specified search criteria.
     @param searchable the Searchable object containing the search criteria
     @return a list of AvailableCourse objects that match the search criteria
     */
    public List<AvailableCourse<String, Course>> search(Searchable searchable) {
        List<AvailableCourse<String, Course>> results = new ArrayList<>();
        for (AvailableCourse<String, Course> course : catalog) {
            if (searchable.matches(course)) {
                results.add(course);
            }
        }
        return results;
    }
    /**

     Sorts the catalog based on the title of each course.
     */
    public void sort() {
        Collections.sort(catalog);
    }
    /**

     Returns the list of AvailableCourse objects in the catalog.
     @return the list of AvailableCourse objects in the catalog
     */
    public List<AvailableCourse<String, Course>> getCatalog() {
        return catalog;
    }
    /**

     Sets the catalog list to the specified list of AvailableCourse objects.
     @param catalog the new list of AvailableCourse objects
     */
    public void setCatalog(List<AvailableCourse<String, Course>> catalog) {
        this.catalog = catalog;
    }
}