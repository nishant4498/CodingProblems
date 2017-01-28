package StacksAndQueues;

import java.util.LinkedList;

public class AnimalShelter{
	
}

abstract class Animal{
	private int order;
	protected String name;
	
	public Animal(String n){
		name = n;
	}
	
	public int getOrder(){
		return order;
	}
	
	public void setOrder(int ord){
		order = ord;
	}
	
	public boolean isOlderThan(Animal a){
		/**
		 * The order should be smaller for older animals.
		 */
		return this.order < a.order;
	}
	
}

class AnimalQueue{
	private LinkedList<Dog> dogs = new LinkedList<>();
	private LinkedList<Cat> cats = new LinkedList<>();
	int order = 0;
	
	public void enqueue(Animal a){
		order++;
		a.setOrder(order);
		if(a instanceof Dog){
			dogs.addLast((Dog)a);
		} else if(a instanceof Cat){
			cats.addLast((Cat)a);
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.size() == 0){
			return dequeueCats();
		}else if(cats.size() == 0){
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOlderThan(cat)){
			return dequeueDogs();
		}else{
			return dequeueCats();
		}
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}	
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}
