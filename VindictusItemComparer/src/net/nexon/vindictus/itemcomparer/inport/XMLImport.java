package net.nexon.vindictus.itemcomparer.inport;

import java.io.File;

import javax.xml.bind.JAXB;

import net.nexon.vindictus.itemcomparer.modell.Items;

public class XMLImport {


	public static Items importItems(String filename) throws Exception{
		return JAXB.unmarshal( new File(filename), Items.class );
		
	}
	public static Items importItems(File file) throws Exception{
		return JAXB.unmarshal( file, Items.class );
		
	}

}
