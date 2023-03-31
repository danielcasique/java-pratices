package org.casique.oop.liskov;

interface Figure{
    double calculateArea();
}

class Rectangle2 implements Figure {

    private double height;
    private double width;

    public double area(){
        return height*width;
    };

    public void setHeight(double height){
        this.height = height;
    };

    public void setWidth(double width){
        this.width = width;
    };

    public double calculateArea(){
        return height * width;
    }

}

class Square2 implements Figure {

    private double side;

    public void setSide(double side){
        this.side = side;
    }

    public double calculateArea(){
        return Math.pow(side, 2);
    }

}

public class Liskov2 {

    public static void calculateArea(Figure obj){
        System.out.println(obj.calculateArea());
    }

    public static void main(String ...args){
        Rectangle2 rectangle = new Rectangle2();
        rectangle.setHeight(5);
        rectangle.setWidth(4);
        Square2 square = new Square2();
        square.setSide(5);
        calculateArea(rectangle);
        calculateArea(square);
    }
}
