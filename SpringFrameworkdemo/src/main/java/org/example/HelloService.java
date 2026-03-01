package org.example;

public class HelloService {
    private String message;
    public HelloService(String message){
        this.message=message;
    }
    public HelloService(){

    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public void sayHello(){
        System.out.println("Message: "+message);
    }
}
