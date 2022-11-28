import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Programs {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String database = "jdbc:mysql://localhost:3306/JDBC_Connectivity";
		String user = "root";
		String password = "Ritika";
		
		Connection connection = DriverManager.getConnection(database, user, password);
		Statement statement = connection.createStatement();
		
		
		Scanner Sc = new Scanner(System.in);
		
		System.out.println("Menu  ");
		int choice = 0;
		
		do {
			System.out.println("1. Insert into Table");
			System.out.println("2. Delete all rows from table");
			System.out.println("3. Show records ");
			System.out.println("4. Delete specific row from table");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice : ");
			choice = Sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Insert INTO table  ");
					
					System.out.print("Enter id : ");
					int id = Sc.nextInt();
					
					System.out.print("Enter name : ");
					String name = Sc.next();
					
					System.out.print("Enter salary : ");
					int salary = Sc.nextInt();
					
					System.out.print("Enter department name : ");
					String department = Sc.next();
					
					String command = "INSERT INTO Employee VALUES ("+ id +","+ "'" + name+"'"+","+salary+","+ "'" + department +"'"+ ")";
					System.out.println(command);
					statement.executeUpdate(command);
					
					break;
				
					
				case 2:
					System.out.println("Delete all rows");
					
					command = "DELETE FROM Employee";
					statement.executeUpdate(command);
					break;
				
				case 3:
					System.out.println("Displaying all records ");
					command="SELECT * from Employee";
					 
					ResultSet resultSet =statement.executeQuery(command);

					System.out.println("ID          Name        Salary      Department");
					while(resultSet.next())
					{
						id=resultSet.getInt("id");
						name= resultSet.getString("name");
						salary= resultSet.getInt("salary");
						String dept= resultSet.getString("department");

						
						System.out.println(id + "          "  + name + "     " + salary + "        " + dept);
					}
					resultSet.close();
					break;
				case 5:
					choice = -1;
					break;
				case 4:
					System.out.println("Delete a row");
					
					int idToDelete = Sc.nextInt();
					command = "DELETE FROM Employee WHERE id = " + idToDelete;
					statement.executeUpdate(command);
					break;
				default:
					System.out.println("Please enter correct choice !! ");
			}
			
		}while(choice != -1);
		
		
		Sc.close();
		statement.close();
		connection.close();
	}
}