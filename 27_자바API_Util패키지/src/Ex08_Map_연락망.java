import java.util.HashMap;
import java.util.Map;

class Member {
    private String phoneNo;
    private String email;

    public Member(String phoneNo, String email) {
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " phoneNo='" + phoneNo + "'" +
            ", email='" + email + "'" +
            "}";
    }

}

public class Ex08_Map_연락망 {
    public static void main(String[] args) {
        Map<String, Member> map = new HashMap<String, Member>();

        Member mem1 = new Member("010-1234-5678", "ck@gmail.com");
        map.put("창기",mem1);

        map.put("성주", new Member("010-5678-9999", "sj@gmail.com"));
        map.put("현수", new Member("010-5678-9999", "hs@gmail.com"));
        map.put("보경", new Member("010-5678-9999", "sj@gmail.com"));
        map.put("지환", new Member("010-5678-9999", "sj@gmail.com"));

        System.out.println(map);

        Member output = map.get("성주");
        System.out.println(output.toString());
    }
}
