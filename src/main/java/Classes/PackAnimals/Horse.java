package Classes.PackAnimals;

import Classes.Animal;
import Classes.PackAnimal;

import java.util.Date;

public class Horse extends PackAnimal {

    public String name;
    public Date birthDate;
    public String commands;

    public Horse(String name, Date birthDate, String commands){
        super(name, birthDate, commands);
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }
    public Animal getAnimal(){
        return Animal.Horse;
    }
}
