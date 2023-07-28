import java.util.*;

/**
 * This class represents an available course with a key of type K and a value of type V that implements the Comparable interface.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value, which must extend Comparable
 */
public class AvailableCourse<K, V extends Comparable<V>> implements Comparable<AvailableCourse<K,V>> {

    /**
     * The key of the available course.
     */
    private K key;

    /**
     * The value of the available course.
     */
    private V value;

    /**
     * Constructs an available course with the specified key and value.
     *
     * @param key the key of the available course
     * @param value the value of the available course
     */
    public AvailableCourse(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key of the available course.
     *
     * @return the key of the available course
     */
    public K getKey() {
        return key;
    }

    /**
     * Returns the value of the available course.
     *
     * @return the value of the available course
     */
    public V getValue() {
        return value;
    }

    /**
     * Returns true if this available course is equal to the specified object.
     *
     * @param obj the object to compare to
     * @return true if this available course is equal to the specified object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AvailableCourse) {
            AvailableCourse<?, ?> other = (AvailableCourse<?, ?>) obj;
            return Objects.equals(value, other.value);
        }
        return false;
    }

    /**
     * Compares this available course to the specified available course by their values.
     *
     * @param other the other available course to compare to
     * @return a negative integer, zero, or a positive integer as this available course is less than, equal to, or greater than the specified available course
     */
    @Override
    public int compareTo(AvailableCourse<K, V> other) {
        return value.compareTo(other.value);
    }
}
