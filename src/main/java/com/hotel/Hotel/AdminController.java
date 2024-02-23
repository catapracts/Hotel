package com.hotel.Hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController 
{

    @GetMapping("/admin")
    public String admin() 
    {
        return "dev_jjw/admin";
    }
    
    @GetMapping("/roomBookList")
    public String roomBookList() 
    {
        return "dev_jjw/roomBookList";
    }
    
    @GetMapping("/facilityBookList")
    public String facilityBookList() 
    {
        return "dev_jjw/facilityBookList";
    }
    
    @GetMapping("/getRoomStatus")
    public String getRoomStatus() 
    {
        return "dev_jjw/getRoomStatus";
    }
    
    @GetMapping("/getFacilityStatus")
    public String getFacilityStatus() 
    {
        return "dev_jjw/getFacilityStatus";
    }
    
    
    
    
}
