package net.sf.latexdraw.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestResources {

	private String path;

	public TestResources(final String pathToTest) {
		path = pathToTest;
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<String> getPaths() {
		return Arrays.asList("/res/LaTeXDrawIcon.png",
			"/res/LaTeXDrawSmall.png",
			"/res/emblem-important.png",
			"/res/help-browser.png",
			"/res/comment.png",
			"/res/preferences-desktop-theme.png",
			"/res/New.png",
			"/res/hatch/hatch.none.png",
			"/res/hatch/hatch.vert.png",
			"/res/hatch/hatch.horiz.png",
			"/res/hatch/hatch.cross.png",
			"/res/arrowStyles/line.arc.left.png",
			"/res/arrowStyles/line.arc.right.png",
			"/res/arrowStyles/line.arc.r.left.png",
			"/res/arrowStyles/line.arc.r.right.png",
			"/res/arrowStyles/line.arrow.left.png",
			"/res/arrowStyles/line.arrow.right.png",
			"/res/arrowStyles/line.barEnd.left.png",
			"/res/arrowStyles/line.barEnd.right.png",
			"/res/arrowStyles/line.barIn.left.png",
			"/res/arrowStyles/line.barIn.right.png",
			"/res/arrowStyles/line.bracket.left.png",
			"/res/arrowStyles/line.bracket.right.png",
			"/res/arrowStyles/line.bracket.r.left.png",
			"/res/arrowStyles/line.bracket.r.right.png",
			"/res/arrowStyles/line.circle.end.left.png",
			"/res/arrowStyles/line.circle.end.right.png",
			"/res/arrowStyles/line.circle.in.left.png",
			"/res/arrowStyles/line.circle.in.right.png",
			"/res/arrowStyles/line.dbleArrow.left.png",
			"/res/arrowStyles/line.dbleArrow.right.png",
			"/res/arrowStyles/line.disk.end.left.png",
			"/res/arrowStyles/line.disk.end.right.png",
			"/res/arrowStyles/line.disk.in.left.png",
			"/res/arrowStyles/line.disk.in.right.png",
			"/res/arrowStyles/line.none.left.png",
			"/res/arrowStyles/line.none.right.png",
			"/res/arrowStyles/line.rarrow.left.png",
			"/res/arrowStyles/line.rarrow.right.png",
			"/res/arrowStyles/line.rdbleArrow.left.png",
			"/res/arrowStyles/line.rdbleArrow.right.png",
			"/res/arrowStyles/line.roundIn.left.png",
			"/res/arrowStyles/line.roundIn.right.png",
			"/res/dotStyles/dot.asterisk.png",
			"/res/dotStyles/dot.none.png",
			"/res/dotStyles/dot.bar.png",
			"/res/dotStyles/dot.o.png",
			"/res/dotStyles/dot.cross.png",
			"/res/dotStyles/dot.diamond.png",
			"/res/dotStyles/dot.diamondF.png",
			"/res/dotStyles/dot.ocross.png",
			"/res/dotStyles/dot.oplus.png",
			"/res/dotStyles/dot.pentagon.png",
			"/res/dotStyles/dot.pentagonF.png",
			"/res/dotStyles/dot.plus.png",
			"/res/dotStyles/dot.square.png",
			"/res/dotStyles/dot.squareF.png",
			"/res/dotStyles/dot.triangle.png",
			"/res/dotStyles/dot.triangleF.png",
			"/res/lineStyles/lineStyle.none.png",
			"/res/lineStyles/lineStyle.dashed.png",
			"/res/lineStyles/lineStyle.dotted.png",
			"/res/doubleBoundary/double.boundary.middle.png",
			"/res/doubleBoundary/double.boundary.into.png",
			"/res/doubleBoundary/double.boundary.out.png",
			"/res/grid.png",
			"/res/Copy.png",
			"/res/Paste.png",
			"/res/Cut.png",
			"/res/Draw.png",
			"/res/text.png",
			"/res/polygon.png",
			"/res/background.png",
			"/res/foreground.png",
			"/res/Undo.png",
			"/res/Redo.png",
			"/res/Magnify.png",
			"/res/wedge.png",
			"/res/Arc.png",
			"/res/document-open.png",
			"/res/document-save.png",
			"/res/document-save-as.png",
			"/res/circle.png",
			"/res/del.png",
			"/res/dot.png",
			"/res/ellipse.png",
			"/res/empty.png",
			"/res/rectangle.png",
			"/res/rhombus.png",
			"/res/select.png",
			"/res/square.png",
			"/res/triangle.png",
			"/res/join.png",
			"/res/separate.png",
			"/res/bezierCurve.png",
			"/res/chord.png",
			"/res/joinedLines.png",
			"/res/emblem-unreadable.png",
			"/res/stop.png",
			"/res/image-x-generic.png",
			"/res/thickness.png",
			"/res/hatch/gradient.png",
			"/res/rotation180.png",
			"/res/rotation90.png",
			"/res/rotation270.png",
			"/res/mirrorH.png",
			"/res/mirrorV.png",
			"/res/axes.png",
			"/res/texEditor.png",
			"/res/freehand/curve.png",
			"/res/freehand/line.png");
	}

	@Test
	public void testFileResource() {
		assertTrue(Files.isReadable(Paths.get(getClass().getResource(path).getPath())));
	}
}
