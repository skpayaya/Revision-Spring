package com.cg.iter.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Address;
import com.cg.iter.bean.Student;
import com.cg.iter.service.StudentService;

@Component
public class StudentMain {

	@Autowired
	private StudentService studService;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("student.xml");
		StudentMain sm = ctx.getBean(StudentMain.class);
		sm.startApplication();
	}
	public void startApplication() {

//		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();	
//		appContext.scan("com.cg.iter");
//		appContext.refresh();
//		studService = (StudentService) appContext.getBean("studentService");
		Scanner scan = new Scanner(System.in);
		int choice;
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Create Student");
				System.out.println("Enter <houseId> <HouseName> <City>");
				Address addr = new Address(scan.nextInt(), scan.next(), scan.next());
				System.out.println("Enter <ID> <Name> <Mobile> <Subject>");
				Student stud = new Student(scan.nextInt(),scan.next(),
						scan.nextLong(),scan.next(),addr);
				boolean success = studService.create(stud);
				if(success) {
					System.out.println("Student saved");
				}
				else {
					System.out.println("Could not save student");
				}
				break;
			case 2:

				System.out.println("Enter Student Id");
				Student student = studService.findStudentById(scan.nextInt());
				if(student==null) {
					System.out.println("Student not found");
				}
				else {
					System.out.println(student);
				}
				break;
			case 3:

				System.out.println("Enter Student Id");
				Student studentUpdate = studService.findStudentById(scan.nextInt());
				if(studentUpdate!=null) {
					System.out.println("Enter <Name> <Mobile> <Subject>");
					studentUpdate.setName(scan.next());
					studentUpdate.setMobile(scan.nextLong());
					studentUpdate.setSubject(scan.next());
					Address addressUpdate = studentUpdate.getAddress();

					System.out.println("Enter<HouseName> <City>");
					addressUpdate.setHouseName(scan.next());
					addressUpdate.setCity(scan.next());

					studentUpdate.setAddress(addressUpdate);

					if(studService.updateStudent(studentUpdate)) {
						System.out.println("Updated sucessfully");
					}
					else {
						System.out.println("Update Failed");
					}
				}
				else {
					System.out.println("Student not found");
				}
				break;
			case 4:
				System.out.println("Enter Student Id");
				if(studService.deleteStudent(scan.nextInt())) {
					System.out.println("Removed sucessfully");
				}

				break;
			case 5:

				System.out.println("Enter Student Name");
				Student studentByName = studService.findStudentByName(scan.next());
				if(studentByName==null) {
					System.out.println("Student not found");
				}
				else {
					System.out.println(studentByName);
				}
				break;
			case 6:
				System.out.println("Exiting Program");
				System.exit(0);
				break;

			default:
				System.out.println("Enter 1 to 5 only");
				break;
			}
		}
	}
	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("STUDENT MANAGEMENT");
		System.out.println("1. Add Student");
		System.out.println("2. Find Student by ID");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Find Student By Name");
		System.out.println("6. Exit Program");
		System.out.println("Choose the option from above");
		try {
			choice = scan.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Please choose a number");
			scan.nextLine();
		}
		return choice;
	}		


	

}
