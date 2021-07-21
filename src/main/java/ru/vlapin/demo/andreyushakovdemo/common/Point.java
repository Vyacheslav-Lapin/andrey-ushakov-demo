package ru.vlapin.demo.andreyushakovdemo.common;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.jetbrains.annotations.Contract;

@RequiredArgsConstructor
public class Point {

  int x;
  int y;

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object o) {
    return this == o
               || o instanceof Point point
                      && point.canEquals(this)
                      && x == point.x && y == point.y;
  }

  @Contract(pure = true)
  protected boolean canEquals(Object __) {
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Contract(pure = true)
  public static void main(String... __) {
    val point = new Point(5, 3);

    //1 рефлексивность
    System.out.println("point.equals(point) = " + point.equals(point)); //true

    //2. симметричность
    System.out.println("point.equals(new Point(5, 3)) = " + point.equals(new Point(5, 3))); // true

    val coloredPoint1 = new ColoredPoint(5, 3, 1);
    System.out.println("point.equals(coloredPoint1) = " + point.equals(coloredPoint1)); // true
    System.out.println("coloredPoint1.equals(point) = " + coloredPoint1.equals(point)); // true

    // 3. транзитивность
    val coloredPoint2 = new ColoredPoint(5, 3, 2);
    System.out.println("point.equals(coloredPoint1) = " + point.equals(coloredPoint1)); // true
    System.out.println("point.equals(coloredPoint2) = " + point.equals(coloredPoint2)); // true
    System.out.println("coloredPoint1.equals(coloredPoint2) = " + coloredPoint1.equals(coloredPoint2)); // false
  }
}

class ColoredPoint extends Point {

  int color;

  public ColoredPoint(int x, int y, int color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    val result = this == o || o instanceof Point && super.equals(o);
    return o instanceof ColoredPoint coloredPoint && canEquals(o) ?
               result && color == coloredPoint.color
               : result;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), color);
  }

  @Override
  protected boolean canEquals(Object o) {
    return o instanceof ColoredPoint;
  }
}
