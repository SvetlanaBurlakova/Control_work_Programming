package Classes;

import Classes.PackAnimals.Camel;
import Classes.PackAnimals.Donkey;
import Classes.PackAnimals.Horse;
import Classes.Pets.Cat;
import Classes.Pets.Dog;
import Classes.Pets.Hamster;
import Interfaces.iAnimal;
import Interfaces.iAnimalFactory;

import java.util.Date;

public class AnimalFactory implements iAnimalFactory {
    String Name;
    Date BirthDate;

    String commands;


    @Override
    public iAnimal Create(Animal animal, String Name, Date BirthDate, String commands) {
        iAnimal current_animal;
        return switch (animal){
            case Cat -> current_animal = new Cat(Name, BirthDate, commands);
            case Dog -> current_animal = new Dog(Name, BirthDate, commands);
            case Hamster -> current_animal = new Hamster(Name, BirthDate, commands);
            case Camel -> current_animal = new Camel(Name, BirthDate, commands);
            case Horse -> current_animal = new Horse(Name, BirthDate, commands);
            case Donkey -> current_animal = new Donkey(Name, BirthDate, commands);
            };
        //throw new EnumConstantNotPresentException(Animal.class, animal.toString());

    }
}
