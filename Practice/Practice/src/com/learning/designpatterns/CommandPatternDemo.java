public class CommandPatternDemo {

    public static void main(String[] args) {
        Document doc = new Document();
        ActionOpen openDoc = new ActionOpen(doc);
        ActionSave saveDoc = new ActionSave(doc);
        MenuActions menuActions = new MenuActions(openDoc,saveDoc);
        menuActions.openDocument();
        menuActions.saveDocument();

        Order order = new Order();
        PlaceOrder placeOrder = new PlaceOrder(order);
        PrepareOrder prepareOrder = new PrepareOrder(order);
        ServeOrder serveOrder = new ServeOrder(order);
        Waiter waiter = new Waiter(placeOrder,serveOrder);
        Cook cook = new Cook(prepareOrder);

        waiter.placeOrder();
        cook.prepareOrder();
        waiter.serveOrder();
    }
}

class Waiter {
    PlaceOrder placeOrder;
    ServeOrder serveOrder;

    Waiter(PlaceOrder placeOrder, ServeOrder serveOrder){
        this.placeOrder = placeOrder;
        this.serveOrder = serveOrder;
    }
    public void placeOrder(){
        this.placeOrder.execute();
    }

    public void serveOrder(){
        this.serveOrder.execute();
    }
}

class Cook {
    PrepareOrder prepareOrder;
    Cook(PrepareOrder prepareOrder){
        this.prepareOrder = prepareOrder;
    }
    public void prepareOrder(){
        this.prepareOrder.execute();
    }
}

class PlaceOrder implements  Command {
    Order order;

    PlaceOrder(Order order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.placeOrder();
    }
}

class PrepareOrder implements  Command {
    Order order;

    PrepareOrder(Order order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.prepareOrder();
    }
}

class ServeOrder implements  Command {
    Order order;

    ServeOrder(Order order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.serveOrder();
    }
}

class Order {

    public void placeOrder(){
        System.out.println("Order placed");
    }

    public void prepareOrder(){
        System.out.println("Order prepared");
    }

    public void serveOrder(){
        System.out.println("Order served");
    }
}

class MenuActions {
    ActionOpen openDoc;
    ActionSave saveDoc;

    MenuActions(ActionOpen openDoc,ActionSave saveDoc){
        this.openDoc = openDoc;
        this.saveDoc = saveDoc;
    }

    public void openDocument(){
        openDoc.execute();
    }

    public void saveDocument(){
        saveDoc.execute();
    }
}

interface Command {
    void execute();
}

class ActionOpen implements Command {

    Document doc;

    ActionOpen(Document doc){
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.open();
    }
}

class ActionSave implements Command {

    Document doc;

    ActionSave(Document doc){
        this.doc = doc;
    }

    @Override
    public void execute() {
        doc.save();
    }
}

class Document {
    public void open(){
        System.out.println("Document opened");
    }

    public void save(){
        System.out.println("Document saved");
    }
}