import java.util.Scanner;

public class LoopGame {
    public static void main(String[] args) {

            int secretNumber = (int) (Math.random() * 10) + 1;
            int userNumber = 666;

            for (int i = 1; secretNumber != userNumber; i = i + 1) {
                System.out.println("Введи число от 1 до 10 🔮");
                userNumber = new Scanner(System.in).nextInt();
                if (userNumber != secretNumber) {
                    System.out.println("Крутится рулетка, играет джаз! Ты проиграл, ты пидорас! ¯\\_(ツ)_/¯");
                    System.out.println("-------------------------------------------------------------------");
                } else if (userNumber == secretNumber && (i != 1)) {
                    System.out.println("Ты угадал с " + i + " попыток, дружок!🎉✨");
                    break;
                } else {
                    System.out.println("Ты что, экстрасенс??)))");
                    System.out.println("☆*:.｡. ☆*:.｡. ☆*:.｡. ╰(*°▽°*)╯ .｡.:*☆ .｡.:*☆ .｡.:*☆");
                    break;
                }
            }
    }
}
