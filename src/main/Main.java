package main;



import insertions.DataInsert;
import account.Account;
import account.EnterpriseAccount;
import computeTransaction.ComputeTransaction;
import computeTransaction.CreatedAccount;
import computeTransaction.UpdateAccountContext;

import control.Control;
import exceptions.InsertException;
import region.Romania;
import service.Call;
import view.Menu;

public class Main {

	public static void main(String[] args) throws InsertException {
		
		DataInsert dt = new DataInsert();
		//dt.insertCustomersAndAccounts();
		dt.insertRegions();
		
		//AccountBLL<?> accountBLL = new AccountBLL();
		
		
		
		
		Control control = Control.getInstance();
		Menu window = new Menu();
		window.getFrmMainMenu().setVisible(true);
		

		
		
		/*ComputeTransaction ct = new ComputeTransaction();
		ct.processServices();
		*/
		
		
		//// LUCIAN TESTING (don't remove until computeTransaction works) -> Auzi la el ce dume are
		/*ComputeTransaction cT= new ComputeTransaction();
		Customer customer = new Customer();
		Account account = new EnterpriseAccount(0,new Romania(10,5),customer,"dada","fdfad");
		Call call= new Call(new Romania(10,5),"dsads",new Romania(10,5),45);
		UpdateAccountContext updateAccountContext = new UpdateAccountContext(new CreatedAccount(), account ,call, 0);
		Account account2 = updateAccountContext.updateAccount();
		System.out.println("Here"+account2.getBalance());*/
	//
		
		
///
	
		


	}

}