package Classes.PackAnimals;

import Classes.Animal;
import Classes.PackAnimal;

import java.util.Date;

public class Camel extends PackAnimal {
    public String name;
    public Date birthDate;

    public String commands;

    public Camel(String name, Date birthDate, String commands){
        super(name, birthDate, commands);
        this.name = name;
        this.birthDate = birthDate;
    }
    public Animal getAnimal(){
        return Animal.Camel;
    }


}
