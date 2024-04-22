package strategy_pattern.init_version;

public class WaterBall implements Skill{

    private static int WATER_BALL_ATTACK_MP = 5;
    private static int WATER_BALL_ATTACK_RATE = 2;

    @Override
    public String toString() {
        return "水球攻擊";
    }

    @Override
    public int attack(Hero selfHero, Hero otherHero) {
        if (selfHero.getMp() < WATER_BALL_ATTACK_MP) {
            System.out.println("MP不足, 跳過攻擊");
            return -1;
        } else {
            selfHero.lostMP(WATER_BALL_ATTACK_MP);
        }
        int damaged = selfHero.getWisdom() * WATER_BALL_ATTACK_RATE;
        otherHero.lostHP(damaged);
        return damaged;
//        System.out.println(String.format("%s 水球攻擊", selfHero.getName()));
//        if (selfHero.getMp() < WATER_BALL_ATTACK_MP) {
//            System.out.println("MP不足, 跳過攻擊");
//            return;
//        } else {
//            selfHero.setMp(selfHero.getMp() - WATER_BALL_ATTACK_MP);
//        }
//        int damaged = selfHero.getWisdom() * WATER_BALL_ATTACK_RATE;
//        System.out.println(String.format("造成 %s 傷害", damaged));
//        int otherHeroLastHp = otherHero.getHp() - damaged;
//        Hero.damagedCalculate(selfHero, otherHero, otherHeroLastHp);
    }

}
