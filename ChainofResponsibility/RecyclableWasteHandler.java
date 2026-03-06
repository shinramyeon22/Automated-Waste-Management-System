package ChainofResponsibility;
public class RecyclableWasteHandler implements WasteHandlerChain {
    private WasteHandlerChain nextChain;

    @Override
    public void setNextChain(WasteHandlerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleDisposal(WasteContainer container) {
        if ("recyclable".equals(container.getType())) {
            System.out.println("Recyclable handler → sorting facility truck dispatched");
            container.dispose();
        } else if (nextChain != null) {
            nextChain.handleDisposal(container);
        } else {
            System.out.println("× No handler available for type: " + container.getType());
        }
    }
}