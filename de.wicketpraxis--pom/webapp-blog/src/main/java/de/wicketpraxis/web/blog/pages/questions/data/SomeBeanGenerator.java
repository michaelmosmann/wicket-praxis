package de.wicketpraxis.web.blog.pages.questions.data;

import java.util.ArrayList;
import java.util.List;

public class SomeBeanGenerator {

	public static List<SomeBean> getBeans(int size, SomeBean filter) {
		List<SomeBean> ret = new ArrayList<SomeBean>();

		for (int i = 0; i < size; i++) {
			SomeBean bean = new SomeBean(getVorname(i), getName(i), getAlter(i));
			if (filter != null) {
				if (filter.match(bean)) {
					ret.add(bean);
				}
			} else
				ret.add(bean);
		}

		return ret;
	}

	private static int getAlter(int pos) {
		return (pos % 7) + (pos / 9);
	}

	static String getVorname(int pos) {
		switch (pos % 5) {
			case 0:
				return "Klaus";
			case 1:
				return "Susi";
			case 2:
				return "Petra";
			case 3:
				return "Axel";
		}
		return "Bert";
	}

	static String getName(int pos) {
		switch (pos % 8) {
			case 0:
				return "Schmidt";
			case 1:
				return "Meier";
			case 2:
				return "Schulz";
			case 3:
				return "Schuster";
			case 4:
				return "Müller";
			case 5:
				return "Francis";
			case 6:
				return "Friedrich";
		}
		return "Sommerfeld";
	}
}
