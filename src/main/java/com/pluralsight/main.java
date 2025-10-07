package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        try
        {
            FileReader my_freader = new FileReader("src/main/resources/employees.csv");
            BufferedReader my_breader = new BufferedReader(my_freader);
            String input;

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
                    System.out.printf("ID: %d\nName: %s\nHoursWorked: %.2f\nPayRate: %.2f\nGrossPay: %.2f%n\n\n",
                            emp.getEmployee_id(), emp.getName(), emp.getHours_worked(), emp.getPay_rate(), emp.gross_pay());
                }
            }
            my_breader.close();



        }
        catch(IOException exc)
        {
          exc.printStackTrace();
        }
    }
}
