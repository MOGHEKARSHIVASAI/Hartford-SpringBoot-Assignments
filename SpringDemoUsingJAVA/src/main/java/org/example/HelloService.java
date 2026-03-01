package org.example;

public class HelloService {

    private String message;
    public HelloService(String message){
        this.message = message;
    }

    public void sayHello(){
        System.out.println(this.message);
    }
}
