package com.pattern.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String message);
}

interface Subject{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(String message);
}

class YoutubeChannel implements Subject{
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObserver(String message) {
        for(Observer o:subscribers){
            o.update(message);
        }
    }  
    
    public void uploadVideo(String title){
        System.out.println("New video uploaded: "+title);
        System.out.println("New video available: "+title);
    }
}

class Subscriber implements Observer{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recieved notifications " + message);
    }
} 

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();
        Observer user1 = new Subscriber("Alice");
        Observer user2 = new Subscriber("Bob");
        Observer user3 = new Subscriber("Charlie");
        
        channel.addObserver(user1);
        channel.addObserver(user2);
        channel.addObserver(user3);
        
        channel.uploadVideo("Observer pattern tutorial");
        System.out.println("Bob unsubscribes...");
        channel.removeObserver(user2);
        
        channel.uploadVideo("Proxy Pattern tutorial");
    }
}
