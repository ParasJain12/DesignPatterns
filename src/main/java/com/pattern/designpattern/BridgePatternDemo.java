package com.pattern.designpattern;

interface Device{
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class TV implements Device{
    @Override
    public void turnOn(){
        System.out.println("TV is on");
    }
    
    @Override
    public void turnOff(){
        System.out.println("TV is off");
    }
    
    @Override
    public void setVolume(int level){
        System.out.println("TV Volume set to " + level);
    }
}

class Radio implements Device{
    @Override
    public void turnOn(){
        System.out.println("Radio is on");
    }
    
    @Override
    public void turnOff(){
        System.out.println("Radio is off");
    }
    
    @Override
    public void setVolume(int level){
        System.out.println("Radio Volume set to " + level);
    }
}

abstract class RemoteControl{
    protected Device device;
    
    public RemoteControl(Device device){
        this.device = device;
    }
    
    abstract void powerOn();
    abstract void powerOff();
    abstract void volumeUp();
}

class AdvancedRemote extends RemoteControl{
    public AdvancedRemote(Device device){
        super(device);
    }

    @Override
    void powerOn() {
        device.turnOn();
    }

    @Override
    void powerOff() {
        device.turnOff();
    }

    @Override
    void volumeUp() {
        device.setVolume(10);
    }   
}

public class BridgePatternDemo {
    
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();
        
        RemoteControl tvRemote = new AdvancedRemote(tv);
        tvRemote.powerOn();
        tvRemote.volumeUp();
        tvRemote.powerOff();
        
        System.out.println("-----------------");
        
        RemoteControl radioRemote = new AdvancedRemote(radio);
        radioRemote.powerOn();
        radioRemote.volumeUp();
        radioRemote.powerOff();
    }
}
