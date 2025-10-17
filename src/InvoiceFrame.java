import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceFrame extends JFrame {
    JPanel MainPnl, TitlePnl, AddressPnl, InvoicePnl;
    JLabel AddressLbl, TitleLbl;
    JTextArea InvoiceTA;
    JScrollPane InvoiceScr;


    public InvoiceFrame(){
        super("InvoiceGUI");
        MainPnl = new JPanel();
        MainPnl.setLayout(new BorderLayout());

        createTitlePnl();
        createAddressPnl();
        createInvoicePnl();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,600);
        add(MainPnl);

        Customer addressBlock = new Customer(askQuestion("What is your full name:", "Enter Your Name"),
                askQuestion("What is your street name:", "Enter Your Street"),
                askQuestion("What is your apartment number: (leave the form blank if you do not live in an apartment)", "Enter Your Apartment Number"),
                askQuestion("What is your city:", "Enter Your City"),
                askQuestion("What is your state?", "Enter Your State"),
                askQuestion("What is your zip code:", "Enter Your Zip Code"));
        AddressLbl.setText(addressBlock.getCustomerBlock());

        InvoiceTA.append("========================================");
        InvoiceTA.append("\nItem                Qty   Price  Total");
        double finalTotal = 0;
        boolean done = false;
        do{
            LineItem lineItem = new LineItem(askQuestion("What is the product's name", "Enter the Product's Name"),
                    Double.parseDouble(askQuestion("What is the product's price:", "Enter the Product's Price")),
                    Integer.parseInt(askQuestion("How many of the product's are you buying:", "Enter the Quantity")));

            String invoice = String.format("\n%1$-20s%2$-6d$%3$-7.2f$%4$.2f", lineItem.getName(), lineItem.getQuantity(), lineItem.getPrice(), lineItem.getCalculatedTotal());
            InvoiceTA.append(invoice);
            finalTotal = finalTotal + lineItem.getCalculatedTotal();
            if(JOptionPane.showConfirmDialog(MainPnl, "Are you done adding line items?", "Are You Finished", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                done = true;
            }
        }while(!done);

        InvoiceTA.append("\n========================================");
        String invoiceFinalTotal = String.format("\nAMOUNT DUE: $%.2f", finalTotal);
        InvoiceTA.append(invoiceFinalTotal);
    }

    public String askQuestion(String question, String title){
        return JOptionPane.showInputDialog(MainPnl, question, title, JOptionPane.QUESTION_MESSAGE);
    }

    private void createInvoicePnl() {
        InvoicePnl = new JPanel();
        MainPnl.add(InvoicePnl,BorderLayout.SOUTH);
        InvoiceTA = new JTextArea(20, 45);
        InvoiceTA.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        InvoiceTA.setEditable(false);
        InvoiceScr = new JScrollPane(InvoiceTA);
        InvoicePnl.add(InvoiceScr);
    }

    private void createAddressPnl() {
        AddressPnl = new JPanel();
        MainPnl.add(AddressPnl, BorderLayout.WEST);
        AddressLbl = new JLabel();
        AddressLbl.setHorizontalAlignment(JLabel.CENTER);
        AddressLbl.setVerticalAlignment(JLabel.TOP);
        AddressLbl.setPreferredSize(new Dimension(200,55));
        AddressLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        AddressPnl.add(AddressLbl);
    }

    private void createTitlePnl() {
        TitlePnl = new JPanel();
        TitlePnl.setLayout(new BorderLayout(5, 5));
        MainPnl.add(TitlePnl, BorderLayout.NORTH);
        TitleLbl = new JLabel("Invoice");
        TitleLbl.setFont(new Font("Serif", Font.BOLD, 40));
        TitleLbl.setHorizontalAlignment(JLabel.CENTER);
        TitleLbl.setVerticalAlignment(JLabel.CENTER);
        TitleLbl.setPreferredSize(new Dimension(400,100));
        TitlePnl.add(TitleLbl, BorderLayout.NORTH);
    }

    public static class Invoice{
        public double totalAmtDue;

        public Invoice(double totalAmountDue) {
            this.totalAmtDue = totalAmountDue;
        }

        public double getTotalAmtDue() {
            return totalAmtDue;
        }

        public void setTotalAmtDue(double totalAmtDue) {
            this.totalAmtDue = totalAmtDue;
        }

        public double calculateTotalAmtDue(){
            return totalAmtDue;
        }
    }

}
