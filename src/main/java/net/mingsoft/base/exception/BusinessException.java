package net.mingsoft.base.exception;

public class BusinessException  extends RuntimeException {

    public BusinessException(Object Obj) {
        super(Obj.toString());
    }

}
