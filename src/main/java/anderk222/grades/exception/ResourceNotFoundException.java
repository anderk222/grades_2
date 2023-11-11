package anderk222.grades.exception;


public class ResourceNotFoundException extends RuntimeException {
    

    public ResourceNotFoundException(Object value, String property, String resource){

        super(String.format("%s with %s %s", value, property,resource));


    }

}
