package com.example.springproject5.Controller;

import com.example.springproject5.Model.Book;
import com.example.springproject5.Model.Customer;
import com.example.springproject5.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

      final private CustomerService customerService;
    @GetMapping("/display")
    public ResponseEntity getAlLCustomers(){
        List<Customer> customers = customerService.getCustomer();
        return ResponseEntity.status(200).body(customers);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addCustomers(@Valid @RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer is deleted ");
    }


    // Assign customers to Stores [NOTE]
    @PutMapping("/assignCustomer/{store_id}/{customer_id}")
    public ResponseEntity assignCustomer(@PathVariable Integer store_id,@PathVariable Integer customer_id){
        customerService.assignCustomerToStore(store_id,customer_id);
        return ResponseEntity.status(200).body("Customer is assigned ");
    }

    //Create endpoint thar takes storeid and return all customers
    @PutMapping("/getAllCustomers/{store_id}")
    public ResponseEntity getAllCustomers(@PathVariable Integer store_id){
        List<Customer> customers = customerService.getAllCustomer(store_id);
        return ResponseEntity.status(200).body(customers);
    }

}
