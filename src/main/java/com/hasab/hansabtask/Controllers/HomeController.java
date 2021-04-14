package com.hasab.hansabtask.Controllers;

import com.hasab.hansabtask.Services.APIService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    APIService apiService = new APIService();

    /** GET ALL USERS DATA **/
    @CrossOrigin
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers() {

        if(apiService.getAllCustomers().size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.getAllCustomers());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiService.getAllCustomers().size());
    }

    /** GET USER BY ID **/
    @CrossOrigin
    @RequestMapping(value = "users/{userid}")
    public ResponseEntity getCustomer(@PathVariable("userid")Integer id) {

        if(apiService.getCustomerById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.getCustomerById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /** GET CUSTOMER'S CARS **/
    @CrossOrigin
    @RequestMapping(value = "users/{userid}/cars")
    public ResponseEntity getCars(@PathVariable("userid")Integer id) {

        if(apiService.getAllCarsByCustomerId(id).size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.getAllCarsByCustomerId(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /** GET ALL CARS **/
    @CrossOrigin
    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public ResponseEntity getAllCars() {

        if(apiService.getAllCars().size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.getAllCars());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /** GET CAR DATA BY ID **/
    @CrossOrigin
    @RequestMapping(value = "cars/{carid}", method = RequestMethod.GET)
    public ResponseEntity getCarById(@PathVariable("carid")Integer id) {

        if(apiService.getCarData(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.getCarData(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /** GET CUSTOMER BY NAME AND TYPE OF REQUESTED SORT ORDER **/
    @CrossOrigin
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity sortUser(@RequestParam String find, @RequestParam String sort) {

        if(apiService.sortCustomers(find, sort).size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(apiService.sortCustomers(find, sort));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
