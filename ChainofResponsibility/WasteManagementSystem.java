package ChainofResponsibility;
public class WasteManagementSystem {
    public static void main(String[] args) {
        WasteCollectionChain system = new WasteCollectionChain();

        // Test cases
        WasteContainer bin1 = new WasteContainer("organic", 240.0);
        bin1.addWaste(205.0);   // >80%

        WasteContainer bin2 = new WasteContainer("recyclable", 360.0);
        bin2.addWaste(310.0);   // >80%

        WasteContainer bin3 = new WasteContainer("hazardous", 120.0);
        bin3.addWaste(108.0);   // >80%

        WasteContainer bin4 = new WasteContainer("paper", 200.0);
        bin4.addWaste(190.0);   // >80% but unknown type

        WasteContainer bin5 = new WasteContainer("organic", 240.0);
        bin5.addWaste(140.0);   // <80% → no action

        System.out.println("=== Waste Collection Simulation ===\n");

        system.process(bin1);
        System.out.println();

        system.process(bin2);
        System.out.println();

        system.process(bin3);
        System.out.println();

        system.process(bin4);
        System.out.println();

        system.process(bin5);
    }
}