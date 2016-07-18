/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commands.Command;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author vasovourka
 */
public class StackCommand {

    public static void showpush(Stack st, Command com) {
        st.push(com);
        System.out.println("push(" + com.getName() + ")");
        System.out.println("push(" + com.getType() + ")");
        System.out.println("push(" + com.getSource() + ")");

        System.out.println("stack: " + st);
    }

    public static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    /*  public static void main(String args[]) {
     Stack st = new Stack();
     System.out.println("stack: " + st);
     showpush(st, 42);
     showpush(st, 66);
     showpush(st, 99);
     showpop(st);
     showpop(st);
     showpop(st);
     try {
     showpop(st);
     } catch (EmptyStackException e) {
     System.out.println("empty stack");
     }
     }*/
}
