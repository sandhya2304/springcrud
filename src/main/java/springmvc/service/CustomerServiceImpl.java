package springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.CustomerDao;
import springmvc.model.Customer;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerDao customerDao;
	

	public List listAllCustomers() {	
		return customerDao.listAllCustomers();
	}

	public void saveOrUpdate(Customer customer) {
	    customerDao.saveOrUpdate(customer);
	}

	public Customer findCustomerById(int id) {
		return customerDao.findCustomerById(id);
	}

	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
	
	
	

}
