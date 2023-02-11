package com.example.springproject5.Service;

import com.example.springproject5.Exception.ApiException;
import com.example.springproject5.Model.Book;
import com.example.springproject5.Model.Customer;
import com.example.springproject5.Model.Store;
import com.example.springproject5.Repository.BookRepository;
import com.example.springproject5.Repository.CustomerRepository;
import com.example.springproject5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
   private final BookRepository bookRepository;

   private final StoreRepository storeRepository;

    // ADD
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    // Display
    public List<Customer> getCustomer(){
        return  customerRepository.findAll();
    }

    // update
    public void updateCustomer(Integer id, Customer customer) {
        Customer newCustomer = customerRepository.findCustomerById(id);
        if (newCustomer == null) {
            throw new ApiException("Customer not found!!");
        }
        customerRepository.save(newCustomer);
    }

    // delete

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer ==null) {
            throw new ApiException("Id is not found");
        }
        customerRepository.delete(customer);
    }
//
    public void assignCustomerToStore(Integer store_id, Integer customer_id){
        Store store = storeRepository.findStoreById(store_id);
        Customer customer = customerRepository.findCustomerById(customer_id);
        if (customer ==null || store ==null ) {
            throw new ApiException("Id is not found");
        }

        store.getCustomers().add(customer);
        customer.getStores().add(store);
        storeRepository.save(store);
        customerRepository.save(customer);
    }

    //Create endpoint thar takes storeid and return all customers
    public List<Customer> getAllCustomer(Integer store_id){
        Store store = storeRepository.findStoreById(store_id);
        if (store ==null ) {
            throw new ApiException("store is not found");
        }
        return store.getCustomers();
    }

}
