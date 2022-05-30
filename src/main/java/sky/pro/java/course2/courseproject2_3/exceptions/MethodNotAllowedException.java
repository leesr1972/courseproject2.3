package sky.pro.java.course2.courseproject2_3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException{
    public MethodNotAllowedException(String message) {
        super(message);
    }
}
