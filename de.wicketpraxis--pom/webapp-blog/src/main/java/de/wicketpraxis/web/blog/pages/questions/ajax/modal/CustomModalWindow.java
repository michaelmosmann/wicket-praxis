package de.wicketpraxis.web.blog.pages.questions.ajax.modal;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

public class CustomModalWindow extends ModalWindow {

	private static ResourceReference CSS = new CompressedResourceReference(CustomModalWindow.class,
			"styles/custom-modal.css");
	private static ResourceReference JAVASCRIPT = new JavascriptResourceReference(CustomModalWindow.class,
			"styles/custom-modal.js");

	public CustomModalWindow(String id) {
		super(id);

		setCssClassName("custom");

		add(JavascriptPackageResource.getHeaderContribution(JAVASCRIPT));
		add(CSSPackageResource.getHeaderContribution(CSS));

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

	protected void onClose(AjaxRequestTarget target) {

	}

	protected boolean onCloseClicked(AjaxRequestTarget target) {
		return true;
	}
}
