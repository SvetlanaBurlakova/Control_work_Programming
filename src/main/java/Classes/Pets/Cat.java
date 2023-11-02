package Classes.Pets;

import Classes.Animal;
import Classes.Pet;

import java.util.Date;

public class Cat extends Pet {

    public String name;
    public Date birthDate;

    public String commands;

    public Cat(String name, Date birthDate, String commands){
        super(name, birthDate, commands);
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }
    public Animal getAnimal(){
        return Animal.Cat;
    }

    }

