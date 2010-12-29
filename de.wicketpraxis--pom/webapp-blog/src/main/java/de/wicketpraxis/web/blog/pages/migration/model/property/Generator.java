package de.wicketpraxis.web.blog.pages.migration.model.property;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Generator implements Serializable {

	public List<String> findAll() {
		return Arrays.asList("fun", "with", "wicket");
	}
}
