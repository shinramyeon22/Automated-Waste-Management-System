package ChainofResponsibility;

public class HazardousWasteHandler implements WasteHandlerChain {
    private WasteHandlerChain nextChain;

    @Override
    public void setNextChain(WasteHandlerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleDisposal(WasteContainer container) {
        if ("hazardous".equals(container.getType())) {
            System.out.println("Hazardous handler → special chemical waste truck dispatched");
            container.dispose();
        } else if (nextChain != null) {
            nextChain.handleDisposal(container);
        } else {
            System.out.println("× No handler available for type: " + container.getType());
        }
    }
}