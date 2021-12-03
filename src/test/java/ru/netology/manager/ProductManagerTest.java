package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product first = new Smartphone(1, "Lg-g6", 25000, "LG");
    Product second = new Smartphone(2, "Liquid Z6", 10000, "Acer");
    Product third = new Smartphone(3, "Honor 9A", 13100, "Huawei");
    Product fourth = new Smartphone(4, "P40 Pro", 54587, "Huawei");
    Product fifth = new Book(5, "Повезло", 350, "Мэй Маск");
    Product sixth = new Book(6, "Правила жизни", 350, "Мэй Маск");
    Product seventh = new Book(7, "Снегурочка", 350, "Александр Островский");

    @BeforeEach
    public void setUp() {
        manager.addProduct(first);
        manager.addProduct(second);
        manager.addProduct(third);
        manager.addProduct(fourth);
        manager.addProduct(fifth);
        manager.addProduct(sixth);
        manager.addProduct(seventh);
    }

    @Test
    public void shouldSearchByBookName() {

        String search = "Правила жизни";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthor() {

        String search = "Александр Островский";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{seventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTheSameAuthor() {

        String search = "Мэй Маск";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{fifth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneName() {

        String search = "Honor 9A";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTheSameMaker() {

        String search = "Huawei";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMaker() {

        String search = "LG";

        Product[] actual = manager.searchBy(search);
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);

    }
}