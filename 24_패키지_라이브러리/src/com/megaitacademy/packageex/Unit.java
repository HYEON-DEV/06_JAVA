package com.megaitacademy.packageex;

/**
 * 게임 캐릭터의 기본 속성들을 정의하는 Beans
 */
public class Unit {
    
    private String name;
    private int hp;
    private int speed;
    private int dps;
    

    public Unit(String name, int hp, int speed, int dps) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.dps = dps;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDps() {
        return this.dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", hp='" + getHp() + "'" +
            ", speed='" + getSpeed() + "'" +
            ", dps='" + getDps() + "'" +
            "}";
    }
    
}
