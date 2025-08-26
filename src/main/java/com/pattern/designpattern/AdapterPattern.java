package com.pattern.designpattern;

// Old interface (incompatible)
class OldCharger{
    public void chargeWithTwoPins(){
        System.out.println("Charging with 2 pin charger");
    }
}
    
// Target interface, what client expects
interface NewCharger{
    void chargeWithThreePins();
}

//make old charger compatible
class ChargerAdapter implements NewCharger{
    private OldCharger oldCharger;
    
    public ChargerAdapter(OldCharger oldCharger){
        this.oldCharger = oldCharger;
    }
    
    @Override
    public void chargeWithThreePins(){
        // adapting old 2 pin with 3 pin
        oldCharger.chargeWithTwoPins();
    }
}

//Client
public class AdapterPattern {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();
        NewCharger adapter = new ChargerAdapter(oldCharger);
        adapter.chargeWithThreePins();
    }
}
