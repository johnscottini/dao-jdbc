package application;

import java.util.Date;
import java.util.List;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("====TEST 1:seller find by Id====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n====TEST 2:seller find by Department====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		

		System.out.println("\n====TEST 3:seller find All====");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);
	
		System.out.println("\n====TEST 4:seller insert====");
		Seller newSeller= new Seller(null, "greg", "greg@gmail", new Date(), 4000.0, department );
		sellerDao.insert(newSeller);
		System.out.println("inserted! New id: "+newSeller.getId());
		
	}

}
