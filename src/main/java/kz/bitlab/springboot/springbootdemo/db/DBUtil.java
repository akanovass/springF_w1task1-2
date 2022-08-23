package kz.bitlab.springboot.springbootdemo.db;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Setter
@Getter
public class DBUtil {

    private static ArrayList<Item> items = new ArrayList<>();
    private static Long index = 6L;

    static {
        items.add(new Item(1L,"Macbook Pro 2020","8GB RAM 256 GB SSD Intel Core i7",1499.99));
        items.add(new Item(2L,"ASUS TUF GAMING","16 GB RAM 512 GB SSD AMD Ryzen 5",999.99));
        items.add(new Item(3L,"Apple Iphone 12 Pro","6 GB RAM 128 GB Super Retina XDR OLED Display",1099.99));
        items.add(new Item(4L,"XIAOMI Redmi  Note 8","6 GB RAM 64 GB Android 9 Pie",199.99));
        items.add(new Item(5L,"XIAOMI Redmi  Note 10","16 GB RAM 512 GB Android 11",299.99));

    }

    public static void addItem(Item item){
        items.add(item);
        index++;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static Long getIndex() {
        return index;
    }
    public static  Item getItemByName(String name){
        Item item0 = null;
        for(Item item: items){
            if(item.getName().equals(name)){
               item0 = item;
                break;
            }
        }
        return item0;
    }

}
