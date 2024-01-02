# Spark RDD

## Introduction 
Spark is a universal parallel computing framework developed by the UC Berkeley AMPLab in 2009, was open sourced in early 2010, and moved to the Apache Software Foundation in 2013. It is a fast, versatile, and scalable memory-based big data computing engine.<br>
MapReduce-based computing engines typically output intermediate results to disks for storage and fault tolerance. Spark stores intermediate results in memory to reduce the I/O of the underlying storage system and improve the computing speed. It is a one-stop solution that integrates batch processing, real-time stream processing, interactive query, graph computing, and machine learning. Spark can process data requirements in different scenarios, including batch processing, interactive query, real-time stream processing, and machine learning. <br>
Spark not only outperforms MapReduce, but also is compatible with the Hadoop ecosystem. It can run on Hadoop HDFS to provide enhanced functions. To some extent, Spark replaces Hadoop MapReduce. It is still compatible with YARN and Apache Mesos in Hadoop so existing Hadoop users can easily migrate their workloads to Spark.It typical Use Cases :
- Batch processing can be used for extracting, transforming, and loading (ETL).
- Machine learning can be used to automatically determine whether the comments of online buyers are positive or negative.
- Interactive analysis can be used to query the Hive warehouse.
- Stream processing can be used for real-time businesses analysis (such as page-click streams), recommendation systems, and public opinion analysis.<br>

## Spark Core
It is similar to the distributed memory computing framework of MapReduce. The most striking feature of Spark Core is that it directly inputs the intermediate computing results into the memory to improve computing performance. In addition to the resource management framework in standalone mode, it also supports the resource 
management system of YARN and Mesos. FusionInsight integrates Spark on YARN. Other modes are currently not supported.

![image](https://github.com/SDAllouche/spark-rdd/assets/102489525/b738b03e-a74d-4697-90f9-49730a8704c1)

## Objective
- Create a Spark application that achieves this lineage.
![image](https://github.com/SDAllouche/spark-rdd/assets/102489525/4933e040-52f8-482b-8304-eb4989abec3c)

- Develop a Spark application allowing, from a text file (ventes.txt) as input, containing the sales of a company in different cities, to determine the total sales by city. The structure of the file is of the following form: date city product price. Then, create a second application to calculate the total price of product sales by city for a given year.

## Application
1. Lineage
<table >
    <thead>
        <tr>
            <th>RDD 1</th>
            <th>RDD 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/1.png"></td>
            <td><img src="screenshots/2.png"></td>
        </tr>
    </tbody>
   <thead>
        <tr>
            <th>RDD 3</th>
            <th>RDD 4</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/3.png"></td>
            <td><img src="screenshots/4.png"></td>
        </tr>
    </tbody>
    <thead>
        <tr>
            <th>RDD 5</th>
            <th>RDD 6</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/5.png"></td>
            <td><img src="screenshots/6.png"></td>
        </tr>
    </tbody>
    <thead>
        <tr>
            <th>RDD 7</th>
            <th>Pair RDD 7</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/7.png"></td>
            <td><img src="screenshots/8.png"></td>
        </tr>
    </tbody>
    <thead>
        <tr>
            <th>RDD 8</th>
            <th>Pair RDD 8</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/9.png"></td>
            <td><img src="screenshots/10.png"></td>
        </tr>
    </tbody>
    <thead>
        <tr>
            <th>RDD 9</th>
            <th>Sorted RDD 9</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/11.png"></td>
            <td><img src="screenshots/12.png"></td>
        </tr>
    </tbody>
</table>
<br><br>

2. Sales
<table >
    <thead>
        <tr>
            <th>Total Sales By city</th>
            <th>Total Sales By city & Products</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><img src="screenshots/13.png"></td>
            <td><img src="screenshots/14.png"></td>
        </tr>
    </tbody>
</table>
