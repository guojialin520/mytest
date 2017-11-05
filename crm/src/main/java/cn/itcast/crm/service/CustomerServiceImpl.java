package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> findByFixedAreaIdIsNull() {
		
		return customerDao.findByFixedAreaIdIsNull();
	}

	@Override
	public List<Customer> findByFixedAreaId(String fixedAreaId) {
		// TODO Auto-generated method stub
		return customerDao.findByFixedAreaId(fixedAreaId);
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	
	@Override
	public Customer findByTelephone(String telephone) {
		return customerDao.findByTelephone(telephone);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	@Override
	public Customer findByEmailAndPassword(String telephone, String password) {
		return customerDao.findByEmailAndPassword(telephone,password);
	}

	@Override
	public Customer findByTelephoneAndPassword(String telephone, String password) {
		return customerDao.findByTelephoneAndPassword(telephone,password);
	}

	//根据客户的地址查询出定区的id
	@Override
	public String findFixedAreaIdByAdress(String address) {
		//会查询出相同地址的多个客户，只需要提取一个客户的定区id就可以
		List<Customer> list= customerDao.findByAddress(address);
		if (list!=null&& list.size()>0) {
			String fixedAreaId = list.get(0).getFixedAreaId();
			return fixedAreaId;
		}
		return null;
	}

	

}
