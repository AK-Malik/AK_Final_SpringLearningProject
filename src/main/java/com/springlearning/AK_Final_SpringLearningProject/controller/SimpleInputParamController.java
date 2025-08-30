package com.springlearning.AK_Final_SpringLearningProject.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleInputParamController {

  // Note - PathParam Example using simple method and using ResponseEntity
    /**
     * PathParam is javax.ws.rs (JAX-RS) which is equivalent to Spring's PathVariable. Similarly, QueryParam from javax.ws.rs is equivalent to RequestParam
     * In Spring Boot, the terms "path parameter" and "path variable" are used interchangeably and refer to the same concept.
     * Specifically, a path variable (or path parameter) is a placeholder in a URI path that allows you to extract dynamic values from the URL. In Spring Boot, you define these placeholders in your @RequestMapping or @GetMapping, @PostMapping, etc., annotations using curly braces {}. To bind these extracted values to method parameters in your controller, you use the @PathVariable annotation.
     * In this example, Id & name are the path variables (or path parameters) defined in the URL, and @PathVariable("Id"),@PathVariable("name") Interger id binds its value to the id method parameter.
     * Therefore, while you might encounter both terms, they both refer to the same mechanism of extracting dynamic data from the URL path in Spring Boot.
     *
     * @param id
     * @return String
     */
     //run as Get with: http://localhost:9099/AKSpringLearning/getPathParamExp/123 . This is simple Path Param example.
     //is used in a Spring Boot controller to handle HTTP requests where a value is passed as part of the URL path.
     //Explanation: @PathVariable("id") tells Spring to extract the value of the id variable from the URL path and assign it to the id parameter.
     //For example, if your endpoint is /user/{id}, and you call /user/123, then id will be 123. The method returns a String (usually a response or view name).

     @GetMapping(path="/getPathParamExp/{id}") //Works with or without / e.g. getPathParamExp/{id}" or /getPathParamExp/{id}"
     public String getPathParamExample(@PathVariable("id") Integer id) {
         System.out.println("getPathParamExample /getPathVariable Example:");
         return "getPathVariableExample: " + id ;
     }

    /**
     * GET --> http://localhost:9099/AKSpringLearning/spring-pathParam/1/Anil
     * Both are mandatory, no key names required, only values required
     * If any one of them is not provided then exception will be thrown with 404(Not Found) as ResponseCode
     * ResponseEntity in Spring Boot is a class that represents the entire HTTP response, providing control over the status code, headers, and body of the response sent from a Spring controller. It is a generic type, allowing any type to be specified as the response body.
     * Why ResponseEntity is needed: google out.
     * Full Control over HTTP Response:When building RESTful APIs, it is often necessary to provide more than just the data in the response. ResponseEntity allows explicit control over the HTTP status code (e.g., 200 OK, 201 Created, 404 Not Found), exception, custom headers, and the response body. This enables more precise communication with the client about the outcome of a request.
     */
    @GetMapping(path = "/spring-pathParam/{Id}/{name}")
                                                            //{Id} will be like /1 and {name} like AK . http://localhost:9099/AKSpringLearning/spring-pathParam/1/Anil
    public ResponseEntity<String> springPathParam(@PathVariable(value="Id") Integer Id, @PathVariable(value="name") String name) {
        System.out.println("spring-pathParam /pathVariable Example:");
        return new ResponseEntity<String>("spring-pathParam/pathVariable Example: " + Id + " - " + name, HttpStatus.OK);
    }

    /**
     * @PathParam can be used with REST only, where @PathVariable used in Spring so it works in MVC and REST. As mentioned @PathVariable is from spring and @PathParam is from JAX-RS.
     * @param userID
     * @param userName
     * @return
     * run below as POST : http://localhost:9099/AKSpringLearning/postPathParamExample/123/anil
     */
    @PostMapping(path = "postPathParamExample/{userID}/{userName}")
    public ResponseEntity<String> postPathParamExample(@PathVariable("userID") Integer userID, @PathVariable("userName") String userName) {
        return new ResponseEntity<String>("postPathParamExampleOutput: " + userID + ":" + userName, HttpStatusCode.valueOf(200)); //HttpStatus.OK -- don't add both else throw error
    }

    /********* Note - RequestParam also known as Query Param- Example:  run as GET using: http://localhost:9099/AKSpringLearning/getRequestParamExp?id=123 ****************************/

    @GetMapping(path="getRequestParamExp")
    public String getRequestParamExample(@RequestParam Integer id) {
        System.out.println("getPathParamExample /getPathVariable Example:");
        return "getPathVariableExample: " + id ;
    }
    //Using responseEntity . Run as POST : http://localhost:9099/AKSpringLearning/postRequestParamExp?id=123&name=anil
    // both id &Name are mandatory else you will get 404 error

    @PostMapping(path="/postRequestParamExp")
    public ResponseEntity<String> postRequestParamExample(@RequestParam("id") Integer id ,  @RequestParam(value="name") String name) {
        System.out.println("postPathParamExample /postPathVariable Example:");
        return new ResponseEntity<String>( "postPathVariableExample: " + id +"--"+name , HttpStatus.valueOf(200)) ;
    }
    /*
    * Using responseEntity . Run as POST : http://localhost:9099/AKSpringLearning/requestParamMandatoryValue?id=123&name=anil
     * id is mandatory and Name is optional. if id is missing, it will give 404 error. order if id or name doesn't matter
     * Only id is mandatory
     * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     * If name is not provided "Sumita" is assigned as default value to RequestParam variable name
    */
    @PostMapping("/requestParamMandatoryValue")
    public ResponseEntity<String> requestParamMandatoryValues(@RequestParam (required=true) String id, @RequestParam(required=false,defaultValue ="Kumar") String name) {
        System.out.println("in requestParamMandatoryValue");
        return new ResponseEntity<>("requestParamMandatoryValue: " + id + " - " + name, HttpStatus.OK);
    }

 /****** --- Request Param with multivalue as list Example -----------------*****/
 /*
  * Hit with : nameList = AK, nameList = Anil, nameList = Kumar, nameList = Sumita, nameList = Ram
  * POST --> http://localhost:9099/AKSpringLearning/requestParamMultiValuesMandatory
  * nameList is mandatory
  * If nameList is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
  * Key name should be nameList
  */
 @PostMapping("/requestParamMultiValuesMandatory")  //params.  http://localhost:9099/AKSpringLearning/requestParamMultiValuesMandatory?nameList=A&nameList=B
 public ResponseEntity<String> requestParamMultiValuesMandatoryEx(@RequestParam List<String> nameList) {
     System.out.println("in requestParamMultiValuesMandatory");
     return new ResponseEntity<>("requestParamMultiValuesMandatory: " + nameList,HttpStatus.OK);
 }

 //http://localhost:9099/AKSpringLearning/displayNamesDefinedbyAK  - whether you add values in list it will pick default.
    @PostMapping("/displayNamesDefinedbyAK")
    // public ResponseEntity<String> myTestMethodWithRequestParam(@RequestParam (required = true, value = "names", defaultValue ="Anil, Kumar, Malik" ) String DisplayNames)
    public ResponseEntity<String> myTestMethodWithRequestParam(@RequestParam (required = true, value = "names", defaultValue ="Anil, Kumar, Singh, Malik" ) List<String> DisplayNames)
    {
        System.out.println("Display myTestMethodWithRequestParam with Name String");
        return new ResponseEntity<>("Given names printed as: "+ DisplayNames,HttpStatus.OK);
    }


}