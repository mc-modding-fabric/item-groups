package me.kodysimpson.customitems;

import me.kodysimpson.customitems.items.Spear;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CustomItems implements ModInitializer {

    public static final Item BANANA = new Item(new Item.Settings().maxCount(2).food(FoodComponents.BEEF)); // new FabricItemSettings()
    public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));

    //Custom ItemGroup
    private static final ItemGroup WEAPONS = FabricItemGroup.builder(new Identifier("custom-items", "weapons_group"))
            .icon(() -> new ItemStack(SPEAR))
            //.icon(() -> Items.BEEF.getDefaultStack())
            .displayName(Text.of("Weapons"))
            .noScrollbar()
            .build();

    @Override
    public void onInitialize() {

        //Add an item to an item group(food and drink group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            //entries.add(BANANA);
            entries.addAfter(Items.APPLE, BANANA);
        });

        //You can add an event handler for any item group that you want to add to.
        // Multiple items can be added to the same item group handler.

        //Add the spear to the custom item group
        ItemGroupEvents.modifyEntriesEvent(WEAPONS).register(entries -> {
            entries.add(SPEAR);
        });


        Registry.register(Registries.ITEM, new Identifier("custom-items", "banana"), BANANA);
        Registry.register(Registries.ITEM, new Identifier("custom-items", "spear"), SPEAR);

    }
}
