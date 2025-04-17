// Интерфейс стратегии печати
interface PrintingStrategy {
    void print();
}

class TextPrintingStrategy implements PrintingStrategy {
    @Override
    public void print() {
        System.out.println("Печать текста.");
    }
}

class PhotoPrintingStrategy implements PrintingStrategy {
    @Override
    public void print() {
        System.out.println("Печать фотографии.");
    }
}

class ThreeDPrintingStrategy implements PrintingStrategy {
    @Override
    public void print() {
        System.out.println("3D-печать модели.");
    }
}

// Класс Принтер, использующий стратегию
class Printer {
    private PrintingStrategy strategy;

    // Установка стратегии
    public void setStrategy(PrintingStrategy strategy) {
        this.strategy = strategy;
    }

    // Выполнение печати
    public void executePrinting() {
        if (strategy != null) {
            strategy.print();
        } else {
            System.out.println("Стратегия не установлена.");
        }
    }
}

// Главный класс для демонстрации работы программы
public class Main {
    public static void main(String[] args) {
        // Создаем принтер
        Printer printer = new Printer();

        // Установка и выполнение текстовой печати
        printer.setStrategy(new TextPrintingStrategy());
        printer.executePrinting();

        // Смена стратегии на печать фотографий
        printer.setStrategy(new PhotoPrintingStrategy());
        printer.executePrinting();

        // Смена стратегии на 3D печать
        printer.setStrategy(new ThreeDPrintingStrategy());
        printer.executePrinting();
    }
}
