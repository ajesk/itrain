package io.acode.spark_starter.control;

import lombok.Data;

import javax.naming.ldap.Control;

/**
 * A response container for a controller. Just a normalized object which can pass a result/success/message back to
 * the API implementation.
 */
@Data
public class ControlResponse <T> {
    String message = "";
    boolean success = true;
    T result = null;

    public ControlResponse() {}
    public ControlResponse(boolean success) {
        setSuccess(success);
    }
    public ControlResponse(boolean success, String message) {
        setSuccess(success);
        setMessage(message);
    }
    public ControlResponse(boolean success, String message, T result) {
        setSuccess(success);
        setMessage(message);
        setResult(result);
    }
    public ControlResponse(String message) {
        setMessage(message);
    }
    public ControlResponse(String message, T result) {
        setMessage(message);
        setResult(result);
    }
    public ControlResponse(T result) {
        setResult(result);
    }
}
