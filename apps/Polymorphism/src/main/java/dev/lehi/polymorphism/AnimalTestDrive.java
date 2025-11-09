package dev.lehi.polymorphism;

public class AnimalTestDrive {
  public static void main(String[] args) {
    MyAnimalList list = new MyAnimalList();
    Dog dog = new Dog();
    Cat cat = new Cat();
    Bird bird = new Bird();
    list.add(dog);
    list.add(cat);
    list.add(bird);
  }
}
  