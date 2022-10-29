class Shape {
    private double volume;

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

class Box extends Shape {


    //Добавление фигуры в контейнер
    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return false;
        } else {

            double freeVolume = this.getVolume() - shape.getVolume();
            this.setVolume(freeVolume);
            return true;
        }
    }
}
class Cylinder extends SolidOfRevolution {
    private double height;
}
class Pyramid extends Shape {
    private double s;
    private double h;

}
class SolidOfRevolution extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

}
class Ball extends SolidOfRevolution {
}


public class Main {

    public static void main(String[] args) {

        Box box = new Box();
        //Максимальный объём коробки
        box.setVolume(100.5);

        //Шар с объёмом 33.5
        Ball ball1 = new Ball();
        ball1.setVolume(33.5);


        //Добавляем шар в коробку
        System.out.println("\nОбъём коробки: " + box.getVolume());
        boolean result = box.add(ball1);
        System.out.println("Отображение добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());

        //Добавляем объёмный объект в коробку
        SolidOfRevolution obj = new SolidOfRevolution();
        obj.setVolume(435);
        System.out.println("\nОбъём коробки: " + box.getVolume());
        result = box.add(obj);
        System.out.println("Отображение добавления объекта: " + result);
        System.out.println("Объём коробки: " + box.getVolume());


    }
}