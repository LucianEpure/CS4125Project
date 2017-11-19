package region;
/*
 * @author Xiangkai Tang
 */
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHN")
public class China extends Region {

	public China() {}
	
	public China(double callPrice, double percent) {
		super();
		this.regionName="China";
		this.setCallingPrice(callPrice);
		this.computeRoamingTax(percent);
	}
	
	@Override
	public void setCallingPrice(double callPrice) {
		this.callingPrice = callPrice;
	}
	
	@Override
	public void computeRoamingTax(double percent) {
		double roaming = (double)(this.callingPrice * percent)/100;
		this.roamingTax = roaming;
	}
 
	@Override
	public String getRegionName() {
		return regionName;
	}

	@Override
	public void setRegionName(String regionName) {
		this.regionName = "China";
	}

	@Override
	public String getUniqueIdentifierFieldValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessagePrice(double messagePrice) {
		this.messagePrice=messagePrice;
		
	}

	@Override
	public void setInternetPrice(double internetPrice) {
		this.internetPrice=internetPrice;
		
	}

}

