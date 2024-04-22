package strategy_pattern.init_version;

import java.util.Random;

public class Class1_Demo {
    public static void main(String[] args) {
        Random random = new Random();

        Hero swordsman = new Hero("劍士", Math.abs(random.nextInt()), Math.abs(random.nextInt()), Math.abs(random.nextInt()) / 10, Math.abs(random.nextInt()) / 10, Math.abs(random.nextInt()) / 10, new Slash());
        Hero magician = new Hero("格鬥家", Math.abs(random.nextInt()), Math.abs(random.nextInt()), Math.abs(random.nextInt()) / 10, Math.abs(random.nextInt()) / 10, Math.abs(random.nextInt()) / 10, new Kick());
        System.out.println("戰鬥開始");
        System.out.println(swordsman.getName() +swordsman.toString());
        System.out.println(magician.getName()+magician.toString());
        while (swordsman.isAlive() && magician.isAlive()){
            if(swordsman.getHp() < magician.getHp()){
                swordsman.attack(magician);
            } else {
                magician.attack(swordsman);
            }
            if(!swordsman.isAlive() || !magician.isAlive())
                break;
        }
    }
}
