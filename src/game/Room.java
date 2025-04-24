package game;

import java.util.ArrayList;

public class Room {
    private Room northRoom;
    private Room eastRoom;
    private Room southRoom;
    private Room westRoom;

    private String name;
    private String description;
    private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Convenience methods for creating and adding Item
    public void addItem(String description) {
        this.addItem(new Item(description));
    }

    // Convenience methods for creating and adding Item with custom short name
    public void addItem(String description, String name) {
        this.addItem(new Item(description, name));
    }

    public Room getNorthRoom() {
        return this.northRoom;
    }

    public void setNorthRoom(Room northRoom) {
       this.northRoom = northRoom;
       if(northRoom.getSouthRoom() != this){
           northRoom.setSouthRoom(this);
       }

    }

    public Room getEastRoom() {
        return this.eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
        if(eastRoom.getWestRoom() != this){
            eastRoom.setWestRoom(this);
        }
    }

    public Room getSouthRoom() {
        return this.southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
        if(southRoom.getNorthRoom() != this){
            southRoom.setNorthRoom(this);
        }
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
        if(westRoom.getEastRoom() != this){
            westRoom.setEastRoom(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Item removeItem(String itemName) {
        Item itemToBeRemoved = findItem(itemName);
        if (itemToBeRemoved != null) {
            items.remove(itemToBeRemoved);
        }
        return itemToBeRemoved;
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
