package Interfaces;

import Classes.Animal;

import java.util.Date;

public interface iAnimalFactory {
        public iAnimal Create(Animal animal, String Name, Date BirthDate, String commands) throws RuntimeException;

}
