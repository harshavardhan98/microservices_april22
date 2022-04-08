package com.bvr;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}

	
	private static final Logger log = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	
	@Autowired
	private BookRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		log.info("Start DB Service");
		
		repository.save(new Book("MicroServices"));
		repository.save(new Book("Python for operational AI"));
		repository.save(new Book("GoLang"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Apache Spark"));
		repository.save(new Book("Kafka"));
		repository.save(new Book("Ansible"));
		
		
		System.out.println("\n Find all records :");
		
		repository.findAll().forEach(x -> System.out.println(x));
		
		
		System.out.println("\n Find by Id record :");
		
		repository.findById(5l).ifPresent(x -> System.out.println(x));
		
		
		System.out.println("\n Find by Name records :");
		
		repository.findByName("Kafka").forEach(x -> System.out.println(x));
		
		
		
		
		
//		System.out.println("\n Delete book by ID :");
//		
//		Book bookToDelete = repository.findById(13l).get();
//		
//		System.out.println("Deleting Book : " + bookToDelete.getName());
//		
//		repository.delete(bookToDelete);
//		
		
		
		
		
//		System.out.println("\n Delete Book By Title :");
//		
//		repository.findByName("GoLang").forEach(book -> {
//			System.out.println("Deleting Book : " + book.getName());
//			repository.delete(book);
//		});
		
		
//		System.out.println("\n Delete book by ID :");
//		
//		repository.deleteById(19L);
//		
		
		
//		System.out.println("\n Delete All by ID :");
//		
//		repository.deleteAllById(Arrays.asList(15l, 21l, 22l, 31l));
//		
		
		
		
//		System.out.println("\n Delete By Name :");
//		
//		repository.deleteAll(repository.findByName("Kafka"));
//		
		
		

		
		System.out.println("\n Updating Records :");
		
		repository.findById(28l).ifPresent(x -> {
			System.out.println(x);
			x.setName("Ansible for Network Automation");
			repository.save(x);
		});
		
	}

}
