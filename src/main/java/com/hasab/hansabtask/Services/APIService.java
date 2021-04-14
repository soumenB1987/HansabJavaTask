package com.hasab.hansabtask.Services;

import com.hasab.hansabtask.Data.GenerateData;
import com.hasab.hansabtask.Data.Schemas.Car;
import com.hasab.hansabtask.Data.Schemas.Customer;
import com.hasab.hansabtask.Data.Schemas.CustomerData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class APIService {

    private List<CustomerData> customerData = new ArrayList<CustomerData>();
    private List<Customer> customers = new ArrayList<Customer>();
    final GenerateData generateData = new GenerateData();

    public APIService() {

        this.customerData = generateData.getData();
        this.customers = generateData.getCustomers();
    }

    /** GET ALL USERS DATA METHOD **/
    public List<Customer> getAllCustomers() {

        return this.customers;
    }

    /** GET CUSTOMER BY ID METHOD **/
    public Customer getCustomerById(Integer customerId) {

        List<Customer> customer = this.customers.stream().filter(getUser -> getUser.getId()
                .equals(customerId)).collect(Collectors.toList());

        if(customer.size() > 0) {
            return customer.get(0);
        }

        return null;
    }

    /** GET ALL CARS BY CUSTOMER ID METHOD **/
    public List<Car> getAllCarsByCustomerId(Integer customerId) {

        List<CustomerData> customerData = this.customerData.stream().filter(getUser -> getUser.getId().equals(customerId))
                .collect(Collectors.toList());

        if(customerData.size() > 0) {
            return customerData.stream().map(CustomerData::getCars)
                    .collect(Collectors.toList()).get(0);
        }

        return null;
    }

   /** GET ALL CARS METHOD **/
   public List<Car> getAllCars() {

       return this.customerData.stream()
               .flatMap(allCars -> allCars.getCars().stream())
               .collect(Collectors.toList());
   }

   /** GET CAR DETAILS BY ID METHOD **/
   public Car getCarData(Integer id) {

       List<Car> carList = this.customerData
               .stream()
               .flatMap(fmap -> fmap.getCars().stream().filter(filterCar -> filterCar.getId().equals(id)))
               .collect(Collectors.toList());

       if(carList.size() > 0) {
           return carList.get(0);
       }

       return null;
   }

   /** SEARCH AND SORT CUSTOMER LIST METHOD **/
   public List<CustomerData> sortCustomers(String find, String sort) {

       List<CustomerData> sortedData = new ArrayList<CustomerData>();

       if(sort.contains(":")) {
           if(sort.split(":")[0].equals("name") &&
                   (sort.split(":")[1].equals("asc")) ||
                   (sort.split(":")[1].equals("desc"))) {

               sortedData = doSort(sort.split(":")[1], find);
           }
       }

       return sortedData;
   }

    /** METHOD TO DO SORT CUSTOMER DATA BASED ON REQUESTED METHOD **/
    private List<CustomerData> doSort(String sortType, String customerName) {

        List<CustomerData> sorted = this.customerData;

        sorted = sorted.stream().filter(getCustomerDataName -> getCustomerDataName.getName().contains(customerName))
                .collect(Collectors.toList());

        if(sortType.equals("desc"))
            sorted.sort((CustomerData customerData1, CustomerData customerData2) ->
                    customerData2.getName().compareTo(customerData1.getName()));  // DESC

        else
            sorted.sort(Comparator.comparing(CustomerData::getName));  // ASC

        return sorted;
    }
}
