package com.hotel.Hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController 
{

    @GetMapping("/")
    public String main() 
    {
        return "index";
    }
    
    @GetMapping("/admin")
    public String admin() 
    {
        return "admin";
    }
    
    @GetMapping("/facility_list")
    public String facility_list() 
    {
        return "facility_list";
    }
    
    @GetMapping("/bookFacility")
    public String bookFacility() 
    {
        return "bookfacility";
    }
    
    @GetMapping("/bookRoom")
    public String bookRoom() 
    {
        return "bookRoom";
    }
    
    @GetMapping("/facility_golf_reservation")
    public String facility_golf_reservation() 
    {
        return "facility_golf_reservation";
    }
    
    @GetMapping("/facility_golf")
    public String facility_golf() 
    {
        return "facility_golf";
    }
    
    @GetMapping("/facility_health_reservation")
    public String facility_health_reservation() 
    {
        return "facility_health_reservation";
    }
    
    @GetMapping("/facility_health")
    public String facility_health() 
    {
        return "facility_health";
    }
    
    @GetMapping("/facility_pool_reservation")
    public String facility_pool_reservation() 
    {
        return "facility_pool_reservation";
    }
    
    @GetMapping("/facility_pool")
    public String facility_pool() 
    {
        return "facility_pool";
    }
    
    @GetMapping("/facility_restaurant_reservation")
    public String facility_restaurant_reservation() 
    {
        return "facility_restaurant_reservation";
    }
    
    @GetMapping("/facility_restaurant")
    public String facility_restaurant() 
    {
    	return "facility_restaurant";
    }
    
    @GetMapping("/getCs")
    public String getCs() 
    {
        return "getCs";
    }
    
    @GetMapping("/getCsList")
    public String getCsList() 
    {
        return "getCsList";
    }
    
    @GetMapping("/getFacilityCancle")
    public String getFacilityCancle() 
    {
        return "getFacilityCancle";
    }
    
    @GetMapping("/getMyFacilityBook")
    public String getMyFacilityBook() 
    {
        return "getMyFacilityBook";
    }
    
    @GetMapping("/getMyRoomBook")
    public String getMyRoomBook() 
    {
        return "getMyRoomBook";
    }
    
    @GetMapping("/getRoomCancle")
    public String getRoomCancle() 
    {
        return "getRoomCancle";
    }
    
    @GetMapping("/insertCs")
    public String insertCs() 
    {
        return "insertCs";
    }
    
    @GetMapping("/join")
    public String join() 
    {
        return "join";
    }
    
    @GetMapping("/payment")
    public String payment() 
    {
        return "payment";
    }
    
    @GetMapping("/payment2")
    public String payment2() 
    {
        return "payment2";
    }
    
    @GetMapping("/myBookList")
    public String myBookList() 
    {
        return "myBookList";
    }
    
    @GetMapping("/myCancleList")
    public String myCancleList() 
    {
        return "myCancleList";
    }
    
    @GetMapping("/myPage")
    public String myCancmyPageleList() 
    {
        return "myPage";
    }
    
    @GetMapping("/room_list")
    public String room_list() 
    {
        return "room_list";
    }
    
    @GetMapping("/room_classic")
    public String room_classic() 
    {
        return "room_classic";
    }
    
    @GetMapping("/room_deluxe")
    public String room_deluxe() 
    {
        return "room_deluxe";
    }
    
    @GetMapping("/room_family")
    public String room_family() 
    {
        return "room_family";
    }
    
    @GetMapping("/room_luxury")
    public String room_luxury() 
    {
        return "room_luxury";
    }
    
    @GetMapping("/room_suite")
    public String room_suite() 
    {
        return "room_suite";
    }
    
    @GetMapping("/room_superior")
    public String room_superior() 
    {
        return "room_superior";
    }
    
    @GetMapping("/room_classic_reservation")
    public String room_classic_reservation() 
    {
        return "room_classic_reservation";
    }
    
    @GetMapping("/room_deluxe_reservation")
    public String room_deluxe_reservation() 
    {
        return "room_deluxe_reservation";
    }
    
    @GetMapping("/room_family_reservation")
    public String room_family_reservation() 
    {
        return "room_family_reservation";
    }
    
    @GetMapping("/room_luxury_reservation")
    public String room_luxury_reservation() 
    {
        return "room_luxury_reservation";
    }
    
    @GetMapping("/room_suite_reservation")
    public String room_suite_reservation() 
    {
        return "room_suite_reservation";
    }
    
    @GetMapping("/room_superior_reservation")
    public String room_superior_reservation() 
    {
        return "room_superior_reservation";
    }
    
    @GetMapping("/room")
    public String room() 
    {
        return "room";
    }
    
    @GetMapping("/updateCs")
    public String updateCs() 
    {
        return "updateCs";
    }
}
