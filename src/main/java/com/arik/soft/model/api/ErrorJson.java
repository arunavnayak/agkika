package com.arik.soft.model.api;

import java.util.Map;

public class ErrorJson {
    private final int status;
    private final Map<String, Object> errorAttributes;

    public ErrorJson(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.errorAttributes = errorAttributes;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, Object> getErrorAttributes() {
        return errorAttributes;
    }
}
