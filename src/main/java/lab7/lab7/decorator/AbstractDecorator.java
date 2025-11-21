package lab7.lab7.decorator;

public abstract class AbstractDecorator implements Decorator {
    protected final Decorator decorator;

    public AbstractDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void operation() {
        decorator.operation();
    }
}
