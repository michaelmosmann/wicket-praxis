package de.wicketpraxis.usecase.bigtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;


public class BigComponentTreePage extends WebPage {

	public BigComponentTreePage() {
		final List<String> names=Arrays.asList("1","2","3","4","5","6","7","8","A","B","C","D","E","F");
		add(new ListView<String>("row",names) {

			@Override
			protected void populateItem(ListItem<String> item) {
				final IModel<String> rowModel = item.getModel();
				item.add(new ListView<String>("column",names) {

					@Override
					protected void populateItem(final ListItem<String> item) {
						Label label = new Label("entry",new LoadableDetachableModel<String>() {

							@Override
							protected String load() {
								return item.getModel().getObject()+"x"+rowModel.getObject();
							}
							
							@Override
							protected void onDetach() {
								item.getModel().detach();
								rowModel.detach();
							}
							
						});
						Link<Void> link = new Link<Void>("link") {

							String randomWorkloadData=new Date().toString();
							double randomWorkload = Math.random();
							
							@Override
							public void onClick() {
								
							}
						};
						link.add(label);
						item.add(link);
						
					}
				});
			}
		});
	}
}
