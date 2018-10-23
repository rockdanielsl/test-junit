package com.example.demoJUnit.model;

public class Response {

    private String internalCode;

    private String message;

    private Object payload;

    public Response(String internalCode, String message, Object payload) {
        super();
        this.internalCode = internalCode;
        this.message = message;
        this.payload = payload;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "internalCode='" + internalCode + '\'' +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                '}';
    }
}
