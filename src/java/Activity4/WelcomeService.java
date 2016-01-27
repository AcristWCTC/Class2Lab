/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activity4;

import java.time.LocalDateTime;


/**
 *
 * @author Adam
 */
public class WelcomeService {
    // afternoon 12pm
    // evening 6pm
    // morning 12am
    
        public String sayWelcome(String name) {
            LocalDateTime time = LocalDateTime.now();
            String msg = null;
            
            if (time.getHour() > 0 && time.getHour() < 12){
                msg = "Welcome " + name + ", and Good Morning";
        } else if (time.getHour() >= 12 && time.getHour() < 18){
                msg = "Welcome " + name + ", and Good Afternoon";
        }else {
            msg = "Welcome " + name + ", and Good Evening";
        }
            return msg;
        }  
    
}
