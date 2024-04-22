package strategy_pattern.init_version;

public class Kick implements Skill{

    private static int KICK_ATTACK_RATE = 2;
    @Override
    public int attack(Hero selfHero, Hero otherHero) {
        int injury = otherHero.getDefense() - (selfHero.getStrength() * KICK_ATTACK_RATE);
        otherHero.lostHP(injury);
        return injury;
    }

    @Override
    public String toString() {
        return "飛踢攻擊";
    }
}
