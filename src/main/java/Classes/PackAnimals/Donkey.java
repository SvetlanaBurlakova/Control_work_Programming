package Classes.PackAnimals;

import Classes.Animal;
import Classes.PackAnimal;

import java.util.Date;

public class Donkey extends PackAnimal {

    public String name;
    public Date birthDate;

    public String commands;

    public Donkey(String name, Date birthDate, String commands){
        super(name, birthDate, commands);
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }
    public Animal getAnimal(){
        return Animal.Donkey;
    }
}
