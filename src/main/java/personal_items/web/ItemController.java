package personal_items.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal_items.item_model.Item;
import personal_items.service.ItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Item findById (@RequestParam(value = "id") Integer id) {
        return itemService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean insert (@RequestBody Item item){
        return itemService.insert(item);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public boolean update (@RequestBody Item item){
        return itemService.update(item);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean delete (@RequestParam("id") int id){
        return itemService.delete(id);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.DELETE)
    public void clearCache() {
        itemService.clearCache();
    }

}
