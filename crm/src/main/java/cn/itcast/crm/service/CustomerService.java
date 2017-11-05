package cn.itcast.crm.service;

import java.util.List;

import javax.jws.WebService;

import cn.itcast.crm.domain.Customer;

@WebService
public interface CustomerService {

	//查询为空的
	List<Customer> findByFixedAreaIdIsNull();
	//查询不为空的，id查询
	List<Customer> findByFixedAreaId(String fixedAreaId);
	/**
	 * 注册客户
	 * @param customer
	 */
	public  void  save(Customer customer);
	//查询手机号是否被注册
	Customer findByTelephone(String telephone);
	
	//查询有限是被注册
	Customer findByEmail(String email);
	
	//判断邮箱与密码的telephone password email
	Customer findByEmailAndPassword(String telephone,String password);

	//判断用户名密码的
	Customer findByTelephoneAndPassword(String telephone,String password);
	
	
	//根据地址查询出点取的id 
	String findFixedAreaIdByAdress(String address);
}
