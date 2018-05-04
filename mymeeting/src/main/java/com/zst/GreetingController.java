package com.zst;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        
        if(message.getName().contains("wangle")){
        	Thread.sleep(1000 * 10);
        	System.out.println("wangle delay 10 seconds in" + new Date());
        }
        
        return new Greeting("Hello, " + message.getName() + "!");
    }
    
    @MessageMapping("/zst")
    @SendTo("/topic/greetings")
    public Greeting hellozst(HelloMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        
        if(message.getName().contains("wangle")){
        	Thread.sleep(1000 * 10);
        	System.out.println("wangle delay 10 seconds in" + new Date());
        }
        
        return new Greeting("zst, " + message.getName() + "!");
    }

}
