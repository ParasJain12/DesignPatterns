package com.pattern.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Internet{
    void connectTo(String serverHost) throws Exception;
}

class RealInternet implements Internet{
    public void connectTo(String serverHost){
        System.out.println("Connecting to: "+serverHost);
    }
}

class ProxyInternet implements Internet{
    private Internet realInternet = new RealInternet();
    private static List<String> bannedSites;
    
    static{
        bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("xyz.com");
    }
    
    @Override
    public void connectTo(String serverHost) throws Exception{
        if(bannedSites.contains(serverHost.toLowerCase())){
            throw new Exception("Access denied to: "+serverHost);
        }
        realInternet.connectTo(serverHost);
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try{
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
