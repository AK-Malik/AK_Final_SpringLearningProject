package com.springlearning.AK_Final_SpringLearningProject.model;

import org.springframework.stereotype.Repository;

public class ErrorResponse {

    private int httpErrorCode;
    private String errorMessage;

    public int getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(int httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }













//    public EmpResponseError_SK validateHTTPResponse(Boolean httpErrorCode) {
//        if(httpErrorCode==Boolean.TRUE)
//        {
//            this.httpErrorCode = 200;
//            System.out.println("Match Found,Return the HTTP status code as:200 "+this.httpErrorCode);
//        }
//        else
//        {
//            System.out.println("Bad request "+this.httpErrorCode);
//            this.httpErrorCode = 400;
//        }
//        return this;
//    }
//



}
