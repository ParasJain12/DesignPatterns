package com.pattern.designpattern;

interface Button{
    void click();
}

interface Checkbox{
    void check();
}

class WinButton implements Button{
    
    @Override
    public void click(){
        System.out.println("Windows Button clicked");
    }
}

class WinCheckbox implements Checkbox{
    
    @Override
    public void check(){
        System.out.println("Windows Checkbox checked");
    }
}

class MacButton implements Button{
    
    @Override
    public void click(){
        System.out.println("Mac Button clicked");
    }
}

class MacCheckbox implements Checkbox{
    
    @Override
    public void check(){
        System.out.println("Mac Checkbox checked");
    }
}

// Abstract factory
interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WinFactory implements GUIFactory{
    
    @Override
    public Button createButton(){
        return new WinButton();
    }
    
    @Override
    public Checkbox createCheckbox(){
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory{
    
    @Override
    public Button createButton(){
        return new MacButton();
    }
    
    @Override
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}

// Client code use factory, not concreate classes
public class AbstractFactoryPatternDemo {
    
    public static void main(String[] args) {
        GUIFactory factory = new WinFactory();
        Button btn = factory.createButton();
        Checkbox chk = factory.createCheckbox();
        
        btn.click();
        chk.check();
        
        factory = new MacFactory();
        Button btn1 = factory.createButton();
        Checkbox chk1 = factory.createCheckbox();
        
        btn1.click();
        chk1.check();
    }
}
