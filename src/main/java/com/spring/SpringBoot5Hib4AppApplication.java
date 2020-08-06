package com.spring;

import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.spring.model.Login;
import com.spring.model.Mobile;
import com.spring.model.UserAddress;
import com.spring.service.LoginService;

@SpringBootApplication
@ComponentScan("com.spring")
public class SpringBoot5Hib4AppApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  context = (AnnotationConfigApplicationContext) 
				SpringApplication.run(SpringBoot5Hib4AppApplication.class, args);
		
//		context.scan("com.spring"); 
		
		LoginService loginService = context.getBean("loginService", LoginService.class);
		
		Mobile m01 = new Mobile("01010101010");
		Mobile m02 = new Mobile("02020202020");
		Mobile m03 = new Mobile("03030303030");
		Mobile m11 = new Mobile("1111111111");
		Mobile m12 = new Mobile("1212121212");
		Mobile m21 = new Mobile("21");
		
		LinkedHashSet<Mobile> m1 = new LinkedHashSet<Mobile>();
		m1.add(m01);
		m1.add(m02);
		m1.add(m03);
		
		LinkedHashSet<Mobile> m2 = new LinkedHashSet<Mobile>();
		m2.add(m11);
		m2.add(m12);
		
		LinkedHashSet<Mobile> m3 = new LinkedHashSet<Mobile>();
		m3.add(m21);
		
		Login u1 = new Login("admin", "admin", new UserAddress("Kormangala", "Bengaluru"), m1);
		Login u2 = new Login("harish", "harish", new UserAddress("Juhu", "Mumbai"), m2);
		Login u3 = new Login("nbj", "nbj", new UserAddress("Saket", "New Delhi"), m3);
		
		loginService.saveLogin(u1);
		loginService.saveLogin(u2);
		loginService.saveLogin(u3);
		
		List<Login> allLogins = loginService.findAllLogins();
		for(Login u : allLogins) {
			System.out.print("Username = " + u.getUsername() + "\t");
			System.out.print("City = " + u.getAdress().getCity() + "\t");
			Set<Mobile> mobiles = u.getMobile();
			for(Mobile m : mobiles) {
				System.out.print("Mobile = " + m.getMobileNo() + "\t");
			}
			System.out.println("------------------------------------------------------------");
		}
		context.close();
	}
}
