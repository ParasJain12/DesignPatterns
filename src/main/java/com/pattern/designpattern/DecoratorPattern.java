package com.pattern.designpattern;

interface Coffee{
    String getDescription();
    double getCost();
}

class PlainCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Plain coffee";
    }

    @Override
    public double getCost() {
        return 50.0;
    } 
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }
    
    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription();
    }
    
    @Override
    public double getCost(){
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    
    @Override
    public String getDescription(){
        return super.getDescription() + " ,Milk";
    }
    
    @Override
    public double getCost(){
        return super.getCost() + 10.0;
    }
}

class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    
    @Override
    public String getDescription(){
        return super.getDescription() + " ,Sugar";
    }
    
    @Override
    public double getCost(){
        return super.getCost() + 5.0;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new PlainCoffee();
        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());
        
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());
        
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());
        
    }
}
