package s01.strings;

/**
 * Created by Tommy on 2019/8/28.
 */
public class ReverseWords {
    public static void  main(String[] args) {
        String str = "Let's take LeetCode contest";
        String[] arr = str.split(" ");
        String newStr = "";
        for(int i = 0; i<arr.length; i++ ){
            StringBuilder s =  new StringBuilder(arr[i]);
            newStr =newStr+  String.valueOf(s.reverse()) + " ";
        }

        System.out.println(newStr);







    }
}
