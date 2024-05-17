package exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter

@Setter
public class ResourceNotFoundException  extends IllegalArgumentException{

    private String resourceName;

    private String fieldName;

    private  Long value;

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){

    }

}
