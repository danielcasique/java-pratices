package org.casique.oop.liskov;

class Rectangle1 {

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

class Square1 extends Rectangle1 {
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    public void setWidth(double width) {
        setHeight(width);
    }
}


public class Liskov {

    public static void calculateArea(Square1 obj){
        System.out.println(obj.calculateArea());
    }

    public static void main(String ...args){
        Rectangle1 rectangle = new Rectangle1();
        rectangle.setHeight(5);
        rectangle.setWidth(4);
        Square1 square = new Square1();
        square.setHeight(5);
        calculateArea((Square1) rectangle);
        calculateArea(square);
    }
}
