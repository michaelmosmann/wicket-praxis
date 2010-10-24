package de.wicketpraxis.web.blog.pages.questions.email;

public interface WicketCallback<I,O>
{
	public O getResult(I input);
}
