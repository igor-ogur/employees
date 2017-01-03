package com.softgroup.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.oracle.jrockit.jfr.Transition.To;

public class Runner {
    public static void main( String[] args ) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Peter", new FixedPayment(5000)));
        employeeList.add(new Employee("Lois", new HourlyPayment(15)));
        employeeList.add(new Employee("Stewie", new FixedPayment(5000)));
        employeeList.add(new Employee("Brian", new HourlyPayment(20)));
        employeeList.add(new Employee("Chris", new FixedPayment(7000)));
        employeeList.add(new Employee("Homer", new HourlyPayment(30)));
        employeeList.add(new Employee("March", new FixedPayment(5000)));
        employeeList.add(new Employee("Lisa", new HourlyPayment(25)));
        employeeList.add(new Employee("Bart", new FixedPayment(6000)));
        employeeList.add(new Employee("Maggie", new HourlyPayment(27)));

        //a) Sort the collection of employees in descending order by the average monthly salary.
        // In the case of equal salary – by the name. Write ID, name and monthly salary for all employees from collection.
        Collections.sort(employeeList, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                if (o2.getPayment().calculateAverageMonthlySalary()-o1.getPayment().calculateAverageMonthlySalary() == 0)
                    return o2.getName().compareTo(o1.getName());
                return (int) (o2.getPayment().calculateAverageMonthlySalary()-o1.getPayment().calculateAverageMonthlySalary());
            }
        });

        System.out.println("ID, name and monthly salary for all employees from collection:");
        System.out.println();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println();

        //b) Write information about first five employees from collection (problem a)
        System.out.println("Information about first five employees from collection:");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(employeeList.get(i));
        }
        System.out.println();
        //c) Write ID of three last employees from collection (problem b).
        System.out.println("ID of three last employees from collection:");
        System.out.println();
        for (int i = employeeList.size()-3; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i).getId());
        }

        //d) Write code for reading and writing collection of these objects from (into) file.
        //e) Write code for handling the incorrect format of incoming file.
        writeListToFile(employeeList);

        System.out.println();
        System.out.println("List of employees that has been read from file:");
        System.out.println();
        List<Employee> list = readListFromFile();
        for (Employee employee : list) {
            System.out.println(employee);
        }

    }

    public static void writeListToFile(List list){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List readListFromFile() {
        FileInputStream fis = null;
        List<Employee> list = null;
        try {
            fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Employee>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
