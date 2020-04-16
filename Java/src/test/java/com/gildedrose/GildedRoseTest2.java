package com.gildedrose;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GildedRoseTest2 {

    private Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

//    @Test
//    public void shouldReturnFooWhenItemNameIsFoo() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].name).isEqualTo("foo");
//    }
//
//    @Test
//    public void shouldReturnNegativeSellinWhenQualityIs0AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-1);
//    }
//
//    @Test
//    public void shouldReturnSellIn5WhenSellinIs6AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 6, 0) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].sellIn).isEqualTo(5);
//    }
//
//    @Test
//    public void shouldReturnQuality0WhenQualityIs0AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 6, 0) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].quality).isEqualTo(0);
//    }
//
//    @Test
//    public void shouldReturnQuality11WhenQualityIs12AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 6, 12) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].quality).isEqualTo(11);
//    }
//
//    @Test
//    public void shouldReturnSellIn5WhenSellinIsmoins1AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", -1, 0) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-2);
//    }
//
//    @Test
//    public void shouldReturnQuality1999WhenQualityIs2000AtBeginning() {
//        // Given
//        Item[] items = new Item[] { new Item("foo", 6, 2000) };
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].quality).isEqualTo(1999);
//    }
//
//    @Test
//    public void shouldReturnQuality19WhenQualityIs20AtBeginning() {
//        // Given
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].quality).isEqualTo(19);
//    }
//    @Test
//    public void shouldReturSellinForFirstItem() {
//        // Given
//        Item[] expectItems = new Item[] { items[0] };
//        GildedRose app = new GildedRose(expectItems);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[0].sellIn).isEqualTo(9);
//    }
//
//    @Test
//    public void shouldReturn5QualityForConjuredManaCake() {
//        // Given
//        GildedRose app = new GildedRose(items);
//
//        // When
//        app.updateQuality();
//
//        // Then
//        Assertions.assertThat(app.items[8].quality).isEqualTo(5);
//    }

    @Test
    public void shouldReturnAllInformationItems() {
        // Given
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        /**
         * in general, sellIn decrease of 1, quality decrease of 1
         */

        // Then
        Assertions.assertThat(app.items[0].name).isEqualTo("+5 Dexterity Vest");
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(9);
        Assertions.assertThat(app.items[0].quality).isEqualTo(19);

        /**
         * Quality increase by 1 go Aged Brie
         */
        Assertions.assertThat(app.items[1].name).isEqualTo("Aged Brie");
        Assertions.assertThat(app.items[1].sellIn).isEqualTo(1);
        Assertions.assertThat(app.items[1].quality).isEqualTo(1);

        Assertions.assertThat(app.items[2].name).isEqualTo("Elixir of the Mongoose");
        Assertions.assertThat(app.items[2].sellIn).isEqualTo(4);
        Assertions.assertThat(app.items[2].quality).isEqualTo(6);

        /**
         * sellIn stay at 0 when item a sellIn 0 for Sulfuras, Hand of Ragnaros
         * quality don't decrease
         */
        Assertions.assertThat(app.items[3].name).isEqualTo("Sulfuras, Hand of Ragnaros");
        Assertions.assertThat(app.items[3].sellIn).isEqualTo(0);
        Assertions.assertThat(app.items[3].quality).isEqualTo(80);

        /**
         * if sellIn is negative, it don't decrease
         */
        Assertions.assertThat(app.items[4].name).isEqualTo("Sulfuras, Hand of Ragnaros");
        Assertions.assertThat(app.items[4].sellIn).isEqualTo(-1);
        Assertions.assertThat(app.items[4].quality).isEqualTo(80);

        /**
         * quality increase of 1 for Backstage passes to a TAFKAL80ETC concert
         */
        Assertions.assertThat(app.items[5].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        Assertions.assertThat(app.items[5].sellIn).isEqualTo(14);
        Assertions.assertThat(app.items[5].quality).isEqualTo(21);

        /**
         * quality increase of 1 for Backstage passes to a TAFKAL80ETC concert
         */
        Assertions.assertThat(app.items[6].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        Assertions.assertThat(app.items[6].sellIn).isEqualTo(9);
        Assertions.assertThat(app.items[6].quality).isEqualTo(50);

        Assertions.assertThat(app.items[7].name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        Assertions.assertThat(app.items[7].sellIn).isEqualTo(4);
        Assertions.assertThat(app.items[7].quality).isEqualTo(50);

        Assertions.assertThat(app.items[8].name).isEqualTo("Conjured Mana Cake");
        Assertions.assertThat(app.items[8].sellIn).isEqualTo(2);
        Assertions.assertThat(app.items[8].quality).isEqualTo(5);

    }
    @Test
    public void testForsBackstageException() {
        // Given
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(9);
        Assertions.assertThat(app.items[0].quality).isEqualTo(22);
    }
    @Test
    public void testForsBackstageException2() {
        // Given
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(4);
        Assertions.assertThat(app.items[0].quality).isEqualTo(23);
    }

    @Test
    public void shouldDecreaseQualityBy1ForElixirOfTheMongooseWhen() {
        // Given
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -3, 20) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-4);
        Assertions.assertThat(app.items[0].quality).isEqualTo(18);
    }

    @Test
    public void testForAgedBrieSpecification() {
        // Given
        Item[] items = new Item[] { new Item("Aged Brie", -5, 20) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-6);
        Assertions.assertThat(app.items[0].quality).isEqualTo(22);
    }

    @Test
    public void testForBackStagedPassesException() {
        // Given
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -5, 20) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0].sellIn).isEqualTo(-6);
        Assertions.assertThat(app.items[0].quality).isEqualTo(0);
    }

}
