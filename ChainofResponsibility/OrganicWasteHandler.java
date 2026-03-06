package ChainofResponsibility;

public class OrganicWasteHandler implements WasteHandlerChain {
    private WasteHandlerChain nextChain;

    @Override
    public void setNextChain(WasteHandlerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleDisposal(WasteContainer container) {
        if ("organic".equals(container.getType())) {
            System.out.println("Organic handler → composting truck dispatched");
            container.dispose();
        } else if (nextChain != null) {
            nextChain.handleDisposal(container);
        } else {
            System.out.println("× No handler available for type: " + container.getType());
        }
    }
}