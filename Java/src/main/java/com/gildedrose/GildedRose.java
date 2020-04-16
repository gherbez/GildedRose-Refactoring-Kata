package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (items[i].quality > 0 && !items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    decreaseQuality(items[i]);
                }
            } else {
                if (items[i].quality < MAX_QUALITY) {
                    increaseQuality(items[i]);

                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].sellIn < 11 && items[i].quality < MAX_QUALITY) {
                            increaseQuality(items[i]);
                        }

                        if (items[i].sellIn < 6 && items[i].quality < MAX_QUALITY) {
                            increaseQuality(items[i]);
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(AGED_BRIE)) {
                    if (items[i].quality < MAX_QUALITY) {
                        increaseQuality(items[i]);
                    }
                } else if (!items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (items[i].quality > 0 && !items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        decreaseQuality(items[i]);
                    }
                } else {
                    items[i].quality = 0;
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}