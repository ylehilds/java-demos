package dev.lehi.inheritance;

public class SuperclassConstructors {
public static abstract class Animal {
  private String name;

  public String getName() {
    return name;
  }

  public Animal(String theName) {
    name = theName;
  }
}

public static class Hippo extends Animal {
  public Hippo(String name) {
    super(name);
  }
}

public static void main(String[] args) {
  Hippo h = new Hippo("Lehi");
  System.out.println(h.getName());
}
}
