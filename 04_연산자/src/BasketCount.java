public class BasketCount {
    public static void main(String[] args) {
        int numOfApples = 120;
        int sizeOfBucket = 10;
        // int rest = numOfApples%sizeOfBucket>0? 1: 0;
        // int numOfBucket = numOfApples/sizeOfBucket + rest;

        int divide = numOfApples/sizeOfBucket;
        int numOfBucket = numOfApples%10==0? divide : divide+1; 
        
        System.out.println("필요한 바구니의 수 : " + numOfBucket);
    }
}
