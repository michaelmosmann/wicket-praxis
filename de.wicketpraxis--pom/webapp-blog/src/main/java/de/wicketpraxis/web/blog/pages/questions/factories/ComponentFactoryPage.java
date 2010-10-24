package de.wicketpraxis.web.blog.pages.questions.factories;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class ComponentFactoryPage extends WebPage
{
	public ComponentFactoryPage()
	{
		Model<String> redBorderStyle = Model.of("border:1px solid red; background-color: #fff0f0;");
		Model<String> greenBorderStyle = Model.of("border:1px solid green; background-color: #f0fff0;");
		Model<String> blueBorderStyle = Model.of("border:1px solid blue; background-color: #f0f0ff;");
		
		LabelFactory haveFunLabelFactory = new LabelFactory(Model.of("Have Fun"));
		
		BorderPanelFactory redBorderHasFunFactory = new BorderPanelFactory(haveFunLabelFactory,redBorderStyle);
		BorderPanelFactory greenBorderWrapsRedFactory = new BorderPanelFactory(redBorderHasFunFactory,greenBorderStyle);
		BorderPanelFactory blueBorderWrapsAllFactory = new BorderPanelFactory(greenBorderWrapsRedFactory,blueBorderStyle);
		
		add(blueBorderWrapsAllFactory.newComponent("element"));
		
		TwoInARowFactory twoInARowFactory = new TwoInARowFactory(redBorderHasFunFactory, greenBorderWrapsRedFactory);
		
		add(twoInARowFactory.newComponent("two"));
	}
}
