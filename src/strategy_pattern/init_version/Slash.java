package strategy_pattern.init_version;

public class Slash implements Skill{

    @Override
    public String toString() {
        return "斬擊";
    }

    @Override
    public int attack(Hero selfHero, Hero otherHero) {
        int damaged = selfHero.getStrength() - otherHero.getDefense();
        otherHero.lostHP(damaged);
        return damaged;

//        System.out.print(selfHero.getName() + " 使出衝撞攻擊");
//        if(damaged > 0){
//            System.out.println(String.format(" 造成 %s 傷害", damaged));
//            int otherHeroLastHp = otherHero.getHp() - damaged;
//            Hero.damagedCalculate(selfHero, otherHero, otherHeroLastHp);
//        } else {
//            System.out.print(String.format("%s 防禦太高, %s 獲勝", otherHero.getName(), otherHero.getName() ));
//            return;
//        }
    }
}
