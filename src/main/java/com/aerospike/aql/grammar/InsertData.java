package com.aerospike.aql.grammar;
import java.sql.*;


public class InsertData {
    public java.sql.Connection con = null;
    public String HOST;
    public Integer PORT;
    public String NAMESPACE;

    public InsertData(){
        this.HOST = "127.0.0.1";
        this.PORT = 3000;
        this.NAMESPACE = "test";
    }

    public void testDBCOnnection(){

        try {

            Class.forName("com.aerospike.jdbc.AerospikeDriver");

            String DB_URL = String.format("jdbc:aerospike://%s:%d/%s",HOST,PORT,NAMESPACE);
            con = DriverManager.getConnection(DB_URL);
            System.out.println(String.format("URL= "+ DB_URL));


            if(con.isClosed()){
                System.out.println("Connection is not established ");
            }else{

                System.out.println("Connection established successfuly !!");
            }
            System.out.println("Connected to Node name : "+con.getCatalog());
            System.out.println("\n");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException sqEx) {
            sqEx.printStackTrace();
        }

    }
    public void testInertQuery() throws Exception
    {
        String insert;
        String key;
        String nameData;
        String cityData;
         Statement statement = con.createStatement();
        System.out.println("Insert Query..");
        for(int i=10000000;i<10100000;i++) {
           key=Integer.toString(i);
           nameData= "AP "+key;
           cityData = "San Jose " +key;
           insert = "INSERT INTO test.bintest(PK,name,city) VALUES('"+key+"','"+nameData+"','"+cityData+"')";
           statement.executeUpdate(insert);
           System.out.println("Insert done " + key);
        }
        statement.close();
        //con.commit();
        System.out.println("Record Inserted !!");
        System.out.println("\n");



    }

}
