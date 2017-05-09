package com.company;

public class Main {

    public static void main(String[] args) {
	CoffeMachine saeco = new CoffeMachine();
	saeco.decreaseSugar();
	saeco.on();
	PhilipsCoffeMachine philips = new PhilipsCoffeMachine();
	philips.decreaseSugar();
	philips.chooseDrink(3);
	philips.on();
    }
}

class CoffeMachine implements SimpleCoffeMachine{
    private int currentWaterCapacity;
    final int MaxWaterCapacity = 4;
    private int currentSugarCapacity;
    final int MinSugarCapacity = 0;
    final int MaxSugarCapacity = 6;

    public CoffeMachine(){
        this.currentWaterCapacity = this.MaxWaterCapacity;
        this.currentSugarCapacity = 3;
    }

    public void on(){
        if(checkWater()){
            System.out.println("Ваш напиток готов, уважемый! Количество сахара в нем: " + this.currentSugarCapacity +".");
            this.currentWaterCapacity--;
        } else {
            System.out.println("Возможно, добавить воды не такая уж и плохая идея");
        }
    }

     public boolean checkWater(){
        if (this.currentWaterCapacity>0){
            return true;
        } else {
            return false;
        }
    }

    public void increaseSugar(){
         if (this.currentSugarCapacity<this.MaxSugarCapacity){
             this.currentSugarCapacity++;
         }
    }

    public void decreaseSugar(){
        if (this.currentSugarCapacity>this.MinSugarCapacity){
            this.currentSugarCapacity--;
        }
    }

    public void fillWater(){
        this.currentWaterCapacity = this.MaxWaterCapacity;
    }
}

class PhilipsCoffeMachine extends CoffeMachine implements  AdvancedCoffeMachine{
    private String[] drinks = {"Американо","Эспрессо","Латте","Капучино"};
    private String chosenDrink;

    public PhilipsCoffeMachine(){
        super();
        this.chosenDrink = this.drinks[0];
    }

    public void on(){
        super.on();
        System.out.println("Вы выбрали " + this.chosenDrink + ".");
    }

    public void chooseDrink(int drink){
        if (drink>this.drinks.length-1){
            System.out.println("Попробуй еще раз");
        } else {
            this.chosenDrink = this.drinks[drink];
        }
    }
}

interface SimpleCoffeMachine{
    void on();
    void increaseSugar();
    void decreaseSugar();
    void fillWater();
    boolean checkWater();
}

interface AdvancedCoffeMachine{
    void chooseDrink(int drink);
}