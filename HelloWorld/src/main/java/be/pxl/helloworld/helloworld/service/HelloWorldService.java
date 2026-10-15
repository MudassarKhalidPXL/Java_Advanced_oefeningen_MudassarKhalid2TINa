package be.pxl.helloworld.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public HelloWorldService() {

    }

    public int calculateSum(int a, int b) {
        return a + b;
    }
}
