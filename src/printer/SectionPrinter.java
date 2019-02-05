package printer;

import java.awt.*;

public abstract class SectionPrinter {
	protected PrintableSectionInterface psi;
	protected Graphics g;
	protected int init_x;
	protected int init_y;
	protected FontMetrics fm;

	public SectionPrinter addPrintableSection(PrintableSectionInterface psi) {
		this.psi = psi;
		return this;
	}

	public SectionPrinter addGraphics(Graphics g) {
		this.g = g;
		return this;
	}

	public SectionPrinter setX(int x) {
		this.init_x = x;
		return this;
	}

	public SectionPrinter setY(int y) {
		this.init_y = y;
		return this;
	}

	public SectionPrinter setFontMetrics(FontMetrics fm) {
		this.fm = fm;
		;
		return this;
	}

	public abstract int generate();
}
