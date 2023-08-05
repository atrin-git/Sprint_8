package org.example;

public class Praktikum {
    public static void main(String[] args) {
        String holderName = "Тимоти Шаламе";
        Account account = new Account(holderName);

        System.out.println(account.checkNameToEmboss());
    }
}
