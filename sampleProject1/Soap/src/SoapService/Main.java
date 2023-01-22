package SoapService;

import SoapService.Calculator;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("service is published...");
        Endpoint.publish(
          "http://localhost:8888/cal",
          new Calculator()
        );
    }
}