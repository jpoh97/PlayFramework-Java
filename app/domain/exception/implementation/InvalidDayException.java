package domain.exception.implementation;

import domain.exception.BaseException;

public class InvalidDayException extends BaseException {

    public InvalidDayException() {
        super("The buildings that start with 'M' not attend tenants on Sunday");
    }
}
