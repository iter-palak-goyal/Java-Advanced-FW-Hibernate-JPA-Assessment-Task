package com.capgemini.customer_wallet.service;

import com.capgemini.customer_wallet.dao.CustomerDAO;
import com.capgemini.customer_wallet.entity.Customer;
import com.capgemini.customer_wallet.entity.Wallet;

public class CustomerService {

    CustomerDAO dao = new CustomerDAO();

    public void addCustomer(String name, String email, double balance, String currency) {

        if(balance <= 0){
            System.out.println("Balance must be positive");
            return;
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);

        Wallet wallet = new Wallet();
        wallet.setBalance(balance);
        wallet.setCurrency(currency);

        customer.setWallet(wallet);

        dao.addCustomer(customer);

        System.out.println("Customer added successfully");
        printCustomer(customer);
    }

    public void searchCustomer(int id){

        Customer c = dao.findCustomer(id);

        if(c!=null){
            printCustomer(c);
        }
        else{
            System.out.println("Customer not found");
        }
    }

    public void updateWallet(int id,double newBalance){

        Customer c = dao.findCustomer(id);

        if(c!=null){

            c.getWallet().setBalance(newBalance);
            dao.updateWallet(c);

            System.out.println("Wallet updated successfully");
        }
        else{
            System.out.println("Customer not found");
        }
    }

    public void deleteCustomer(int id){

        dao.deleteCustomer(id);
        System.out.println("Customer deleted successfully");
    }

    private void printCustomer(Customer c){

        System.out.println("ID: "+c.getId());
        System.out.println("Name: "+c.getName());
        System.out.println("Email: "+c.getEmail());
        System.out.println("Wallet:");
        System.out.println("  Balance: "+c.getWallet().getBalance());
        System.out.println("  Currency: "+c.getWallet().getCurrency());
    }
}