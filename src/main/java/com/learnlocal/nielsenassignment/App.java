package com.learnlocal.nielsenassignment;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Map<String,Map<Integer,Integer>> regionGradesV2=new HashMap<>();
        regionGradesV2.putIfAbsent ("x",new HashMap<>());
        regionGradesV2.putIfAbsent ("x",new HashMap<>());
        regionGradesV2.putIfAbsent ("y",new HashMap<>());
        regionGradesV2.get("x").merge(1,1,Integer::sum);
        regionGradesV2.get("x").merge(1,1,Integer::sum);
        regionGradesV2.get("x").merge(2,1,Integer::sum);

        regionGradesV2.get("y").merge(1,1,Integer::sum);
        regionGradesV2.get("y").merge(1,1,Integer::sum);
        regionGradesV2.get("y").merge(2,1,Integer::sum);
        
        AtomicInteger sumAllGradeRegions=new AtomicInteger();
        AtomicInteger sumAllStudentsCounter=new AtomicInteger();
        regionGradesV2.forEach((k,v) -> {
            AtomicInteger sumGradeRegion= new AtomicInteger();
            AtomicInteger sumStudentsCounter= new AtomicInteger();
            v.forEach((k2,v2) ->{
                        sumGradeRegion.addAndGet(k2 * v2);
                        sumStudentsCounter.addAndGet(v2);
                    }
                    );
            sumAllGradeRegions.addAndGet(sumGradeRegion.get());
            sumAllStudentsCounter.addAndGet(sumStudentsCounter.get());
            System.out.println("Region " + k + " Average score: " + sumGradeRegion.get()/ sumStudentsCounter.get());
        })        ;
        System.out.println("Average all region score: " + sumAllGradeRegions.get()/ sumAllStudentsCounter.get());

    }
}
