package lab7.lab7.decorator;

import lab7.lab7.repository.item.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) { 
        super(item); 
    }

    @Override public double price() { 
        return 4 + item.price();
    }

    @Override public String getDescription() { 
        return super.getDescription() + " + basket"; 
    }
}

//беремо конкретну сутніть конкретого типу і той самий тип повертаємо
//заміняє попередню сутність наступною
// def square(f):
//     def new_f(**args):
//         return f(**args) ** 2
//     return new_f

// @squaredef do_something():
//     return -4