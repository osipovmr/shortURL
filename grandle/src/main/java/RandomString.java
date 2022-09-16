import java.util.Random;

public class RandomString {

        public static String createShortUrlRandom(){
            String symbol="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<6;i++){
                int number=random.nextInt(62);
                sb.append(symbol.charAt(number));
            }
            return sb.toString();
    }
}
