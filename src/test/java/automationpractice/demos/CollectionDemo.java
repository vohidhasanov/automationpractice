package automationpractice.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CollectionDemo {

    public static void main(String[] args) {

        ArrayList<String> myToDoList = new ArrayList ();
        myToDoList.add("do grocery");
        myToDoList.add("car wash");
        myToDoList.add("laundry");

//        for (String list: myToDoList)
//        {        System.out.println(list);     }

        Set<String> setList = new HashSet<>();
        setList.add("do grocery");
        setList.add("car wash");
        setList.add("laundry");
        setList.add("laundry");
        setList.add("laundry");


//        for (String s : setList)
//        {    System.out.println(s);     }

//        Iterator it = setList.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        setList.forEach(data-> {
            System.out.println(data);
        });





    }

}
