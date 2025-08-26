package com.pattern.designpattern;

interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape{
    public void draw(){
        System.out.println("Drawing a square");
    }
}

class Rectangle implements Shape{
    public void draw(){
        System.out.println("Drawing a rectangle");
    }
}

// Creating a factory to generate objects
class ShapeFactory{

    //Factory methods
    public static Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

// Use the factory
public class FactoryPatternDemo{
    public static void main(String args[]){
        ShapeFactory factory = new ShapeFactory();

        // get an object of Circle and call its method
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // get an object of Rectangle and call its method
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // get an object of Square and call its method
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }
}