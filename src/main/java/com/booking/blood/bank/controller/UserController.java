package com.booking.blood.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.blood.bank.model.Users;
import com.booking.blood.bank.service.BloodBankService;
import com.booking.blood.bank.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService service;
	
	@Autowired
	BloodBankService hall_service;

	
	@RequestMapping(value = "/user/register",method =RequestMethod.POST)
	public boolean register(ModelMap model, @RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("confirm")String confirm){
		System.out.println(email+" "+password+" "+confirm+" "+"USER");
		if(password.equals(confirm)) {
			Users newUser = new Users(email, password, true, "USER");
			if(service.addUser(newUser)) {
				model.addAttribute("name", email);
				return true;
			}
			else {
				model.addAttribute("err","user already registered!");
				return false;
			}
		}
		model.addAttribute("err","password and confirmation are not same!");
		return false;
	}
	/*
	@RequestMapping(value = "/book/{id}",method=RequestMethod.GET)
	public String bookHall(ModelMap model, @PathVariable int id){
		//System.out.println(id);
		Optional<BloodBank> hall = hall_service.getHallById(id);
		if(hall.isPresent()) {
			model.addAttribute("hall",hall.get());
			System.out.println(hall);
		}
		return "book-hall";
	}
	
	@RequestMapping(value = "/book/pay",method=RequestMethod.GET)
	public String bookHallDate(ModelMap model, @RequestParam("from")String from, @RequestParam("to")String to, @RequestParam("id")int id){
		System.out.println(from+" | "+to+" | "+id);
		Optional<BloodBank> hall = hall_service.getHallById(id);
		if(hall.isPresent()) {
			model.addAttribute("hall",hall.get());
			System.out.println(hall);
		}
		else {
			return "error";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
		    LocalDate date1 = LocalDate.parse(from, dtf);
		    LocalDate date2 = LocalDate.parse(to, dtf);
		    long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		    if(daysBetween<0)
		    	return "redirect:/book/"+id;
		    daysBetween+=1;
		    double amount = hall.get().getPrice()*daysBetween;
		    
		    Bookings newBooking = new Bookings(getLoggedInUserId(model), hall.get().getOwner_id(), id, from, to, daysBetween, amount);
		    service.addBookings(newBooking);
		    model.addAttribute("booking", newBooking);
		    //System.out.println ("Days: " + daysBetween);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		//System.out.println(hall);
		return "buy-hall";
	}
	
	private int getLoggedInUserId(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getId();
		}
		System.out.println("loggedin userid: "+principal.toString());
		return -1;
	}
	*/
	
}
