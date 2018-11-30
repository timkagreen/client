package main;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NetClientThread {
    public static void main(String[] args) {
        try {
            // установка соединения с сервером
            Socket s = new Socket(InetAddress.getLocalHost(), 8071);
            //или Socket s = new Socket("ИМЯ_СЕРВЕРА", 8071);

            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            //Растительное масло;
            String request = ";Яйцо куриное;Соль;Сахар;Молоко;Пшеничная мука;Гашеная сода;Растительное масло;Картофель;Говядина;Курица;Вода;Какао;Сода;Разрыхлитель;Ванилин;Ванильный сахар;Сливка;Сливочное масло;Подсолнечное масло;Перец;";
//            String request = "";
//            System.out.println("Введите ингредиенты. Для поиска ничего не вводить.");
//            String ing = scanner.nextLine();
//           while (!ing.isEmpty()){
//                request += ing + ";";
//                ing = scanner.nextLine();
//           }
            System.out.println("Поиск рецепта по ингредиентам \n" + request);
            ps.println(request);

            String[] recipes = br.readLine().split(";");
            for (int i = 0; i < recipes.length; i++) {
                System.out.println("*************************************");
                System.out.println(recipes[i]);
            }

            Thread.sleep(1000);


            s.close();

        } catch (UnknownHostException e) {
            // если не удалось соединиться с сервером
            System.out.println("адрес недоступен");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ошибка I/О потока");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("ошибка потока выполнения");
            e.printStackTrace();
        }
    }
}
