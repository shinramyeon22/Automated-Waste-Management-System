package ChainofResponsibility;
public interface WasteHandlerChain {
    void setNextChain(WasteHandlerChain nextChain);
    void handleDisposal(WasteContainer container);
}