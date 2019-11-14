package warm_up_tasks;

import Utils.Common;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WarmUpDay77  {

    @Test
    public void mapTask() {
        Map <Integer, String> myList = new HashMap<Integer, String>();
//        myList.put(10, "One");
//        myList.put(20, "Two");
//        myList.put(30, "Three");
//        myList.put(40, "Four");
//        myList.put(50, "Five");

            for (int index =1; index<=5; index++) {
                myList.put(Common.getRandomInt(0,60), Common.getRandomFirstName());
    }

            for (Map.Entry<Integer, String> map : myList.entrySet())
            {
                System.out.println(map.getKey()+ " "+ map.getValue());
            }

//        Iterator it = myList.entrySet().iterator();
        Set<Integer> keys = myList.keySet();
        int result = 0;

//        while (it.hasNext()) {
////            Map.Entry pair = (Map.Entry) it.next();
////            int result2 = (int) pair.getKey();
////            result= result +result2;
////        }
 //       System.out.println(result);

        for (Integer key: keys) {
            result = result+key;
        }

        System.out.println(result);

    }


}
