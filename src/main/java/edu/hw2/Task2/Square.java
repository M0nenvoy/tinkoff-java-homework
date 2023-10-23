package edu.hw2.Task2;

public class Square extends Rectangle {
    Square() {
        this(0);
    }

    Square(int size) {
        this.height = size;
        this.width = size;
    }

    @Override
    Rectangle setWidth(int width) {
        if (width == this.width) {
            return this;
        }

        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        if (height == this.height) {
            return this;
        }

        return new Rectangle(this.width, height);
    }
}
