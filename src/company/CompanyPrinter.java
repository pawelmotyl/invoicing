package company;

import java.awt.Graphics;

import printer.*;

public class CompanyPrinter extends SectionPrinter {

	@Override
	public int generate() {
		Company print_company = (Company) this.psi;
		int line_height = this.fm.getHeight();
		int x = this.init_x;
		int current_y = this.init_y + line_height;

		Graphics g = this.g;
		if (print_company.getName1() != null) {
			g.drawString(print_company.getName1(), x, current_y);
		}

		if (print_company.getName2() != null) {
			current_y += line_height;
			g.drawString(print_company.getName2(), x, current_y);
		}

		String company_address = null;

		if (print_company.getZipCode() != null) {
			company_address = print_company.getZipCode();
		}

		if (print_company.getCity() != null) {
			if (company_address != null) {
				company_address += " " + print_company.getCity();
			} else {
				company_address = print_company.getCity();
			}
		}

		if (company_address != null) {
			current_y += line_height;
			g.drawString(company_address, x, current_y);
		}

		return current_y + line_height;
	}

	@Override
	public String toString() {
		return "" + this.init_x;
	}

}
