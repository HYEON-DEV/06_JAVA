package com.megaitacademy.packageex.impl;

import com.megaitacademy.packageex.IFight;
import com.megaitacademy.packageex.IMove;
import com.megaitacademy.packageex.IMovement;
import com.megaitacademy.packageex.Unit;

public class MainChar extends Unit implements IMove, IFight, IMovement {

    public MainChar(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    @Override
    public void attack() {
        System.out.printf("[MainChar]  %s가 %d의 힘으로 주인공 공격\n", this.getName(), this.getDps());
    }

    @Override
    public void defense() {
        System.out.printf("[MainChar]  %s가 주인공의 공격 방어\n", this.getName());
    }

    @Override
    public void evasion() {
        System.out.printf("[MainChar]  %s가 주인공 공격 회피\n", this.getName());
    }

    @Override
    public void walk() {
        System.out.printf("[MainChar]  %s가 주변을 배회\n", this.getName());
    }

    @Override
    public void run() {
        System.out.printf("[MainChar]  %s가 주변을 뛰면서 배회\n", this.getName());
    }

    @Override
    public void jump() {
        System.out.printf("[MainChar]  %s가 주변에서 점프\n", this.getName());
    }

    @Override
    public void pickUpItem() {
        System.out.printf("[Main] %s가 %d의 속력으로 걷는다\n",this.getName(), this.getSpeed());
    }

    @Override
    public void talkNpc() {
        System.out.printf("[Main] %s가 %d와 대화 중\n",this.getName(), this.getSpeed());
    }
    
}
