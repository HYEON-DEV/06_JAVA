/**
 * 게임 중 캐릭터가 구현해야 하는 전투 관련 기능 나열
 */
public interface IFight {
    /** 공격하다 */
    public void attack();
    /** 방어하다 */
    public void defense();
    /** 회피하다 */
    public void evasion();
}
