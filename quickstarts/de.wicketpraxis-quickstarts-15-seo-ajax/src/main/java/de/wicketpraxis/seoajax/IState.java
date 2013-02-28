package de.wicketpraxis.seoajax;

import java.io.Serializable;

public interface IState extends Serializable {
	IState oneUp();
	IState oneDown();
	int getCounter();
}
