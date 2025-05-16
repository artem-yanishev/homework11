import java.time.LocalDate;

public class Homework {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        short year = 2025;
        checkLeapYear(year);
    }

    /**
     * Проверяет, является ли год високосным
     * @param year год для проверки
     */
    public static void checkLeapYear(int year) {
        if (year <= 1584) {
            System.out.println(year + " год: григорианский календарь ещё не введён.");
        } else if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            System.out.println(year + " год — високосный год.");
        } else {
            System.out.println(year + " год — невисокосный год.");
        }
    }

    public static void task2() {
        recommendAppVersion((byte) 1, (short) 2025);
    }

    /**
     * Метод для рекомендации версии приложения
     * @param clientOS 0 - iOS, 1 - Android
     * @param clientDeviceYear год выпуска устройства
     */
    public static void recommendAppVersion(byte clientOS, short clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 0 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (clientOS == 0 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        } else if (clientOS == 1 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    public static void task3() {
        byte days = calculationDeliveryDays((byte)95);
        if (days == -1) {
            System.out.println("Доставки нет.");
        } else {
            System.out.println("Потребуется дней: " + days);
        }
    }

    /**
     * Метод для расчёта дней доставки
     * @param deliveryDistance дистанция доставки
     * @return дни доставки (1-3) или -1, если доставки нет
     */
    public static byte calculationDeliveryDays(byte deliveryDistance) {
        if (deliveryDistance > 100) {
            return -1;
        }
        byte deliveryDays = 1;
        if (deliveryDistance > 20) {
            deliveryDays++;
        }
        if (deliveryDistance > 60) {
            deliveryDays++;
        }
        return deliveryDays;
    }
}