package com.springlearning.AK_Final_SpringLearningProject.controller;

import com.springlearning.AK_Final_SpringLearningProject.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONUserController {

   // private ArrayList<UseStringrModel> userModels = new arralys
    /*
     * POST --> http://localhost:9099/AKSpringLearning/springJsonExample/users
     * Hit with JSON format of UserModel object
     * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
     * If some fields are missing from JSON body, and it's a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
     */
//http://localhost:9099/AKSpringLearning/springJson/createUserA
    @GetMapping(value = "/springJson/createUserA")
    public ResponseEntity<UserModel> springJSON() {
        UserModel userModel = new UserModel(1, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    //Run as : http://localhost:9099/AKSpringLearning/springJson/createUserB
    //@GetMapping(value = "/springJson/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/springJson/createUserB",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<UserModel> springJSONExample() {
        UserModel userModel = new UserModel(2, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully:"+userModel);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

//run as : http://localhost:9099/AKSpringLearning/springJson/createUserC
    @GetMapping(value = "/springJson/createUserC", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> springJSONExampleS() {
        UserModel userModel = new UserModel(3, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    //http://localhost:9099/AKSpringLearning/springJson/getUsersById/2
    @RequestMapping(method = {RequestMethod.POST},value = "/springJson/getUsersById/{id}")  //2   // Line 13 & this can be combined here and written as @PostMapping("/users")
   // @PostMapping("/springJson/getUsersById/{id}")
    public ResponseEntity<?> getUserFromUserModel(@PathVariable Integer id) {   //? because we are returning multivalue - String and object
        if (id == 2) {
            UserModel userModel = new UserModel(2, "Anil-Kumar", "ak@test.com", "NewJersey");
            return new ResponseEntity<String>("User Found for:" + id + " is:" + userModel, HttpStatus.valueOf(200));
        } else {
            //Example for handling not found scenario
            return new ResponseEntity<UserModel>(new UserModel(0, null, null, "User not found."), HttpStatus.NOT_FOUND); // Returns 404 Not Found
               }
       }

    //http://localhost:9099/AKSpringLearning/springJson/createUserAB
    @GetMapping(value = "/springJson/createUserAB")
        public ResponseEntity<UserModel> springJSONAB() {
        // userModels.add(name)
        UserModel userModel = new UserModel(101, "Anil", "ak@test.com", "Panipat");   //this will be taken as input and printed as output in line:66
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    /**
     * @GetMapping(value = "/springJson/createUserABC"): Maps HTTP GET requests to /springJson/createUserABC to this method.
     * @RequestBody UserModel userModel: Spring automatically converts the incoming JSON request body into a UserModel Java object (POJO).
     * The method prints a message and returns the userModel object in the response, with HTTP status 201 Created.
     * Note:Typically, @RequestBody is used with @PostMapping or @PutMapping, not @GetMapping, since GET requests do not have a body by HTTP standards.
     * For creating resources, use @PostMapping.
     * Summary: This method receives a JSON object, converts it to a Java POJO, and returns it in the response with status 201 Created. For best practice, use @PostMapping for resource creation.
     * @param userModel
     * @return    userModel Object
     * Run as: http://localhost:9099/AKSpringLearning/springJson/createUserABC
     * Provide under body in postman -->raw -->json enter
     *      {   "id" :123,
     *         "name" : "ANIL-KUMAR",
     *         "email" : "a.test.com",
     *         "city" :"NY"
     *     }
     */
    @PostMapping(value = "/springJson/createUserABC")
    public ResponseEntity<UserModel> springJSONABC(@RequestBody UserModel userModel ){  //JSON provided in request body will be converted to POJO and returned in ResponseEntity- line80
        // userModels.add(name)
        System.out.println("spring-JSON Example - UserCreated Successfully: "+userModel.toString());
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    //http://localhost:9099/AKSpringLearning/springJson/createUserABCD
    @PostMapping(value = "/springJson/createUserABCD")
    public ResponseEntity<UserModel> springJSONABCD(@RequestBody UserModel userModel ){
        // userModels.add(name)
       new UserModel(103, "Anil", "ak@test.com", "Panipat");  //this is not passed in request body so it will only be printed as a pojo but not the processing
        System.out.println("spring-JSON Example - UserCreated Successfully: "+userModel.getName()+":-"+userModel.toString());
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    //http://localhost:9099/AKSpringLearning/springJson/createUserABCDE
    @PostMapping(value = "/springJson/createUserABCDE")
    public ResponseEntity<UserModel> springJSONABCDE( UserModel userModel ){    //removed @RequestBody and passed USerModel Object as Argument and used for setting value
        // userModels.add(name)
        userModel.setId(1234); //setting inputs in POJO
        userModel.setName("Anil-Kumar");
        userModel.setCity("Bridgewater");
        userModel.setEmail("Ak@Gmail.com");
        System.out.println("spring-JSON Example - UserCreated Successfully: "+userModel.getName()+":-"+userModel.toString() +":-:"+userModel);  //userModel.toString() and userModel both prints same
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }


}

