package org.casique.validators;

public class Main {
  public static void main(String[] args) {
    Person person = new Person();
    person.setName("John");

    PersonDto personDto = PersonMapper.INSTANCE.toDto(person);
    PersonDto personDto2 = PersonMapper.INSTANCE.toDtoWithValidation(person);


    System.out.println("Name: " + personDto.getName());
    System.out.println("Age: " + personDto.getAge());
  }
}

