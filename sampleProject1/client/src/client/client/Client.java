package client.client;

import client.Calculator;
import client.CalculatorService;

public class Client {
    public static void main(String[]args){
        CalculatorService cal = new CalculatorService();
        Calculator port = cal.getCalculatorPort();
        System.out.println(port.add(2,2));
    }
}
