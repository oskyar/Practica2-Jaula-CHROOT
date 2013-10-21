package nl.topicus.heroku.wicket;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
		add(feedbackPanel);
		feedbackPanel.setOutputMarkupId(true);

		Form<?> form = new Form("form");

		Label pregunta = new Label(
				"pregunta",
				"�Qu� tipo de virtualizaci�n requiere la modificaci�n de los sistemas operativos?");
		form.add(pregunta);

		final TextField<String> areaRespuesta = new TextField("respuesta", new Model(""));
		areaRespuesta.setOutputMarkupId(true);
		areaRespuesta.setRequired(true);
		form.add(areaRespuesta);
		Button evaluar = new Button("evaluar") {
			public void onSubmit() {
				String respuesta = areaRespuesta.getModelObject();
				if (respuesta.equals("paravirtualizacion")) {
					feedbackPanel
							.info("�Enhorabuena! �Has aprendido mucho con JJ!");
				} else {
					feedbackPanel
							.error("�Error! Hay que estudiar un poquito m�s...");
				}
			}
		};
		form.add(evaluar);
		add(form);
	}
}
