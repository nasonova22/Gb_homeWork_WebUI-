package lesson4;

public class Triangle {

    public static double AreaTriangle(double a, double b, double c) {
        double p;
        if ((a<=0) | (b<=0) | (c<=0)| (a+b<c) | (a+c<b) | (b+c<a)) {
            System.out.println("Тругольник с такими сторонами не существует");
            // если треугольник не существует, возвращаем -1
            return (-1);
        }
        p=(a+b+c)/2;
        // если треугольник существует, возвращаем его площадь
        return(Math.sqrt(p*(p-a)*(p-c)*(p-b)));
    }
}
