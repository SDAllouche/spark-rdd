package ma.sdia.lignage;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LignageApp {
    public static void main(String[] args) {
        SparkConf configuration=new SparkConf().setAppName("Students").setMaster("local[*]");
        JavaSparkContext sc=new JavaSparkContext(configuration);

        List<String> names = Arrays.asList("Lila Thompson", "Ethan Blackwell", "Maya Rodriguez", "Oliver Mercer",
                "Zoe Carter", "Caleb Whitman", "Ava Montgomery", "Liam Donovan", "Isabella Chang", "Noah Harrington");

        JavaRDD<String> RDD1 = sc.parallelize(names);
        List<String> list1 = RDD1.collect();
        System.out.println("********** RDD 1 **********");
        list1.forEach(System.out::println);

        JavaRDD<String> RDD2 = RDD1.flatMap(name -> {
            List<String> LastNames = new ArrayList<>();
            String[] strings = name.split(" ");
            String s = Arrays.stream(strings).collect(Collectors.toList()).get(1);
            LastNames.add(s);
            return LastNames.iterator();});
        List<String> list2 = RDD2.collect();
        System.out.println("********** RDD 2 **********");
        list2.forEach(System.out::println);

        JavaRDD<String> RDD3 = RDD2.filter(name -> {return name.length() > 6;});
        List<String> list3 = RDD3.collect();
        System.out.println("********** RDD3 **********");
        list3.forEach(System.out::println);

        JavaRDD<String> RDD4 = RDD2.filter(name -> {return name.contains("er");});
        List<String> list4 = RDD4.collect();
        System.out.println("********** RDD4 **********");
        list4.forEach(System.out::println);

        JavaRDD<String> RDD5 = RDD2.filter(name -> {return name.length()==7;});
        List<String> list5 = RDD5.collect();
        System.out.println("********** RDD5 **********");
        list5.forEach(System.out::println);

        JavaRDD<String> RDD6 = RDD3.union(RDD4);
        List<String> list6 = RDD6.collect();
        System.out.println("********** RDD6 **********");
        list6.forEach(System.out::println);

        JavaRDD<String> RDD7 = RDD5.map(m -> {return m+71;});
        List<String> list7 = RDD7.collect();
        System.out.println("********** RDD7 **********");
        list7.forEach(System.out::println);

        JavaPairRDD<String, Integer> PairRDD7 = RDD7.mapToPair(name -> new Tuple2<>(name, 1));
        List<Tuple2<String, Integer>> list77 = PairRDD7.collect();
        System.out.println("********** Pair RDD 7**********");
        list77.forEach(pair -> System.out.println(pair._1() + ": " + pair._2()));

        JavaRDD<String> RDD8 = RDD6.map(m -> {return m+81;});
        List<String> list8 = RDD8.collect();
        System.out.println("********** RDD8 **********");
        list8.forEach(System.out::println);

        JavaPairRDD<String, Integer> PairRDD8 = RDD8.mapToPair(name -> new Tuple2<>(name, 1));
        List<Tuple2<String, Integer>> list88 = PairRDD8.collect();
        System.out.println("********** Pair RDD 8 **********");
        list88.forEach(pair -> System.out.println(pair._1() + ": " + pair._2()));

        JavaPairRDD<String, Integer> RDD9 = PairRDD7.union(PairRDD8);
        List<Tuple2<String, Integer>> list9 = RDD9.collect();
        System.out.println("********** RDD 9 **********");
        list9.forEach(pair -> System.out.println(pair._1() + ": " + pair._2()));

        RDD9.sortByKey();
        List<Tuple2<String, Integer>> list99 = RDD9.collect();
        System.out.println("********** Sorted RDD 9 **********");
        list99.forEach(pair -> System.out.println(pair._1() + ": " + pair._2()));

    }
}
