package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


//Modeling One-to-many Relationships

public class App12 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Department2 techDept = new Department2("Tech", "Floor 3");
            Department2 researchDept = new Department2("Research", "Floor 5");

            EmployeeContactInfo2 eciOne = new EmployeeContactInfo2("101 Main St", "555-101");
            EmployeeContactInfo2 eciTwo = new EmployeeContactInfo2("51 Broadway", "555-155");
            EmployeeContactInfo2 eciThree = new EmployeeContactInfo2("24 Walnut St", "555-222");

            Employee7 firstEmployee = new Employee7("Peter", "Holland",
                    "Manager", 120000d);

            Employee7 secondEmployee = new Employee7("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee7 thirdEmployee = new Employee7("Naomi", "Miller",
                    "Vice President", 160000d);

            firstEmployee.setContactInfo(eciOne);
            secondEmployee.setContactInfo(eciTwo);
            thirdEmployee.setContactInfo(eciThree);

            firstEmployee.setDepartment2(techDept);
            secondEmployee.setDepartment2(techDept);
            thirdEmployee.setDepartment2(researchDept);

            entityManager.persist(techDept);
            entityManager.persist(researchDept);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);

            entityManager.persist(eciOne);
            entityManager.persist(eciTwo);
            entityManager.persist(eciThree);


            List<Employee7> employeeList = entityManager
                    .createQuery("SELECT ed FROM Employee7 ed")
                    .getResultList();

            System.out.println("\n****************************\n");
            System.out.println("The employees in the Employee table:");
            for(Employee7 emp: employeeList){
                System.out.println(emp);
            }

            System.out.println("\n****************************\n");

            List<EmployeeContactInfo2> contactInfos = entityManager
                    .createQuery("SELECT eci FROM EmployeeContactInfo2 eci")
                    .getResultList();

            System.out.println("\nThe contact details for employees:\n");
            for(EmployeeContactInfo2 eci: contactInfos){
                System.out.println(eci);
            }

            System.out.println("\n****************************\n");

            List<Department2> departments = entityManager
                    .createQuery("SELECT dep FROM Department2 dep")
                    .getResultList();

            System.out.println("\nThe departments on record:\n");
            for(Department2 dep: departments){
                System.out.println(dep);
            }

            System.out.println("\n****************************\n");

        }
        catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }
        finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}