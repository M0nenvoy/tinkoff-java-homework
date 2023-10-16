package edu.hw2.Task2;

public class Rectangle {
    protected int width;
    protected int height;

    Rectangle() {
        this(0, 0);
    }

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle setWidth(int width) {
        if (width == this.height) {
            return new Square(this.width);
        }

        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        if (height == this.width) {
            return new Square(this.width);
        }

        return new Rectangle(this.width, height);
    }

    double area() {
        return this.width * this.height;
    }
}
