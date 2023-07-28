/**
 * An interface for objects that can be searched for a specific criteria.
 * @param <A> the type of object that can be searched
 */
interface Searchable<A> {

    /**
     * Checks if the given course matches the specified criteria.
     * @param course the course to check against the criteria
     * @return true if the course matches the criteria, false otherwise
     */
    boolean matches(A course);
}
