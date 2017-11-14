package bll;

import java.util.ArrayList;
import java.util.List;

import account.Account;
import account.AccountFactory;
import account.EnterpriseAccount;
import account.FamilyAccount;
import customer.Customer;
import dao.AbstractDAO;
import dao.AccountDAO;
import dao.EnterpriseAccountDAO;
import dao.FamilyAccountDAO;
import exceptions.InsertException;
import promotion.PromotionFactory;
import region.Region;

public class AccountBLL<T extends Account> {
	
	private AbstractDAO<T> abstractDAO;
	private AccountDAO accountDAO;
	
	public AccountBLL() {
		//this.accountDAO = new AccountDAO();
	}
	
	public AccountBLL(AbstractDAO<T> abstractDAO) {
		this.abstractDAO = abstractDAO;
	}
	
	
	@SuppressWarnings("unchecked")
	public Integer addAccount(String type, Region region, Customer customer,String number,String endDate) throws InsertException{
		Integer id = null;
		Account account = AccountFactory.getAccount(type, 0, region, customer, number, endDate);
		System.out.println(account.getCustomerSystemReference());
		id = abstractDAO.add((T) account);
		return id;
	}
	
	public Account getAccount(String number){
		List<?> listAccounts = null;
		Account account = null;
		accountDAO = new EnterpriseAccountDAO();
		listAccounts = accountDAO.getByField("number", number);
		if(listAccounts == null){
			accountDAO = new FamilyAccountDAO();
			listAccounts = accountDAO.getByField("numbersString", number);
			account = (FamilyAccount) listAccounts.get(0);
		}
		else{
			account = (EnterpriseAccount) listAccounts.get(0);
		}
		return account;
	}
	
	@SuppressWarnings("unchecked")
	public void modifyAccount(Account newAccount){
		if(newAccount.getClass().getSimpleName() == "EnterpriseAccount"){
			accountDAO = new EnterpriseAccountDAO();
		}
		else
			accountDAO = new FamilyAccountDAO();
		accountDAO.modify(newAccount);
	}
	
	public List<String >applyPromotion(String promotionType,String accountId){
		List<String> recievedAttributes=new ArrayList<String>();
		Account retrievedAccount;//=-----------------------------------------get from data base with accountId
		Account promotedAccount=PromotionFactory.applyPromotion(promotionType, retrievedAccount);//------update the account with promotedAccount
		recievedAttributes.add(Integer.toString(promotedAccount.getMinutes()));
		recievedAttributes.add(Integer.toString(promotedAccount.getMessages()));
		return recievedAttributes;
	}
	
	public void presentReport(String idValue){
		//--------------------------------------------------------------------------- get account from data base, based on id;
		
		//Account account=(Account) familyAccount.getByField("id", idValue);
		//account.generateReport();
	}
}
