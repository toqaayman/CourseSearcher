import java.util.*;

/**

 A CourseSearcher is a type of Searchable that checks if an AvailableCourse contains any of the given search terms.

 The CourseSearcher uses the toString() method of the Course object to perform the search.
 */
public class CourseSearcher implements Searchable<AvailableCourse<String, Course>> {
    private Collection<String> searchTerms;

    /**

     Constructs a CourseSearcher object with the given collection of search terms.
     @param searchTerms the collection of search terms to match against.
     */
    public CourseSearcher(Collection<String> searchTerms) {
        this.searchTerms = searchTerms;
    }
    /**

     Checks if the given AvailableCourse contains any of the search terms.
     @param course the AvailableCourse to check against the search terms.
     @return true if the course contains any of the search terms, false otherwise.
     */
    @Override
    public boolean matches(AvailableCourse<String, Course> course) {
        for (String term : searchTerms) {
            if (course.getValue().toString().indexOf(term) != -1) {
                return true;
            }
        }
        return false;
    }
}