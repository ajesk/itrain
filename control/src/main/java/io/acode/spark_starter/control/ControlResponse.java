package io.acode.spark_starter.control;

import lombok.Data;

import javax.naming.ldap.Control;

/**
 * A response container for a controller. Just a normalized object which can pass a result/success/message back to
 * the API implementation.
 */
@Data
public class ControlResponse {
    String message = "";
    boolean success = true;
    Object result = null;

    public ControlResponse() {}
    public ControlResponse(boolean success) {
        setSuccess(success);
    }
    public ControlResponse(boolean success, String message) {
        setSuccess(success);
        setMessage(message);
    }
    public ControlResponse(boolean success, String message, Object result) {
        setSuccess(success);
        setMessage(message);
        setResult(result);
    }
    public ControlResponse(String message) {
        setMessage(message);
    }
    public ControlResponse(String message, Object result) {
        setMessage(message);
        setResult(result);
    }
    public ControlResponse(Object result) {
        setResult(result);
    }
}
