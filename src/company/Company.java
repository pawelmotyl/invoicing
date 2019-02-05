package company;

import printer.*;
import java.awt.print.Printable;

public class Company implements CompanyInterface, PrintableSectionInterface {

	protected String name1;
	protected String name2;
	protected String zip_code;
	protected String city;
	protected String street;
	protected String hause_no;
	protected String tax_number;
	protected String account_number;

	@Override
	public String toString() {
		return this.name1 + " " + this.city;
	}

	@Override
	public void setName1(String name1) {
		this.name1 = name1;
	}

	@Override
	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Override
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public void setHouseNumber(String hause_no) {
		this.hause_no = hause_no;
	}

	@Override
	public void setTaxNumber(String tax_number) {
		this.tax_number = tax_number;
	}

	@Override
	public void setAccountNumber(String account_number) {
		this.account_number = account_number;
	}

	@Override
	public String getName1() {
		return this.name1;
	}

	@Override
	public String getName2() {
		return this.name2;
	}

	@Override
	public String getZipCode() {
		return this.zip_code;
	}

	@Override
	public String getCity() {
		return this.city;
	}

	@Override
	public String getStreet() {
		return this.street;
	}

	@Override
	public String getHouseNumber() {
		return this.hause_no;
	}

	@Override
	public String getTaxNumber() {
		return this.tax_number;
	}

	@Override
	public String getAccountNumber() {
		return this.account_number;
	}

}
