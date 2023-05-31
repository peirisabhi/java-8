package org.example.lambda;


import java.util.function.Function;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 17/05/2023
 * Time: 09:54
 */
public class Test {
    public static void main(String[] args) {

        MyFunction myFunction = (i) -> System.out.println("test .. " + i);
        myFunction.test(10);

        T1 t1 = () ->System.out.println("Test printed");
        t1.test1();


        Function function = (t) -> "output : "+t;
        System.out.println(function.apply(10));

    }
}



interface T1{
    void test1();
}
