package cn.itcast.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.crm.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<Customer> findByFixedAreaIdIsNull();

	List<Customer> findByFixedAreaId(String fixedAreaId);

	Customer findByTelephone(String telephone);

	Customer findByEmail(String email);

	Customer findByEmailAndPassword(String telephone, String password);

	Customer findByTelephoneAndPassword(String telephone, String password);
	//根据地址查询出所有客户
	List<Customer> findByAddress(String address);



}
