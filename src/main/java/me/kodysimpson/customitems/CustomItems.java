package me.kodysimpson.customitems;

import me.kodysimpson.customitems.items.Spear;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CustomItems implements ModInitializer {

    //An item is made from the Item class and requires a Settings object.
    public static final Item BANANA = new Item(new Item.Settings().maxCount(2).food(FoodComponents.BEEF)); // new FabricItemSettings()
    public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));

    @Override
    public void onInitialize() {

        //Now that you have an item, you need to register it so that it can be used in the game
        Registry.register(Registries.ITEM, new Identifier("custom-items", "banana"), BANANA);
        Registry.register(Registries.ITEM, new Identifier("custom-items", "spear"), SPEAR);

    }
}
