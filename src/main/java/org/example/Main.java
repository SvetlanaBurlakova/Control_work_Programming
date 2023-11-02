package org.example;

import Classes.Animal;
import Classes.AnimalFactory;
import Classes.Reestr;
import Interfaces.iAnimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {

        AnimalFactory animalFactory = new AnimalFactory();
        iAnimal animal1 = animalFactory.Create(Animal.Cat, "Whiskers", new Date(120,01,01),
                "Sit, Stay, Fetch");
        iAnimal animal2 = animalFactory.Create(Animal.Dog, "Fido", new Date(119,03,11),
                "Sit, Pounce");
        iAnimal animal3 = animalFactory.Create(Animal.Hamster, "Hammy", new Date(121,03,10),
                "Roll, Hide");
        iAnimal animal4 = animalFactory.Create(Animal.Dog, "Buddy", new Date(118,12,11),
                "Sit, Paw, Bark");
        iAnimal animal5 = animalFactory.Create(Animal.Cat, "Smudge", new Date(120,02,20),
                "Sit, Pounce, Scratch");
        iAnimal animal6 = animalFactory.Create(Animal.Hamster, "Peanut", new Date(121,06,01),
                "Roll, Spin");
        iAnimal animal7 = animalFactory.Create(Animal.Dog, "Bella", new Date(119, 11, 11),
                "Sit, Stay, Roll");
        iAnimal animal8 = animalFactory.Create(Animal.Cat, "Olivier", new Date(120, 06, 30),
                "Meow, Scratch, Jump");
        iAnimal animal9 = animalFactory.Create(Animal.Horse, "Thunder", new Date(115, 07, 21),
                "Trot, Canter, Gallop");
        iAnimal animal10 = animalFactory.Create(Animal.Camel, "Sandy", new Date(116, 11, 03),
                "Walk, Carry Load");
        iAnimal animal11 = animalFactory.Create(Animal.Donkey, "Eeyore", new Date(117, 9, 18),
                "Walk, Carry Load, Bray");
        iAnimal animal12 = animalFactory.Create(Animal.Horse, "Storm", new Date(114, 5, 05),
                "Trot, Canter");
        iAnimal animal13 = animalFactory.Create(Animal.Camel, "Dune", new Date(118, 12, 12),
                "Walk, Sit");
        iAnimal animal14 = animalFactory.Create(Animal.Donkey, "Burro", new Date(119, 1, 23),
                "Walk, Bray, Kick");
        iAnimal animal15 = animalFactory.Create(Animal.Horse, "Blaze", new Date(116, 2, 29),
                "Trot, Jump, Gallop");
        iAnimal animal16 = animalFactory.Create(Animal.Camel, "Sahara", new Date(115, 8, 14),
                "Walk, Run");
        HashMap<Integer, iAnimal> animalHashMap = new HashMap<Integer, iAnimal>();
        Reestr reestr = new Reestr(animalHashMap);
        reestr.addAnimal(animal1);
        reestr.addAnimal(animal2);
        reestr.addAnimal(animal3);
        reestr.addAnimal(animal4);
        reestr.addAnimal(animal5);
        reestr.addAnimal(animal6);
        reestr.addAnimal(animal7);
        reestr.addAnimal(animal8);
        reestr.addAnimal(animal9);
        reestr.addAnimal(animal10);
        reestr.addAnimal(animal11);
        reestr.addAnimal(animal12);
        reestr.addAnimal(animal13);
        reestr.addAnimal(animal14);
        reestr.addAnimal(animal15);
        reestr.addAnimal(animal16);
        int choice = 1;
        while (choice != 7)
        {
            choice = choice_list();
            menu(choice, reestr, animalHashMap, animalFactory);
        }
    }
        public static int choice_list(){
            System.out.println("Консольное приложение 'Реестр животных'.");
            System.out.println("1. Просмотр списка всех животных в реестре");
            System.out.println("2. Добавление нового животного в реестр");
            System.out.println("3. Вывод всех команд для выбранного животного");
            System.out.println("4. Обучение выбранного животного новым командам");
            System.out.println("5. Вывод всех животных по дате рождения");
            System.out.println("6. Вывод количества всех животных в реестре");
            System.out.println("7. Выход из приложения");
            System.out.print("Выберите один из пунктов меню: ");
            String choice_str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(choice_str);
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число, повторите ввод");
                choice_list();
            }
            return 0;
        }

    public static void menu(int choice, Reestr reestr,  HashMap<Integer, iAnimal> animalHashMap, AnimalFactory animalFactory){
        if (choice == 1){
            ViewReestr(reestr);
        }
        else if (choice == 2) {
            AddAnimal(animalHashMap, animalFactory, reestr);
        }
        else if (choice == 3) {
            ViewCommands(animalHashMap, reestr);
        }
        else if (choice == 4) {
            TeachNewCommands(animalHashMap, reestr);
        }
        else if (choice == 5) {
            printSortedByBirthdate(animalHashMap, reestr);
        }
        else if (choice == 6) {
            countAllAnimals(reestr);
        }
        else if (choice == 7) {
            System.out.println("Приложение завершает работу");
        }
        else {
            System.out.println("Неверно введена команда, повторите выбор");
            int choice_new = choice_list();
        }
    }

    private static void countAllAnimals(Reestr reestr) {
        System.out.println("Всего в реестре зарегестрировано " + reestr.countAnimals() + " животных");
    }

    private static void printSortedByBirthdate(HashMap<Integer, iAnimal> animalHashMap, Reestr reestr) {
        ArrayList<iAnimal> animalArrayList = new ArrayList<>();

        for (int i = 1; i < reestr.countAnimals()+1; i++) {
            animalArrayList.add(animalHashMap.get(i));
        }
        animalArrayList.stream().sorted((a,b) -> a.getBirthDate().compareTo(b.getBirthDate())).
                forEach(a -> System.out.println(a.toString()));
    }

    private static void TeachNewCommands(HashMap<Integer, iAnimal> animalHashMap, Reestr reestr) {
        Integer numberAnimal = ViewCommands(animalHashMap, reestr);
        String commandsAnimal = animalHashMap.get(numberAnimal).getCommands();
        boolean isCorrectInput = false;
        while (!isCorrectInput){
            System.out.println("Введите новую команду");
            String comm = iScanner.nextLine();
            if (comm != null){
                isCorrectInput = true;
                commandsAnimal = commandsAnimal + " ," + comm;
            }
            else{
                System.out.println("Повторите ввод новой команды");
            }
        }
        animalHashMap.get(numberAnimal).setCommands(commandsAnimal);
        System.out.println(animalHashMap.get(numberAnimal).getCommands());

    }

    private static Integer ViewCommands(HashMap<Integer, iAnimal> animalHashMap, Reestr reestr) {
        boolean isCorrectNumber = false;
        int anInt = 0;
        while (!isCorrectNumber){
            System.out.println("Введите порядковый номер животного, для которого необходимо показать команды");
            String anNum = iScanner.nextLine();
            try {
                anInt = Integer.parseInt(anNum);
                if (anInt >= 1 && anInt <= reestr.countAnimals()){
                    isCorrectNumber = true;
                }
                else {
                    System.out.println("Живоного с таким порядковым номером не существует");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число, повторите ввод");
            }
        }
        System.out.println(animalHashMap.get(anInt).getCommands());
        return anInt;

    }

    private static void AddAnimal(HashMap<Integer, iAnimal> animalHashMap, AnimalFactory animalFactory, Reestr reestr) {
        System.out.println("Выберите какое животное вы хотите добавить");
        int i = 1;
        for (Animal an : Animal.values()) {
            System.out.println(i + ": " + an);
            i = i + 1;
        }
        boolean isCorrectNumber = false;
        int anInt = 0;
        while (!isCorrectNumber){
            System.out.println("Введите число от 1 до 6:");
            String anNum = iScanner.nextLine();
            try {
                anInt = Integer.parseInt(anNum);
                if (anInt >= 1 && anInt <= 6){
                    isCorrectNumber = true;
                }
                else {
                    System.out.println("Введеное число не в указаанном диапазоне");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число, повторите ввод");
            }
        }
        String animalType = "";
        if (anInt == 1){
            animalType = "Cat";
        } else if (anInt == 2) {
            animalType = "Dog";
        } else if (anInt == 3) {
        animalType = "Hamster";
        } else if (anInt == 4) {
            animalType = "Camel";
        } else if (anInt == 5) {
            animalType = "Donkey";
        } else if(anInt == 6) {
            animalType = "Horse";
        }
        System.out.println("Введите имя животного");
        String nameNewAnimal = iScanner.nextLine();
        System.out.println("Введите команды, которые может делать животное");
        String commandNewAnimal = iScanner.nextLine();
        boolean isCorrectDate = false;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date dateNew = new Date();
        while (!isCorrectDate){
            System.out.println("Введите дату рождения животного в формате dd.mm.yyyy(день.месяц.год)");
            String dateNewAnimal = iScanner.nextLine();
            try {
                dateNew = formatter.parse(dateNewAnimal);
                isCorrectDate = true;
            } catch (ParseException e) {
                System.out.println("Дата введена в неверном формате");
            }
        }
        iAnimal animalNew = animalFactory.Create(Animal.valueOf(animalType), nameNewAnimal, dateNew, commandNewAnimal);
        reestr.addAnimal(animalNew);
    }

    private static void ViewReestr(Reestr reestr) {
        System.out.println(reestr.toString());
    }


}
