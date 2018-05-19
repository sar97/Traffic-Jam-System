package hello1;
import java.sql.*;
import java.util.*;

public class Test1 
{
	   
	public static void main(String args[])
 {  
	try
	{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/test1","root","");  
	//here sonoo is database name, root is username and password 
	
	Statement smt=con.createStatement();

	Scanner sc=new Scanner(System.in);

    //input the Id which we want to display to java
	System.out.print("Enter ID:");
	int eid=sc.nextInt();

	//query to display a particular record from table employee where id= something arduiuno is table name
	String q="Select * from sensor where id='"+eid+"'";

	//to execute query
	ResultSet rs=smt.executeQuery(q);

	//to print the resultset on to the console
	if(rs.next())
	{
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	}
	else
	{
		System.out.println("Record Not Found...");
	}
	
	
	// starting state determination
	 q="SELECT * FROM (SELECT * FROM SENSOR ORDER BY ID DESC)SENSOR1 WHERE ID>(SELECT COUNT(id)-4 FROM SENSOR);";
     rs=smt.executeQuery(q);
     int c=0;
	while(rs.next())
	{
		String a=rs.getString(3);
		int b=Integer.parseInt(a);
		if(b<300)
		{
			c++;
		}
	}
	
	q="SELECT * FROM (SELECT * FROM SENSOR1 ORDER BY ID DESC)SENSOR11 WHERE ID>(SELECT COUNT(id)-4 FROM SENSOR1);";
    rs=smt.executeQuery(q);
    while(rs.next())
	{
		String a=rs.getString(3);
		int b=Integer.parseInt(a);
		if(b<300)
		{
			c++;
		}
	}
    
    q="SELECT * FROM (SELECT * FROM SENSOR2 ORDER BY ID DESC)SENSOR22 WHERE ID>(SELECT COUNT(id)-4 FROM SENSOR2);";
    rs=smt.executeQuery(q);
    while(rs.next())
	{
		String a=rs.getString(3);
		int b=Integer.parseInt(a);
		if(b<300)
		{
			c++;
		}
	}
	
	if(c>7 || c==9)
		System.out.println("Jam detected");
	else
		System.out.println("No jam");
	
	con.close();
}
catch(Exception e){
	System.out.println(e);
}
}
}


