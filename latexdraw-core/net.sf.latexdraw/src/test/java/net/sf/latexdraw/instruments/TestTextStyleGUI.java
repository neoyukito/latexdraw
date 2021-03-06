package net.sf.latexdraw.instruments;

import java.util.concurrent.TimeoutException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import net.sf.latexdraw.models.interfaces.shape.TextPosition;
import net.sf.latexdraw.view.latex.LaTeXGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class TestTextStyleGUI extends TestShapePropGUI<ShapeTextCustomiser> {
	protected ComboBox<TextPosition> textPos;
	protected TextArea packagesField;
	protected TextArea logField;

	protected final GUICommand<TextPosition> selectPosition = item -> selectGivenComboBoxItem(textPos, item);

	@Override
	public String getFXMLPathFromLatexdraw() {
		return "/fxml/TextStyle.fxml";
	}

	@Override
	@Before
	public void setUp() {
		super.setUp();
		textPos = find("#textPos");
		packagesField = find("#packagesField");
		logField = find("#logField");
		ins = (ShapeTextCustomiser) injectorFactory.call(ShapeTextCustomiser.class);
		ins.setActivated(true);
	}

	@Override
	@After
	public void tearDown() throws TimeoutException {
		LaTeXGenerator.setPackages("");
		super.tearDown();
	}

	@Test
	public void testEditPackagesField() {
		clickOn(packagesField).type(KeyCode.A).type(KeyCode.B).sleep(1300L);
		assertEquals("ab", LaTeXGenerator.getPackages());
	}
}
