package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Department> list = new ArrayList<>();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1 Department: insert ===");
		Department dep = new Department(null, "Music");
		departmentDao.insert(dep);
		System.out.println("Inserted! New Id = "+ dep.getId());
		
		System.out.println("\n=== TEST 2 Department: findByid ===");
		dep = departmentDao.findByid(2);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 3 Department: update ===");
		dep = departmentDao.findByid(2);
		dep.setName("IT");
		departmentDao.update(dep);
		System.out.println("Updated!");
		
		System.out.println("\n=== TEST 4 Department: delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteByid(id);
		System.out.println("Deleted!");
		
		System.out.println("\n=== TEST 5 Department: findAll ===");
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		sc.close();

	}

}
