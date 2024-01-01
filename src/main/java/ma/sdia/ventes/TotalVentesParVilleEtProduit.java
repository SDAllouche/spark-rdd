package ma.sdia.ventes;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TotalVentesParVilleEtProduit {
    public static void main(String[] args) {
        SparkConf configuration=new SparkConf().setAppName("Ventes").setMaster("local[*]");
        JavaSparkContext sc=new JavaSparkContext(configuration);

        JavaRDD<String> RDD = sc.textFile("ventes.txt");

        JavaRDD<String> RDD2 = RDD.map(ligne -> {
            String[] split = ligne.split(" ");
            String ville = Arrays.stream(split).collect(Collectors.toList()).get(1);
            double price = Double.parseDouble(split[3]);
            String Date = Arrays.stream(split).collect(Collectors.toList()).get(0);
            return Date +" "+ville +" "+ price;
        });

        JavaPairRDD<String, String> rdd = RDD2.mapToPair(s -> new Tuple2<>(Arrays.stream(Arrays.stream(s.split(" "))
                .collect(Collectors.toList()).get(0).split("-")).collect(Collectors.toList()).get(0) +" "+
                Arrays.stream(s.split(" ")).collect(Collectors.toList()).get(1), Arrays.stream(s.split(" "))
                .collect(Collectors.toList()).get(2)));

        JavaPairRDD<String, String> RDD4 = rdd.reduceByKey((price1, price2) ->
                String.valueOf(Double.parseDouble(price1) + Double.parseDouble(price2))
        );

        RDD4.foreach(s->{
            System.out.println(s);
        });


    }
}
