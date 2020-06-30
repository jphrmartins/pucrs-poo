package app;

import entities.SalesBase;
import entities.Stock;

public interface SystemLoader {
    Stock getStock();
    SalesBase getSalesBase();
}
