import Games.*;

public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "FiveCardDraw":
                FiveCardDraw f = new FiveCardDraw();
                f.play();
                break;
            default:
                System.exit(0);
        }
    }
}
