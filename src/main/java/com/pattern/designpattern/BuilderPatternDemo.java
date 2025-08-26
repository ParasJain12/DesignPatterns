package com.pattern.designpattern;

class Burger{
    private String bread;
    private String sauce;
    private String patty;
    
    private Burger(BurgerBuilder builder){
        this.bread = builder.bread;
        this.sauce = builder.sauce;
        this.patty = builder.patty;
    }

    @Override
    public String toString() {
        return "Burger{" + "bread=" + bread + ", sauce=" + sauce + ", patty=" + patty + '}';
    }
    
    public static class BurgerBuilder{
        private String bread;
        private String sauce;
        private String patty;
        
        public BurgerBuilder setBread(String bread){
            this.bread = bread;
            return this;
        }
        
        public BurgerBuilder setSauce(String sauce){
            this.sauce = sauce;
            return this;
        }
        
        public BurgerBuilder setPatty(String patty){
            this.patty = patty;
            return this;
        }
        
        public Burger build(){
            return new Burger(this);
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder()
                            .setBread("Wheat")
                            .setPatty("Normal")
                            .setSauce("Mayo")
                            .build();
        System.out.println(burger);
    }
}
