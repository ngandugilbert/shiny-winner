package Question2;

import Question2.windows.Accounts;

import Question2.windows.LauchGeneric;

public class Program {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {

        new LauchGeneric<Accounts, Accounts >(new Accounts());

    }
}
