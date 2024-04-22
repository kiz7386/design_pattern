package strategy_pattern.init_version;

public class Hero {
    private String name;
    private int hp;
    private int mp;
    private int strength;
    private int wisdom;
    private int defense;
    private Skill skill;

    public Hero(){

    }

    public Hero(String name,int hp, int mp, int strength, int wisdom, int defense, Skill skill) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
        this.wisdom = wisdom;
        this.defense = defense;
        this.skill = skill;
    }
    public void attack(Hero targetHero){
        int injury = this.skill.attack(this, targetHero);
        System.out.println(String.format("%s 使出了 %s, 造成 %s 傷害", this.getName(), this.skill, injury));
        System.out.println(String.format("%s 的hp剩下 %s", targetHero.getName(), targetHero.getHp()));
    }

    public boolean isAlive(){
        return this.hp >0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void lostHP(int injury){
        this.hp = this.hp - injury;
    }

    public void lostMP(int lostMP){
        this.mp = this.mp - lostMP;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hp=" + hp +
                ", mp=" + mp +
                ", strength=" + strength +
                ", wisdom=" + wisdom +
                ", defense=" + defense +
                '}';
    }

    public static void damagedCalculate(Hero selfHero, Hero otherHero, int otherHeroLastHp){
        if(otherHeroLastHp > 0) {
            System.out.println(String.format("%s HP剩餘%s, MP剩餘%s", otherHero.getName(), otherHeroLastHp, otherHero.getMp()));
        } else {
            System.out.println(String.format("%s HP不足, 恭喜%s勝利", otherHero.getName(), selfHero.getName()));
        }
        otherHero.setHp(otherHeroLastHp);
    }
}
