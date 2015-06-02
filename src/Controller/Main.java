package Controller;

import View.GUI;
import Model.Model;

public class Main {

    public static void main(String[] args) {

        Controller controller=new Controller(new GUI(), new Model());
    }
}
