package personal_items.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import personal_items.item_model.Item;
import java.util.ArrayList;


@Service
public class ItemServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    ArrayList<Item> items = new ArrayList<>();

    @Cacheable(value = "items")
    public ArrayList<Item> findAll() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Retrieving items");
        createItems();
        return items;
    }

    private void createItems() {
        logger.info("Creating items");
        items.add(new Item(1L, "T-shirt", 120000, "black t-shirt", true));
        items.add(new Item(2L, "Shorts", 90000, "grey shorts", true));
    }

    @CachePut(value = "items", key = "#item.id")
    public boolean insert(Item item) {
        logger.info("Inserting item");
        items.add(item);
        return true;
    }

    @CachePut(value = "items", key = "#item.id")
    public boolean update(Item item) {

        for(Item t : items){
            if(t.getId() == item.getId()){
                t.setInUse(item.isInUse());
                t.setId(item.getId());
                t.setNameOfItem(item.getNameOfItem());
                t.setDescription(item.getDescription());
                t.setPrice(item.getPrice());
                return true;
            }
        }
        return false;
    }

    @CacheEvict(value = "items", key = "#id")
    public boolean delete(int id) {

        for(int i = 0; i < items.size(); i++){
            if(id == items.get(i).getId()){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    @Cacheable(value = "items", key = "#id")
    public Item findById(int id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("finding item by id");
        for (Item t : items){
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    @CacheEvict(value = "items", allEntries = true)
    public void clearCache() {
        logger.info("clearing cache");
    }


}
