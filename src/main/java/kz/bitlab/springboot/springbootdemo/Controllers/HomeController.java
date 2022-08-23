package kz.bitlab.springboot.springbootdemo.Controllers;

import kz.bitlab.springboot.springbootdemo.db.DBUtil;
import kz.bitlab.springboot.springbootdemo.db.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@Controller

public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Item> items = DBUtil.getItems();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping(value = "/addSales")
    public String addSales(){
        return "addSales";
    }
    @PostMapping(value = "/addSales")
    public String addSales(@RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "price") double price){
        Item newItem = new Item();
        newItem.setId(DBUtil.getIndex());
        newItem.setName(name);
        newItem.setDescription(description);
        newItem.setPrice(price);
        DBUtil.addItem(newItem);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{name}")
    public String getDetail(@PathVariable( name = "name") String name, Model model){
        Item item = DBUtil.getItemByName(name);
                model.addAttribute("item", item);
        return "details";

    }
}
