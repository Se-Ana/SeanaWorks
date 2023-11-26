import java.util.Arrays;
import java.util.Collections;

public class BenefitCalculator {
    public static void main(String[] args) {
        String inn = "1234567890";
        boolean isClientIP = inn.length() > 10;
        System.out.println(isClientIP);

        int userInput_PayUL = 25;

        int[] payUL_Limits = new int[] {5, 25, 50};
        int[] payUL_LimitCosts = new int[] {0, 990, 1590};
        int payUL_OverLimitCost = 100;
        int[] payUL_TotalPrices = new int[] {
                getTotalPrice(userInput_PayUL, payUL_Limits[0], payUL_LimitCosts[0], payUL_OverLimitCost),
                getTotalPrice(userInput_PayUL, payUL_Limits[1], payUL_LimitCosts[1], payUL_OverLimitCost),
                getTotalPrice(userInput_PayUL, payUL_Limits[2], payUL_LimitCosts[2], payUL_OverLimitCost)
        };
        var payUL_MinPrice = Collections.min(Arrays.stream(payUL_TotalPrices).boxed().toList());

        int payUL_Limit = -0;
        int payUL_LimitCost = -0;
        if (payUL_MinPrice == payUL_TotalPrices[0]) {
            payUL_Limit = payUL_Limits[0];
            payUL_LimitCost = payUL_LimitCosts[0];
        } if (payUL_MinPrice == payUL_TotalPrices[1]) {
            payUL_Limit = payUL_Limits[1];
            payUL_LimitCost = payUL_LimitCosts[1];
        } if (payUL_MinPrice == payUL_TotalPrices[2]) {
            payUL_Limit = payUL_Limits[2];
            payUL_LimitCost = payUL_LimitCosts[2];
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Была рассчитана общая стоимость указанного количества платежей юрлицам: " + userInput_PayUL + " шт.");
        System.out.println("Для каждого лимита, в порядке очередности, общая сумма составляет: " + Arrays.toString(payUL_TotalPrices) + ".");
        System.out.println("Наименьшей суммой в диапазоне является: " + payUL_MinPrice + " руб.");
        System.out.println("Ей соответствует лимит в " + payUL_Limit + " платежей.");
        System.out.println("Стоимость данной подписки составляет: " + payUL_LimitCost + " руб.");
        System.out.println("Стоимость платежей сверх лимита составляет: " + (payUL_MinPrice - payUL_LimitCost) + " руб.");

    }

    public static int getTotalPrice(int userInput, int limit, int limitCost, int OverLimitCost) {
        int getTotalPrice = (userInput - limit) * OverLimitCost;
        if (getTotalPrice < 0) {getTotalPrice = 0;}
        getTotalPrice = getTotalPrice + limitCost;
        return getTotalPrice;
    }
}
