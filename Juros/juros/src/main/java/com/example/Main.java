import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");

        Scanner ler = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.print("Nome: ");
        cliente.setNome(ler.nextLine());

        System.out.print("Email: ");
        cliente.setEmail(ler.nextLine());

        System.out.println("Quantidades de itens você está comprando: ");
        int qtd = ler.nextInt();

        Item[] itens = new Item[qtd];

        for (int i = 0; i < itens.length; i++) {
            System.out.println("-----");

            Item item = new Item();

            System.out.print("Nome do " + (i + 1) + " produto: ");
            item.setNome(ler.next());

            System.out.print("Valor: ");
            item.setPreco(ler.nextDouble());

            itens[i] = item;

        }
    
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setCarrinho(itens);

        System.out.print("Forma de pagamento (DÉBITO, PIX, ou CRÉDITO): ");
        compra.setFormaPag(ler.next());

        System.out.print("Número de parcelas: ");
        compra.setParcelas(ler.nextInt());


        LojaOnline lojaOnline = new LojaOnline();
        NotaFiscal nf = lojaOnline.efetuarCompra(compra);

        // IMPRIMINDO A NOTA 


        System.out.println("---------------- RECIBO ---------------- ");
        System.out.println("");

        System.out.println("NÚMERO DA NOTA: " + nf.getCodNota());
        System.out.println("Cliente: " + nf.getCliente());

        System.out.println("");
        
        System.out.println("PRODUTOS: ");
        for (Item item : compra.getCarrinho()) {
            System.out.println(item.getNome() + ":                 " + item.getPreco());
        }

        System.out.println("Forma de pagamento: " + compra.getFormaPag());
        System.out.println("Valor total: " + formatoDecimal.format(nf.getTotal()));


    }
}
