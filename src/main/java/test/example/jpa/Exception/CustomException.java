package test.example.jpa.Exception;

import lombok.Getter;

@Getter

public class CustomException extends RuntimeException {

    CustomExceptionType type;
    Object desc;

    public CustomException(CustomExceptionType type, Object desc) {
        super("[" + type.getInnerCode() + "] " + type.getMessage() + desc);
        this.type = type;
        this.desc = desc;
    }

}
