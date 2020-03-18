package com.company;

public class Something {
    @Timer
    public static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println( "Method print  "+i );
        }
    }
     @Timer
    public  static  void printMore(){
         for (int i = 10; i < 110; i++) {
             System.out.println( "Method printMore  "+i );
         }
     }

    public static void notTimed() {
        System.out.println("The not timed function");
    }
}
