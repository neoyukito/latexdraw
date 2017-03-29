/*
 * This file is part of LaTeXDraw
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 * LaTeXDraw is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * LaTeXDraw is distributed without any warranty; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */
package net.sf.latexdraw.view.jfx;

import java.util.Optional;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import net.sf.latexdraw.models.MathUtils;
import net.sf.latexdraw.models.interfaces.shape.IAxes;
import net.sf.latexdraw.models.interfaces.shape.IBezierCurve;
import net.sf.latexdraw.models.interfaces.shape.ICircle;
import net.sf.latexdraw.models.interfaces.shape.IDot;
import net.sf.latexdraw.models.interfaces.shape.IEllipse;
import net.sf.latexdraw.models.interfaces.shape.IFreehand;
import net.sf.latexdraw.models.interfaces.shape.IGrid;
import net.sf.latexdraw.models.interfaces.shape.IGroup;
import net.sf.latexdraw.models.interfaces.shape.IPicture;
import net.sf.latexdraw.models.interfaces.shape.IPolygon;
import net.sf.latexdraw.models.interfaces.shape.IPolyline;
import net.sf.latexdraw.models.interfaces.shape.IRectangle;
import net.sf.latexdraw.models.interfaces.shape.IRhombus;
import net.sf.latexdraw.models.interfaces.shape.IShape;
import net.sf.latexdraw.models.interfaces.shape.ISquare;
import net.sf.latexdraw.models.interfaces.shape.IText;
import net.sf.latexdraw.models.interfaces.shape.ITriangle;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The factory that creates views from given models.
 */
@NonNullByDefault
public final class ViewFactory {
	/** The singleton. */
	public static final ViewFactory INSTANCE = new ViewFactory();

	private ViewFactory() {
		super();
	}

	/**
	 * Creates a view from a shape.
	 * @param shape The shape used to create the view.
	 * @return The created view or empty.
	 * @since 3.0
	 */
	public <T extends IShape, S extends ViewShape<T>> Optional<S> createView(final @Nullable T shape) {
		if(shape instanceof IGroup) return Optional.of((S) new ViewGroup((IGroup) shape));
		// if(shape instanceof IPlot) return new LPlotView((IPlot)shape);
		if(shape instanceof ISquare) return Optional.of((S) new ViewSquare((ISquare) shape));
		if(shape instanceof IRectangle) return Optional.of((S) new ViewRectangle((IRectangle) shape));
		if(shape instanceof IText) return Optional.of((S) new ViewTextText((IText) shape));
		// if(shape instanceof ICircleArc) return new LCircleArcView((ICircleArc)shape);
		if(shape instanceof ICircle) return Optional.of((S) new ViewCircle((ICircle) shape));
		if(shape instanceof IEllipse) return Optional.of((S) new ViewEllipse((IEllipse) shape));
		if(shape instanceof ITriangle) return Optional.of((S) new ViewTriangle((ITriangle) shape));
		if(shape instanceof IRhombus) return Optional.of((S) new ViewRhombus((IRhombus) shape));
		if(shape instanceof IPolyline) return Optional.of((S) new ViewPolyline((IPolyline) shape));
		if(shape instanceof IPolygon) return Optional.of((S) new ViewPolygon((IPolygon) shape));
		if(shape instanceof IBezierCurve) return Optional.of((S) new ViewBezierCurve((IBezierCurve) shape));
		if(shape instanceof IAxes) return Optional.of((S) new ViewAxes((IAxes) shape));
		if(shape instanceof IGrid) return Optional.of((S) new ViewGrid((IGrid) shape));
		if(shape instanceof IDot) return Optional.of((S) new ViewDot((IDot) shape));
		if(shape instanceof IPicture) return Optional.of((S) new ViewPicture((IPicture) shape));
		if(shape instanceof IFreehand) return Optional.of((S) new ViewFreeHand((IFreehand) shape));
		return Optional.empty();
	}

	public LineTo createLineTo(final double x, final double y) {
		return new EqLineTo(x, y);
	}

	public MoveTo createMoveTo(final double x, final double y) {
		return new EqMoveTo(x, y);
	}

	public ClosePath createClosePath() {
		return new EqClosePath();
	}

	public CubicCurveTo createCubicCurveTo(final double controlX1, final double controlY1, final double controlX2, final double controlY2, final double x, final double y) {
		return new EqCubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y);
	}


	private static class EqCubicCurveTo extends CubicCurveTo {
		EqCubicCurveTo(final double controlX1, final double controlY1, final double controlX2, final double controlY2, final double x, final double y) {
			super(controlX1, controlY1, controlX2, controlY2, x, y);
		}

		@Override
		public boolean equals(final Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;

			EqCubicCurveTo that = (EqCubicCurveTo) o;

			if(Double.compare(that.getControlX1(), getControlX1()) != 0) return false;
			if(Double.compare(that.getControlY1(), getControlY1()) != 0) return false;
			if(Double.compare(that.getControlX2(), getControlX2()) != 0) return false;
			if(Double.compare(that.getControlY2(), getControlY2()) != 0) return false;
			if(Double.compare(that.getX(), getX()) != 0) return false;
			return Double.compare(that.getY(), getY()) == 0;
		}

		@Override
		public int hashCode() {
			int result;
			long temp;
			temp = Double.doubleToLongBits(getControlX1());
			result = (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getControlY1());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getControlX2());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getControlY2());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getX());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getY());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			return result;
		}
	}


	private static class EqClosePath extends ClosePath {
		@Override
		public boolean equals(final Object obj) {
			return obj != null && (obj == this || obj instanceof ClosePath);
		}
	}


	private static class EqLineTo extends LineTo {
		EqLineTo(final double x, final double y) {
			super(x, y);
		}

		@Override
		public int hashCode() {
			int result;
			long temp = Double.doubleToLongBits(getX());
			result = (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getY());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			result = 31 * result + (isAbsolute() ? 1 : 0);
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if(obj == null) return false;
			if(obj == this) return true;
			if(!(obj instanceof LineTo)) return false;
			final LineTo lt = (LineTo) obj;
			return MathUtils.INST.equalsDouble(lt.getX(), getX()) && MathUtils.INST.equalsDouble(lt.getY(), getY()) && lt.isAbsolute() == isAbsolute();
		}
	}


	private static class EqMoveTo extends MoveTo {
		EqMoveTo(final double x, final double y) {
			super(x, y);
		}

		@Override
		public int hashCode() {
			int result;
			long temp = Double.doubleToLongBits(getX());
			result = (int) (temp ^ temp >>> 32);
			temp = Double.doubleToLongBits(getY());
			result = 31 * result + (int) (temp ^ temp >>> 32);
			result = 31 * result + (isAbsolute() ? 1 : 0);
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if(obj == null) return false;
			if(obj == this) return true;
			if(!(obj instanceof MoveTo)) return false;
			final MoveTo mt = (MoveTo) obj;
			return MathUtils.INST.equalsDouble(mt.getX(), getX()) && MathUtils.INST.equalsDouble(mt.getY(), getY()) && mt.isAbsolute() == isAbsolute();
		}
	}
}
