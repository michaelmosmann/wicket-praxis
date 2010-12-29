package de.wicketpraxis.web.blog.pages.questions.ajax.modal;

import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.time.Duration;

public class ModalWindowPage extends WebPage {

	public ModalWindowPage() {
		final CustomModalWindow modalWindow = new CustomModalWindow("modal");

		modalWindow.setTitle("Popup");
		modalWindow.setInitialWidth(400);
		modalWindow.setInitialHeight(400);
		modalWindow.setResizable(true);
		modalWindow.setContent(new AbstractModalClosePanel(modalWindow) {

			@Override
			public void onClick(AjaxRequestTarget target) {
				modalWindow.close(target);
			}
		});
		add(modalWindow);

		add(new AjaxLink<Void>("open") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				modalWindow.show(target);
			}
		});

		add(new AbstractAjaxTimerBehavior(Duration.seconds(2)) {

			@Override
			protected void onTimer(AjaxRequestTarget target) {
				modalWindow.show(target);
				stop();
			}
		});
	}
}
