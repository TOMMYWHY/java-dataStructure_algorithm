package deginPatterns.singleton;

/**
 * Created by Tommy on 2019/8/24.
 */
public class SingleTon {
//     private static SingleTon singleInstance =  new SingleTon();
     private static SingleTon singleInstance ;


    public static SingleTon getSingleInstance(){
        if(singleInstance == null){
            singleInstance = new SingleTon();
        }

        return singleInstance;
    }
    private SingleTon(){
        System.out.println("I am a singleton");
    }

}


