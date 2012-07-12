package de.wicketpraxis.web.blog.pages.questions.listview.ajax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

public class ListViewAjaxRefreshPage extends WebPage {

	String search;

	FileSearchService fileSearchService = new FileSearchService();

	public ListViewAjaxRefreshPage() {

		final Form<Void> form = new Form<Void>("search");
		add(form);

		final TextField<String> query = new TextField<String>("query", new PropertyModel<String>(this, "search"));
		form.add(query);

		List<CustomFileDescription> results = null;
		final WebMarkupContainer resultcontainer = new WebMarkupContainer("resultcontainer");
		add(resultcontainer.setOutputMarkupId(true));

		final ListView<CustomFileDescription> files = new ListView<CustomFileDescription>("files", results) {

			@Override
			protected void populateItem(ListItem<CustomFileDescription> item) {
				final CustomFileDescription fileDesc = item.getModelObject();
				item.setModel(new CompoundPropertyModel<CustomFileDescription>(fileDesc));
				item.add(new Label("name"));
				item.add(new Label("lastModified"));
			}
		};
		// files.setReuseItems(true);
		resultcontainer.add(files);

		final IndicatingAjaxButton buttquery = new IndicatingAjaxButton("submit", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				final List<CustomFileDescription> results = fileSearchService.search(query.getDefaultModelObjectAsString());
				System.out.println(results.size());
				files.setDefaultModelObject(results);
				target.addComponent(resultcontainer);
			}
			
			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				
			}
		};
		form.add(buttquery);

	}

	static class CustomFileDescription implements Serializable {

		String _name;

		long _lastModified;

		public CustomFileDescription(String name, long last) {
			_name = name;
			_lastModified = last;
		}

		public String getName() {
			return _name;
		}

		public long getLastModified() {
			return _lastModified;
		}
	}

	static class FileSearchService {

		public List<CustomFileDescription> search(String defaultModelObjectAsString) {
			ArrayList<CustomFileDescription> ret = new ArrayList<CustomFileDescription>();
			ret.add(new CustomFileDescription("klaus", new Date().getTime()));
			ret.add(new CustomFileDescription("bert", new Date().getTime()));
			return ret;
		}

	}
}
