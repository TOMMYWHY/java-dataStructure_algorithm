package s01.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {

    public Object getBean (String className){
        Object obj = null;
        Scanner input = new Scanner(System.in);
        System.out.println("give a param for : " + className);
        try {
            Class clazz =  Class.forName(className);
            obj = clazz.newInstance(); //IOC
            // 私有属性 => 获取属性字段 => set 属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field :fields){
                String fieldName =  field.getName();
                String firstLetter =   fieldName.substring(0,1).toUpperCase();
                String otherLetters =  fieldName.substring(1);
                StringBuilder setMethodName = new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetters);
                Class fieldClass =  field.getType();

                Method setMethod = clazz.getMethod(setMethodName.toString(),fieldClass);
                System.out.println("give a field value for : " + fieldName);
                String value = input.nextLine();
                Constructor con =  fieldClass.getConstructor(String.class);

                 setMethod.invoke(obj,   con.newInstance(value));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
