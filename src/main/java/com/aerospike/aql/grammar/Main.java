package com.aerospike.aql.grammar;

public class Main {
    public static void main(String[] args) throws Exception {
        InsertData insertData = new InsertData();
        insertData.testDBCOnnection();
        insertData.testInertQuery();
    }
}
