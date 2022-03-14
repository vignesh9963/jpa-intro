package com.dxc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class App13 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Department3 techDept = new Department3("Tech", "Floor 3");
            Department3 researchDept = new Department3("Research", "Floor 5");

            EmployeeContactInfo3 eciOne = new EmployeeContactInfo3("101 Main St", "555-101");
            EmployeeContactInfo3 eciTwo = new EmployeeContactInfo3("51 Broadway", "555-155");
            EmployeeContactInfo3 eciThree = new EmployeeContactInfo3("24 Walnut St", "555-222");

            Employee8 firstEmployee = new Employee8("Peter", "Holland",
                    "Manager", 120000d);

            Employee8 secondEmployee = new Employee8("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee8 thirdEmployee = new Employee8("Naomi", "Miller",
                    "Vice President", 160000d);

            Project releaseAutomationProj = new Project("Release Automation",
                    LocalDate.of(2022, 3, 31));
            Project recommendationsProj = new Project("Recommendation Engine",
                    LocalDate.of(2023, 3, 30));

            firstEmployee.setContactInfo(eciOne);
            secondEmployee.setContactInfo(eciTwo);
            thirdEmployee.setContactInfo(eciThree);

            firstEmployee.setDepartment3(techDept);
            secondEmployee.setDepartment3(techDept);
            thirdEmployee.setDepartment3(researchDept);

            firstEmployee.addProject(releaseAutomationProj);
            secondEmployee.addProject(releaseAutomationProj);
            thirdEmployee.addProject(releaseAutomationProj);
            thirdEmployee.addProject(recommendationsProj);

            entityManager.persist(releaseAutomationProj);
            entityManager.persist(recommendationsProj);

            entityManager.persist(techDept);
            entityManager.persist(researchDept);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);

            entityManager.persist(eciOne);
            entityManager.persist(eciTwo);
            entityManager.persist(eciThree);


            List<Employee8> employeeList = entityManager
                    .createQuery("SELECT ed FROM Employee8 ed")
                    .getResultList();

            System.out.println("\n****************************\n");
            System.out.println("The employees in the Employee table:");
            for(Employee8 emp: employeeList){
                System.out.println(emp);
            }

            System.out.println("\n****************************\n");

            List<EmployeeContactInfo3> contactInfos = entityManager
                    .createQuery("SELECT eci FROM EmployeeContactInfo3 eci")
                    .getResultList();

            System.out.println("\nThe contact details for employees:\n");
            for(EmployeeContactInfo3 eci: contactInfos){
                System.out.println(eci);
            }

            System.out.println("\n****************************\n");

            List<Department3> departments = entityManager
                    .createQuery("SELECT dep FROM Department3 dep")
                    .getResultList();

            System.out.println("\nThe departments on record:\n");
            for(Department3 dep: departments){
                System.out.println(dep);
            }

            System.out.println("\n****************************\n");

            List<Project> projects = entityManager
                    .createQuery("SELECT proj FROM Project proj")
                    .getResultList();

            System.out.println("\nThe projects on record:\n");
            for(Project project: projects){
                System.out.println(project);
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