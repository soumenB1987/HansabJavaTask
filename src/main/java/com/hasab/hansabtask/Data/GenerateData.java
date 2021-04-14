package com.hasab.hansabtask.Data;

import java.util.List;
import java.util.ArrayList;
import com.hasab.hansabtask.Data.Schemas.Car;
import com.hasab.hansabtask.Data.Schemas.Customer;
import com.hasab.hansabtask.Data.Schemas.CustomerData;

public class GenerateData {

    public List<CustomerData> getData() {
        List<CustomerData> dataSchemaList = new ArrayList<>();
        List<Car> carList;

        carList = new ArrayList<>();
        carList.add(new Car(1, "Lada", "2101", "123ASD"));
        carList.add(new Car(2, "Kia", "Sorento", "534TTT"));
        dataSchemaList.add(new CustomerData(1, "Teet Järveküla", carList));

        carList = new ArrayList<>();
        carList.add(new Car(3, "Skoda", "Octavia", "999GLF"));
        carList.add(new Car(4, "Kia", "Sorento", "555TFF"));
        dataSchemaList.add(new CustomerData(2, "Pille Purk", carList));

        carList = new ArrayList<>();
        carList.add(new Car(5, "Lada", "2101", "445KKK"));
        carList.add(new Car(6, "Audi", "A6", "997HHH"));
        dataSchemaList.add(new CustomerData(3, "Mati Kaal", carList));

        carList = new ArrayList<>();
        carList.add(new Car(7, "BMW", "760", "444RRR"));
        carList.add(new Car(8, "Audi", "A6", "876OUI"));
        dataSchemaList.add(new CustomerData(4, "Külli Kukk", carList));

        carList = new ArrayList<>();
        carList.add(new Car(9, "BMW", "740", "112YUI"));
        dataSchemaList.add(new CustomerData(5, "Teet Kruus", carList));

        return dataSchemaList;
    }

    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer(1, "Teet Järveküla"));
        customerList.add(new Customer(2, "Pille Purk"));
        customerList.add(new Customer(3, "Mati Kaal"));
        customerList.add(new Customer(4, "Külli Kukk"));
        customerList.add(new Customer(5, "Teet Kruus"));
        return customerList;
    }
}
