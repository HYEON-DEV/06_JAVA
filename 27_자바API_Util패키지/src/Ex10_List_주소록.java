import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String phoneNo;
    private String email;

    public User(String name, String phoneNo, String email) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + name + "'" +
            ", phoneNo='" + phoneNo + "'" +
            ", email='" + email + "'" +
            "}";
    }
}

public class Ex10_List_주소록 {
    public static void main(String[] args) {
        
        List<User> list = new ArrayList<User>();

        list.add( new User("동원", "010-1234-5678", "lg@gmail.com") );
        list.add( new User("본혁", "010-1234-5678", "lg@gmail.com") );
        list.add( new User("해민", "010-1234-5678", "lg@gmail.com") );
        list.add( new User("영빈", "010-1234-5678", "lg@gmail.com") );
        list.add( new User("원영", "010-1234-5678", "lg@gmail.com") );
        System.out.println(list);

        for ( int i=0; i<list.size(); i++ ) {
            User item = list.get(i);
            System.out.println(item.toString());
        }

    }
}
