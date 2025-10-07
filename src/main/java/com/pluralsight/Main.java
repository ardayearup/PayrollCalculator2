package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

            System.out.print("Enter the name of the file employee file to process(.csv): ");
            String emp_file_name = keyboard.nextLine();
            System.out.print("Enter the name of the payroll file to create(.csv): ");
            String pay_file_name = keyboard.nextLine();
            String[] emp1 = emp_file_name.split(Pattern.quote(""));
            String[] pay1 = pay_file_name.split(Pattern.quote(""));

            if (emp_file_name.length() >= 4 && pay_file_name.length() >= 4)
            {
                if (emp_file_name.substring(emp_file_name.length() - 4).equals(".csv") &&
                        pay_file_name.substring(pay_file_name.length() - 4).equals(".csv"))
                {

                }
                else
                {
                    System.out.println("Wrong file format.");
                    return;
                }
            }
            else
            {
                System.out.println("File name too short.");
                return;
            }



        try
        {
            FileReader my_freader = new FileReader("src/main/resources/" + emp_file_name);
            BufferedReader my_breader = new BufferedReader(my_freader);
            String input;

            FileWriter my_fwriter = new FileWriter("src/main/resources/" + pay_file_name );
            BufferedWriter my_bwriter = new BufferedWriter(my_fwriter);
            my_bwriter.write("id|name|gross pay");
            my_bwriter.newLine();


            while (( input = my_breader.readLine()) != null)
            {
                String[] tokens = input.split(Pattern.quote("|"));
                if (tokens[0].equals("id") )
                {
                    continue;
                }
                else
                {
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hours_worked = Double.parseDouble(tokens[2]);
                    double pay_rate = Double.parseDouble(tokens[3]);

                    Employee emp = new Employee(id,name,hours_worked,pay_rate);
                    //System.out.printf("ID: %d\nName: %s\nHoursWorked: %.2f\nPayRate: %.2f\nGrossPay: %.2f%n\n\n",emp.getEmployee_id(), emp.getName(), emp.getHours_worked(), emp.getPay_rate(), emp.gross_pay());

                    my_bwriter.write(emp.getEmployee_id() + "|" + emp.getName() + "|" + emp.gross_pay());
                    my_bwriter.newLine();
                }
            }
            my_breader.close();
            my_bwriter.close();



        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }
}