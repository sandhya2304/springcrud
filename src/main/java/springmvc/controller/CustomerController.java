package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Customer;
import springmvc.service.CustomerService;



@Controller
@RequestMapping(value="/customer")
public class CustomerController
{
    @Autowired
	private CustomerService customerService;
    
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list(){
     ModelAndView model = new ModelAndView("customer/list");
     List list = customerService.listAllCustomers();
     model.addObject("list", list);
     
     return model;
    }
    
    
    @RequestMapping(value="/update/${id}",method=RequestMethod.GET)
    public ModelAndView update(@PathVariable("id")int id)
    {
    	ModelAndView mv = new ModelAndView("customer/form");
    	Customer customer = customerService.findCustomerById(id);
    	mv.addObject("customerForm",customer);
    	
    	return mv;
    }
    
    @RequestMapping(value="/delete/${id}",method=RequestMethod.GET)
    public ModelAndView delete(int id)
    {
    	customerService.deleteCustomer(id);
    	
    	return new ModelAndView("redirect:/customer/list");
    }
    
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView add()
    {
    	ModelAndView mv = new ModelAndView();
    	Customer customer = new Customer();
    	
    	return mv;
    }
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customerForm") Customer customer){
     customerService.saveOrUpdate(customer);
     
     return new ModelAndView("redirect:/customer/list");
    }

}
