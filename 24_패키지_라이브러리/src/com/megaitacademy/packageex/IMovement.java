package com.megaitacademy.packageex;
/**
 * 게임 중 캐릭터가 구현해야 하는 기본 동작 관련 기능 나열
 */
public interface IMovement {
    /** 아이템 획득 */
    public void pickUpItem();
    /** NPC와 대화하기 */
    public void talkNpc();
}
