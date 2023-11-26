import java.util.Arrays;
import java.util.Collections;

public class BenefitCalculator {
    public static void main(String[] args) {

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

        //-------------------------------------------------------------------------------------------------------------------------------

        String inn = "1234567890";
        boolean isClientIP = inn.length() > 10;

        int userInput_PayFL = 1505000;

        int[] payFL_Limits = new int[] {300000, 500000, 1000000};
        int[] payFL_LimitCosts = new int[] {0, 2490, 5990};
        if (isClientIP) {
            payFL_LimitCosts[1] = 690;
            payFL_LimitCosts[2] = 3190;
        }
        double payFL_OverLimitCost = 0.035;
        int[] payFL_TotalPrices = new int[] {
                getTotalPriceIfDouble(userInput_PayFL, payFL_Limits[0], payFL_LimitCosts[0], payFL_OverLimitCost),
                getTotalPriceIfDouble(userInput_PayFL, payFL_Limits[1], payFL_LimitCosts[1], payFL_OverLimitCost),
                getTotalPriceIfDouble(userInput_PayFL, payFL_Limits[2], payFL_LimitCosts[2], payFL_OverLimitCost)
        };
        var payFL_MinPrice = Collections.min(Arrays.stream(payFL_TotalPrices).boxed().toList());

        int payFL_Limit = -0;
        int payFL_LimitCost = -0;
        if (payFL_MinPrice == payFL_TotalPrices[0]) {
            payFL_Limit = payFL_Limits[0];
            payFL_LimitCost = payFL_LimitCosts[0];
        } if (payFL_MinPrice == payFL_TotalPrices[1]) {
            payFL_Limit = payFL_Limits[1];
            payFL_LimitCost = payFL_LimitCosts[1];
        } if (payFL_MinPrice == payFL_TotalPrices[2]) {
            payFL_Limit = payFL_Limits[2];
            payFL_LimitCost = payFL_LimitCosts[2];
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Была рассчитана общая стоимость указанной суммы платежей физлицам: " + userInput_PayFL + " руб.");
        System.out.println("Для каждого лимита, в порядке очередности, общая сумма составляет: " + Arrays.toString(payFL_TotalPrices) + ".");
        System.out.println("Наименьшей суммой в диапазоне является: " + payFL_MinPrice + " руб.");
        System.out.println("Ей соответствует лимит в " + payFL_Limit + " руб. на платежи физлицам.");
        System.out.println("Стоимость данной подписки составляет: " + payFL_LimitCost + " руб.");
        System.out.println("Стоимость платежей сверх лимита составляет: " + (payFL_MinPrice - payFL_LimitCost) + " руб.");

        //-------------------------------------------------------------------------------------------------------------------------------
    }

    public static int getTotalPrice(int userInput, int limit, int limitCost, int OverLimitCost) {
        int getTotalPrice = (userInput - limit) * OverLimitCost;
        if (getTotalPrice < 0) {getTotalPrice = 0;}
        getTotalPrice = getTotalPrice + limitCost;
        return getTotalPrice;
    }

    public static int getTotalPriceIfDouble(int userInput, int limit, int limitCost, double OverLimitCost) {
        int getTotalPrice = (userInput - limit);
        getTotalPrice = (int) (Math.round(getTotalPrice * OverLimitCost));
        if (getTotalPrice < 0) {getTotalPrice = 0;}
        getTotalPrice = getTotalPrice + limitCost;
        return getTotalPrice;
    }
}
