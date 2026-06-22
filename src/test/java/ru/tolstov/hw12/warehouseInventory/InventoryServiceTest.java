package ru.tolstov.hw12.warehouseInventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {
    /**
     * №	Тест	                                           Входные данные	                                            Ожидаемый результат
     * 1	addProduct, склад открыт	                       isInventoryOpen = true; Product("Яблоко", 1.0, "Фрукты")     Товар добавлен, getProductsByCategory("Фрукты") возвращает список, содержащий этот товар
     * 1	addProduct, склад открыт	                       isInventoryOpen = true; Два продукта с категорией "Фрукты"   Товар добавлен, getProductsByCategory("Фрукты") возвращает список, содержащий этот товар 2 шт
     * 1	addProduct, склад открыт	                       isInventoryOpen = true; Добавить две разные категории        Товар добавлен, getProductsByCategory() возвращает список, содержащий 2 категории
     * 2	addProduct, склад закрыт (после добавления яблока) isInventoryOpen = false; Product("Банан", 1.5, "Фрукты") 	Товар не добавлен, getProductsByCategory("Фрукты") содержит только яблоко
     * 2	addProduct, склад закрыт сразу                     isInventoryOpen = false; Product("Банан", 1.5, "Фрукты") 	Товар не добавлен, getProductsByCategory("Фрукты") список пуст
     * 3	addProduct(null)	                               product = null	                                            NullPointerException с сообщением "product не должен быть null"
     * 4	getProductsByCategory(null)	                       category = null	                                            NullPointerException с сообщением "Категория для поиска не должна быть null"
     * 5	getProductsByCategory, категории нет	           category = "Несуществующая"	                                OutOfStockException("На складе нет категории: Несуществующая")
     * 6	getProductsByCategory, категория есть, товаров нет category = "Фрукты", инвентарь содержит ключ "Фрукты" с пустым списком (после очистки через рефлексию)	OutOfStockException("Товары в категории 'Фрукты' закончились")
     * 1,2ткgetProductsByCategory, успешное получение	       category = "Фрукты", в инвентаре есть товары	                Список из добавленных товаров; при попытке модификации – UnsupportedOperationException
     * 8	getProductsByPrice, точное совпадение	          price = 10.0, инвентарь содержит товары с ценой 10.0 и другие Список только товаров с ценой 10.0
     * 9	getProductsByPrice, товаров с такой ценой нет	   price = 5.0, инвентарь без такой цены	                    Пустой список
     * 10	getProductsByPrice, пустой инвентарь	           price = 10.0, инвентарь пуст	                                Пустой список
     */

    private InventoryService inventoryService;
    private Product productFirst;
    private Product productSecond;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
        productFirst = new Product("Яблоко", 10.0, "Фрукты");
        productSecond = new Product("Банан", 15.5, "Фрукты");
    }

    @Test
    void addProductWhenListEmpty() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        assertTrue(inventoryService.getProductsByCategory(productFirst.category()).contains(productFirst));
        assertEquals(productFirst.productName(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().productName());
        assertEquals(productFirst.price(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().price());
        assertEquals(productFirst.category(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().category());
    }

    @Test
    void addProductWhenListNoEmpty() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        inventoryService.addProduct(productSecond);
        assertTrue(inventoryService.getProductsByCategory(productFirst.category()).contains(productFirst));
        assertTrue(inventoryService.getProductsByCategory(productSecond.category()).contains(productSecond));
        assertEquals(2, inventoryService.getProductsByCategory(productFirst.category()).size());
        assertEquals(2, inventoryService.getProductsByCategory(productSecond.category()).size());
        assertEquals(productFirst.productName(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().productName());
        assertEquals(productFirst.price(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().price());
        assertEquals(productFirst.category(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().category());
        assertEquals(productSecond.productName(), inventoryService.getProductsByCategory(productSecond.category()).getLast().productName());
        assertEquals(productSecond.price(), inventoryService.getProductsByCategory(productSecond.category()).getLast().price());
        assertEquals(productSecond.category(), inventoryService.getProductsByCategory(productSecond.category()).getLast().category());
    }

    @Test
    void addProductWhenTwoCategory() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        inventoryService.addProduct(productSecond);
        assertTrue(inventoryService.getProductsByCategory(productFirst.category()).contains(productFirst));
        assertTrue(inventoryService.getProductsByCategory(productSecond.category()).contains(productSecond));
        assertEquals(1, inventoryService.getProductsByCategory(productFirst.category()).size());
        assertEquals(1, inventoryService.getProductsByCategory(productSecond.category()).size());
        assertEquals(productFirst.productName(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().productName());
        assertEquals(productFirst.price(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().price());
        assertEquals(productFirst.category(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().category());
        assertEquals(productSecond.productName(), inventoryService.getProductsByCategory(productSecond.category()).getLast().productName());
        assertEquals(productSecond.price(), inventoryService.getProductsByCategory(productSecond.category()).getLast().price());
        assertEquals(productSecond.category(), inventoryService.getProductsByCategory(productSecond.category()).getLast().category());
    }

    @Test
    void addProductWhenInventoryOpenThenClose() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        inventoryService.setInventoryOpen(false);
        assertTrue(inventoryService.getProductsByCategory(productFirst.category()).contains(productFirst));
        assertEquals(1, inventoryService.getProductsByCategory(productFirst.category()).size());
        assertEquals(productFirst.productName(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().productName());
        assertEquals(productFirst.price(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().price());
        assertEquals(productFirst.category(), inventoryService.getProductsByCategory(productFirst.category()).getFirst().category());

        inventoryService.addProduct(productSecond);
        assertFalse(inventoryService.getProductsByCategory(productSecond.category()).contains(productSecond));
        assertEquals(1, inventoryService.getProductsByCategory(productFirst.category()).size());
    }

    @Test
    void addProductWhenInventoryClose() {
        inventoryService.addProduct(productFirst);
        OutOfStockException outOfStockException = assertThrows(
                OutOfStockException.class,
                () -> inventoryService.getProductsByCategory(productFirst.category())
        );
        assertEquals("На складе нет категории: " + productFirst.category(), outOfStockException.getMessage());
    }

    @Test
    void addProductNull() {
        inventoryService.setInventoryOpen(true);
        NullPointerException nullPointerException = assertThrows(
                NullPointerException.class,
                () -> inventoryService.addProduct(null)
        );
        assertEquals("product не должен быть null", nullPointerException.getMessage());
    }

    @Test
    void getProductsByCategoryIsNull() {
        inventoryService.setInventoryOpen(true);
        NullPointerException nullPointerException = assertThrows(
                NullPointerException.class,
                () -> inventoryService.getProductsByCategory(null)
        );
        assertEquals("Категория для поиска не должна быть null", nullPointerException.getMessage());
    }

    @Test
    void getProductsNoCategory() {
        inventoryService.setInventoryOpen(true);
        OutOfStockException outOfStockException = assertThrows(
                OutOfStockException.class,
                () -> inventoryService.getProductsByCategory("Овощи")
        );
        assertEquals("На складе нет категории: Овощи", outOfStockException.getMessage());
    }

    @Test
    void getProductsNoProduct() throws NoSuchFieldException, IllegalAccessException {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);

        // Получаем приватное поле inventory
        Field inventoryField = InventoryService.class.getDeclaredField("inventory");
        inventoryField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, List<Product>> inventory = (Map<String, List<Product>>) inventoryField.get(inventoryService);

        inventory.get(productFirst.category()).clear();

        OutOfStockException outOfStockException = assertThrows(
                OutOfStockException.class,
                () -> inventoryService.getProductsByCategory(productFirst.category())
        );
        assertEquals(
                String.format("Товары в категории '%s' закончились", productFirst.category()),
                outOfStockException.getMessage()
        );
    }

    @Test
    void getProductsByPrice() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        assertTrue(inventoryService.getProductsByPrice(productFirst.price()).contains(productFirst));
        assertEquals(1, inventoryService.getProductsByPrice(productFirst.price()).size());
        assertEquals(productFirst.productName(), inventoryService.getProductsByPrice(productFirst.price()).getFirst().productName());
        assertEquals(productFirst.price(), inventoryService.getProductsByPrice(productFirst.price()).getFirst().price());
        assertEquals(productFirst.category(), inventoryService.getProductsByPrice(productFirst.price()).getFirst().category());
    }

    @Test
    void getProductsByNoPrice() {
        inventoryService.setInventoryOpen(true);
        inventoryService.addProduct(productFirst);
        assertTrue(inventoryService.getProductsByCategory(productFirst.category()).contains(productFirst));
        assertEquals(0, inventoryService.getProductsByPrice(5.0).size());
    }

    @Test
    void getProductsByPriceListEmpty() {
        assertEquals(0, inventoryService.getProductsByPrice(5.0).size());
    }
}