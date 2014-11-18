package net.nexon.vindictus.itemcomparer.inport;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ScrollProperty {

	private double enthu = 12.0;
	private double force = 3.0;
	private double armadi = 1.0;
	private double senti = 3.0;
	private double tut = 3.0;
	private double res = 0.4;
	private double master = 0.5;
	private double wb = 0.0;

	public ScrollProperty() {
		Properties props = new Properties();
		try {
			BufferedInputStream stream = new BufferedInputStream(
					new FileInputStream("data" + File.separator
							+ "scrolls.properties"));
			props.load(stream);
			
			enthu = new Double(props.getProperty("enthu"));
			force = new Double(props.getProperty("force"));
			senti = new Double(props.getProperty("sentinel"));
			res = new Double(props.getProperty("resistant"));
			armadi = new Double(props.getProperty("armadilo"));
			tut = new Double(props.getProperty("tutelary"));
			master = new Double(props.getProperty("master"));
			wb = new Double(props.getProperty("wellbalanced"));
			
		} catch (Exception e) {
			System.err.println("Error reading scrolls.properties, using defaults");
		}
	}

	public double getEnthu() {
		return enthu;
	}

	public double getForce() {
		return force;
	}

	public double getArmadi() {
		return armadi;
	}

	public double getSenti() {
		return senti;
	}

	public double getTut() {
		return tut;
	}

	public double getRes() {
		return res;
	}

	public double getMaster() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getWb() {
		// TODO Auto-generated method stub
		return wb;
	}
	
}
