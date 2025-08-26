package com.pattern.designpattern;

interface Prototype{
    Prototype clone();
}

class Student implements Prototype{
    private String name;
    private int age;
    
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public void showDetails(){
        System.out.println("Student name: "+name + " Age: "+age);
    }
    
    @Override
    public Prototype clone(){
        return new Student(name,age);
    }
}

public class PrototypePatternDemo {
    
    public static void main(String[] args) {
        Student s1 = new Student("Alice",12);
        s1.showDetails();
        
        Student s2 = (Student)s1.clone();
        s2.showDetails();
        
        Student s3 = new Student("Bob",14);
        s3.showDetails();
    }
}
