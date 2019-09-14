package com.solution.singtel.facade;

/**
 * @author ankitkumarjain
 * @version $Id: SingtelClientCallback.java, v 0.1 2019-09-13 7:50 AM ankitkumarjain Exp $$
 */
public interface SingtelClientCallback<T> {

    public T execute();

    public boolean isSuccessResult(T result);
}