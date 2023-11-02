package Classes;

import Interfaces.iAnimal;

import java.util.ArrayList;
import java.util.HashMap;

public class Reestr {
    Integer count = 0;
    public iAnimal animal;
   // public ArrayList<iAnimal> animalArrayList;
    public HashMap<Integer, iAnimal> animalHashMap;
    //public Reestr(){
    //    ArrayList<iAnimal> animalArrayList =  new ArrayList<>();
    //}
    //public Reestr(){
    //    HashMap<Integer, iAnimal> animalHashMap =  new HashMap<>();
    //}
    public Reestr(HashMap<Integer, iAnimal> animalHashMap) {
        this.animalHashMap = animalHashMap;
    }

    public HashMap<Integer, iAnimal> addAnimal(iAnimal animal){
        this.count = this.count + 1;
        animalHashMap.put(this.count,animal);
        return animalHashMap;
    }
    public Integer countAnimals(){
        return this.count;
    }

    //public Class<? extends Animal> getType(Animal animal)
    @Override
    public String toString(){
        return "Reestr [animalList=" + animalHashMap + "]";
    }






}
