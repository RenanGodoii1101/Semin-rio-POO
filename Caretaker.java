import java.util.Stack;

public class Caretaker {
    private Stack<CarrinhoMemento> mementoStack = new Stack<>();

    public void saveState(Produto[] produtos) {
        mementoStack.push(new CarrinhoMemento(produtos));
    }

    public CarrinhoMemento restoreState() {
        if (!mementoStack.isEmpty()) {
            return mementoStack.pop();
        }
        return null;
    }
}
