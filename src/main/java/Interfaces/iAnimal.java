package Interfaces;

import Classes.Animal;

import java.util.Date;

public interface iAnimal {
    Animal animal = null;
    public String getName();
    public Date getBirthDate();

    public String getCommands();
    public void setCommands(String commandsAnimal);

    public String toString();

}
