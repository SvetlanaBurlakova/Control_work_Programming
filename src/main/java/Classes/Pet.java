package Classes;

import Classes.Animal;
import Interfaces.iAnimal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet implements iAnimal {
    String name;
    Date birthDate;
    String commands;
    private Animal animal;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    public Animal getAnimal(){
        return animal;
    }
    public Pet(String name, Date birthDate, String commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Date getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getCommands() {
        return this.commands;
    }

    public void setCommands(String commands){
        this.commands = commands;
    }

    public String toString(){
        return "Animal{" +
                "name='" + this.name + '\'' +
                " BirthDate='" + formater.format(this.birthDate) + '\'' +
                " Type='" + this.getClass().getName() + '\'' +
                + '}';
    }
}
