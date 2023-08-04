package com.ars;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ars.controller.DrinkController;
import com.ars.entity.Drink;
import com.ars.repository.DrinkRepository;


@SpringBootTest(classes=DrinkBootAppApplication.class)
public class DrinkControllerTest {
	
	@Mock
	DrinkRepository repository;

	@InjectMocks
	DrinkController drinkcontroller = new DrinkController();
	
	@Test
	public void testFindAll() {
		Iterable<Drink> drinks = new ArrayList<Drink>();
		Drink d1 = new Drink(101,"Coffee Latte","Hot",false);
		//Drink d2 = new Drink(102,"Pineapple Punch","Cold",false);
		//Drink d3 = new Drink(103,"Americano","Hot",false);
		
		((ArrayList<Drink>) drinks).add(d1);
		//drinks.add(d2);
		//drinks.add(d3);
		
		//Iterable<Drink> iterator = (Iterable<Drink>) drinks.iterator();
		//Iterator<Drink> iterator = drinks.iterator();
		
		when(repository.findAll()).thenReturn((ArrayList<Drink>) drinks);
		Iterable<Drink> result = drinkcontroller.findAll();
		
		Assertions.assertNotEquals(null, result);
		//Assertions.assertTrue(result.);
		Assertions.assertEquals("Coffee Latte", ((ArrayList<Drink>) result).get(0).getName());
		
	}
	
	@Test
	public void testFindByName() {
		
		String drinkName = "Coffee Latte";
		
		List<Drink> drinks = new ArrayList<Drink>();
		Drink d1 = new Drink(101,"Coffee Latte","Hot",false);
		
		drinks.add(d1);
		
		when(repository.findByName(drinkName)).thenReturn(drinks);
		List<Drink> result = drinkcontroller.findByName(drinkName);
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(0).getName().endsWith("e"));
		Assertions.assertEquals("Coffee Latte", result.get(0).getName());
	}
}