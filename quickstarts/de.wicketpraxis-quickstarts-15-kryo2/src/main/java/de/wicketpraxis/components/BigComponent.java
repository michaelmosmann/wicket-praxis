package de.wicketpraxis.components;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

public class BigComponent extends Panel {

	private BigContainer data;

	public BigComponent(String id, int size) {
		super(id,Model.of(Strings.toHexString(new byte[size/4])));
		
		data=new BigContainer(size);
	}

}
