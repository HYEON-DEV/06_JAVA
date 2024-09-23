public class Exercise_02 {
    public static void main(String[] args) {
        Food chicken = new Food("치킨", 18000);
        Food pizza = new Food("피자", 28000);
        Food sushi = new Food("초밥세트", 22000);

        System.out.println(chicken.toString());
        System.out.println(pizza.toString());
        System.out.println(sushi.toString());
    }   
}
