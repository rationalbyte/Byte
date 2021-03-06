/**
 * 
 */
package com.dw.data.access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author user
 *
 */
public class SequenceNumberTest {


    /* the default framework is embedded */
    private String framework = "embedded";
    private String protocol = "jdbc:derby:";

    public static void main(String[] args)
    {
        new SequenceNumberTest().go(args);
        System.out.println("SequenceNumberTest finished");
    }


    void go(String[] args)
    {

        System.out.println("SimpleApp starting in " + framework + " mode");


        Connection conn = null;
        ArrayList<Statement> statements = new ArrayList<Statement>(); // list of Statements, PreparedStatements
        PreparedStatement psInsert;
        PreparedStatement psUpdate;
        PreparedStatement psInvoiceInsert;
        Statement s;
        ResultSet rs = null;
        try
        {
            Properties props = new Properties(); // connection properties
            // providing a user name and password is optional in the embedded
            // and derbyclient frameworks
            props.put("user", "user1");
            props.put("password", "user1");

            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
            String dbName = "TESTING_0001;create=true"; // the name of the database

            protocol = "org.apache.derby.jdbc.EmbeddedDriver";
            /*conn = DriverManager.getConnection(protocol + dbName
                    + ";create=true", props);*/
            /////////////////
            String protocol = "jdbc:derby:";
            //conn = DriverManager.getConnection(protocol + "REWORKS_0001;create=true", props);
            conn = DriverManager.getConnection(protocol + dbName);
            //conn = DriverManager.getConnection(protocol + "E:'\\PROJECTS'\\SOFTWARES'\\db-derby-10.12.1.1-bin'\\bin'\\TESTING_002;create=true", props);
            //E:\PROJECTS\SOFTWARES\db-derby-10.12.1.1-bin\bin
            /////////////////

            System.out.println("Connected to and created database " + dbName);

            // We want to control transactions manually. Autocommit is on by
            // default in JDBC.
            conn.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
            s = conn.createStatement();
            statements.add(s);

            // We create a table...
            /*s.execute("create table location(num int, addr varchar(40))");
            System.out.println("Created table location");*/
            
            psInvoiceInsert = conn.prepareStatement(
                    "insert into INVOICE_001 values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statements.add(psInvoiceInsert);
            createInoice(psInvoiceInsert);
            //createDataModel(s, conn/*, psInvoiceInsert*/);

            // and add a few rows...

            /* It is recommended to use PreparedStatements when you are
             * repeating execution of an SQL statement. PreparedStatements also
             * allows you to parameterize variables. By using PreparedStatements
             * you may increase performance (because the Derby engine does not
             * have to recompile the SQL statement each time it is executed) and
             * improve security (because of Java type checking).
             */
            // parameter 1 is num (int), parameter 2 is addr (varchar)
            psInsert = conn.prepareStatement(
                        "insert into location values (?, ?)");
            statements.add(psInsert);

            psInsert.setInt(1, 1956);
            psInsert.setString(2, "Webster St.");
            psInsert.executeUpdate();
            System.out.println("Inserted 1956 Webster");

            psInsert.setInt(1, 1910);
            psInsert.setString(2, "Andhra Pradesh");
            psInsert.executeUpdate();
            System.out.println("Inserted 1910 Union");

            // Let's update some rows as well...

            // parameter 1 and 3 are num (int), parameter 2 is addr (varchar)
            psUpdate = conn.prepareStatement(
                        "update location set num=?, addr=? where num=?");
            statements.add(psUpdate);

            psUpdate.setInt(1, 180);
            psUpdate.setString(2, "KASUKARRY");
            psUpdate.setInt(3, 1956);
            psUpdate.executeUpdate();
            System.out.println("Updated 1956 Webster to 180 Grand");

            psUpdate.setInt(1, 300);
            psUpdate.setString(2, "Lakeshore Ave.");
            psUpdate.setInt(3, 180);
            psUpdate.executeUpdate();
            System.out.println("Updated 180 Grand to 300 Lakeshore");


            /*
               We select the rows and verify the results.
             */
            rs = s.executeQuery(
                    "SELECT num, addr FROM location ORDER BY num");

            /* we expect the first returned column to be an integer (num),
             * and second to be a String (addr). Rows are sorted by street
             * number (num).
             *
             * Normally, it is best to use a pattern of
             *  while(rs.next()) {
             *    // do something with the result set
             *  }
             * to process all returned rows, but we are only expecting two rows
             * this time, and want the verification code to be easy to
             * comprehend, so we use a different pattern.
             */
            System.out.println("===================================================");
            while(rs.next()) {
                 // do something with the result set
            	System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            	
            }
            System.out.println("===================================================");
            
            ///////////////////////////////
            rs = s.executeQuery(
                    "SELECT * FROM INVOICE_001");

            /* we expect the first returned column to be an integer (num),
             * and second to be a String (addr). Rows are sorted by street
             * number (num).
             *
             * Normally, it is best to use a pattern of
             *  while(rs.next()) {
             *    // do something with the result set
             *  }
             * to process all returned rows, but we are only expecting two rows
             * this time, and want the verification code to be easy to
             * comprehend, so we use a different pattern.
             */
            System.out.println("===================INVOICE================================");
            while(rs.next()) {
                 // do something with the result set
            	System.out.println(rs.getInt(1)+"   "+rs.getDate(2)+"  "+rs.getInt(3));
            	
            }
            System.out.println("===================INVOICE================================");
            /////////////////////////////////
            int number; // street number retrieved from the database
            boolean failure = false;
            /*if (!rs.next())
            {
                failure = true;
                reportFailure("No rows in ResultSet");
            }

            if ((number = rs.getInt(1)) != 300)
            {
                failure = true;
                reportFailure(
                        "Wrong row returned, expected num=300, got " + number);
            }

            if (!rs.next())
            {
                failure = true;
                reportFailure("Too few rows");
            }

            if ((number = rs.getInt(1)) != 1910)
            {
                failure = true;
                reportFailure(
                        "Wrong row returned, expected num=1910, got " + number);
            }

            if (rs.next())
            {
                failure = true;
                reportFailure("Too many rows");
            }*/

            if (!failure) {
                System.out.println("Verified the rows");
            }

            // delete the table
            //s.execute("drop table location");
            //System.out.println("Dropped table location");

            /*
               We commit the transaction. Any changes will be persisted to
               the database now.
             */
            conn.commit();
            System.out.println("Committed the transaction");

            /*
             * In embedded mode, an application should shut down the database.
             * If the application fails to shut down the database,
             * Derby will not perform a checkpoint when the JVM shuts down.
             * This means that it will take longer to boot (connect to) the
             * database the next time, because Derby needs to perform a recovery
             * operation.
             *
             * It is also possible to shut down the Derby system/engine, which
             * automatically shuts down all booted databases.
             *
             * Explicitly shutting down the database or the Derby engine with
             * the connection URL is preferred. This style of shutdown will
             * always throw an SQLException.
             *
             * Not shutting down when in a client environment, see method
             * Javadoc.
             */

            if (framework.equals("embedded"))
            {
                try
                {
                    // the shutdown=true attribute shuts down Derby
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");

                    // To shut down a specific database only, but keep the
                    // engine running (for example for connecting to other
                    // databases), specify a database in the connection URL:
                    //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
                }
                catch (SQLException se)
                {
                    if (( (se.getErrorCode() == 50000)
                            && ("XJ015".equals(se.getSQLState()) ))) {
                        // we got the expected exception
                        System.out.println("Derby shut down normally");
                        // Note that for single database shutdown, the expected
                        // SQL state is "08006", and the error code is 45000.
                    } else {
                        // if the error code or SQLState is different, we have
                        // an unexpected exception (shutdown failed)
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                    }
                }
            }
        }
        catch (SQLException sqle)
        {
            printSQLException(sqle);
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            // release all open resources to avoid unnecessary memory usage

            // ResultSet
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }

            // Statements and PreparedStatements
            int i = 0;
            while (!statements.isEmpty()) {
                // PreparedStatement extend Statement
                Statement st = (Statement)statements.remove(i);
                try {
                    if (st != null) {
                        st.close();
                        st = null;
                    }
                } catch (SQLException sqle) {
                    printSQLException(sqle);
                }
            }

            //Connection
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
    }

    /**
     * Reports a data verification failure to System.err with the given message.
     *
     * @param message A message describing what failed.
     */
    private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }

    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */
    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }

    /**
     * Parses the arguments given and sets the values of this class's instance
     * variables accordingly - that is, which framework to use, the name of the
     * JDBC driver class, and which connection protocol to use. The
     * protocol should be used as part of the JDBC URL when connecting to Derby.
     * <p>
     * If the argument is "embedded" or invalid, this method will not change
     * anything, meaning that the default values will be used.</p>
     * <p>
     * @param args JDBC connection framework, either "embedded" or "derbyclient".
     * Only the first argument will be considered, the rest will be ignored.
     */
    private void parseArguments(String[] args)
    {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("derbyclient"))
            {
                framework = "derbyclient";
                protocol = "jdbc:derby://localhost:1527/";
            }
        }
    }
    
    ///////////////////////////////////
/*    private void createDataModel(Statement stmt, Connection conn, PreparedStatement psInvoiceInsert){
    	//stmt.execute("create table location(num int, addr varchar(40))");
    	try {
			stmt.execute("CREATE TABLE INVOICE_001 (BILL_NO INT NOT NULL, BILL_DATE DATE NOT NULL, YOUR_ORDER_NUMBER INT NOT NULL, YOUR_ORDER_DATE DATE NOT NULL, OUR_DC_NUMBER INT NOT NULL, OUR_DC_DATE DATE NOT NULL, VAT_PERCENTAGE FLOAT NOT NULL, PARTY_TIN_NUMBER INT NOT NULL, ADDRESS_ID INT NOT NULL, CONSTRAINT INVOICE_PK PRIMARY KEY (BILL_NO))");
			psInvoiceInsert = conn.prepareStatement(
                    "insert into INVOICE_001 values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			psInvoiceInsert.setInt(1, 1000000002);
			psInvoiceInsert.setDate(2, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(3, 500);
			psInvoiceInsert.setDate(4, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(5, 600);
			psInvoiceInsert.setDate(6, new Date(2016, 5, 5));
			psInvoiceInsert.setFloat(7, 14.5f);
			psInvoiceInsert.setInt(8, 8536985);
			psInvoiceInsert.setInt(9, 23000);
			psInvoiceInsert.executeUpdate();
			System.out.println("DATA INSERTED INTO INVOICE TABLE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }*/
    
    private void createDataModel(Statement stmt, Connection conn/*, PreparedStatement psInvoiceInsert*/){
    	//stmt.execute("create table location(num int, addr varchar(40))");
    	try {
			stmt.execute("CREATE TABLE INVOICE (BILL_NO INT NOT NULL, BILL_DATE DATE NOT NULL, YOUR_ORDER_NUMBER INT NOT NULL, YOUR_ORDER_DATE DATE NOT NULL, OUR_DC_NUMBER INT NOT NULL, OUR_DC_DATE DATE NOT NULL, VAT_PERCENTAGE FLOAT NOT NULL, PARTY_TIN_NUMBER INT NOT NULL, ADDRESS_ID INT NOT NULL, CONSTRAINT INVOICE_PK PRIMARY KEY (BILL_NO))");
			
			stmt.execute("CREATE TABLE ITEM (SERIAL_NO INT NOT NULL, PARTICULARS VARCHAR(50) NOT NULL, QUANTITY INT NOT NULL, PER INT NOT NULL, RATE FLOAT NOT NULL, AMOUNT_RS FLOAT NOT NULL, AMOUNT_PRICE FLOAT NOT NULL, BILL_NO INT NOT NULL, CONSTRAINT ITEM_PK PRIMARY KEY (SERIAL_NO, BILL_NO), CONSTRAINT INVOICE_FK FOREIGN KEY (BILL_NO) REFERENCES INVOICE (BILL_NO)");
			/*psInvoiceInsert = conn.prepareStatement(
                    "insert into INVOICE_001 values (?, ?, ?, ?, ?, ?, ?, ?, ?)");*/
			/*psInvoiceInsert.setInt(1, 1000000002);
			psInvoiceInsert.setDate(2, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(3, 500);
			psInvoiceInsert.setDate(4, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(5, 600);
			psInvoiceInsert.setDate(6, new Date(2016, 5, 5));
			psInvoiceInsert.setFloat(7, 14.5f);
			psInvoiceInsert.setInt(8, 8536985);
			psInvoiceInsert.setInt(9, 23000);
			psInvoiceInsert.executeUpdate();
			System.out.println("DATA INSERTED INTO INVOICE TABLE");*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void createInoice(PreparedStatement psInvoiceInsert){
    	//stmt.execute("create table location(num int, addr varchar(40))");
    	try {
			//stmt.execute("CREATE TABLE INVOICE_001 (BILL_NO INT NOT NULL, BILL_DATE DATE NOT NULL, YOUR_ORDER_NUMBER INT NOT NULL, YOUR_ORDER_DATE DATE NOT NULL, OUR_DC_NUMBER INT NOT NULL, OUR_DC_DATE DATE NOT NULL, VAT_PERCENTAGE FLOAT NOT NULL, PARTY_TIN_NUMBER INT NOT NULL, ADDRESS_ID INT NOT NULL, CONSTRAINT INVOICE_PK PRIMARY KEY (BILL_NO))");
			/*psInvoiceInsert = conn.prepareStatement(
                    "insert into INVOICE_001 values (?, ?, ?, ?, ?, ?, ?, ?, ?)");*/
			psInvoiceInsert.setInt(1, 1000000004);
			psInvoiceInsert.setDate(2, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(3, 500);
			psInvoiceInsert.setDate(4, new Date(2016, 5, 5));
			psInvoiceInsert.setInt(5, 600);
			psInvoiceInsert.setDate(6, new Date(2016, 5, 5));
			psInvoiceInsert.setFloat(7, 14.5f);
			psInvoiceInsert.setInt(8, 8536985);
			psInvoiceInsert.setInt(9, 23000);
			psInvoiceInsert.executeUpdate();
			System.out.println("DATA INSERTED INTO INVOICE TABLE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /////////////////////////////////// 

}
