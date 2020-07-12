package com.bruno.projects.mccourse;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.projects.mccourse.domain.Address;
import com.bruno.projects.mccourse.domain.BilletPayment;
import com.bruno.projects.mccourse.domain.CardPayment;
import com.bruno.projects.mccourse.domain.Category;
import com.bruno.projects.mccourse.domain.City;
import com.bruno.projects.mccourse.domain.Client;
import com.bruno.projects.mccourse.domain.Payment;
import com.bruno.projects.mccourse.domain.Product;
import com.bruno.projects.mccourse.domain.Request;
import com.bruno.projects.mccourse.domain.State;
import com.bruno.projects.mccourse.domain.enums.ClientType;
import com.bruno.projects.mccourse.domain.enums.PaymentStatus;
import com.bruno.projects.mccourse.repositories.AddressRepository;
import com.bruno.projects.mccourse.repositories.CategoryRepository;
import com.bruno.projects.mccourse.repositories.CityRepository;
import com.bruno.projects.mccourse.repositories.ClientRepository;
import com.bruno.projects.mccourse.repositories.PaymentRepository;
import com.bruno.projects.mccourse.repositories.ProductRepository;
import com.bruno.projects.mccourse.repositories.RequestRepository;
import com.bruno.projects.mccourse.repositories.StateRepository;

@SpringBootApplication
public class MccourseApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MccourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000);
		Product p2 = new Product(null, "Printer", 800);
		Product p3 = new Product(null, "Mouse", 80);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Belo Horizonte", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Campinas", s2);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.FISICALPERSON);
		cli1.getTelephones().addAll(Arrays.asList("27363323","93838393"));
		
		Address ad1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAddresses().addAll(Arrays.asList(ad1, ad2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1,ad2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Request req1 = new Request(null, sdf.parse("30/09/2017 10:32"), cli1, ad1);
		Request req2 = new Request(null, sdf.parse("10/10/2017 19:35"), cli1, ad2);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.PAID, req1, 6);
		req1.setPayment(pay1);
		
		Payment pay2 = new BilletPayment(null, PaymentStatus.PENDENT, req2, sdf.parse("20/10/2017 00:00"), null);
		req2.setPayment(pay2);
		
		cli1.getRequests().addAll(Arrays.asList(req1, req2));
		
		requestRepository.saveAll(Arrays.asList(req1, req2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
	}

}
