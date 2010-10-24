/*****************************************
Quelltexte zum Buch: Praxisbuch Wicket
(http://www.hanser.de/978-3-446-41909-4)

Autor: Michael Mosmann
(michael@mosmann.de)
*****************************************/
package de.wicketpraxis.web.components.paging;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import de.wicketpraxis.web.model.Cascading2LoadableDetachableModel;

public class OffsetPagePanel extends Panel
{
	IModel<Integer> _offsetModel;

	IModel<? extends Integer> _perPageModel;

	IModel<? extends Integer> _sizeModel;

	public OffsetPagePanel(String id, IModel<Integer> offsetModel, IModel<? extends Integer> perPageModel, IModel<? extends Integer> sizeModel)
	{
		super(id);

		_offsetModel = offsetModel;
		_perPageModel = perPageModel;
		_sizeModel = sizeModel;

		Cascading2LoadableDetachableModel<List<Integer>, Integer, Integer> pages = new Cascading2LoadableDetachableModel<List<Integer>, Integer, Integer>(perPageModel,
				sizeModel)
			{
				@Override
				protected List<Integer> load(Integer p2, Integer p3)
				{
					List<Integer> ret = null;

					if ((p2 != null) && (p3 != null))
					{
						int perPage = p2;
						int size = p3;

						int pages = (size + (perPage - 1)) / perPage;

						ret = new ArrayList<Integer>();
						for (int i = 0; i < pages; i++)
						{
							ret.add(i * perPage);
						}
					}
					return ret;
				}
			};

		ListView<Integer> list = new ListView<Integer>("pages", pages)
			{
				@Override
				protected void populateItem(ListItem<Integer> item)
				{
					Link<Integer> link = new Link<Integer>("page", item.getModel())
						{
							@Override
							public void onClick()
							{
								Integer offset=getModelObject();
								_offsetModel.setObject(offset);
							}
						};
					link.add(new Label("name",item.getModel()));
					item.add(link);
					
					Integer cur = item.getModel().getObject();
					if (cur.equals(_offsetModel.getObject()))
					{
						link.setEnabled(false);
					}
				}
			};

		add(list);
		// LoadableDetachableModel<List<Integer>> pages=new
		// LoadableDetachableModel<List<Integer>>()
		// {
		// @Override
		// protected List<Integer> load()
		// {
		// return null;
		// }
		// };

	}

}
