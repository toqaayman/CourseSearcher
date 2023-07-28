/**

 This exception is thrown when a lecture course is being constructed with an illegal or null value.
 */
public class LectureCourseException extends Exception {
    private String fieldName;

    /**

     Constructs a new LectureCourseException with the specified field name.
     @param fieldName the name of the field that has an illegal or null value
     */
    public LectureCourseException(String fieldName) {
        super("An argument has a null or illegal value");
        this.fieldName = fieldName;
    }
    /**

     Returns the name of the field that has an illegal or null value.
     @return the name of the field
     */
    public String getFieldName() {
        return fieldName;
    }
}