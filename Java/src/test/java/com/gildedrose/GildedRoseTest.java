package com.gildedrose;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    private Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};

    private Item[] itemsCopy = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};

    @Test
    public void shouldTestWithGoldenMasterPrinciple() {
        GildedRose gildedRose = new GildedRose(items);
        GildedRoseCopy gildedRoseCopy = new GildedRoseCopy(itemsCopy);
        for (int i = 0; i < 200; i++) {
            gildedRose.updateQuality();
            gildedRoseCopy.updateQuality();
        }

        Item[] items = gildedRose.items;
        assertThat(items).extracting("name").contains(Arrays.stream(gildedRoseCopy.items).map(item -> item.name).toArray());
        assertThat(items).extracting("sellIn").contains(Arrays.stream(gildedRoseCopy.items).map(item -> item.sellIn).toArray());
        assertThat(items).extracting("quality").contains(Arrays.stream(gildedRoseCopy.items).map(item -> item.quality).toArray());
    }

}
