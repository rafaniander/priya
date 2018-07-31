package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class EmpRestController extends WebSecurityConfigurerAdapter {

	Map<Integer, Employee> empMap = new HashMap<>();

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public Collection<Employee> getEmployees() {
		if (ObjectUtils.isEmpty(empMap)) {
			empMap.put(122, new Employee(122, "Rafa", 25, "Rua A"));
			empMap.put(123, new Employee(123, "Niander", 25, "Rua B"));
			empMap.put(124, new Employee(124, "Nini", 25, "Rua C"));
		}
		return empMap.values();
	}

	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
	public Collection<Employee> saveEmployee(@PathVariable Integer empId) {
		empMap.put(empId, new Employee(empId, "Rafa", 25, "Rua A"));
		return empMap.values();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/emp")
		.permitAll()
		.anyRequest()
		.authenticated();
	}

}
