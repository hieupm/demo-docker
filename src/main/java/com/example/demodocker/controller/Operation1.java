package com.example.demodocker.controller;

public class Operation1 {
    int data = 50;

    void change(int data) {
        data = data + 100;
    }

    public static void main(String args[]) {
        Operation1 op = new Operation1();

        System.out.println("Trước khi thay đổi: " + op.data);
        op.change(500);
        System.out.println("Sau khi thay đổi: " + op.data);
    }
}
