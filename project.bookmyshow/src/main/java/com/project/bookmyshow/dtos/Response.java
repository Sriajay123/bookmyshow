package com.project.bookmyshow.dtos;



public class Response {

    private String error;

    private ResponseStatus responseStatus;

    public Response(ResponseStatus responseStatus, String error ) {
        this.responseStatus = responseStatus;
        this.error = error;

    }

    public static Response getSuccessResponse(){
        return new Response(ResponseStatus.SUCCESS,null);
    }

    public static Response getFailureResponse(String error) {
        return new Response(ResponseStatus.FAILURE, error);
    }
}
