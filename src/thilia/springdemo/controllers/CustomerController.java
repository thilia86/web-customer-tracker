package thilia.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thilia.springdemo.entity.Customer;
import thilia.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/boot")
	public String listCustomer(Model theModel) {

		//get customers from service
		List<Customer> theCustomers=customerService.getCustomers();
		theModel.addAttribute("customers", theCustomers);

		return "boot";
	}

	@GetMapping("/showFormForAdd")
	public String shoFormAdd(Model theModel) {

		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/boot";
	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int customerid,
			Model theModel) {

		Customer theCustomer=customerService.getCustomer(customerid);

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";

	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerid) {
		
		customerService.deleteCustomer(customerid);
		
		return "redirect:/customer/boot";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "boot";        
    }
	
	

}
