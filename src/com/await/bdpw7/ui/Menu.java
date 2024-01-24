package com.await.bdpw7.ui;

import com.await.bdpw7.da.CRUD;

import java.util.Scanner;

public class Menu {
    static CRUD crud = new CRUD();

    public static void menu(){

        int mainMenu;
        Scanner mainInput = new Scanner(System.in);
        do{
            System.out.println("Вітаємо в центрі управління базою даних");
            System.out.println("[1] Додати товар");
            System.out.println("[2] Редагувати товар");
            System.out.println("[3] Переглянути товар");
            System.out.println("[4] Видалити товар");
            System.out.println("[5] Вийти з програми");

            mainMenu = mainInput.nextInt();
            switch (mainMenu){
                case 1:
                    insert();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    read();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Дякуємо що скористалися нашими послугами");
                    System.exit(5);
                    break;
            }
            if(mainMenu > 5){
                System.out.println();
                System.out.println("Введено хибні дані");
            }
        }while (mainMenu != 5);
    }

    public static void insert(){
        System.out.println("Введіть назву товара");
        Scanner goodsName = new Scanner(System.in);
        String name = goodsName.nextLine();

        System.out.println("Введіть ціну товара");
        Scanner goodsPrice = new Scanner(System.in);
        Double price = goodsPrice.nextDouble();

        try {
            crud.insert(name, price);
            System.out.println("Товар додано");
        }catch (Exception ex){
            System.out.println("Введено хибні дані");
            menu();
        }

        Menu.menu();
    }

    public static void update(){
        crud.read();

        System.out.println("Виберіть номер товара який змінете");
        Scanner goodsId = new Scanner(System.in);
        int id = goodsId.nextInt();

        System.out.println("Введіть назву товара");
        Scanner goodsName = new Scanner(System.in);
        String name = goodsName.nextLine();

        System.out.println("Введіть ціну товара");
        Scanner goodsPrice = new Scanner(System.in);
        Double price = goodsPrice.nextDouble();

        try {
            crud.update(id, name, price);
            System.out.println("Товар оновлено");
        }catch (Exception ex){
            System.out.println("Введено хибні дані");
            menu();
        }

        Menu.menu();
    }

    public static void read(){
        crud.read();
        Menu.menu();
    }

    public static void delete(){
        crud.read();

        System.out.println("Виберіть номер товара який хочете видалити: ");
        Scanner goodsId = new Scanner(System.in);
        int id = goodsId.nextInt();

        try {
            crud.delete(id);
            System.out.println("Товар видалено");
        }catch (Exception ex){
            System.out.println("Введено хибні дані");
            menu();
        }
        menu();
    }

}
