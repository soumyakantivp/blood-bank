package com.booking.blood.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.blood.bank.model.Bookings;
import com.booking.blood.bank.model.Users;
import com.booking.blood.bank.security.CustomUserDetails;
import com.booking.blood.bank.service.BloodBankService;
import com.booking.blood.bank.service.BookingService;
import com.booking.blood.bank.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	BloodBankService hall_service;

	@Autowired
	BookingService bookings_service;


	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public boolean register(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("address") String address) {
		Users newUser = new Users(email, password, address, true, "USER");
		if (service.addUser(newUser)) {
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/user/get/all", method = RequestMethod.POST)
	public List<Users> register() {
		return service.getAllUsers();
	}

	@RequestMapping(value = "/user/blood/request", method = RequestMethod.POST)
	public boolean requestBlood(@RequestBody Bookings booking) {
		// System.out.println(id);
		try {
			bookings_service.createNewBooking(booking);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(value = "/user/blood/request/all", method = RequestMethod.GET)
	public List<Bookings> getUserBloodRequests(@RequestParam String email) {
		int id = service.findUserByEmailId(email);
		if(id != -1) {
			Users user = service.getUserById(id);
			if(user!=null) {
				return user.getBookings();
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	private int getLoggedInUserId(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal).getId();
		}
		System.out.println("loggedin userid: " + principal.toString());
		return -1;
	}
	/*
	 * @RequestMapping(value = "/book/pay",method=RequestMethod.GET) public String
	 * bookHallDate(ModelMap model, @RequestParam("from")String
	 * from, @RequestParam("to")String to, @RequestParam("id")int id){
	 * System.out.println(from+" | "+to+" | "+id); Optional<BloodBank> hall =
	 * hall_service.getHallById(id); if(hall.isPresent()) {
	 * model.addAttribute("hall",hall.get()); System.out.println(hall); } else {
	 * return "error"; } DateTimeFormatter dtf =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd"); try { LocalDate date1 =
	 * LocalDate.parse(from, dtf); LocalDate date2 = LocalDate.parse(to, dtf); long
	 * daysBetween = ChronoUnit.DAYS.between(date1, date2); if(daysBetween<0) return
	 * "redirect:/book/"+id; daysBetween+=1; double amount =
	 * hall.get().getPrice()*daysBetween;
	 * 
	 * Bookings newBooking = new Bookings(getLoggedInUserId(model),
	 * hall.get().getOwner_id(), id, from, to, daysBetween, amount);
	 * service.addBookings(newBooking); model.addAttribute("booking", newBooking);
	 * //System.out.println ("Days: " + daysBetween); } catch (Exception e) {
	 * e.printStackTrace(); } //System.out.println(hall); return "buy-hall"; }
	 * 
	 * private int getLoggedInUserId(ModelMap model) { Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * 
	 * if (principal instanceof CustomUserDetails) { return ((CustomUserDetails)
	 * principal).getId(); }
	 * System.out.println("loggedin userid: "+principal.toString()); return -1; }
	 */

}
