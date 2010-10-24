package de.wicketpraxis.web.blog.pages.questions.listview.model;

import java.util.List;
import java.util.logging.Logger;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

public class ListViewModelChangePage extends WebPage
{
	private static final Logger _logger = Logger.getLogger(ListViewModelChangePage.class.getName());
	
	ProduktDao _produktDao=new ProduktDao();
	
	public ListViewModelChangePage()
	{
		IModel<List<Produkt>> listModel = new LoadableDetachableModel<List<Produkt>>()
		{
			@Override
			protected List<Produkt> load()
			{
				_logger.severe("Produktliste");
				return _produktDao.getProdukte();
			}
		};
		
		final WebMarkupContainer blockA = new WebMarkupContainer("blockA");
		blockA.setOutputMarkupId(true);
		blockA.add(new ListView<Produkt>("liste",listModel)
		{
			@Override
			protected void populateItem(ListItem<Produkt> item)
			{
				item.add(new Label("id",new PropertyModel<String>(item.getModel(),"id")));
				item.add(new Label("name",new PropertyModel<String>(item.getModel(),"name")));
				item.add(new Label("aktiv",new PropertyModel<String>(item.getModel(),"aktiv")));
				item.add(new AjaxFallbackLink<Produkt>("change",item.getModel())
				{
					@Override
					public void onClick(AjaxRequestTarget target)
					{
						Produkt produkt = getModelObject();
						produkt.setAktiv(!produkt.isAktiv());
						_produktDao.update(produkt);
						if (target!=null) target.addComponent(blockA);
					}
				});
			}
		});
		add(blockA);
	}
}
