package de.wicketpraxis.web.blog.pages.questions.ajax.modal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public class CustomModalWindow extends ModalWindow {

	private static PackageResourceReference CSS = new PackageResourceReference(CustomModalWindow.class,
			"styles/custom-modal.css");
	private static ResourceReference JAVASCRIPT = new PackageResourceReference(CustomModalWindow.class,
			"styles/custom-modal.js");

	public CustomModalWindow(String id) {
		super(id);

		setCssClassName("custom");


		setCloseButtonCallback(new CloseButtonCallback() {

			public boolean onCloseButtonClicked(AjaxRequestTarget target) {
				return onCloseClicked(target);
			}
		});

		setWindowClosedCallback(new WindowClosedCallback() {

			public void onClose(AjaxRequestTarget target) {
				CustomModalWindow.this.onClose(target);
			}
		});
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptReferenceHeaderItem.forReference(JAVASCRIPT));
		response.render(CssReferenceHeaderItem.forReference(CSS));
	}

	protected void onClose(AjaxRequestTarget target) {

	}

	protected boolean onCloseClicked(AjaxRequestTarget target) {
		return true;
	}
}
