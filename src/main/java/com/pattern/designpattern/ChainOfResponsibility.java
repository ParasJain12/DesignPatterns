package com.pattern.designpattern;

abstract class Handler{
    protected Handler nextHandler;
    
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    public abstract void handleRequest(String request);
}

class Level1Support extends Handler{
    
    @Override
    public void handleRequest(String request){
        if(request.equalsIgnoreCase("Password reset")){
            System.out.println("Level 1 Handled: "+request);
        }else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}

class Level2Support extends Handler{
    
    @Override
    public void handleRequest(String request){
        if(request.equalsIgnoreCase("Software installation")){
            System.out.println("Level 2 Handled: "+request);
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}

class Level3Support extends Handler{
    
    @Override
    public void handleRequest(String request){
        if(request.equalsIgnoreCase("Server issue")){
            System.out.println("Level 3 Handled: "+request);
        }else {
            System.out.println("Request not handled: "+request);
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler level1 = new Level1Support();
        Handler level2 = new Level2Support();
        Handler level3 = new Level3Support();
        
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        
        level1.handleRequest("Password reset");
        level1.handleRequest("Software installation");
        level1.handleRequest("Server issue");
        level1.handleRequest("Network issue");
    }
}
