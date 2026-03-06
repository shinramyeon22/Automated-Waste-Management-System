package ChainofResponsibility;

public class WasteCollectionChain implements WasteHandlerChain {
    private WasteHandlerChain nextChain;

    public WasteCollectionChain() {
        WasteHandlerChain organic    = new OrganicWasteHandler();
        WasteHandlerChain recyclable = new RecyclableWasteHandler();
        WasteHandlerChain hazardous  = new HazardousWasteHandler();

        organic.setNextChain(recyclable);
        recyclable.setNextChain(hazardous);

        this.nextChain = organic;
    }

    @Override
    public void setNextChain(WasteHandlerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void handleDisposal(WasteContainer container) {
        if (nextChain != null) {
            nextChain.handleDisposal(container);
        }
    }

    public void process(WasteContainer container) {
        if (container.needsDisposal()) {
            System.out.println("Collection triggered for: " + container.getType()
                    + " container  (" + container.getCurrentLevel() + " / "
                    + container.getCapacity() + ")");
            handleDisposal(container);
        } else {
            System.out.println("→ No action needed: " + container.getType()
                    + " is only " + String.format("%.0f%%",
                    (container.getCurrentLevel() / container.getCapacity()) * 100) + " full");
        }
    }
}