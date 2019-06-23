import java.util.Scanner; 
import java.io.*;

public class SalesmanCompensation {
    static FileWriter fileWriter = new FileWriter();
    
     public static void main(String []args){
        int fixedSalary = 30000;
        double commisionPercentage = .07;
        double totalAnnualCompensation = 0;
        double totalAnnualSales = 0;
        
        //ask user for input
        System.out.println("Enter annual sales"); 
        Scanner scanner = new Scanner(System.in); 
        String input = scanner.nextLine(); 

        //error handling if input is not a integer
        try {
            totalAnnualSales = Double.parseDouble(input);
            //calculate totalAnnualCompensation
            totalAnnualCompensation = (totalAnnualSales * commisionPercentage) + fixedSalary;
            //output result to console
            System.out.println("Total annual compensation is: " + totalAnnualCompensation);
            //create file
            fileWriter.writeFile(totalAnnualCompensation);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error number of sales needs to be a number"); 
        }
     }

    //FileWriter class
    public static class FileWriter{
    Writer writer = null;

    //write file
    public void writeFile(double totalAnnualCompensation){
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("totalAnnualCompensation.txt"), "utf-8"));
            writer.write("Total annual compensation is: " + totalAnnualCompensation);
        } catch (IOException ex) {
            System.out.println("Error while writing file");
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
}


